package vnua.fita.bookstore.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.frombean.BookForm;
import vnua.fita.bookstore.model.BookDao;
import vnua.fita.bookstore.utils.MyUtils;

/**
 * Servlet implementation class CreateBookServlet
 */
@WebServlet("/createBook")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 20 // 20MB
)
public class CreateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Views/createBookView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String priceStr = request.getParameter("price");
		String quantityInStockStr = request.getParameter("quantityInStock");
		String detail = request.getParameter("detail");
		Part filePart = request.getPart("file");
		String imagePath;

		BookForm bookForm = new BookForm(title, author, priceStr, quantityInStockStr,
				detail, filePart);
		List<String> errors = bookForm.validateCreateBookForm();
		if (errors.isEmpty()) {
			int price = Integer.parseInt(priceStr);
			int quantityInStock = Integer.parseInt(quantityInStockStr);

//			// lưu ảnh thanh toán vào thư mục nếu có
//			String fileName = title + "_" + MyUtil.getTimeLabel()
//					+ MyUtil.extracFileExtension(filePart);
//			String appPath = getServletContext().getRealPath(""); // thu muc goc cua ung
//																	// dung web
//			filePart.write(MyUtil.getFolderUpload(appPath, "book-img").getAbsolutePath()
//					+ File.separator + fileName);
//			imagePath = "" + File.separator+fileName;

			// lưu ảnh vào thư mục 'img' nếu có
			String fileName = title + "_" + MyUtils.getTimeLabel()
					+ MyUtils.extractFileExxtension(filePart);
			String contextPath = getServletContext().getRealPath("/"); // Lấy đường dẫn
																		// thực của ứng
																		// dụng web
			String savePath = contextPath + "img"; // Đường dẫn đến thư mục 'img'

			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir(); // Tạo thư mục 'img' nếu nó không tồn tại
			}

			String filePath = savePath + File.separator + fileName; // Đường dẫn file cuối
																	// cùng để lưu trữ ảnh
			filePart.write(filePath); // Lưu file ảnh
			imagePath = "img" + File.separator + fileName; // Đường dẫn tương đối để lưu
															// trong cơ sở dữ liệu

			Book book = new Book(title, author, price, quantityInStock, detail,
					imagePath);
			book.setCreateDate(new Date());

			boolean insertResult = BookDao.insertBook(book);
			if (!insertResult) {
				errors.add("Thêm sách không thành công");
			} else {
				response.sendRedirect(request.getContextPath() + "/adminHome");
			}
		}

		if (!errors.isEmpty()) {
			request.setAttribute("errors", String.join(", ", errors));
			request.setAttribute("book", bookForm);
			RequestDispatcher rd = request.getServletContext()
					.getRequestDispatcher("/Views/createBookView.jsp");
			rd.forward(request, response);
		}
		
	}

}

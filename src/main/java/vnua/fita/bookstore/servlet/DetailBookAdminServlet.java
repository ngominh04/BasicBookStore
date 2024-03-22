package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.bean.BookAndOrder;
import vnua.fita.bookstore.bean.Order;
import vnua.fita.bookstore.model.BookDao;
import vnua.fita.bookstore.utils.MyUtils;

/**
 * Servlet implementation class DetailBookAdminServlet
 */
@WebServlet(urlPatterns = {"/detailBookAdmin","/detailBookAdmin1","/detailBookAdmin2","/detailBookAdmin3","/detailBookAdmin5"})
public class DetailBookAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailBookAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
		String orderNo = request.getParameter("orderNo");
		String servletPath = request.getServletPath();
		String pathInfo = MyUtils.getPathInfoFromServletPath(servletPath);
		
		if(errors.isEmpty()) {
			if ("detailBookAdmin1".equals(pathInfo)) {
				List<BookAndOrder> book = BookDao.getBook(orderNo);
				BookAndOrder order = BookDao.getOrder(orderNo);
				Boolean order2 = BookDao.updatePaymentOrder(order);
				if(book == null) {
					System.out.println("ko có sách");
				}else {
					request.setAttribute("book", book);
					request.setAttribute("order", order);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Views/detailBookAdmin.jsp");
					dispatcher.forward(request, response);
				}
			}
			if ("detailBookAdmin".equals(pathInfo)) {
				String bookIdStr = request.getParameter("bookId");
				int bookId = -1;
				try {
					bookId = Integer.parseInt(bookIdStr);
				} catch (Exception e) {
					// TODO: handle exception
					errors.add("Không tồn tại bookId");
				}
				Book book = BookDao.getBook(bookId);
				if(book == null) {
					System.out.println("ko có sách");
				}else {
					request.setAttribute("book", book);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Views/detailBookAdmin_.jsp");
					dispatcher.forward(request, response);
				}
			}
			if ("detailBookAdmin2".equals(pathInfo)) {
				List<BookAndOrder> book = BookDao.getBook(orderNo);
				BookAndOrder order = BookDao.getOrder(orderNo);
				if(book == null) {
					System.out.println("ko có sách");
				}else {
					request.setAttribute("book", book);
					request.setAttribute("order", order);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Views/detailBookAdmin.jsp");
					dispatcher.forward(request, response);
				}
			}
			if ("detailBookAdmin3".equals(pathInfo)) {
				List<BookAndOrder> book = BookDao.getBook(orderNo);
				BookAndOrder order = BookDao.getOrder(orderNo);
				if(book == null) {
					System.out.println("ko có sách");
				}else {
					request.setAttribute("book", book);
					request.setAttribute("order", order);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Views/detailBookAdmin.jsp");
					dispatcher.forward(request, response);
				}
			}
			if ("detailBookAdmin5".equals(pathInfo)) {
				List<BookAndOrder> book = BookDao.getBook(orderNo);
				BookAndOrder order = BookDao.getOrder(orderNo);
				if(book == null) {
					System.out.println("ko có sách");
				}else {
					request.setAttribute("book", book);
					request.setAttribute("order", order);
					RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Views/detailBookAdmin.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		if(!errors.isEmpty()) {
			request.setAttribute("errors", String.join(", ", errors));
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/adminHome");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

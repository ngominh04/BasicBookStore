package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.model.BookDao;
import vnua.fita.bookstore.utils.MyUtils;

/**
 * Servlet implementation class OrderAdmin1
 */
@WebServlet(urlPatterns = {"/OrderAdmin1","/OrderAdmin2","/OrderAdmin3","/OrderAdmin5"} )
public class OrderAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String servletPath = request.getServletPath();
		String pathInfo = MyUtils.getPathInfoFromServletPath(servletPath);
		String errors = null;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Book> list = BookDao.listAllBooks();
		String keyword = request.getParameter("keyword");
		if("OrderAdmin1".equals(pathInfo)) {
			if(keyword != null && !keyword.isEmpty()) {
				list = BookDao.listAllOrder_1(keyword);
			}else {
				list = BookDao.listAllOrder_1();
			}
			if (list.isEmpty()) {
				errors = "Không thể lấy dữ liệu";
			}
	
			request.setAttribute("errors", errors);
			request.setAttribute("bookList", list);
			RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher("/Views/orderAdmin1.jsp");
			rd.forward(request, response);
		}
		if("OrderAdmin2".equals(pathInfo)) {
			list = BookDao.listAllOrder_2();
			if (list.isEmpty()) {
				errors = "Không thể lấy dữ liệu";
			}
	
			request.setAttribute("errors", errors);
			request.setAttribute("bookList", list);
			RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher("/Views/orderAdmin2.jsp");
			rd.forward(request, response);
		}
		if("OrderAdmin3".equals(pathInfo)) {
			list = BookDao.listAllOrder_3();
			if (list.isEmpty()) {
				errors = "Không thể lấy dữ liệu";
			}
	
			request.setAttribute("errors", errors);
			request.setAttribute("bookList", list);
			RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher("/Views/orderAdmin3.jsp");
			rd.forward(request, response);
		}
		if("OrderAdmin5".equals(pathInfo)) {
			list = BookDao.listAllOrder_5();
			if (list.isEmpty()) {
				errors = "Không thể lấy dữ liệu";
			}
	
			request.setAttribute("errors", errors);
			request.setAttribute("bookList", list);
			RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher("/Views/orderAdmin5.jsp");
			rd.forward(request, response);
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

package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.model.BookDao;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookId = request.getParameter("bookId");
		int id = Integer.parseInt(bookId);
		boolean check = BookDao.deleteBook(id);
		if (check) {
			response.sendRedirect(request.getContextPath() + "/adminHome");
		}
		else {
			System.out.println("Ko xóa đc ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		int id = Integer.parseInt(bookId);
		boolean check = BookDao.deleteBook(id);
		if (check) {
			response.sendRedirect(request.getContextPath() + "/adminHome");
		}
		else {
			System.out.println("Ko xóa đc ");
		}
	}

}

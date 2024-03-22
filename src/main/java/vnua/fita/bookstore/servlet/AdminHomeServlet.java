package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/adminHome")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errors = null;
		int page = 1;
		int revordsPerPage =2;
		
		
		if (request.getParameter("page") != null) {
			page =Integer.parseInt(request.getParameter("page"));
		}
		
		String keyword = request.getParameter("keyword");
		Date today = new Date();
		int noOfRecords = BookDao.getNoOfRecords(keyword);
		int noOfPages = (int) Math.ceil(noOfRecords*1.0/revordsPerPage);
		
		
		Date todaySubtract12Month = MyUtils.subtractFromDate(12, today);
		String todaySubtract12MonthStr = MyUtils.convertDateToString(todaySubtract12Month);
		String todayStr = MyUtils.convertDateToString(today);
		
		List<Book> list  = BookDao.listAllBooks((page-1)*revordsPerPage, revordsPerPage,keyword, todaySubtract12MonthStr, todayStr);
		
		if (list.isEmpty()) {
			errors = "Không thể lấy dữ liệu";
		}
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		request.setAttribute("errors", errors);
		request.setAttribute("turnover", calSumOfMoney(list));
		request.setAttribute("bookList", list);
		RequestDispatcher rd = this.getServletContext()
				.getRequestDispatcher("/Views/adminHomeView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		List<Book> list= BookDao.listAllBook();
////		Book book = new Book(1, "a", "b",120000, 0, "a", "b");
////		list.add(book);
//		request.setAttribute("bookList", list);
		doGet(request, response);
	}
	private boolean validateDate(String fromDate, String toDate) {
		if(fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty()) {
			return true;
		}
		return false;
	}
	
	private int calSumOfMoney(List<Book> list) {
		int sum = 0;
		for(Book book: list) {
			sum+=book.getSumOfSoldBook();
		}
		return sum;
	}

}

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
import vnua.fita.bookstore.model.BookDao;
import vnua.fita.bookstore.utils.MyUtils;

/**
 * Servlet implementation class ConFrimOrderAdmin
 */
@WebServlet(urlPatterns = {"/confirmOrder1","/confirmOrder2","/confirmOrder3","/confirmOrder5"})
public class ConFrimOrderAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConFrimOrderAdmin() {
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
			if ("confirmOrder1".equals(pathInfo)) {
				BookAndOrder order = BookDao.getOrder(orderNo);
				order.setOrderId(order.getOrderId());
				order.setOrderStatus(2);
				boolean update =BookDao.updateOrder(order);
				if(update) {
					System.out.println("cập nhật thành công orderStatus");
				}else {
					System.out.println("cập nhật thất bại orderStatus");
				}
				List<BookAndOrder> list = BookDao.listAllOrder_1();
				request.setAttribute("order", list);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/OrderAdmin1");
				dispatcher.forward(request, response);
			}
			if ("confirmOrder2".equals(pathInfo)) {
				BookAndOrder book = BookDao.getOrder(orderNo);
				book.setOrderId(book.getOrderId());
				book.setOrderStatus(3);
				boolean update =BookDao.updateOrder(book);
				if(update) {
					System.out.println("cập nhật thành công orderStatus");
				}else {
					System.out.println("cập nhật thất bại orderStatus");
				}
				List<BookAndOrder> list = BookDao.listAllOrder_2();
				request.setAttribute("order", list);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/OrderAdmin2");
				dispatcher.forward(request, response);
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

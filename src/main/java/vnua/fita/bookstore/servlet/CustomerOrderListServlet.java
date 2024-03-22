package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vnua.fita.bookstore.bean.Order;
import vnua.fita.bookstore.frombean.LoginFrom;
import vnua.fita.bookstore.model.OrderDao;
import vnua.fita.bookstore.model.UserDao;
import vnua.fita.bookstore.utils.MyUtils;

/**
 * Servlet implementation class CustomerOrderListServlet
 */
@WebServlet("/customerOrderList")
public class CustomerOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrderListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customerUserName = MyUtils.getLoginedUser(request.getSession()).getUsername();
		List<Order> orderListOfCustomer = OrderDao.getOrderList(customerUserName);
		request.setAttribute("orderListOfCustomer", orderListOfCustomer);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/Views/customerOrderListView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

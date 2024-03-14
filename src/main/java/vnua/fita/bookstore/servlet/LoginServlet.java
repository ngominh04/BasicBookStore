package vnua.fita.bookstore.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vnua.fita.bookstore.bean.User;
import vnua.fita.bookstore.frombean.LoginFrom;
import vnua.fita.bookstore.model.UserDao;
import vnua.fita.bookstore.utils.MyUtils;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Views/loginView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: "+username);
		System.out.println("Pass: "+ password);
		LoginFrom loginForm = new LoginFrom(username, password);
		
		List<String> errors = loginForm.validate();
		if(errors.isEmpty()) {

		User user= UserDao.findUser(username, password);
		// Nếu ko thấy, bổ sung vào ds lỗi

		if (user == null) {
			errors.add("Sai thong tin tai khoan");
			}
		
		else { 
			HttpSession session = request.getSession();
			MyUtils.storeLoginedUser(session, user);
			if(user.getRole() == 1) {
				response.sendRedirect(request.getContextPath()+"/adminHome");
			}else {
				response.sendRedirect(request.getContextPath()+"/clientHome");
			}
			
		}

		if (!errors.isEmpty()) {

		request.setAttribute("errors", String.join(", ", errors));
		request.setAttribute("loginForm", loginForm);
		// Chuyển tiếp tới trang /views/loginView.jsp
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/Views/loginView.jsp");
		rd.forward(request, response);
		}
		
	}
	}
}

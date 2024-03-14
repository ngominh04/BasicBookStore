package vnua.fita.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vnua.fita.bookstore.bean.User;
import vnua.fita.bookstore.config.SecurityConfig;
import vnua.fita.bookstore.utils.MyUtils;

@WebFilter(filterName = "securityFilter", urlPatterns = { "/*" })
public class SecurityFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		String servletPathFull = request.getServletPath();
		String servletPath = MyUtils.getServletPath(servletPathFull);
		//System.out.println("Servlet Path Full: " + servletPathFull);
		
		if (!SecurityConfig.checkDenyUrlPattern(servletPath)) {
			chain.doFilter(request, response);
			return;
		}

		User loginedUser = MyUtils.getLoginedUser(request.getSession());
		boolean isPermission = false;
		if (loginedUser != null) { 
			byte role = (byte) loginedUser.getRole();
			isPermission = SecurityConfig.checkPermission(role, servletPath);
		}
		
		if(!isPermission) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}

		chain.doFilter(request, response);

		
	}
	
}
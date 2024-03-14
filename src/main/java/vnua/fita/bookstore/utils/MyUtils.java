package vnua.fita.bookstore.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.print.attribute.standard.Fidelity;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vnua.fita.bookstore.bean.Cart;
import vnua.fita.bookstore.bean.CartItem;
import vnua.fita.bookstore.bean.User;

public class MyUtils {
	public static void storeLoginedUser(HttpSession session, User loginedUser) {
			// Trên JSP có thể truy cập thông qua id: ${loginedUser}
			session.setAttribute("loginedUser", loginedUser);
			}
	public static void storeCart(HttpSession session, Cart cart) {
		// Trên JSP có thể truy cập thông qua id: ${loginedUser}
		session.setAttribute("cartOfCustomer", cart);
		}
	public static Cart getCartOfCustomer(HttpSession session) {
		// Trên JSP có thể truy cập thông qua id: ${loginedUser}
		Cart cartOfCustomer= (Cart) session.getAttribute("cartOfCustomer");
		return cartOfCustomer;
		}
	public static void updateCartOfCustomer(HttpSession session, Map<Integer, CartItem> cartItemList) {
		// Trên JSP có thể truy cập thông qua id: ${loginedUser}
			Cart cartOfCustomer = getCartOfCustomer(session);
			cartOfCustomer.setCartItemList(cartItemList);
			session.setAttribute("cartOfCustomer", cartOfCustomer);
		}
	public static void deleteCart(HttpSession session) {
		session.removeAttribute("cartOfCustomer");
	}
	public static String getPathInfoFromServletPath(String path) {
		if (path == null || path.isEmpty()) {
	        return ""; // Hoặc có thể ném một ngoại lệ
	    }
	
	    String[] result = path.split("/");
	    if (result.length == 0) {
	        return "";
	    }
	
	    return result[result.length - 1];
	}
	
	public static String getTimeLabel() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd_MM_yyyy hh_mm");
		return sdf.format(new Date());
	}
	public static String createOrderNo(int orderId) {
		SimpleDateFormat sdf= new SimpleDateFormat("ddMMyy");
		int code = orderId %100 ;
		return sdf.format(new Date())+ code;
	}
	public static String extractFileExxtension(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		int indexOfDot = contentDisp.lastIndexOf(".");
		return contentDisp.substring(indexOfDot,contentDisp.length()-1);
	}

	// upload ảnh
	public static File getFolderUpload(String appPath,String folderName) {
		File file = new File(appPath+File.separator+folderName);
		if (!file.exists()) {
			file.mkdirs();
		}
		return file;
	}
	
	public static String convertDateToString(Date date) {
		DateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	public static String convertDateToStringVn(Date date) {
		DateFormat sdf = new  SimpleDateFormat("dd-MM-yyyy HH:mm");
		return sdf.format(date);
	}
	public static Date subtractFromDate(int months,Date date) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -3);
		return calendar.getTime();
	}
	public static String attachTailToDate(String date) {
		return date+" 00:00:00";
	}
	public static User getLoginedUser(HttpSession session) {
		return (User) session.getAttribute("loginedUser");
	}
	public static void storeUserCookie(HttpServletResponse response, User user) {
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie("USERNAME_STORE_IN_COOKIE_OF_BOOKSTORE",user.getUsername());
		// 1 ngay(doi ra giay)
		cookieUserName.setMaxAge(60 * 60 * 24);
		response.addCookie(cookieUserName);
		Cookie cookieToken = new Cookie("TOKEN_STORE_IN_COOKIE_OF_BOOKSTORE",createTokenFromUserInfo(user));
		
		//1 ngay (da doi ra giay)
		cookieToken.setMaxAge(60*60*24);
		response.addCookie(cookieToken);
	}
	
	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if("USERNAME_STORE_IN_COOKIE_OF_BOOKSTORE".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Lấy ra chuỗi mã hóa lưu trong Cookie
	public static String getTokenInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("TOKEN_STORE_IN_COOKIE_OF_BOOKSTORE".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Tạo chuỗi mã hóa để lưu vào cookie, dành cho xác thực về sau
	public static String createTokenFromUserInfo(User user) {
		return user.getUsername() + "SECRET_STRING" + user.getPasword();
	}

	// xóa Cookie của người dùng
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie("USERNAME_STORE_IN_COOKIE_OF_BOOKSTORE",null);
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
		Cookie cookieToken = new Cookie("TOKEN_STORE_IN_COOKIE_OF_BOOKSTORE",null);
				
		cookieToken.setMaxAge(0);
		response.addCookie(cookieToken);
	}
	public static String getServletPath(String servletPathFull) {
		if (servletPathFull == null || servletPathFull.isEmpty()) {
			// Hoặc có thể ném một ngoại lệ
			return ""; 
		}

		String[] result = servletPathFull.split("/");
		if (result.length == 0) {
			return "";
		}
		return "/"+result[1];
	}
}

package vnua.fita.bookstore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.bean.CartItem;
import vnua.fita.bookstore.bean.Order;
import vnua.fita.bookstore.database.Database;
import vnua.fita.bookstore.utils.MyUtils;

public class OrderDao {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	private static Statement statement;
	private static PreparedStatement preStatement;
	private static ResultSet resultSet;

	public OrderDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	// trả lại kết quả check và cập nhật số lượng có trong kho của các mặt hàng
	// trong order
	public static boolean checkAndUpdateAvaiableBookOfOrder(Order order) {
		boolean checkAvaiable = true; // có hàng
		String sql;
		List<CartItem> orderBookList = order.getOrderBookList();
		try {
			Connection jdbcConnection =Database.getConnection();
			for (CartItem cartItem : orderBookList) {
				sql = "SELECT quantity_in_stock FROM book WHERE id=?";
				preStatement = jdbcConnection.prepareStatement(sql);
				Book selectedBook = cartItem.getSelectedBook();
				preStatement.setInt(1, selectedBook.getBookId());
				resultSet = preStatement.executeQuery();
				if (resultSet.next()) {
					int presentQuantityInStock = resultSet.getInt("quantity_in_stock"); // số
																						// lượng
																						// hiện
																						// có
																						// trong
																						// kho
					if (presentQuantityInStock < cartItem.getQuantity()) { // nếu nhỏ hơn
																			// số lượng
																			// đặt mua
						checkAvaiable = false;
						selectedBook.setQuantityInStock(presentQuantityInStock);
						// cập nhật số lượng có trong kho của sách
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkAvaiable;
	}

	public static boolean insertOrder(Order order) {
		boolean insertResult = false;
		int orderId = -1;
		String orderNo = null;

		String sql1 = "INSERT INTO tblorder(customer_username, payment_mode, order_status, total_cost, payment_img, payment_status, delivery_address, order_approve_date, status_date, order_date) VALUES(?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "SELECT max(order_id) from tblorder";
		String sql3 = "UPDATE tblorder SET order_no = ? WHERE order_id = ?";
		String sql4 = "INSERT INTO tblorder_book(book_id, order_id, quantity, price) VALUES(?,?,?,?)";
		String sql5 = "UPDATE book SET quantity_in_stock = ? WHERE id=?";

		Connection jdbcConnection =Database.getConnection();
		try {
			jdbcConnection.setAutoCommit(false);

			// thêm hóa đơn
			preStatement = jdbcConnection.prepareStatement(sql1);
			preStatement.setString(1, order.getCustomer().getUsername());
			preStatement.setString(2, order.getPaymentMode());
			preStatement.setByte(3, order.getOrderStatus());
			preStatement.setFloat(4, order.getTotalCost());
			preStatement.setString(5, order.getPaymentImagePath());
			preStatement.setBoolean(6, order.getPaymentStatus());
			preStatement.setString(7, order.getDeliveryAddress());
			if (order.getOrderApproveDate() != null) {
				preStatement.setString(8,
						MyUtils.convertDateToString(order.getOrderApproveDate()));
			} else {
				preStatement.setString(8, null);
			}
			preStatement.setString(9, MyUtils.convertDateToString(order.getStatusDate()));
			preStatement.setString(10, MyUtils.convertDateToString(order.getOrderDate()));
			insertResult = preStatement.executeUpdate() > 0;

			// Lấy order_id của hóa đơn vừa tạo
			statement = jdbcConnection.createStatement();
			resultSet = statement.executeQuery(sql2);
			if (resultSet.next()) {
				orderId = resultSet.getInt(1);

				// nếu là hình thức thanh toán khi nhận hàng, tạo luôn orderNo từ orderId
				// vừa tạo
				if ("cash".equals(order.getPaymentMode())) {
					preStatement = jdbcConnection.prepareStatement(sql3);
					orderNo = MyUtils.createOrderNo(orderId);
					preStatement.setString(1, orderNo);
					preStatement.setInt(2, orderId);
					insertResult = preStatement.executeUpdate() > 0;
					if (!insertResult) {
						throw new SQLException();
					}
				}
				if ("transfer".equals(order.getPaymentMode())) {
					preStatement = jdbcConnection.prepareStatement(sql3);
					orderNo = MyUtils.createOrderNo(orderId);
					preStatement.setString(1, orderNo);
					preStatement.setInt(2, orderId);
					insertResult = preStatement.executeUpdate() > 0;
					if (!insertResult) {
						throw new SQLException();
					}
				}
				List<CartItem> orderBookList = order.getOrderBookList();
				for (CartItem cartItem : orderBookList) {
					// thêm các cuốn sách trong hóa đơn vào bảng tblorder_book
					preStatement = jdbcConnection.prepareStatement(sql4);
					preStatement.setInt(1, cartItem.getSelectedBook().getBookId());
					preStatement.setInt(2, orderId);
					preStatement.setInt(3, cartItem.getQuantity());
					preStatement.setInt(4, cartItem.getSelectedBook().getPrice());
					insertResult = preStatement.executeUpdate() > 0;
					if (!insertResult) {
						throw new SQLException();
					}

					// cập nhật số lượng trong bảng tblbook
					preStatement = jdbcConnection.prepareStatement(sql5);
					preStatement.setInt(1, cartItem.getSelectedBook().getQuantityInStock()
							- cartItem.getQuantity());
					preStatement.setInt(2, cartItem.getSelectedBook().getBookId());
					insertResult = preStatement.executeUpdate()>0;
					if(!insertResult) {
						throw new SQLException();
					}
				}
				jdbcConnection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(insertResult) {
			//thêm thành công, bổ sung thuộc tính vào đối tượng order và trả lại
			order.setOrderId(orderId);
			order.setOrderNo(orderNo);
		}
		return insertResult;
	}

	public static List<Order> getOrderList(String customerUserName) {
		// TODO Auto-generated method stub
		return null;
	}
}

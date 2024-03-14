package vnua.fita.bookstore.model;

import java.util.Date;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import vnua.fita.bookstore.bean.Book;
import vnua.fita.bookstore.bean.BookAndOrder;
import vnua.fita.bookstore.database.Database;
import vnua.fita.bookstore.utils.MyUtils;

public class BookDao {
	// lấy toàn bộ sách
	public static List<Book> listAllBooks() {
		// danh sach chua ket qua tra ve
		List<Book> listBook = new ArrayList<Book>();

		// cau lenh sql
		String sql = "SELECT * FROM	book";

		// tao ket noi
		Connection jdbcConnection = Database.getConnection();
		try {
			// tao doi tuong truy van CSDL
			Statement statement = jdbcConnection.createStatement();

			// thuc hien truy van
			ResultSet resultSet = statement.executeQuery(sql);

			// duyet qua danh sach ban ghi ket qua tra ve
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int quantityInStock = resultSet.getInt("quantity_in_stock");
				String detail = resultSet.getString("detail");
				String imagePath = resultSet.getString("image_path");

				// đóng gói các giá trị thuộc tính vào đối tượng Bean(Book)
				Book book = new Book(id, title, author, price, quantityInStock);
				book.setDetail(detail);
				book.setImagePath(imagePath);

				// Thêm đối tượng Bean vào danh sách
				listBook.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}

	public static List<Book> listAllBooks(String keyword) {
		List<Book> searchBookList = new ArrayList<Book>();

		String sql = "SELECT * FROM book WHERE title LIKE ?";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				Book book = new Book(id, title, author, price);
				searchBookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchBookList;
	}
	
	// order admin 1
	public static List<BookAndOrder> listAllOrder_1() {
		// danh sach chua ket qua tra ve
		List<BookAndOrder> listBook = new ArrayList<BookAndOrder>();

		// cau lenh sql
		String sql = "select distinct\r\n"
				+ "t.order_date orderDate,t.total_cost orderPrice,tb.quantity orderQuantity,t.order_no orderNo,\r\n"
				+ "t2.fullname fullname,t2.mobile mobile\r\n"
				+ "    from tblorder t\r\n"
				+ "             inner join bookshop.tblorder_book tb on t.order_id = tb.order_id\r\n"
				+ "             inner join tbluser t2 on t2.username = t.customer_username\r\n"
				+ "where t.order_status = 1";

		// tao ket noi
		Connection jdbcConnection = Database.getConnection();
		try {
			// tao doi tuong truy van CSDL
			Statement statement = jdbcConnection.createStatement();
			
			// thuc hien truy van
			ResultSet resultSet = statement.executeQuery(sql);

			// duyet qua danh sach ban ghi ket qua tra ve
			while (resultSet.next()) {
				String orderNo = resultSet.getString("orderNo");
				String fullName = resultSet.getString("fullname");
				String mobile = resultSet.getString("mobile");
				Float totalCost = resultSet.getFloat("orderPrice");
				Date orderDate = resultSet.getTimestamp("orderDate");
				BookAndOrder book = new BookAndOrder(orderNo, orderDate, totalCost, fullName, mobile);
				// Thêm đối tượng Bean vào danh sách
				listBook.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}

	
	// order admin 2
		public static List<BookAndOrder> listAllOrder_2() {
			// danh sach chua ket qua tra ve
			List<BookAndOrder> listBook = new ArrayList<BookAndOrder>();

			// cau lenh sql
			String sql = "select distinct\r\n"
					+ "t.order_date orderDate,t.total_cost orderPrice,tb.quantity orderQuantity,t.order_no orderNo,\r\n"
					+ "t2.fullname fullname,t2.mobile mobile\r\n"
					+ "    from tblorder t\r\n"
					+ "             inner join bookshop.tblorder_book tb on t.order_id = tb.order_id\r\n"
					+ "             inner join tbluser t2 on t2.username = t.customer_username\r\n"
					+ "where t.order_status = 2";

			// tao ket noi
			Connection jdbcConnection = Database.getConnection();
			try {
				// tao doi tuong truy van CSDL
				Statement statement = jdbcConnection.createStatement();
				
				// thuc hien truy van
				ResultSet resultSet = statement.executeQuery(sql);

				// duyet qua danh sach ban ghi ket qua tra ve
				while (resultSet.next()) {
					String orderNo = resultSet.getString("orderNo");
					String fullName = resultSet.getString("fullname");
					String mobile = resultSet.getString("mobile");
					Float totalCost = resultSet.getFloat("orderPrice");
					Date orderDate = resultSet.getTimestamp("orderDate");
					BookAndOrder book = new BookAndOrder(orderNo, orderDate, totalCost, fullName, mobile);
					// Thêm đối tượng Bean vào danh sách
					listBook.add(book);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listBook;
		}
		// order admin 3
	public static List<BookAndOrder> listAllOrder_3() {
		// danh sach chua ket qua tra ve
				List<BookAndOrder> listBook = new ArrayList<BookAndOrder>();

				// cau lenh sql
				String sql = "select distinct\r\n"
						+ "t.order_date orderDate,t.total_cost orderPrice,tb.quantity orderQuantity,t.order_no orderNo,\r\n"
						+ "t2.fullname fullname,t2.mobile mobile\r\n"
						+ "    from tblorder t\r\n"
						+ "             inner join bookshop.tblorder_book tb on t.order_id = tb.order_id\r\n"
						+ "             inner join tbluser t2 on t2.username = t.customer_username\r\n"
						+ "where t.order_status = 3";

				// tao ket noi
				Connection jdbcConnection = Database.getConnection();
				try {
					// tao doi tuong truy van CSDL
					Statement statement = jdbcConnection.createStatement();
					
					// thuc hien truy van
					ResultSet resultSet = statement.executeQuery(sql);

					// duyet qua danh sach ban ghi ket qua tra ve
					while (resultSet.next()) {
						String orderNo = resultSet.getString("orderNo");
						String fullName = resultSet.getString("fullname");
						String mobile = resultSet.getString("mobile");
						Float totalCost = resultSet.getFloat("orderPrice");
						Date orderDate = resultSet.getTimestamp("orderDate");
						BookAndOrder book = new BookAndOrder(orderNo, orderDate, totalCost, fullName, mobile);
						// Thêm đối tượng Bean vào danh sách
						listBook.add(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return listBook;
	}
	// order admin 5
		public static List<BookAndOrder> listAllOrder_5() {
			// danh sach chua ket qua tra ve
			List<BookAndOrder> listBook = new ArrayList<BookAndOrder>();

			// cau lenh sql
			String sql = "select distinct\r\n"
					+ "t.order_date orderDate,t.total_cost orderPrice,tb.quantity orderQuantity,t.order_no orderNo,\r\n"
					+ "t2.fullname fullname,t2.mobile mobile\r\n"
					+ "    from tblorder t\r\n"
					+ "             inner join bookshop.tblorder_book tb on t.order_id = tb.order_id\r\n"
					+ "             inner join tbluser t2 on t2.username = t.customer_username\r\n"
					+ "where t.order_status = 5";

			// tao ket noi
			Connection jdbcConnection = Database.getConnection();
			try {
				// tao doi tuong truy van CSDL
				Statement statement = jdbcConnection.createStatement();
				
				// thuc hien truy van
				ResultSet resultSet = statement.executeQuery(sql);

				// duyet qua danh sach ban ghi ket qua tra ve
				while (resultSet.next()) {
					String orderNo = resultSet.getString("orderNo");
					String fullName = resultSet.getString("fullname");
					String mobile = resultSet.getString("mobile");
					Float totalCost = resultSet.getFloat("orderPrice");
					Date orderDate = resultSet.getTimestamp("orderDate");
					BookAndOrder book = new BookAndOrder(orderNo, orderDate, totalCost, fullName, mobile);
					// Thêm đối tượng Bean vào danh sách
					listBook.add(book);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listBook;
		}


	public static List<Book> listAllBooks(String fromDate, String toDate) {
		List<Book> listBooks = new ArrayList<Book>();
		String sql = "SELECT b.*, sum(obor.quantity) AS sum_quantity, sum(obor.price*obor.quantity) AS sum_price FROM book b "
				+ "LEFT JOIN "
				+ "(SELECT ob.* from tblorder_book ob INNER JOIN tblorder o ON ob.order_id = o.order_id "
				+ "WHERE o.order_status = ? AND (o.status_date BETWEEN ? AND ?)) obor "
				+ "ON b.id = obor.book_id "
				+ "GROUP BY b.id "
				+ "ORDER BY sum_quantity DESC, b.create_date DESC";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setInt(1, 3);
			preStatement.setString(2, fromDate);
			preStatement.setString(3, toDate);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int quantityInStock = resultSet.getInt("quantity_in_stock");
				String detail = resultSet.getString("detail");
				String imagePath = resultSet.getString("image_path");
				Date createDate = resultSet.getTimestamp("create_date");
				int soldQuantity = resultSet.getInt("sum_quantity");
				int sumOfSoldBook = resultSet.getInt("sum_price");
				Book book = new Book(id, title, author, price, quantityInStock);
				book.setDetail(detail);
				book.setImagePath(imagePath);
				book.setCreateDate(createDate);
				book.setSoldQuantity(soldQuantity);
				book.setSumOfSoldBook(sumOfSoldBook);
				listBooks.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBooks;
	}
	
	
	// xóa sách 
	public static boolean deleteBook(int bookId) {
		boolean result = false;
		// Cau lenh sql
		String sql = "DELETE FROM book WHERE id = ?";

		// Tao ket noi
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setInt(1, bookId);
			int check = preStatement.executeUpdate();
			if (check > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	
	}
	
	// lấy ra sách theo id
	public static Book getBook(int id) {
		Book book = null;
		String sql = "SELECT * FROM book WHERE id = ?";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setInt(1, id);
			ResultSet resultSet = preStatement.executeQuery();
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int quantityInStock = resultSet.getInt("quantity_in_stock");
				String detail = resultSet.getString("detail");
				String imagePath = resultSet.getString("image_path");

				// đóng gói các giá trị thuộc tính vào đối tượng Bean(Book)
				book = new Book(id, title, author, price, quantityInStock);
				book.setDetail(detail);
				book.setImagePath(imagePath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	// lấy sách theo orderNo
	public static List<BookAndOrder> getBook(String orderNo) {
		List<BookAndOrder> list = new ArrayList<BookAndOrder>();
		String sql = "select b.*,tb.quantity orderQuantity from book b\r\n"
				+ "        inner join bookshop.tblorder_book tb on b.id = tb.book_id\r\n"
				+ "        inner join bookshop.tblorder t on tb.order_id = t.order_id\r\n"
				+ "where t.order_no = ?"
				+ "";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, orderNo);
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()) {
				Integer bookId = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int orderQuantity = resultSet.getInt("orderQuantity");
				String imagePath = resultSet.getString("image_path");
				
				// đóng gói các giá trị thuộc tính vào đối tượng Bean(Book)
				BookAndOrder book = new BookAndOrder(bookId, title, author, price, imagePath,orderQuantity);
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// lấy thông tin đơn hàng theo orderNo
	public static BookAndOrder getOrder(String OrderNo) {
		BookAndOrder order = null;
		String sql = "select distinct t.*,t2.fullname fullname,t2.mobile mobile from tblorder t\r\n"
				+ "           inner join bookshop.tblorder_book tb on t.order_id = tb.order_id\r\n"
				+ "           inner join tbluser t2 on t2.username = t.customer_username\r\n"
				+ "where t.order_no = ?";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, OrderNo);
			ResultSet resultSet = preStatement.executeQuery();
			if (resultSet.next()) {
				String fullname=resultSet.getString("fullname");
				String mobile=resultSet.getString("mobile");
				String orderNo = resultSet.getString("order_no");
				Date orderDate= resultSet.getTimestamp("order_date");
				String deliveryAddress = resultSet.getString("delivery_address");
				Boolean paymentStatus=resultSet.getBoolean("payment_status");
				Integer totalCost = resultSet.getInt("total_cost");
				int orderStatus = resultSet.getInt("order_status");
				// đóng gói các giá trị thuộc tính vào đối tượng Bean(Book)
				order = new BookAndOrder(orderNo, orderDate, paymentStatus
						, totalCost, deliveryAddress, fullname, mobile,orderStatus);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}
	
	
	// update status của order
	public static boolean updateOrder(BookAndOrder book) {
		boolean result = false;
		String sql = "update tblorder set order_status = ?\r\n"
				+ "where order_no =?";
		Connection jdbcConnection = Database.getConnection();

		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setInt(1, book.getOrderStatus());
			preStatement.setString(2, book.getOrderNo());
			result = preStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	// update book đã sửa
	public static boolean updateBook(Book book) {
		boolean result = false;
		String sql = "UPDATE book SET title = ?, author = ?, price = ?, quantity_in_stock = ?, "
				+ "detail=?, image_path=? WHERE id = ?";
		Connection jdbcConnection = Database.getConnection();

		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, book.getTitle());
			preStatement.setString(2, book.getAuthor());
			preStatement.setInt(3, book.getPrice());
			preStatement.setInt(4, book.getQuantityInStock());
			preStatement.setString(5, book.getDetail());
			preStatement.setString(6, book.getImagePath());
			preStatement.setInt(7, book.getBookId());
			result = preStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static boolean insertBook(Book book) {
		boolean insertResult = false;
		String sql = "INSERT INTO book(title, author, price, quantity_in_stock, detail, image_path, create_date) VALUE (?,?,?,?,?,?,?)";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, book.getTitle());
			preStatement.setString(2, book.getAuthor());
			preStatement.setInt(3, book.getPrice());
			preStatement.setInt(4, book.getQuantityInStock());
			preStatement.setString(5, book.getDetail());
			preStatement.setString(6, book.getImagePath());
			preStatement.setString(7, MyUtils.convertDateToString(book.getCreateDate()));
			insertResult = preStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertResult;
	}
	
	public static List<Book> listAllBooks(int offset, int noOfRecords, String keyword) {
		List<Book> listBook = new ArrayList<Book>();
		String sql = "SELECT * FROM book ";
		if (keyword != null && !keyword.isEmpty()) {
			sql += "WHERE title LIKE ? ";
		}
		sql += "ORDER BY create_date DESC ";
		sql += "LIMIT ?, ?";
		Connection jdbcConnection = Database.getConnection();
		try {
			int index = 0;
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			if (keyword != null && !keyword.isEmpty()) {
				preStatement.setString(++index, "%" + keyword + "%");
			}
			preStatement.setInt(++index, offset); // vị trí bắt đầu lấy
			preStatement.setInt(++index, noOfRecords); // số bản ghi lấy ra

			ResultSet resultSet = preStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int quantityInStock = resultSet.getInt("quantity_in_stock");
				String detail = resultSet.getString("detail");
				String imagePath = resultSet.getString("image_path");

				Book book = new Book(id, title, author, price, quantityInStock);
				book.setDetail(detail);
				book.setImagePath(imagePath);
				listBook.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}

	public static List<Book> listAllBooks(String keyword, String fromDate, String toDate){
		List<Book> searchBookList = new ArrayList<Book>();
		String sql = "SELECT b.*, sum(obor.quantity) AS sum_quantity, sum(obor.price) AS sum_price FROM book b "
				+ "LEFT JOIN "
				+ "(SELECT ob.* from tblorder_book ob INNER JOIN tblorder o ON ob.order_id = o.order_id "
				+ "WHERE o.order_status = ? AND (o.status_date BETWEEN ? AND ?)) obor "
				+ "ON b.book_id = obor.book_id "
				+ "WHERE title LIKE ? "
				+ "GROUP BY b.id "
				+ "ORDER BY sum_quantity DESC, b.create_date DESC";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setInt(1, 3);
			preStatement.setString(2, fromDate);
			preStatement.setString(3, toDate);
			preStatement.setString(4, "%"+keyword+"%");
			ResultSet resultSet = preStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				int price = resultSet.getInt("price");
				int quantityInStock = resultSet.getInt("quantity_in_stock");
				String detail = resultSet.getString("detail");
				String imagePath = resultSet.getString("image_path");
				Timestamp createDate = resultSet.getTimestamp("create_date");
				int soldQuantity = resultSet.getInt("sum_quantity");
				int sumOfSoldBook = resultSet.getInt("sum_price");
				Book book = new Book(id, title, author, price, quantityInStock);
				book.setDetail(detail);
				book.setImagePath(imagePath);
				book.setCreateDate(createDate);
				book.setSoldQuantity(soldQuantity);
				book.setSumOfSoldBook(sumOfSoldBook);
				searchBookList.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchBookList;
	}

	public static int getNoOfRecords(String keyword) {
		String sql = "SELECT count(id) FROM book ";
		int result = 0;
		if (keyword != null && !keyword.isEmpty()) {
			sql += "WHERE title LIKE ? ";
		}
		sql += "ORDER BY create_date DESC ";
		Connection jdbcConnection = Database.getConnection();
		try {
			PreparedStatement preStatement = jdbcConnection.prepareStatement(sql);
			if (keyword != null && !keyword.isEmpty()) {
				preStatement.setString(1, "%" + keyword + "%");
			}
			ResultSet resultSet = preStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
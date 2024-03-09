package vnua.fita.bookstore.bean;

import java.util.Date;

public class BookAndOrder {
	private int bookId;
	private String title;
	private String author;
	private int price;
	private int quantityInStock;
	private String detail;
	private String imagePath;
	private Date createDate;
	private int orderId;
	private String orderNo;
	private User customer;
	private Date orderDate;
	private Date orderApproveDate;
	private String paymentMode;
	private String paymentModeDescription;
	private int orderStatus;
	private String orderStatusDescription;
	private float totalCost;
	private String paymentImagePath;
	private boolean paymentStatus;
	private String paymentStatusDescription;
	private Date statusDate;
	private String deliveryAddress;
	private int orderPrice;
	private int orderQuantity;
	
	
	
	public BookAndOrder(String title, String author, int price, String detail, String imagePath, String orderNo,
			User customer, Date orderDate, int orderStatus, float totalCost, String paymentStatusDescription,
			String deliveryAddress, int orderQuantity) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.detail = detail;
		this.imagePath = imagePath;
		this.orderNo = orderNo;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
		this.paymentStatusDescription = paymentStatusDescription;
		this.deliveryAddress = deliveryAddress;
		this.orderQuantity = orderQuantity;
	}

	public BookAndOrder(int bookId,String title, String author, int price, int quantityInStock, String detail, String imagePath,
			int orderId,Date orderDate, int orderStatus, float totalCost, String paymentImagePath
			, String deliveryAddress,int orderQuantity) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.detail = detail;
		this.imagePath = imagePath;
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
		this.paymentImagePath = paymentImagePath;
		this.deliveryAddress = deliveryAddress;
		this.orderQuantity = orderQuantity;
	}
	
	public BookAndOrder(String title, String author, int price, int quantityInStock, String detail, String imagePath,
			Date orderDate, int orderStatus, float totalCost, String paymentImagePath, String deliveryAddress) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.detail = detail;
		this.imagePath = imagePath;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.totalCost = totalCost;
		this.paymentImagePath = paymentImagePath;
		this.deliveryAddress = deliveryAddress;
	}
	
	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public BookAndOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderApproveDate() {
		return orderApproveDate;
	}
	public void setOrderApproveDate(Date orderApproveDate) {
		this.orderApproveDate = orderApproveDate;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentModeDescription() {
		return paymentModeDescription;
	}
	public void setPaymentModeDescription(String paymentModeDescription) {
		this.paymentModeDescription = paymentModeDescription;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}
	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public String getPaymentImagePath() {
		return paymentImagePath;
	}
	public void setPaymentImagePath(String paymentImagePath) {
		this.paymentImagePath = paymentImagePath;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentStatusDescription() {
		return paymentStatusDescription;
	}
	public void setPaymentStatusDescription(String paymentStatusDescription) {
		this.paymentStatusDescription = paymentStatusDescription;
	}
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
}

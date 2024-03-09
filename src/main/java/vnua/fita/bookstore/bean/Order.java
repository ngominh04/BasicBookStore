package vnua.fita.bookstore.bean;

import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order>{

	private int orderId;
	private String orderNo;
	private User customer;
	private Date orderDate;
	private Date orderApproveDate;
	private String paymentMode;
	private String paymentModeDescription;
	private byte orderStatus;
	private String orderStatusDescription;
	private float totalCost;
	private String paymentImagePath;
	private boolean paymentStatus;
	private String paymentStatusDescription;
	private Date statusDate;
	private String deliveryAddress;
	private List<CartItem> orderBookList;
	

	
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
		if ("cashPaymentMode".equals(paymentMode)) {
			this.paymentStatusDescription = "Tiền mặt khi nhận sách";
		}
		if ("tranferPaymentMode".equals(paymentMode)) {
			this.paymentStatusDescription = "Chuyển khoản";
		}
	}



	public String getPaymentModeDescription() {
		return paymentModeDescription;
	}



	public void setPaymentModeDescription(String paymentModeDescription) {
		this.paymentModeDescription = paymentModeDescription;
	}



	public byte getOrderStatus() {
		return orderStatus;
		
	}



	public void setOrderStatus(byte orderStatus) {
		this.orderStatus = orderStatus;
		switch (orderStatus) {
		case 1:
			this.orderStatusDescription = "Chờ xác nhận";
			break;
		case 2:
			this.orderStatusDescription = "Đang giao hàng";
			break;
		case 3:
			this.orderStatusDescription = "Đã giao hàng";
			break;
		case 4:
			this.orderStatusDescription = "Khách hủy đơn";
			break;
		case 5:
			this.orderStatusDescription = "Khách trả hàng";
			break;
		case 6:
			this.orderStatusDescription = "Khách hàng không còn đủ";
			break;
		
	}
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



	public void setTotalCost(float f) {
		this.totalCost = f;
	}



	public String getPaymentImagePath() {
		return paymentImagePath;
	}



	public void setPaymentImagePath(String paymentImagePath) {
		this.paymentImagePath = paymentImagePath;
	}



	public boolean getPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
		if (paymentStatus) {
			this.paymentStatusDescription="paymentedStatus";
		}else {
			this.paymentStatusDescription="unpaymentStatus";
		}
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



	public List<CartItem> getOrderBookList() {
		return orderBookList;
	}



	public void setOrderBookList(List<CartItem> orderBookList) {
		this.orderBookList = orderBookList;
	}



	@Override
	public int compareTo(Order o) {
		// TODO Auto-generated method stub
		return o.orderId - this.orderId;
	}
	
	
}
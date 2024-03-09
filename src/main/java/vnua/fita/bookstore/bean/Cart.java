package vnua.fita.bookstore.bean;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CartItem> cartItemList;
	private float totalCost;
	private String paymentMode;
	private boolean paymentStatus;
	
	public Cart() {
		cartItemList = new HashMap<Integer, CartItem>();
		totalCost = 0;
	}
	public Map<Integer, CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(Map<Integer, CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}
	public float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	// thêm sản phẩm vào giỏ hàng
		public void addCartItemToCart(int bookId,CartItem cartItem) {
			// TODO Auto-generated method stub
			CartItem oldCartItem = cartItemList.get(bookId);
			if(oldCartItem != null) {
				totalCost -= oldCartItem.getQuantity()*oldCartItem.getSelectedBook().getPrice();
			}
			
			cartItemList.put(bookId, cartItem);
			totalCost += cartItem.getQuantity()*cartItem.getSelectedBook().getPrice();
		}
		// xóa sp khỏi giỏ
		public void removeCartItemFromCart(int bookId) {
			CartItem cartItem=cartItemList.get(bookId);
			cartItemList.remove(bookId);
			totalCost -= cartItem.getQuantity()*cartItem.getSelectedBook().getPrice();
		}
	
}

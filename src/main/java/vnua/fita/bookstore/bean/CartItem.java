package vnua.fita.bookstore.bean;

public class CartItem {
	private Book selectedBook;
	private int quantity;
	public Book getSelectedBook() {
		return selectedBook;
	}
	public void setSelectedBook(Book selectedBook) {
		this.selectedBook = selectedBook;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartItem(Book selectedBook, int quantity) {
		super();
		this.selectedBook = selectedBook;
		this.quantity = quantity;
	}
//	public CartItem() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	

}

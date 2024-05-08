package project1;

import java.sql.Date;

public class CartDTO {
	int cartno;
	int itemno;
	int quantity;
	Date indate;
	public CartDTO(int cart, int itemno, int quantity, Date indate) {
		super();
		this.cartno = cart;
		this.itemno = itemno;
		this.quantity = quantity;
		this.indate = indate;
	}
	@Override
	public String toString() {
		String str = String.format("%s\t%s\t%s\t%s\n", cartno, itemno, quantity, indate);
		return str;
	}
	public int getCartno() {
		return cartno;
	}
	public void setCartno(int cartno) {
		this.cartno = cartno;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
}

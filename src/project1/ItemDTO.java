package project1;

import java.sql.Date;

public class ItemDTO {
	private int itemno;		// 상품번호
	private String name;	// 상품이름
	private int cost;		// 원가
	private int sale;		// 판매가
	private int profit;		// 이익
	private double discount;	// 할인	
	private char kind;		// 상품 종류(1:썬크림, 2:비비크림, 3:노션)
	
	private int itemno2;
	private int cartno;
	private int quantity;
	private Date indate;
	
	public ItemDTO() {}

	public ItemDTO(int itemno, String name, int cost, int sale, int profit, double discount, int itemno2,
				   int cartno, int quantity, Date indate) {
		super();
		this.itemno = itemno;
		this.name = name;
		this.cost = cost;
		this.sale = sale;
		this.profit = profit;
		this.discount = discount;
		this.kind = (char) itemno;
		
		this.itemno2 = itemno2;
		this.cartno = cartno;
		this.quantity = quantity;
		this.indate = indate;
	}

	@Override
	public String toString() {
		String str2 = String.format("%s\t%s\t%s\t%s\n", cartno, itemno2, quantity, indate);
		return null;
	}
	

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public char getKind() {
		return kind;
	}

	public void setKind(char kind) {
		this.kind = kind;
	}
	
	public int getItemno2() {
		return itemno2;
	}

	public void setItemno2(int itemno2) {
		this.itemno2 = itemno2;
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
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

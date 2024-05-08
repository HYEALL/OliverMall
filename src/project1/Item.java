package project1;

public interface Item {
	public String getName();
	public double getPrice();
	public double getDiscount();
	public int addToCart(CartDTO dto);
	public void purchase();
}

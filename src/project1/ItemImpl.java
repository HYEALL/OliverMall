package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemImpl implements Item {
	private String name;
    private double price;
    private double discount;
    private int cartno; // 장바구니 관리 객체
    ItemDAO dao = new ItemDAO();

    public ItemImpl(String name, double price, double discount, int cartno) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.cartno = cartno;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public int addToCart(CartDTO dto) {
        int result = dao.addToCart(dto);
        if (result > 0) {
            System.out.println(name + "이(가) 장바구니에 추가되었습니다.");
        } else {
            System.out.println("장바구니에 추가하는데 실패했습니다.");
        }
		return result;
    }

    @Override
    public void purchase() {
        // 구매 로직 구현
        System.out.println(name + "을(를) 구매완료되었습니다.");
    }
}
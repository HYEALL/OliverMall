package controller;
import java.util.List;

import dao.OrderDAO;
import dto.OrderDTO;
import service.Order;



public class OrderImpl implements Order{
	OrderDAO dao = new OrderDAO();
	@Override
	public String readAll() {
		List<OrderDTO> list = dao.searchAll();
	     String result = "";
	      for(int i=0; i<list.size(); i++) {
	         OrderDTO dto = list.get(i);
	         result += dto.toString() + "\t";
	      }
	      return result;
	}

}

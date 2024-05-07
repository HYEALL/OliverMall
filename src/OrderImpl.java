import java.util.List;



public class OrderImpl implements Order{
	OrderDAO dao = new OrderDAO();
	@Override
	public String readAll() {
		List<OrderDTO> list = dao.searchAll();
	     String result = "";
	      for(int i=0; i<list.size(); i++) {
	         OrderDTO dto = list.get(i);
	         result += dto.toString();
	      }
	      System.out.println(result);
	      return result;
	}
	@Override
	public String read(String orderno) {
		 List<OrderDTO> list = dao.searchONum(orderno);
	     String result = "";
	      for(int i=0; i<list.size(); i++) {
	         OrderDTO dto = list.get(i);
	         result += dto.toString() + "\t";
	      }
	      System.out.println(result);
	      return result;
	}
}

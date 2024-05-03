import java.util.List;

public class ItemController implements Item{
	ItemDAO dao = new ItemDAO();
	@Override
	public String read() {
		List<ItemDTO> list = dao.selectAll();
		String result = "";
		for(int i=0; i<list.size(); i++) {
			ItemDTO dto = list.get(i);
			result += dto.toString() + "\t";
		}
		return result;
	}
	@Override
	public String searchName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

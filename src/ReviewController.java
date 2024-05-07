import java.util.List;

public class ReviewController implements Review{
	ReviewDAO dao = new ReviewDAO();
	@Override
	public String searchItemNo(int no) {
		List<ReviewDTO> list = dao.searchItemNo(no);
		String result = "";
		for(int i=0; i<list.size(); i++) {
			ReviewDTO dto = list.get(i);
			result += dto.toString() + "\t";
		}
		return result;
	}
	
}

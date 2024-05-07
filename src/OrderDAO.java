import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class OrderDAO {
	public OrderDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public List<OrderDTO> searchAll() {
		String sql = "select * from orders";
		List<OrderDTO> list = new ArrayList<OrderDTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderadate(rs.getString("orderadate"));;
				dto.setOrderno(rs.getString("orderno"));
				dto.setItemno(rs.getInt("itemno"));
				dto.setOrderstatus(rs.getString("orderstatus"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<OrderDTO> searchONum(String num) {
		String sql = "SELECT orders.orderadate, item.name, orders.orderno, "
				+ "orders.itemno, item.sale, orders.orderstatus " + "FROM orders "
				+ "INNER JOIN item ON item.itemno = orders.itemno " + "WHERE orderno=?";
		List<OrderDTO> list = new ArrayList<OrderDTO>();

		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setOrderadate(rs.getString("orderadate"));
				dto.setName(rs.getString("name"));
				dto.setOrderno(rs.getString("orderno"));
				dto.setOrderstatus(rs.getString("orderstatus"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}

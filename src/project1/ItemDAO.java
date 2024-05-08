package project1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
	public ItemDAO() {
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

	public int insertItem(ItemDTO dto) {
		String sql = "INSERT INTO item (itemno, name, cost, sale, profit, discount, kind)\r\n" + "VALUES = ?";
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getItemno());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getCost());
			pstmt.setInt(4, dto.getSale());
			pstmt.setInt(5, dto.getProfit());
			pstmt.setDouble(6, dto.getDiscount());
			pstmt.setInt(7, dto.getKind());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<ItemDTO> selectItem() {
		String sql = "select * from item";
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int itemno = rs.getInt("itemno");
				String name = rs.getString("name");
				int cost = rs.getInt("cost");
				int sale = rs.getInt("sale");
				int profit = rs.getInt("profit");
				int discount = rs.getInt("discount");
				int kind = rs.getInt("kind");
				int itemno2 = rs.getInt("itemno2");
				int cartno = rs.getInt("cartno");
				int quantity = rs.getInt("quantity");
				Date indate = rs.getDate("indate");
				ItemDTO dto = new ItemDTO(itemno, name, cost, sale, profit, discount, itemno2, cartno, quantity, indate);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int addToCart(CartDTO dto) {
		String sql = "INSERT INTO cart (cartno, itemno, quantity) VALUES (cart_seq.NEXTVAL, ?, ?)";
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getItemno());
			pstmt.setInt(2, dto.getQuantity());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<CartDTO> getCartItems() {
		String sql = "SELECT * FROM cart";
		List<CartDTO> cartItems = new ArrayList<>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cartno = rs.getInt("cartno");
				int itemno = rs.getInt("itemno");
				int quantity = rs.getInt("quantity");
				Date indate = rs.getDate("indate");
				cartItems.add(new CartDTO(cartno, itemno, quantity, indate));
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
		return cartItems;
	}

	public int removeFromCart(int cartno) {
		String sql = "DELETE FROM cart WHERE cartno = ?";
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cartno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

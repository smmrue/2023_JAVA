import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDatabase {
	public static Connection makeConnection() {
		String url = "jdbc:mysql://localhost:3306/duksung";
		String id = "root";
		String password = "";
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다. ");
		}
		catch (SQLException e) {
			System.out.println("연결에 실패하였습니다. ");
		}
		return con;
	}
	
	public static void main(String arg[]) throws SQLException {
		Connection con = makeConnection();
		try {
			String sql = "" + 
		"INSERT INTO duksung (stuId, name, tel, dept) "
		"VALUES (?, ?, ?, ?)";
			
		PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"bno"});
		pstmt.setString(1, "2022001", "Minji lee", "000-00000-0001", "Cyber Security");
		pstmt.setString(2, "2022002", "Hanni Park", "000-00000-0002", "Computer");
		pstmt.setString(3, "2022003", "Danielle chung", "000-00000-0003", "IT Media");
		pstmt.setString(4, "2022004", "Hyein choi", "000-00000-0004", "Software");
		}
		
		int rows = pstmt.executeUpdate();
		
		if (rows == 1) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				int bno = rs.getInt(1);
				
			}
			rs.close();
		}
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {}
		}
	}
	}

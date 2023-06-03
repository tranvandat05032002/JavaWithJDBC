package htai.com.thihk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class NhanVienDAO {
	public boolean insertNhanVien(String maNhanVien, String hoTen, String loaiHopDong, int heSoLuong) throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		
		String query = "INSERT INTO NhanVien (maNhanVien, hoTen, loaiHopDong, heSoLuong) VALUES(?, ?, ?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maNhanVien);
		stmt.setString(index++, hoTen);
		stmt.setString(index++, loaiHopDong);
		stmt.setInt(index++, heSoLuong);
		
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
	public int countChinhThuc() {
		ResultSet rs = null;
		int countChinhThuc = 0;
		String query = "SELECT count(*) as 'countChinhThuc'\n"
				+ "FROM (\n"
				+ "SELECT loaiHopDong\n"
				+ "FROM NhanVien\n"
				+ "WHERE NhanVien.loaiHopDong = 'chinhthuc'\n"
				+ "UNION ALL\n"
				+ "SELECt loaiHopDong\n"
				+ "FROM GiaoVien\n"
				+ "WHERE GiaoVien.loaiHopDong = 'chinhthuc'\n"
				+ ") as 'countChinhThuc'";
		try (Connection cnn = UtilsDAO.getDatabaseSQLife()){
			Statement stmt = cnn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				countChinhThuc = rs.getInt("countChinhThuc");
			}
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countChinhThuc;
	}
}

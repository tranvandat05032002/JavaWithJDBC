package htai.com.thihk.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class GiaoVienDAO {
	public boolean insertGiaoVien(String maNhanVien, String hoTen, String loaiHopDong, int heSoLuong, int phuCap) throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		
		String query = "INSERT INTO GiaoVien (maGiaoVien, hoTen, loaiHopDong, heSoLuong, phuCap) VALUES(?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maNhanVien);
		stmt.setString(index++, hoTen);
		stmt.setString(index++, loaiHopDong);
		stmt.setInt(index++, heSoLuong);
		stmt.setInt(index++, phuCap);
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
}

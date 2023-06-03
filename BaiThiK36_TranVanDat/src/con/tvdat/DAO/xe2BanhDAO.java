package con.tvdat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xe2BanhDAO {
	public boolean insertXe2Banh(String maXeMay, int maXe, String bienSo, String thoiGianVao, String thoiGianRa) throws SQLException {
		Connection cnn = utilsDAO.getDatabaseSQLife();
		String query = "INSERT INTO xeMay (maXeMay, maXe, bienSo, thoiGianVao, thoiGianRa) VALUES(?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maXeMay);
		stmt.setInt(index++, maXe);
		stmt.setString(index++, bienSo);
		stmt.setString(index++, thoiGianVao);
		stmt.setString(index++, thoiGianRa);
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
}
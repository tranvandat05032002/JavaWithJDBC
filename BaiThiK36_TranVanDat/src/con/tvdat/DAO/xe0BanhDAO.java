package con.tvdat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xe0BanhDAO {
	public boolean insertNewXe0Banh(String maXeDap, int maXe, String soVe, String thoiGianVao, String thoiGianRa) throws SQLException {
		Connection cnn = utilsDAO.getDatabaseSQLife();
		String query = "INSERT INTO xeDap (maXeDap, maXe, soVeXe, thoiGianVao, thoiGianRa) VALUES(?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maXeDap);
		stmt.setInt(index++, maXe);
		stmt.setString(index++, soVe);
		stmt.setString(index++, thoiGianVao);
		stmt.setString(index++, thoiGianRa);
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
}

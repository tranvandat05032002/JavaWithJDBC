package con.tvdat.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class xe4BanhDAO {
	public boolean insertXe4Banh(String maXeOTo, int maXe, String bienSo, String thoiGianVao, String thoiGianRa, String trangThaiVao, String trangThaiRa) throws SQLException {
		Connection cnn = utilsDAO.getDatabaseSQLife();
		String query = "INSERT INTO xeOTo (maXeOto, maXe, bienSo, thoiGianVao, thoiGianRa, trangThaiVao, trangThaiRa) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maXeOTo);
		stmt.setInt(index++, maXe);
		stmt.setString(index++, bienSo);
		stmt.setString(index++, thoiGianVao);
		stmt.setString(index++, thoiGianRa);
		stmt.setString(index++, trangThaiVao);
		stmt.setString(index++, trangThaiRa);
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
}

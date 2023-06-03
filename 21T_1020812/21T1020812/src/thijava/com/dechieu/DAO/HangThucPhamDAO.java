package thijava.com.dechieu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class HangThucPhamDAO {
	public boolean insertHangThucPham(String maHang, String tenHang, int soLuong, int donGia, int tonKho, String ngaySanXuat, String ngayHetHan, String maLoaiHang) throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		
		String query = "INSERT INTO HangHoa (maHang, tenHang, soLuong, donGia, ngaySanXuat, ngayHetHan, ) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, maHang);
		stmt.setString(index++, tenHang);
		stmt.setInt(index++, soLuong);
		stmt.setInt(index++, donGia);
		stmt.setInt(index++, tonKho);
		stmt.setString(index++, ngaySanXuat);
		stmt.setString(index++, ngayHetHan);
		
		//handle results
		int n = stmt.executeUpdate();
		
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
}

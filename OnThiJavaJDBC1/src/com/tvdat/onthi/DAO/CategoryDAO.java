package com.tvdat.onthi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tvdat.onthi.modals.Category;

public class CategoryDAO {
	public ArrayList<Category> getCategoryToDatabase() {
		ArrayList<Category> listCategory = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cnn = UtilsDAO.getDatabaseSQLife()) {
			Statement stmt = cnn.createStatement();
			
			String query = "SELECT *\n"
					+ "FROM Category\n"
					+ "ORDER BY name ASC";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int categoryID = rs.getInt("categoryID");
				String nameCategory = rs.getString("name");
				
				Category ctgr = new Category(categoryID, nameCategory);
				listCategory.add(ctgr);
			}
			stmt.close();
			cnn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listCategory;
	}
	public Boolean insertCategory(int categoryID, String nameCategory) throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String query = "INSERT INTO Category (categoryID, name) VALUES(?,?)";
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setInt(index++, categoryID);
		stmt.setString(index++, nameCategory);
		int n = stmt.executeUpdate();
		stmt.close();
		cnn.close();
		
		return n == 1;
	}
	public Boolean UpdateCategory(int categoryID, String categoryName) throws SQLException{
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String query = "UPDATE Category SET name = ? WHERE (categoryID = ?)";
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setString(index++, categoryName);
		stmt.setInt(index++, categoryID);
		int n = stmt.executeUpdate();
		stmt.close();
		cnn.close();
		return n == 1;
	}
	public Boolean checkEmtyDatabase() throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String queryCheckEmty = "SELECT count(categoryID) AS \"totalCategory\" FROM Category";
		ResultSet rs = null;
		Statement stmt = cnn.createStatement();
		rs = stmt.executeQuery(queryCheckEmty);
		int totalCategory =rs.getInt("totalCategory");
		stmt.close();
		cnn.close();
		return totalCategory != 0;
	}
	public Boolean deleteCategory(int categoryID) throws SQLException{
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String query = "DELETE FROM Category WHERE (categoryID = ?) ";
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setInt(index++, categoryID);
		int n = stmt.executeUpdate();
		stmt.close();
		cnn.close();
		return n == 1;
	}
}

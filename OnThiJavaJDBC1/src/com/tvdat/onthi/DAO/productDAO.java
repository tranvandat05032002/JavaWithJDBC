package com.tvdat.onthi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tvdat.onthi.modals.Product;
import com.tvdat.onthi.modals.TotalProduct;

public class productDAO {
	public ArrayList<Product> getProductToDatabase() {
		ArrayList<Product> listProduct = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cnn = UtilsDAO.getDatabaseSQLife()) {
			Statement stmt = cnn.createStatement();
			
			String query = "SELECT *\n"
					+ "FROM Product";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int productID = rs.getInt("productID");
				String nameProduct = rs.getString("nameProduct");
				int priceProduct = rs.getInt("priceProduct");
				int quantityProduct = rs.getInt("quantityProduct");
				int categoryIDProduct = rs.getInt("categoryID");
				
				Product pd = new Product(productID, nameProduct, categoryIDProduct, quantityProduct, priceProduct);
				listProduct.add(pd);
			}
			stmt.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return listProduct;
	}
	public Boolean insertProduct(int productID, String productName, int price, int quantity, int categoryID) throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String query = "INSERT INTO Product (productID, nameProduct, priceProduct, quantityProduct, categoryID) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setInt(index++, productID);
		stmt.setString(index++, productName);
		stmt.setInt(index++, price);
		stmt.setInt(index++, quantity);
		stmt.setInt(index++, categoryID);
		int n = stmt.executeUpdate();
		stmt.close();
		cnn.close();
		return n == 1;
	}
	public Boolean updateProduct(int productID, String nameProduct, int priceProduct, int quantityProduct, int categoryID) throws SQLException{
			Connection cnn = UtilsDAO.getDatabaseSQLife();
			String query = "UPDATE Product SET nameProduct = ?, priceProduct = ?, quantityProduct = ?, categoryID = ? WHERE (productID = ?)";
			PreparedStatement stmt = null;
			stmt = cnn.prepareStatement(query);
			int index = 1;
			stmt.setString(index++, nameProduct);	
			stmt.setInt(index++, priceProduct);
			stmt.setInt(index++, quantityProduct);
			stmt.setInt(index++, categoryID);
			stmt.setInt(index, productID);
			int n = stmt.executeUpdate();
			stmt.close();
			cnn.close();
			return n == 1;
	}
	public Boolean deleteProduct(int productID) throws SQLException {
		Connection cnn = UtilsDAO.getDatabaseSQLife();
		String query = "DELETE FROM Product WHERE(productID = ?)";
		PreparedStatement stmt = cnn.prepareStatement(query);
		int index = 1;
		stmt.setInt(index++, productID);
		int n = stmt.executeUpdate();
		stmt.close();
		cnn.close();
		return n == 1;
	}
	public ArrayList<TotalProduct> staticsProductToCategory(){
		ArrayList<TotalProduct> listTotalProduct = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cnn = UtilsDAO.getDatabaseSQLife()){
			Statement stmt = cnn.createStatement();
			String query = "SELECT Product.categoryID, Category.name, sum(Product.quantityProduct) as \"totalCategory\"\n"
						+ "FROM Product, Category\n"
						+ "WHERE Product.categoryID = Category.categoryID\n"
						+ "GROUP BY Product.categoryID";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int categoryID = rs.getInt("categoryID");
				String nameCategory = rs.getString("name");
				int totalProduct = rs.getInt("totalCategory");
				TotalProduct ttpd = new TotalProduct(categoryID, nameCategory, totalProduct);
				listTotalProduct.add(ttpd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTotalProduct;
		
	}
}
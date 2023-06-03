package com.tvdat.onthi.UI;

import java.sql.SQLException;
import java.util.ArrayList;

import com.tvdat.onthi.DAO.CategoryDAO;
import com.tvdat.onthi.DAO.productDAO;
import com.tvdat.onthi.modals.Category;
import com.tvdat.onthi.modals.Product;
import com.tvdat.onthi.modals.TotalProduct;


public class ChuongTrinh {
//cau_1
	static void getCategory() {
		CategoryDAO categoryDAO = new CategoryDAO();
		ArrayList<Category> listCategory = categoryDAO.getCategoryToDatabase();
		System.out.println("categoryID" + "\t" + "nameCategory");
		for (int i = 0; i < listCategory.size(); i++) {
			Category x = listCategory.get(i);
			System.out.println(x.displayCategoy());
		}
	}
//Cau_2
	static void getProduct(int categoryID) {
		productDAO pdDAO = new productDAO();
		ArrayList<Product> listPD = pdDAO.getProductToDatabase();
		System.out.println("productID" + "\t" + "nameProduct" + "\t"  + "Price" + "\t" + "Quantity" + "\t" + "categoryID");
		for (int i = 0; i < listPD.size(); i++) {
			Product x = listPD.get(i);
			if(x.displayProductFromCategoryID(categoryID, x)) {
				System.out.println(x.displayProduct());
			}
		}
		
	}
//cau_3
	public void insertNganh(int cateoryID, String categoryName) {
		try {
			CategoryDAO dao = new CategoryDAO();
			Boolean statusInsert = dao.insertCategory(cateoryID, categoryName);
			if(statusInsert) {
				System.out.println("Them danh muc thanh cong");
			}
			else {
				System.out.println("Them danh muc that bai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateCategory(int categoryID, String categoryName) {
		try {
			CategoryDAO dao = new CategoryDAO();
			Boolean statusUpdate = dao.UpdateCategory(categoryID, categoryName);
			if(statusUpdate) {
				System.out.println("Cap nhat danh muc thanh cong");
			}
			else {
				System.out.println("Cap nhap danh muc that bai");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deteleCategory(int categoryID) {
		try {
			CategoryDAO dao = new CategoryDAO();
			Boolean statusDelete = dao.deleteCategory(categoryID);
			Boolean statusCategory = dao.checkEmtyDatabase();
			if(!statusCategory) {
				System.out.println("Khong co du lieu trong database");
			}
			else {
				if(statusDelete) {
					System.out.println("Xoa danh muc thanh cong");
				}
				else {
					System.out.println("Khong ton tai danh muc");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//cau_4
	public void insertProduct(int productID, String nameProduct, int priceProduct, int quantityProduct, int categoryID) {
		try {
			productDAO dao = new productDAO();
			Boolean statusInsert = dao.insertProduct(productID, nameProduct, priceProduct, quantityProduct, categoryID);
			if(statusInsert) {
				System.out.println("Them san pham thanh cong");
			}
			else {
				System.out.println("Tham san pham that bai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateProduct(int productID, String nameProduct, int priceProduct, int quantityProduct, int categoryID) {
		try {
			productDAO dao = new productDAO();
			Boolean statusUpdate = dao.updateProduct(productID, nameProduct, priceProduct, quantityProduct, categoryID);
			if(statusUpdate) {
				System.out.println("Update san pham thanh cong");
			}
			else {
				System.out.println("Update san pham thanh cong");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteProduct(int productID) {
		try {
			productDAO dao = new productDAO();
			boolean statusDetele = dao.deleteProduct(productID);
			if(statusDetele) {
				System.out.println("Delete san pham thanh cong");
			}
			else {
				System.out.println("Delete san pham that bai");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//cau_5
	public void getTotalProduct() {
		productDAO totalDAO = new productDAO();
		ArrayList<TotalProduct> listTTPD = totalDAO.staticsProductToCategory();
		System.out.println("categoryID\tnameProduct\ttotalProduct");
		for(int i = 0; i < listTTPD.size(); i++) {
			TotalProduct ttpd = listTTPD.get(i);
			System.out.println(ttpd.displayTotalProduct());
		}
	}
	public static void main(String[] args) {
//		getCategory();
//		getProduct(102);
		ChuongTrinh ct = new ChuongTrinh();
//		ct.insertNganh(101, "Keo");
//		ct.insertNganh(102, "Thach");
//		ct.insertNganh(103, "Banh");
//		ct.insertNganh(104, "Nuoc");
//		ct.insertNganh(105, "Snack");
//		ct.insertNganh(106, "HaiSan");
//		ct.insertProduct(1, "BanhGai", 20000, 1, 103);
//		ct.updateCategory(10, "Tom alaska", 300000, 1);
//		ct.updateProduct(1,"Sting", 10000, 7, 104);
//		ct.deleteProduct(10);
		ct.getTotalProduct();
	}

}

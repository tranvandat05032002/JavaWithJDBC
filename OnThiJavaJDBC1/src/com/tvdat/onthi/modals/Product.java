package com.tvdat.onthi.modals;

import java.util.ArrayList;

public class Product {
	private int productID;
	private String nameProduct;
	private int categoryID;
	private int quantity;
	private int price;
	
	public Product(int productID, String nameProduct, int categoryID, int quantity, int price ) {
		this.productID = productID;
		this.nameProduct = nameProduct;
		this.categoryID = categoryID;
		this.quantity = quantity;
		this.price = price;
	}
	public Boolean displayProductFromCategoryID(int enterCategoryID, Product PD) {
			return( PD.categoryID == enterCategoryID) ? true : false; 
	}
	public String displayProduct() {
//		return this.productID + "\t\t" + this.nameProduct + "\t\t" + this.price + "\t" + this.quantity + "\t" + this.categoryID;
		String formatString = String.format("%d %25s %10d %5d %15d", this.productID, this.nameProduct, this.price, this.quantity, this.categoryID);
		return formatString;
	}
}

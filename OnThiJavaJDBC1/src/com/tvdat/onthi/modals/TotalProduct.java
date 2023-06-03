package com.tvdat.onthi.modals;

public class TotalProduct extends Category {
	private int totalProduct;
	public TotalProduct(int categoryID, String nameCategory, int totalProduct) {
		super(categoryID, nameCategory);
		this.totalProduct = totalProduct;
	}
	public String displayTotalProduct() {
		return getCategoryID() + "\t\t" + getNameCategory() + "\t\t" + this.totalProduct;
	}
}

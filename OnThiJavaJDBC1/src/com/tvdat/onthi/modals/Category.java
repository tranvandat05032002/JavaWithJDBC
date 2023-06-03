package com.tvdat.onthi.modals;

public class Category {
	private int categoryID;
	private String nameCategory;
	
	public Category(int categoryID, String nameCategory) {
		this.categoryID = categoryID;
		this.nameCategory = nameCategory;
	}
	
	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public String displayCategoy() {
		return this.categoryID + "\t\t" + this.nameCategory + "\n";
	}
}

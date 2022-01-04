package com.example.demo;

public class Cartinfo {
	int id;
	String category;
	String name;

    double price;
	int quantity;
	String photos;
	
	int totalqty;
	double totalprice;
	String refemail;
	


	public Cartinfo() {
		super();
	}



	public Cartinfo(int id, String category, String name, double price, int quantity, String photos, int totalqty,
			double totalprice, String refemail) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.photos = photos;
		this.totalqty = totalqty;
		this.totalprice = totalprice;
		this.refemail = refemail;
	}



	public Cartinfo(int id, String category, String name, double price, int totalqty, double totalprice,
			String refemail) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.totalqty = totalqty;
		this.totalprice = totalprice;
		this.refemail = refemail;
	}



	
	

	public Cartinfo(String category, String name, double price, int quantity, String photos, int totalqty,
			double totalprice) {
		super();
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.photos = photos;
		this.totalqty = totalqty;
		this.totalprice = totalprice;
	}



	public Cartinfo(int id, String category, String name, double price, int totalqty, double totalprice) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.totalqty = totalqty;
		this.totalprice = totalprice;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getTotalqty() {
		return totalqty;
	}



	public void setTotalqty(int totalqty) {
		this.totalqty = totalqty;
	}



	public double getTotalprice() {
		return totalprice;
	}



	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}



	public String getRefemail() {
		return refemail;
	}



	public void setRefemail(String refemail) {
		this.refemail = refemail;
	}



	public String getPhotos() {
		return photos;
	}



	public void setPhotos(String photos) {
		this.photos = photos;
	}

	

}

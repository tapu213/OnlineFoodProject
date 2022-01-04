package com.example.demo;

public class Orderedproduct {
	int id;
	String category;
	String name;
	int quantity;
	double price;
	String photos;
	int totalqty;
	double totalprice;
	String transactionid;
	public Orderedproduct() {
		super();
	}
	
	
	public Orderedproduct(String category, String name, double price, int quantity, String photos, int totalqty,
			double totalprice, String transactionid) {
		super();
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.photos = photos;
		this.totalqty = totalqty;
		this.totalprice = totalprice;
		this.transactionid = transactionid;
	}


	public Orderedproduct(int id, String category, String name, int quantity, double price, String photos,
			String transactionid) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.photos = photos;
		this.transactionid = transactionid;
	}
	public Orderedproduct(String category, String name, int quantity, double price, String photos,
			String transactionid) {
		super();
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.photos = photos;
		this.transactionid = transactionid;
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
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	
}

package com.example.demo;

public class ProductCart {
	int id;
	String category;
	String name;
	double price;
	int quantity;

	String photos;

	public ProductCart() {
		super();
	}

	public ProductCart(int id, String category, String name, double price, String photos) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.price = price;
		this.photos = photos;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductCart [id=" + id + ", category=" + category + ", name=" + name + ", price=" + price
				+ ", quantity=" + quantity + ", photos=" + photos + "]";
	}

}

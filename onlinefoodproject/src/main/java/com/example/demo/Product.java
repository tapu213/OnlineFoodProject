package com.example.demo;

public class Product {
int id;
String category;
String name;
double price;
String photos;
int stock;
public Product() {
	super();
}
public Product(int id, String category, String name, double price, String photos, int stock) {
	super();
	this.id = id;
	this.category = category;
	this.name = name;
	this.price = price;
	this.photos = photos;
	this.stock = stock;
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
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}





}

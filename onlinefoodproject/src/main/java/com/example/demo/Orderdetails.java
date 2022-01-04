package com.example.demo;

import java.sql.Date;

public class Orderdetails {
int id;
String fullname;
String email;
String address;
String phone;
Date date;
int totalqty;
double totalprice;
String pmethod;
String status;
String transactionid;
public Orderdetails() {
	super();
}
public Orderdetails(int id, String fullname, String email, String address, String phone, Date date, int totalqty,
		double totalprice, String pmethod, String status, String transactionid) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.email = email;
	this.address = address;
	this.phone = phone;
	this.date = date;
	this.totalqty = totalqty;
	this.totalprice = totalprice;
	this.pmethod = pmethod;
	this.status = status;
	this.transactionid = transactionid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
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
public String getPmethod() {
	return pmethod;
}
public void setPmethod(String pmethod) {
	this.pmethod = pmethod;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getTransactionid() {
	return transactionid;
}
public void setTransactionid(String transactionid) {
	this.transactionid = transactionid;
}
@Override
public String toString() {
	return "Orderdetails [id=" + id + ", fullname=" + fullname + ", email=" + email + ", address=" + address
			+ ", phone=" + phone + ", date=" + date + ", totalqty=" + totalqty + ", totalprice=" + totalprice
			+ ", pmethod=" + pmethod + ", status=" + status + ", transactionid=" + transactionid + "]";
}



}

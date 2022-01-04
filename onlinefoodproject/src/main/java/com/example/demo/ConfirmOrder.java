package com.example.demo;

import java.sql.Date;

public class ConfirmOrder {
	int id;
	String fullname;
	String email;
	String address;
	String phone;
	Date date;
	int totalqty;
	double totalprice;
	String transactionid;
	String owner;
	int cvv;
	int cardnumber;
	

	public ConfirmOrder() {
		super();
	}
	


	public ConfirmOrder(int id, String fullname, String email, String address, String phone, Date date, int totalqty,
			double totalprice, String transactionid) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.date = date;
		this.totalqty = totalqty;
		this.totalprice = totalprice;
		this.transactionid = transactionid;
	}



	public ConfirmOrder(String owner, int cvv, int cardnumber, Date date) {
		super();
		this.owner = owner;
		this.cvv = cvv;
		this.cardnumber = cardnumber;
		this.date = date;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

}

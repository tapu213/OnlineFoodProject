package com.example.demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CustomerDA {
	Connection cn;
	PreparedStatement pst;
	ResultSet rs;

	public void doInsert(Customer s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("insert into signup (fullname,username,email,password) values(?,?,?,?)");

			pst.setString(1, s.fullname);
			pst.setString(2, s.username);
			pst.setString(3, s.email);
			pst.setString(4, s.password);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {

		}

	}

	public Customer customerbyemail(String email) {
		List<Customer> list = new ArrayList<>();
		Customer s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");

			pst = cn.prepareStatement("select * from customer where email=?");
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				list.add(s);
			}

		} catch (Exception e) {

		}
		return list.get(0);
	}

	public Customer customerbyemailpassword(String email, String password) {
		List<Customer> list = new ArrayList<>();
		List<Employee> emplist = new ArrayList<>();
		Customer s;
		Employee emp;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");

			pst = cn.prepareStatement("select * from customer where email=? AND password=?");
			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
				list.add(s);
			}

		} catch (Exception e) {

		}
		return list.get(0);
	}

	public String customernamebyid(String email) {

		String name = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");

			pst = cn.prepareStatement("select fullname from customer where email=?");
			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				name = rs.getString(1);
			}

		} catch (Exception e) {

		}
		return name;
	}

	public void carddetailsinsert(ConfirmOrder co) {
		Date date = co.date;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("insert into orderdetails (fullname,email,address,phone,date,totalqty,totalprice,pmethod,status,transactionid) values(?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, co.getFullname());
            pst.setString(2, co.getEmail());
            pst.setString(3, co.getAddress());
            pst.setString(4, co.getPhone());
            pst.setDate(5, date);
            pst.setInt(6, co.getTotalqty());
            pst.setDouble(7, co.getTotalprice());
			
			pst.setString(8, "by card");
			pst.setString(9, "order pending");
			pst.setString(10, co.getTransactionid());
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void bkashinformation() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("insert into orderdetails(date,pmethod,status) values(?,?,?)");
			java.util.Date d = new java.util.Date();
			pst.setDate(1, new Date(d.getTime()));
			pst.setString(2, "by bkash");
			pst.setString(3, "order pending");
			int x = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public int adminlogin(Employee emp) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("SELECT name,password FROM employee WHERE name=? AND password=?");
			pst.setString(1, emp.name);
			pst.setString(2, emp.password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Orderdetails> showforbillings(int id) {
		List<Orderdetails> list = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("select * from orderdetails where id="+id);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Orderdetails c = new Orderdetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getDouble(8),
						rs.getString(9),rs.getString(10),rs.getString(11));
				list.add(c);

			}
			System.out.println(list.toString());

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;

	}
	public int getbillinginformation() {
		int value=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("select max(id) from orderdetails");
			rs = pst.executeQuery();
			rs.next();
			value=rs.getInt(1);
		

		} catch (Exception e) {
			System.out.println(e);
		}
		return value;
	}

}

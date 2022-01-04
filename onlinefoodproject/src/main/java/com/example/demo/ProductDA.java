package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDA {
	Connection cn;
	PreparedStatement pst;

	public List<Product> doShow() {
		List<Product> list = new ArrayList<>();
		Product s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");

			pst = cn.prepareStatement("select * from product");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6));
				list.add(s);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public void productInsert(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("insert into product (category,name,price,photos,stock) values(?,?,?,?,?)");

			pst.setString(1, p.category);
			pst.setString(2, p.name);
			pst.setDouble(3, p.price);
			pst.setString(4, "/images/" + p.photos);
			pst.setInt(5, p.stock);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {

		}

	}
	
	public void saveorderedproduct(Orderedproduct p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("insert into orderedproduct (category,name,price,quantity,photos,totalqty,totalprice,transactionid) values(?,?,?,?,?,?,?,?)");

			pst.setString(1, p.category);
			pst.setString(2, p.name);
			pst.setDouble(3, p.price);
			pst.setInt(4, p.quantity);
			pst.setString(5, p.photos);
			pst.setInt(6, p.totalqty);
			pst.setDouble(7, p.totalprice);
			pst.setString(8, p.transactionid);
			pst.executeUpdate();
			//System.out.println("insert");
		} catch (Exception e) {
System.out.println(e);
		}

	}

	public void savecartInfo(Cartinfo p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("insert into cartinfo (category,name,price,quantity,photos,totalqty,totalprice) values(?,?,?,?,?,?,?)");

			pst.setString(1, p.category);
			pst.setString(2, p.name);
			pst.setDouble(3, p.price);
			pst.setInt(4, p.quantity);
			pst.setString(5, p.photos);
			pst.setInt(6, p.getTotalqty());
			pst.setDouble(7, p.totalprice);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {

		}

	}

	public void updateCartEmail(String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("update  cartinfo set  refemail=?");

			pst.setString(1, email);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {

		}

	}

	public List<Cartinfo> showCartInfo() {
		List<Cartinfo> list = new ArrayList<>();
		Cartinfo s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");

			pst = cn.prepareStatement("select * from cartinfo");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
			
				s = new Cartinfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5),
						rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getString(9));
				list.add(s);
			}

		} catch (Exception e) {

		}
		return list;
	}

	public void clearcartInfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("delete from cartinfo");
			pst.executeUpdate();
			System.out.println("deleted");
		} catch (Exception e) {

		}

	}

	public void doUpdate(Product p) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("update product set category=?,name=?,price=?,photos=?,stock=? where id=?");

			pst.setString(1, p.category);
			pst.setString(2, p.name);
			pst.setDouble(3, p.price);
			pst.setString(4, "/images/" + p.photos);
			pst.setInt(5, p.stock);
			pst.setInt(6, p.id);
			pst.executeUpdate();
			System.out.println("update");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void doDelete(Product s) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement("delete from product where id=" + s.id);

			pst.executeUpdate();

			System.out.println("delete");
		} catch (Exception e) {

		}
	}

	public List<Product> searchProduct(String search) {
		List<Product> list = new ArrayList<>();
		Product s;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");

			pst = cn.prepareStatement("select * from product where category like '%" + search + "%' || name like '%"
					+ search + "%' || id = '" + search + "'");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getInt(6));
				list.add(s);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public void userInsert(Customer c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodproject", "root", "nh123456");
			pst = cn.prepareStatement(
					"insert into customer (fullname,username,email,password,address,phone) values(?,?,?,?,?,?)");
			pst.setString(1, c.fullname);
			pst.setString(2, c.username);
			pst.setString(3, c.email);
			pst.setString(4, c.password);
			pst.setString(5, c.address);
			pst.setInt(6, c.phone);
			pst.executeUpdate();
			System.out.println("insert");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

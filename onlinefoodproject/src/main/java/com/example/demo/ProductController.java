package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	List<ProductCart> addtocartlist = new ArrayList<>();
	boolean match;
	String cusEmail = "";
	Customer customer;

	@RequestMapping("/home")
	public String form() {
		return "home";
	}

	@RequestMapping("/billingandprint")
	public String billingandprint(Model m) {
		CustomerDA cd = new CustomerDA();

		m.addAttribute("msg", "payment successfull by card");
		List<Orderdetails> list = new ArrayList<>();
		list.addAll(cd.showforbillings(cd.getbillinginformation()));
		m.addAttribute("bill", list);
		System.out.println(list.toString());

		return "billingandprint";
	}

	@RequestMapping("save")
	public String save(@ModelAttribute() Customer customer, Model m) {
		ProductDA da = new ProductDA();
		da.userInsert(customer);
		return "orderpagelogin22";
	}

	@RequestMapping("/adminlogin")
	public String adminlogin(@ModelAttribute() Employee emp, Model m) {
		CustomerDA cda = new CustomerDA();
		m.addAttribute("name", emp.name);
		m.addAttribute("password", emp.password);
		if (cda.adminlogin(emp) == 1) {
			System.out.println("Admin Access");

			return "admin";

		} else {
			return "Adminlogin";
		}

	}

	@RequestMapping("/carddetails")
	public String carddetails(Model m) {
		ProductDA da = new ProductDA();
		CustomerDA cda = new CustomerDA();
		Cartinfo ci = da.showCartInfo().get(0);
		// System.out.println(ci.getRefemail());
		Customer customer = cda.customerbyemail(ci.getRefemail());
		m.addAttribute("customer", customer);
		m.addAttribute("cartproducts", da.showCartInfo());
		m.addAttribute("totalqty", ci.getTotalqty());
		m.addAttribute("totalprice", ci.getTotalprice());
		return "carddetails";
	}

	@RequestMapping("/loginpage")
	public String loginpage() {
		return "login";
	}

	@RequestMapping("/paymentmethod")
	public String paypage() {
		return "paymentmethod";
	}

	@RequestMapping("/customersignup")
	public String customersignup() {
		return "customersignup";
	}

	@RequestMapping("/order")
	public String order() {
		// save cart products into database
		ProductDA da = new ProductDA();
		da.clearcartInfo();
		for (int i = 0; i < addtocartlist.size(); i++) {
			String category = addtocartlist.get(i).getCategory();
			String name = addtocartlist.get(i).getName();
			double price = addtocartlist.get(i).getPrice();
			int quantity = addtocartlist.get(i).getQuantity();
			String photos = addtocartlist.get(i).getPhotos();

			int totalqty = 0;

			for (ProductCart pd : addtocartlist) {
				totalqty = totalqty + pd.getQuantity();
			}

			double totalprice = 0;

			for (ProductCart pd : addtocartlist) {
				totalprice += (pd.price * pd.getQuantity());
			}
			Cartinfo cinfo = new Cartinfo(category, name, price, quantity, photos, totalqty, totalprice);
			da.savecartInfo(cinfo);
		}

		return "orderpagelogin22";
	}

	@RequestMapping("/addressdetails")
	public String addressdetails(@ModelAttribute() Customer c, Model m) {
		CustomerDA da = new CustomerDA();
		m.addAttribute("customer", da.customerbyemailpassword(c.email, c.password));
		customer = da.customerbyemailpassword(c.email, c.password);
		ProductDA pda = new ProductDA();
		pda.updateCartEmail(customer.email);
		System.out.println(customer);
		return "Addressdetails";
	}

	@RequestMapping("/showProduct")
	public String show(@ModelAttribute() Product product, Model m) {
		System.out.println("shown");
		ProductDA da = new ProductDA();

		double totalprice = 0;
		for (ProductCart pd : addtocartlist) {
			totalprice += (pd.price * pd.getQuantity());
		}
		m.addAttribute("totalprice", totalprice);
		// m.addAttribute("cartList", addtocartlist);
		m.addAttribute("products", da.doShow());
		return "showProduct";
	}

	@RequestMapping("/logout")
	public String logout(@ModelAttribute() Product product, Model m) {

		ProductDA da = new ProductDA();
		addtocartlist.clear();
//		double totalprice = 0;
//		for (ProductCart pd : addtocartlist) {
//			totalprice += (pd.price * pd.getQuantity());
//		}
		// m.addAttribute("totalprice", totalprice);
		// m.addAttribute("cartList", addtocartlist);
		m.addAttribute("products", da.doShow());
		return "showProduct";
	}

	@RequestMapping("/addtocart")
	public String addtocart(@ModelAttribute() ProductCart p, Model m) {
		System.out.println(p);
		for (ProductCart pd : addtocartlist) {
			if (pd.getId() == p.id) {
				pd.setQuantity(pd.getQuantity() + 1);
				match = true;
				break;
			} else {
				match = false;
			}

		}
		if (addtocartlist.size() == 0 || match == false) {
			p.setQuantity(p.getQuantity() + 1);
			addtocartlist.add(p);
		}
		int totalitemsadded = 0;

		for (ProductCart pd : addtocartlist) {
			totalitemsadded = totalitemsadded + pd.getQuantity();
		}
		double totalprice = 0;
		for (ProductCart pd : addtocartlist) {
			totalprice += (pd.price * pd.getQuantity());
		}
		ProductDA da = new ProductDA();

		m.addAttribute("totalquantity", totalitemsadded);
		m.addAttribute("totalprice", totalprice);
		m.addAttribute("products", da.doShow());
		return "showProduct";

	}

	@RequestMapping("/login")
	public String login2(@ModelAttribute() Customer c, Model m) {
		CustomerDA cda = new CustomerDA();
		Customer cdb = cda.customerbyemailpassword(c.email, c.password);
		if (cdb != null) {
			ProductDA da = new ProductDA();
			m.addAttribute("products", da.doShow());
			m.addAttribute("customer", cdb);
			cusEmail = c.email;
			return "showProduct";
		} else {
			return "login";
		}
	}
	/*
	 * @RequestMapping("/customerlogin") public String
	 * customerlogin(@ModelAttribute() Customer c, Model m) { CustomerDA cda = new
	 * CustomerDA(); Customer cdb =cda.customerbyemailpassword(c.email, c.password);
	 * if (cdb != null) { ProductDA da = new ProductDA(); m.addAttribute("products",
	 * da.doShow()); m.addAttribute("customer", cdb); customer = cdb;
	 * System.out.println(cdb); System.out.println(customer); return "paypage"; }
	 * else { return "login"; } }
	 */

	@RequestMapping("/billing")
	public String success(@ModelAttribute() ConfirmOrder co, Model m) {
		CustomerDA cd = new CustomerDA();
		co.setTransactionid("TR" + String.format("%06d", new Random().nextInt(999999)));
		cd.carddetailsinsert(co);
		ProductDA da = new ProductDA();
		List<Cartinfo> cartproducts = da.showCartInfo();
		for (int i = 0; i < cartproducts.size(); i++) {
			Cartinfo ci = cartproducts.get(i);
			Orderedproduct op = new Orderedproduct(ci.category, ci.name, ci.price, ci.quantity, ci.photos, ci.totalqty,
					ci.totalprice, co.getTransactionid());
			da.saveorderedproduct(op);
		}
		m.addAttribute("msg", "payment successfull by card");

		m.addAttribute("co", co);
		System.out.println(co);
		return "billing";
	}

	@RequestMapping("/bkashsuccess")
	public String bkashsuccess(@ModelAttribute() ConfirmOrder co, Model m) {
		System.out.println("hello");
		CustomerDA cd = new CustomerDA();
		cd.bkashinformation();
		m.addAttribute("msg", "payment successfull by bkash");
		return "bkashinformation";
	}

	@RequestMapping("/bkashinformation")
	public String bkashinformation() {
		System.out.println(customer);
		return "bkashinformation";
	}

	@RequestMapping("/showcart")
	public String showcart(@ModelAttribute() Customer c, Model m) {
		double totalprice = 0;
		for (ProductCart pd : addtocartlist) {
			totalprice += (pd.price * pd.getQuantity());
		}
		CustomerDA cda = new CustomerDA();
		m.addAttribute("customer", cda.customernamebyid(cusEmail));
		m.addAttribute("totalprice", totalprice);
		m.addAttribute("cartList", addtocartlist);
		return "showcart";
	}
}

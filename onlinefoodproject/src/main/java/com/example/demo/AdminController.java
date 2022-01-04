package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
	@RequestMapping("/categoryform")
	public String form() {
		return "categoryForm";
	}
	
	

	@RequestMapping("saveproduct")
	public String save(@ModelAttribute() Product product, Model m) {
		ProductDA da = new ProductDA();
		da.productInsert(product);
		return "admin";
	}

	
	
	@RequestMapping(value="/productaddform")
	public String form2(@ModelAttribute() Product pd,Model m) {
	ProductDA pda=new ProductDA();
	pda.productInsert(pd);
	m.addAttribute("products", pd);
		return "productaddform";
	}
	
	
	
	@RequestMapping("/showadminproduct")
	public String form3(Model m) {
		ProductDA da = new ProductDA();
		m.addAttribute("products", da.doShow());
		return "showadminproduct";
	}
	@RequestMapping("delete")
	public String delete1(@ModelAttribute() Product product, Model m) {
		ProductDA da = new ProductDA();
		da.doDelete(product);
		m.addAttribute("products", da.doShow());
		return "showadminproduct";
	}

	@RequestMapping("update")
	public String update1(@ModelAttribute() Product product, Model m) {
		ProductDA da = new ProductDA();
		da.doUpdate(product);
		m.addAttribute("products", da.doShow());
		return "showadminproduct";
	}
	@RequestMapping("pdaddform")
	public String updateForm(@ModelAttribute("pd") Product product, Model m) {
		ProductDA da = new ProductDA();
		
		
		return "productupdateform";
	}
	
	@RequestMapping("/search")
	public String searchproduct(@ModelAttribute() Product product, Model m) {
		ProductDA da = new ProductDA();
		m.addAttribute("products", da.searchProduct(product.name));
		return "showadminproduct";
	}
	
}

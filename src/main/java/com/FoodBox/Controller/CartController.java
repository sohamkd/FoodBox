package com.FoodBox.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.FoodBox.Global.GlobalData;
import com.FoodBox.Model.OrderData;
import com.FoodBox.Model.Product;
import com.FoodBox.Repo.OrderDataRepository;
import com.FoodBox.Services.ProductService;


@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	@Autowired
	private OrderDataRepository orderDataRepository;
	
	
	@GetMapping("/addToCart/{id}")
	public String AddToCart(@PathVariable int id) {
		GlobalData.cart1.add(productService.getProductById(id).get());
		return"redirect:/cart";
	}
	@GetMapping("/cart")
	public String GetCart(Model model) {
		model.addAttribute("cartCount",GlobalData.cart1.size());
		model.addAttribute("total",GlobalData.cart1.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cart",GlobalData.cart1);
		return "cart";
		
	}
	
	@PostMapping("/OrderData")
	public String Data(@ModelAttribute("data") OrderData data , HttpSession session,Model model) {
		model.addAttribute("data",data);
		orderDataRepository.save(data);
	
		return"success";
	}
	
	
}

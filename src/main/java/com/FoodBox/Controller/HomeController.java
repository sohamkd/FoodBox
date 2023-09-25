package com.FoodBox.Controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


import com.FoodBox.Global.GlobalData;
import com.FoodBox.Model.Product;

import com.FoodBox.Repo.UserRepo;
import com.FoodBox.Services.CategoryService;
import com.FoodBox.Services.ProductService;

@Controller
public class HomeController {
   @Autowired
   CategoryService categoryService;
   @Autowired
   ProductService productService;
   @Autowired
    UserRepo userRepo;
   
   @GetMapping({"/","/home"})
   public String Home( Model model) {
	   model.addAttribute("now", LocalDateTime.now());
	   return"index";
   }
  
   
   @GetMapping("/aboutus")
   public String Aboutus() {
	   return"aboutus";
   }
   @GetMapping("/give")
   public String giveus() {
	   return"heart";
   }
   @GetMapping("/shop")
   public String Shop(Model model) {
	   model.addAttribute("categories",categoryService.getAllCategory());
	   model.addAttribute("products",productService.getAllProduct());
	   return"shop";
   }
 
   @GetMapping("/shop/category/{id}")
   public String ShopByCategory(Model model,@PathVariable int id) {
	   model.addAttribute("categories",categoryService.getAllCategory());
	   model.addAttribute("products",productService.getAllProductsByCategoryId(id));
	   return"shop";
   }
   @GetMapping("/shop/viewproduct/{id}")
   public String ShopByViewProduct(Model model,@PathVariable int id) {
	  model.addAttribute("product",productService.getProductById(id).get());
	   return"viewProduct";
   }
   @GetMapping("/shopbycat")
   public String shopbycat(Model model) {
	   model.addAttribute("categories",categoryService.getAllCategory());
	   model.addAttribute("products",productService.getAllProduct());
	   return"shopbycat";
   }
 
   @GetMapping("/shopbycat/category/{id}")
   public String shopbycatByCategory(Model model,@PathVariable int id) {
	   model.addAttribute("categories",categoryService.getAllCategory());
	   model.addAttribute("products",productService.getAllProductsByCategoryId(id));
	   return"home";
   }
   @GetMapping("/shopbycat/viewproduct/{id}")
   public String shopbycatByViewProduct(Model model,@PathVariable int id) {
	  model.addAttribute("product",productService.getProductById(id).get());
	   return"index";
   }
   
   @GetMapping("/cart/removeItem/{index}")
   public String RemoveFromCart(@PathVariable int index) {
	   GlobalData.cart1.remove(index);
	   return"redirect:/cart";
   }
   @GetMapping("/checkout")
   public String CheckOut(Model model) {
	   model.addAttribute("total",GlobalData.cart1.stream().mapToDouble(Product::getPrice).sum());
	   return"checkout";
   }
   
}

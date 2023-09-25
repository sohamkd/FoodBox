package com.FoodBox.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.FoodBox.Global.GlobalData;

import com.FoodBox.Model.Role;
import com.FoodBox.Model.User;

import com.FoodBox.Repo.RoleRepo;
import com.FoodBox.Repo.UserRepo;

@Controller
public class LoginController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	RoleRepo roleRepo;
	
	@GetMapping("/login")
	public String Login() {
		GlobalData.cart1.clear();
		return"login";
	}
	
	@GetMapping("/register")
	public String Register() {
		return"register";
	}
	@PostMapping("/register")
	public String PostRegister(@ModelAttribute("user") User user,HttpServletRequest request)throws ServletException 
	
	{
		
		String password=user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles=new ArrayList<>();
		roles.add(roleRepo.findById(2).get());
		user.setRoles(roles);
		userRepo.save(user);
		request.login(user.getEmail(),password);
		return "redirect:/";

	}
	 
}

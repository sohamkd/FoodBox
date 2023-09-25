package com.FoodBox;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.FoodBox.Model.Category;
import com.FoodBox.Model.OrderData;
import com.FoodBox.Model.Product;
import com.FoodBox.Model.User;
import com.FoodBox.Repo.CategoryRepo;
import com.FoodBox.Repo.OrderDataRepository;
import com.FoodBox.Repo.ProductRepo;
import com.FoodBox.Repo.UserRepo;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FoodBoxEcomApplicationTests {
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryrepo;
	@Autowired
	UserRepo userrepo;
	@Autowired
	OrderDataRepository orderRepo;

	@Test
	@Order(1)
	void ProductTest() {
		Product p = new Product();
		p.setId(22l);
		p.setName("samosa");
		p.setPrice(200);
		p.setWeight(1000);
		productRepo.save(p);
	}
	
	@Test
	@Order(2)
	public void TestProductReadAll() {
		List<Product> list=productRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void TestSingleProduct() {
		Product product=productRepo.findById(58l).get();
		assertEquals("Behrouz Biryani", product.getName());
	}
	@Test
	@Order(4)
	public void TestUpdateProduct() {
		Product product=productRepo.findById(58l).get();
		product.setPrice(1410);
		productRepo.save(product);
		assertNotEquals(1420, productRepo.findById(58l).get().getPrice());
	}
	
	
	@Test
	@Order(1)
	void CategoryTest() {
		Category c = new Category();
		c.setId(58);
		c.setName("veg-Food");
		categoryrepo.save(c);
	}
	
	@Test
	@Order(2)
	public void TestCategoryReadAll() {
		List<Category> list=categoryrepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void TestSingleCategory() {
		Category cat=categoryrepo.findById(227).get();
		assertEquals("veg-Food", cat.getName());
	}
	@Test
	@Order(4)
	public void TestUpdateCategory() {
		Category cat=categoryrepo.findById(227).get();
		cat.setName("veg-Food");
		categoryrepo.save(cat);
		assertNotEquals("non-veg-Food", categoryrepo.findById(227).get().getName());
	}
	
	
	@Test
	@Order(6)
	void UserTest() {
		User user = new User();
		user.setId(144l);
		user.setFirstName("radhika");
		user.setLastName("moli");
		user.setEmail("rm@gmail.com");
		user.setPassword("1234");
	
		userrepo.save(user);
	}
	
	@Test
	@Order(7)
	void UserProductOrderDataTest() {
		OrderData od = new OrderData();
		od.setId(112l);		
		od.setAddress("Shivaji peth rankala kolhapur");
		od.setCity("kolhapur");
		od.setEmail("oc@gmail.com");
		od.setFirstName("omkar");
		od.setLastName("charte");
		od.setPhoneno("91191919");
	
		orderRepo.save(od);
	}

}

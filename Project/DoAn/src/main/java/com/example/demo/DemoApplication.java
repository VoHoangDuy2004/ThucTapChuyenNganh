package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.dao.CategoryDAO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import jakarta.persistence.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		 return  runner -> {
			createCategoryWithProduct(appDAO);
		 };
	}

	@Autowired
	private CategoryDAO categoryDAO;
	private void createCategoryWithProduct(AppDAO appDAO) {

//		Category tempCategory=new Category("Tv","https://samnec.com.vn/uploads/images/1%20Th%E1%BA%A3o%20content/Xiaomi%20P1/Xiaomi%20P1.jpg","active");
//		Product temProduct=new Product("Tivi-1","https://samnec.com.vn/uploads/images/1%20Th%E1%BA%A3o%20content/Xiaomi%20P1/Xiaomi%20P1.jpg",(float) 120000.0,"active","mo ta","tac gia","nha xuat ban",tempCategory);
//		Product temProduct1=new Product();
//		tempCategory.add(temProduct);
//		tempCategory.add(temProduct1);
//		appDAO.save(tempCategory);
//		categoryDAO.findAll().forEach(category -> System.out.println(category.toString()));
//		List<Category>categories=categoryDAO.findAll();
//		//List<Integer>id=new ArrayList<>();
//
//		for(Category category : categories ){
//			//id.add(category.getId());
//			System.out.println(category.toString());
//		}
	}

}

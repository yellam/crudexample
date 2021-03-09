package com.cashapona.crudexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cashapona.crudexample.entity.Product;
import com.cashapona.crudexample.exception.ResourceNotFoundException;
import com.cashapona.crudexample.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> listOfproducts(@RequestBody List<Product> products){
		
		return service.saveProducts(products);
	}
	
	//get
	@GetMapping("/products")
	public List<Product> getallProducts(){
		
		return service.getProducts();
	}
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
	try {
		return service.getproductById(id);
	}catch(Exception e) {
		throw new ResourceNotFoundException("product not find with id:"+id);
	}
	}
	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		try {
		return service.getProductByName(name);
		}catch(Exception e) {
			throw new ResourceNotFoundException("product not find with name:"+name);
		}
	}
	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable int id) {
		try {
		return service.updateProduct(product);
		}catch(Exception e) {
			throw new ResourceNotFoundException("product not find with id:"+id);
		}
	}
	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		try {
		return service.deletProduct(id);
		}catch(Exception e) {
			throw new ResourceNotFoundException("product not find with id:"+id);
		}
	}
	

}

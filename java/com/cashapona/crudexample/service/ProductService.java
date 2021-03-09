package com.cashapona.crudexample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashapona.crudexample.entity.Product;
import com.cashapona.crudexample.repository.ProductRepository;
@Service
public class ProductService {
	
	@Autowired
	public ProductRepository repository;
	
	public Product saveProduct(Product product) {
		
		return repository.save(product);
	}
	public List<Product> saveProducts(List<Product> products){
		
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		
		List<Product> products=new ArrayList<Product>();
		
		products = repository.findAll();
		//.forEach(products1 -> products.add(products1));
		return products;
	}
	public Product getproductById(int id) {
		
		return repository.findById(id).get();
	}
	public Product getProductByName(String name) {
		
		return repository.findByName(name);
	}
	public String deletProduct(int id) {
		repository.deleteById(id);
		return "product deleted"+id;
		
	}
	
	public Product updateProduct(Product product) {
	
	/* Product existingProduct=repository.findById(product.getId()
	existingProduct.setName(product.getName());
	existingProduct.setQuantity(product.getQuantity());
	existingProduct.setPrice(product.getPrice());
	return repository.save(existingProduct);
	*/
		return repository.save(product);
		
	}
	
	public void delete(int id) {
		
	repository.deleteById(id);
	}
	

}

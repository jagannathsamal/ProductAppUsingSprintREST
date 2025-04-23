package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // http://localhost:1114/products/getMsg
	public String sayHello() {
		return "need break";
	}

	@PostMapping("/saveproduct") // http://localhost:1114/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct") // http://localhost:8080/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/getproduct/{pid}") // http://localhost:1114/products/getproduct/1
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:1114/products/deleteproduct/1
	public String deleteProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	
	@GetMapping("/getallproducts") // http://localhost:1114/products/getallproducts
	public List<Product> fetchProduct() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getallproductsbetween/{price1}/{price2}") // http://localhost:1114/products/getallproductsbetween/1/20000
	public List<Product> fetchProduct(@PathVariable("price1") int initialPrice,@PathVariable("price2") int finalPrice) {
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}
	
	@GetMapping("/getallproductsgreater/{price1}") // http://localhost:1114/products/getallproductsgreater/20000
	public List<Product> fetchProduct1(@PathVariable("price1") int initialPrice) {
		return service.getAllProductsGreater(initialPrice);
	}
	
	@GetMapping("/getallproductsbycategory/{category}") // http://localhost:1114/products/getallproductsbycategory/electronics
	public List<Product> fetchProduct11(@PathVariable("category") String category) {
		return service.getAllProductsByCategory(category);
	}
	
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
}

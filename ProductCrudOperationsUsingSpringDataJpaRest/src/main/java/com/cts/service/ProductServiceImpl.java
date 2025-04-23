package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;


@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
	ProductRepository repository;


	@Override
	public String saveProduct(Product product) {
		Product pro =repository.save(product);
		if(pro!=null) {
			return "Product Saved Successfully";
		}
		else
			return "Something Went Wrong";
		
	}

	@Override
	public Product updateProduct(Product product) {
		Product pro =repository.save(product);
			return pro;
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "Product deleted";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound {
		Optional<Product> optional=repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Product is Invalid.....");
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int intialPrice, int finalPrice) {
		return repository.findByProductPriceBetween(intialPrice, finalPrice);
	}
	
	@Override
	public List<Product> getAllProductsGreater(int productPrice) {
		return repository.findByProductPriceGreaterThan(productPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repository.findByProductCategory(category);
	}

}

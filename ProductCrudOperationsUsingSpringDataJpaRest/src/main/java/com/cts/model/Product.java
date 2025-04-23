package com.cts.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message="product name cannot be blank")
//	@NotNull
//	@NotEmpty
	private String productName;
	@Column(name = "price")
	@Min(value=100,message="price cannot be less then 100")
	@Max(value=100000,message="price cannot be more then 1 lac")
	private int productPrice;
	@Size(min = 5,max=12,message="category must be 5 to 12 char")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message="Quantity cannot be zero or negetive")
	private int productQuantity;

	public Product() {
		System.out.println("Default Constructor of Product");
	}

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	

}

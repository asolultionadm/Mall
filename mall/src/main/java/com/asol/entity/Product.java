package com.asol.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "product")

public class Product {

	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy = IDENTITY)
  private int productId;
	@Column(name = "NAME", unique = true, nullable = false, length = 200)
  private String name;
	@Column(name = "DESCRIPTION", unique = false, nullable = false, length = 1000)
  private String description;
	@Column(name = "SIZE", unique = false, nullable = false, length = 10)
  private String size;
	
	@Column(name = "COLOR", unique = false, nullable = false, length = 10)
  private String color;
  //private ArrayList images;
  
  public Product() {
  }
  
public Product(int productId, String name, String description, String size, String color) {
	super();
	this.productId = productId;
	this.name = name;
	this.description = description;
	this.size = size;
	this.color = color;
	//this.images = images;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getSize() {
	return size;
}

public void setSize(String size) {
	this.size = size;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

/*public ArrayList getImages() {
	return images;
}

public void setImages(ArrayList images) {
	this.images = images;
}*/
  
  
}

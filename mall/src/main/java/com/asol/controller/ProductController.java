package com.asol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asol.entity.Product;
import com.asol.services.ProductService;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
 private final String sharedKey = "SHARED_KEY";
 private static final String SUCCESS_STATUS = "success";
 private static final String ERROR_STATUS = "error";
 private static final int CODE_SUCCESS = 100;
 private static final int AUTH_FAILURE = 102;
 

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public List getProducts() {

		List list = productService.getAllProducts();
		return list;
	}
 
 
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}
 
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addProduct(@RequestBody Product product) { 
		productService.addProduct(product);
 
	}
 
	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
 
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);  
	}
	
	
	
 /*@RequestMapping(value = "/add", method = RequestMethod.POST)
 public BaseResponse add(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
  BaseResponse response = new BaseResponse();
  if (sharedKey.equalsIgnoreCase(key)) {
   int userId = request.getUserId();
   String itemId = request.getItemId();
   double discount = request.getDiscount();
   // Process the request
   // ....
   // Return success response to the client.
   response.setStatus(SUCCESS_STATUS);
   response.setCode(CODE_SUCCESS);
  } else {
   response.setStatus(ERROR_STATUS);
   response.setCode(AUTH_FAILURE);
  }
  return response;
 }*/
}
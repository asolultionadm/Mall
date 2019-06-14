package com.asol.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asol.entity.Product;
import com.asol.services.ProductService;
 
@Controller
public class ProductPageController {
 
	@Autowired
	ProductService productService;
 
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getProducts(Model model) {
 
		List listOfProducts = productService.getAllProducts();
		model.addAttribute("product", new Product());
		model.addAttribute("listOfProducts", listOfProducts);
		return "productDetails";
	}
 
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}
 
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addProduct(@ModelAttribute("product") Product product) {	
		if(product.getProductId()==0)
		{
			productService.addProduct(product);
		}
		else
		{	
			productService.updateProduct(product);
		}
 
		return "redirect:/getAllProducts";
	}
 
	@RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateProduct(@PathVariable("id") int id,Model model) {
		model.addAttribute("product", this.productService.getProduct(id));
		model.addAttribute("listOfProducts", this.productService.getAllProducts());
		return "productDetails";
	}
 
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/getAllProducts";
 
	}	
}
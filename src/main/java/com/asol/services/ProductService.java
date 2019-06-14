package com.asol.services;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.asol.dao.ProductDAO;
import com.asol.entity.Product;
	 
	@Service("productService")
	public class ProductService {
	 
		@Autowired
		ProductDAO productDao;
	 
		@Transactional
		public List getAllProducts() {
			return productDao.getAllProducts();
		}
	 
		@Transactional
		public Product getProduct(int id) {
			return productDao.getProduct(id);
		}
	 
		@Transactional
		public void addProduct(Product product) {
			productDao.addProduct(product);
		}
	 
		@Transactional
		public void updateProduct(Product product) {
			productDao.updateProduct(product);
	 
		}
	 
		@Transactional
		public void deleteProduct(int id) {
			productDao.deleteProduct(id);
		}
	}

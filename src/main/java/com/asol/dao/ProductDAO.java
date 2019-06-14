package com.asol.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asol.entity.Product;
 
@Repository
public class ProductDAO {
 
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
 
	public List getAllProducts() {
		Session session = this.sessionFactory.getCurrentSession();
		List productList = session.createQuery("from Product").list();
		return productList;
	}
 
	public Product getProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);
		return product;
	}
 
	public Product addProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(product);
		return product;
	}
 
	public void updateProduct(Product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
	}
 
	public void deleteProduct(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Product p = (Product) session.load(Product.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	} 
}
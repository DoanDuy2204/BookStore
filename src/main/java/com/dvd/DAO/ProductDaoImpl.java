package com.dvd.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dvd.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList() ;
	}

	@Override
	public Product getProduct(int productId) {
		return sessionFactory.getCurrentSession().createQuery("from Product where id=:productId",Product.class)
				.setParameter("productId", productId).getSingleResult();
	}

	@Override
	public void saveProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(productId);
	}

	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		
	}

}

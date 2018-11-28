package com.dvd.DAO;

import java.util.List;

import com.dvd.entity.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	public Product getProduct(int productId);
	public void saveProduct(Product product);
	public void deleteProduct(int productId);
	public void updateProduct(Product product);
}

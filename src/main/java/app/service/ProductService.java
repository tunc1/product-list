package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.document.Product;
import app.repository.ProductRepository;

import java.util.Map;

@Service
public class ProductService
{
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository=productRepository;
	}
	public Product save(Product product)
	{
		return productRepository.save(product);
	}
	public Product update(Product product)
	{
		return productRepository.save(product);
	}
	public void deleteById(String id)
	{
		productRepository.deleteById(id);
	}
	public Product findById(String id)
	{
		return productRepository.findById(id).get();
	}
	public Page<Product> findAll(Pageable pageable)
	{
		return productRepository.findAll(pageable);
	}
	public Page<Product> findByName(Pageable pageable,String name)
	{
		return productRepository.findByNameContainingIgnoreCase(pageable,name);
	}
	public Page<Product> findByCategoryId(Pageable pageable,String categoryId)
	{
		return productRepository.findByCategoryId(pageable,categoryId);
	}
}
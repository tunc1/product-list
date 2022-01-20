package app.controller;

import app.document.Product;
import app.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/product")
public class ProductController
{
	private ProductService productService;
	public ProductController(ProductService productService)
	{
		this.productService=productService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Product save(@RequestBody Product product)
	{
		return productService.save(product);
	}
	@PutMapping("/{id}")
	public Product update(@RequestBody Product product,@PathVariable String id)
	{
		product.setId(id);
		return productService.update(product);
	}
	@GetMapping("/{id}")
	public Product findById(@PathVariable String id)
	{
		return productService.findById(id);
	}
	@GetMapping
	public Page<Product> findAll(Pageable pageable)
	{
		return productService.findAll(pageable);
	}
	@GetMapping(params="name")
	public Page<Product> findByName(Pageable pageable,String name)
	{
		return productService.findByName(pageable,name);
	}
	@GetMapping(params="categoryId")
	public Page<Product> findByCategoryId(Pageable pageable,String categoryId)
	{
		return productService.findByCategoryId(pageable,categoryId);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable String id)
	{
		productService.deleteById(id);
	}
}
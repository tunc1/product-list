package app.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import app.document.Category;
import app.repository.CategoryRepository;

@Service
public class CategoryService
{
	private CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository)
	{
		this.categoryRepository=categoryRepository;
	}
	public Category save(Category category)
	{
		return categoryRepository.save(category);
	}
	public Category update(Category category)
	{
		return categoryRepository.save(category);
	}
	public void deleteById(String id)
	{
		categoryRepository.deleteById(id);
	}
	public Category findById(String id)
	{
		return categoryRepository.findById(id).get();
	}
	public Page<Category> findAll(Pageable pageable)
	{
		return categoryRepository.findAll(pageable);
	}
	public Page<Category> findByName(Pageable pageable,String name)
	{
		return categoryRepository.findByNameContainingIgnoreCase(pageable,name);
	}
}
package app.controller;

import app.document.Category;
import app.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/category")
public class CategoryController
{
	private CategoryService categoryService;
	public CategoryController(CategoryService categoryService)
	{
		this.categoryService=categoryService;
	}
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Category save(@RequestBody Category category)
	{
		return categoryService.save(category);
	}
	@PutMapping("/{id}")
	public Category update(@RequestBody Category category,@PathVariable String id)
	{
		category.setId(id);
		return categoryService.update(category);
	}
	@GetMapping("/{id}")
	public Category findById(@PathVariable String id)
	{
		return categoryService.findById(id);
	}
	@GetMapping
	public Page<Category> findAll(Pageable pageable)
	{
		return categoryService.findAll(pageable);
	}
	@GetMapping(params="name")
	public Page<Category> findByName(Pageable pageable,String name)
	{
		return categoryService.findByName(pageable,name);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable String id)
	{
		categoryService.deleteById(id);
	}
}
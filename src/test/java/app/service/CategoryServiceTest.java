package app.service;

import app.document.Category;
import app.document.Product;
import app.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest
{
    @Mock
    CategoryRepository categoryRepository;
    CategoryService categoryService;

    @BeforeEach
    void setUp()
    {
        categoryService=new CategoryService(categoryRepository);
    }
    @Test
    void save()
    {
        Category category=new Category();
        Mockito.when(categoryRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Category.class));
        Category saved=categoryService.save(category);
        Assertions.assertEquals(saved,category);
    }
    @Test
    void update()
    {
        Category category=new Category();
        Mockito.when(categoryRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Category.class));
        Category updated=categoryService.update(category);
        Assertions.assertEquals(updated,category);
    }
    @Test
    void deleteById()
    {
        categoryService.deleteById("id");
        Mockito.verify(categoryRepository).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsCategory()
    {
        Category category=new Category();
        Mockito.when(categoryRepository.findById(Mockito.any())).thenReturn(Optional.of(category));
        Category actual=categoryService.findById("id");
        Assertions.assertEquals(actual,category);
    }
    @Test
    void findAll()
    {
        Page<Category> page=new PageImpl<>(List.of(new Category()));
        Mockito.when(categoryRepository.findAll(Mockito.any(Pageable.class))).thenReturn(page);
        Page<Category> actual=categoryService.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
    @Test
    void findByName()
    {
        String name="name";
        Page<Category> page=new PageImpl<>(List.of(new Category()));
        Mockito.when(categoryRepository.findByNameContainingIgnoreCase(Mockito.any(),Mockito.any())).thenReturn(page);
        Page<Category> actual=categoryService.findByName(PageRequest.of(0,20),name);
        Assertions.assertEquals(actual,page);
    }
}
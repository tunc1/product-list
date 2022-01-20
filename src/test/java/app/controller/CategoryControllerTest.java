package app.controller;

import app.document.Category;
import app.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest
{
    @Mock
    CategoryService categoryService;
    CategoryController categoryController;

    @BeforeEach
    void setUp()
    {
        categoryController=new CategoryController(categoryService);
    }
    @Test
    void save()
    {
        Category category=new Category();
        Mockito.when(categoryService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Category.class));
        Category saved=categoryController.save(category);
        Assertions.assertEquals(saved,category);
    }
    @Test
    void update()
    {
        String id="id";
        Category category=new Category();
        Mockito.when(categoryService.update(Mockito.any())).thenAnswer(e->e.getArgument(0,Category.class));
        Category updated=categoryController.update(category,id);
        Assertions.assertEquals(updated,category);
        Assertions.assertEquals(updated.getId(),id);
    }
    @Test
    void deleteById()
    {
        categoryController.deleteById("id");
        Mockito.verify(categoryService).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsCategory()
    {
        Category category=new Category();
        Mockito.when(categoryService.findById(Mockito.any())).thenReturn(category);
        Category actual=categoryController.findById("id");
        Assertions.assertEquals(actual,category);
    }
    @Test
    void findAll()
    {
        Page<Category> page=new PageImpl<>(List.of(new Category()));
        Mockito.when(categoryService.findAll(Mockito.any())).thenReturn(page);
        Page<Category> actual=categoryController.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
    @Test
    void findByName()
    {
        String name="name";
        Page<Category> page=new PageImpl<>(List.of(new Category()));
        Mockito.when(categoryService.findByName(Mockito.any(),Mockito.any())).thenReturn(page);
        Page<Category> actual=categoryController.findByName(PageRequest.of(0,20),name);
        Assertions.assertEquals(actual,page);
    }
}
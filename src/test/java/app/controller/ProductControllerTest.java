package app.controller;

import app.document.Product;
import app.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest
{
    @Mock
    ProductService productService;
    ProductController productController;

    @BeforeEach
    void setUp()
    {
        productController=new ProductController(productService);
    }
    @Test
    void save()
    {
        Product product=new Product();
        Mockito.when(productService.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Product.class));
        Product saved=productController.save(product);
        Assertions.assertEquals(saved,product);
    }
    @Test
    void update()
    {
        String id="id";
        Product product=new Product();
        Mockito.when(productService.update(Mockito.any())).thenAnswer(e->e.getArgument(0,Product.class));
        Product updated=productController.update(product,id);
        Assertions.assertEquals(updated,product);
        Assertions.assertEquals(updated.getId(),id);
    }
    @Test
    void deleteById()
    {
        productController.deleteById("id");
        Mockito.verify(productService).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsProduct()
    {
        Product product=new Product();
        Mockito.when(productService.findById(Mockito.any())).thenReturn(product);
        Product actual=productController.findById("id");
        Assertions.assertEquals(actual,product);
    }
    @Test
    void findAll()
    {
        Page<Product> page=new PageImpl<>(List.of(new Product()));
        Mockito.when(productService.findAll(Mockito.any())).thenReturn(page);
        Page<Product> actual=productController.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
    @Test
    void findByName()
    {
        String name="name";
        Page<Product> page=new PageImpl<>(List.of(new Product()));
        Mockito.when(productService.findByName(Mockito.any(),Mockito.any())).thenReturn(page);
        Page<Product> actual=productController.findByName(PageRequest.of(0,20),name);
        Assertions.assertEquals(actual,page);
    }
    @Test
    void findByCategoryId()
    {
        String categoryId="1";
        Page<Product> page=new PageImpl<>(List.of(new Product()));
        Mockito.when(productService.findByCategoryId(Mockito.any(),Mockito.any())).thenReturn(page);
        Page<Product> actual=productController.findByCategoryId(PageRequest.of(0,20),categoryId);
        Assertions.assertEquals(actual,page);
    }
}
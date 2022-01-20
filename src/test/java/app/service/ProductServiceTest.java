package app.service;

import app.document.Product;
import app.repository.ProductRepository;
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
class ProductServiceTest
{
    @Mock
    ProductRepository productRepository;
    ProductService productService;

    @BeforeEach
    void setUp()
    {
        productService=new ProductService(productRepository);
    }
    @Test
    void save()
    {
        Product product=new Product();
        Mockito.when(productRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Product.class));
        Product saved=productService.save(product);
        Assertions.assertEquals(saved,product);
    }
    @Test
    void update()
    {
        Product product=new Product();
        Mockito.when(productRepository.save(Mockito.any())).thenAnswer(e->e.getArgument(0,Product.class));
        Product updated=productService.update(product);
        Assertions.assertEquals(updated,product);
    }
    @Test
    void deleteById()
    {
        productService.deleteById("id");
        Mockito.verify(productRepository).deleteById(Mockito.any());
    }
    @Test
    void findById_returnsProduct()
    {
        Product product=new Product();
        Mockito.when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));
        Product actual=productService.findById("id");
        Assertions.assertEquals(actual,product);
    }
    @Test
    void findAll()
    {
        Page<Product> page=new PageImpl<>(List.of(new Product()));
        Mockito.when(productRepository.findAll(Mockito.any(Pageable.class))).thenReturn(page);
        Page<Product> actual=productService.findAll(PageRequest.of(0,20));
        Assertions.assertEquals(actual,page);
    }
    @Test
    void findByName()
    {
        String name="name";
        Page<Product> page=new PageImpl<>(List.of(new Product()));
        Mockito.when(productRepository.findByNameContainingIgnoreCase(Mockito.any(),Mockito.any())).thenReturn(page);
        Page<Product> actual=productService.findByName(PageRequest.of(0,20),name);
        Assertions.assertEquals(actual,page);
    }
    @Test
    void findByCategoryId()
    {
        String categoryId="1";
        Page<Product> page=new PageImpl<>(List.of(new Product()));
        Mockito.when(productRepository.findByCategoryId(Mockito.any(),Mockito.any())).thenReturn(page);
        Page<Product> actual=productService.findByCategoryId(PageRequest.of(0,20),categoryId);
        Assertions.assertEquals(actual,page);
    }
}
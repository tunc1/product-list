package app.repository;

import app.document.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String>
{
    Page<Product> findByNameContainingIgnoreCase(Pageable pageable,String name);
    Page<Product> findByCategoryId(Pageable pageable,String categoryId);
}
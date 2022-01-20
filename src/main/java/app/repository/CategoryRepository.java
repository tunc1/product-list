package app.repository;

import app.document.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String>
{
    Page<Category> findByNameContainingIgnoreCase(Pageable pageable,String name);
}
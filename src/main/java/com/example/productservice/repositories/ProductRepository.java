package com.example.productservice.repositories;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.projection.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByTitleContaining(String word);

    long deleteByTitleIgnoreCase(String title);

    List<Product> findByTitleAndDescription(String title,
                                            String description);
    List<Product> findByPriceBetween(double startRange, double endRange);

    List<Product> findByCategory(Category category);

    Product findByIdAndCategoryOrderByTitle(Long id, Category category);

    List<Product> findByCategory_Id(Long id);


    Optional<Product> findById(Long id);
    // this will return a null ifno product matches the id

    Product save(Product product);

    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> somethingsomething(@Param("id") Long id);

    @Query(value = "select p.id as id, p.title as title from product p where p.id = :id", nativeQuery = true)
    List<ProductWithIdAndTitle> somesome2(@Param("id") Long id);
}

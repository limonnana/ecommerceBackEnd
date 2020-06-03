package com.limonnana.backend02.repository;


import com.limonnana.backend02.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    //deleteRelationCategory_product
    //delete from category_product where product_id = productId

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from category_product where product_id = ?1", nativeQuery = true)
    public void deleteRelationCategory_product(Long product_id);
        //delete from category_product where product_id = productId





}

package com.limonnana.backend02.services;

import com.limonnana.backend02.entity.Category;
import com.limonnana.backend02.entity.Product;
import com.limonnana.backend02.repository.CategoryRepository;
import com.limonnana.backend02.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public void saveProduct(Product product){

        Long categoryParentId = Long.valueOf(product.getCategoryParent());
        Category category = categoryRepository.findById(categoryParentId).get();
        category.getProducts().add(product);

    }

    @Transactional
    public void deleteProduct(Product product){

        categoryRepository.deleteRelationCategory_product(product.getProductId());

        productRepository.delete(product);
    }





}

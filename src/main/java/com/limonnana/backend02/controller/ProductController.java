package com.limonnana.backend02.controller;


import com.google.gson.Gson;
import com.limonnana.backend02.entity.Category;
import com.limonnana.backend02.entity.Product;
import com.limonnana.backend02.repository.CategoryRepository;
import com.limonnana.backend02.repository.ProductRepository;
import com.limonnana.backend02.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping("/secure/product")
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value="/findAll")
    public List findAll(@RequestHeader Map<String, String> m) {

        List<Product> l = productRepository.findAll();

        return l;
    }

    @PostMapping(value="/update")
    public Product update(@RequestBody Product product) {

        Gson gson = new Gson();
        logger.info("Product: " + gson.toJson(product));

            product = productRepository.save(product);

            return product;
    }

    @PostMapping(value="/create")
    public Product create(@RequestBody Product product) {

        Gson gson = new Gson();
        logger.info("Product: " + gson.toJson(product));
        if(product.getCategoryParent() != null && !product.getCategoryParent().equals("")){
            categoryService.saveProduct(product);
        }else{
            product = productRepository.save(product);
        }

        return product;
    }

    @GetMapping(value = "/getProduct/{id}")
    public Product getTheProductById(@PathVariable("id") long id) {

        Product product = productRepository.findById(id).get();
        return product;
    }

    @DeleteMapping(path ={"/deleteProduct/{id}"})
    public String delete(@PathVariable("id") long id) {

        Product product = productRepository.findById(id).get();
        categoryService.deleteProduct(product);

        return "{\"message\":200}";

    }

}

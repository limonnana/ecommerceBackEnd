package com.limonnana.backend02.controller;


import com.google.gson.Gson;
import com.limonnana.backend02.entity.Category;
import com.limonnana.backend02.entity.CategoryDTO;
import com.limonnana.backend02.repository.CategoryRepository;
import com.limonnana.backend02.utils.UtilsCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping("/secure/category")
public class CategoryController {

    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private UtilsCategory utilsCategory;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value="/findAll")
    public List findAll(@RequestHeader Map<String, String> m) {

        List<Category> l = categoryRepository.findAll();

        return l;
    }

    @PostMapping(value="/create")
    public Category create(@RequestBody CategoryDTO category) {

        Gson gson = new Gson();
        logger.info(" category json: " + gson.toJson(category));

        Category c = utilsCategory.fromDTOToCategory(category);

        if(category.getCategoryParent() != null && category.getCategoryParent() != "") {
            Category father = getTheCategoryById(Long.valueOf(category.getCategoryParent()));
            c.setCategoryParent(father);
        }

        return categoryRepository.save(c);
    }

    @GetMapping(value = "/getCategory/{id}")
    public Category getTheCategoryById(@PathVariable("id") long id) {

        Category category = categoryRepository.findById(id).get();
        return category;
    }

    @DeleteMapping(path ={"/deleteCategory/{id}"})
    public String delete(@PathVariable("id") long id) {

        categoryRepository.deleteById(id);

        return "{\"message\":200}";

    }

}

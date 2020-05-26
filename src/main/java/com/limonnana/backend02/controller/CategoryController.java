package com.limonnana.backend02.controller;


import com.google.gson.Gson;
import com.limonnana.backend02.entity.Category;
import com.limonnana.backend02.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping("/secure/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value="/findAll")
    public List findAll(@RequestHeader Map<String, String> m) {

        List<Category> l = categoryRepository.findAll();

        return l;
    }

    @PostMapping(value="/create")
    public Category create(@RequestBody Category category) {
        Gson gson = new Gson();
        System.out.println(gson.toJson(category));
        return categoryRepository.save(category);
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

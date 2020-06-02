package com.limonnana.backend02.utils;

import com.limonnana.backend02.entity.Category;
import com.limonnana.backend02.entity.CategoryDTO;
import org.springframework.stereotype.Component;

@Component
public class UtilsCategory {

    public Category fromDTOToCategory(CategoryDTO c){

        Category category = new Category();
        category.setCategoryId(c.getCategoryId());
        category.setName(c.getName());

        return category;
    }
}

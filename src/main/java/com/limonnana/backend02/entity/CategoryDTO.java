package com.limonnana.backend02.entity;


import java.util.HashSet;
import java.util.Set;

public class CategoryDTO {

    private Long categoryId;

    private String name;

    private String categoryParent;

    private Set<Category> categoryList = new HashSet<Category>();

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }


    public String getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(String categoryParent) {
        this.categoryParent = categoryParent;
    }
}

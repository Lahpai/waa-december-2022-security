package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.Category;

import java.util.List;

public interface CategroyService {
    void save(Category category);
    List<Category> findAll();
    Category findById(int id);
    void deleteById(int id);
}

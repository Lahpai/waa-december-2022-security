package edu.miu.springsecurity1.controller;

import edu.miu.springsecurity1.entity.Category;
import edu.miu.springsecurity1.service.CategroyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategroyService categoryService;

    @PostMapping
    public void save(@RequestBody Category category) {
        categoryService.save(category);
    }

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    public void save(@PathVariable int id, @RequestBody Category category) {
        if (id > 0)
            category.setId(id);
        categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        categoryService.deleteById(id);
    }
}
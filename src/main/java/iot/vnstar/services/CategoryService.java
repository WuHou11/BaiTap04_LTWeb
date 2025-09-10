package iot.vnstar.services;

import java.util.List;
import iot.vnstar.entity.Category;

public interface CategoryService {
    List<Category> findAll();
    List<Category> findByUser(int userId);
    Category findById(int id);
    void insert(Category category);
    void update(Category category);
    void delete(int id);
}
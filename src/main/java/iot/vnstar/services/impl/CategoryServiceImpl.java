package iot.vnstar.services.impl;

import java.util.List;

import iot.vnstar.dao.CategoryDao;
import iot.vnstar.entity.Category;
import iot.vnstar.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDao();

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Category> findByUser(int userId) {
        return dao.findByUser(userId);
    }

    @Override
    public Category findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void insert(Category category) {
        dao.insert(category);
    }

    @Override
    public void update(Category category) {
        dao.update(category);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}

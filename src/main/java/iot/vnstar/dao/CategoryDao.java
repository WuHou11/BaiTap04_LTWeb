package iot.vnstar.dao;

import jakarta.persistence.*;
import java.util.List;

import iot.vnstar.entity.Category;
import iot.vnstar.entity.User;

public class CategoryDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();

    public List<Category> findAll() {
        return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
    }

    // tìm theo userId
    public List<Category> findByUser(int userId) {
        return em.createQuery("SELECT c FROM Category c WHERE c.user.id = :uid", Category.class)
                .setParameter("uid", userId)
                .getResultList();
    }

    // tìm theo entity User (nếu cần)
    public List<Category> findByUser(User user) {
        return em.createQuery("SELECT c FROM Category c WHERE c.user = :u", Category.class)
                .setParameter("u", user)
                .getResultList();
    }

    // tìm theo category id
    public Category findById(int id) {
        return em.find(Category.class, id);
    }

    public void insert(Category c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public void update(Category c) {
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        Category c = em.find(Category.class, id);
        if (c != null) em.remove(c);
        em.getTransaction().commit();
    }
}

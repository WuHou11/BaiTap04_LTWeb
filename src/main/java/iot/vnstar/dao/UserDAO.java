package iot.vnstar.dao;

import iot.vnstar.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
	EntityManager em = emf.createEntityManager();

	public User login(String username, String password) {
		try {
			return em.createQuery("SELECT u FROM User u WHERE u.username = :uname AND u.password = :pwd", User.class)
					.setParameter("uname", username).setParameter("pwd", password).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
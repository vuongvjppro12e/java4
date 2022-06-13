package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.User;
import utils.JpaUtil;

public class UserDao {
 private EntityManager em;
 public UserDao(){
	 this.em = JpaUtil.getEntityManager();
 }
 public User create(User entity) throws Exception {
	 try {
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		return entity;
	} catch (Exception e) {
		e.printStackTrace();
		this.em.getTransaction().rollback();
		throw e;
	}
 }
 public User update(User entity) throws Exception {
	 try {
		this.em.getTransaction().begin();
		this.em.merge(entity);
		this.em.getTransaction().commit();
		return entity;
	} catch (Exception e) {
		e.printStackTrace();
		this.em.getTransaction().rollback();
		throw e;
	}
 }
 public User delete(User entity) throws Exception {
	 try {
		this.em.getTransaction().begin();
		this.em.remove(entity);
		this.em.getTransaction().commit();
		return entity;
	} catch (Exception e) {
		e.printStackTrace();
		this.em.getTransaction().rollback();
		throw e;
	}
 }
 	public List<User> all(){
 		String jpql = "SELECT obj from User obj";
 		this.em.createQuery(jpql,User.class);
 		TypedQuery<User> query = this.em.createQuery(jpql,User.class);
 		List<User> result = query.getResultList();
 		return result;
 	}
	public User findById(int id) {
		
		return this.em.find(User.class, id);
	}
	public User findByEmail(String email) {
		String jpql = "SELECT obj FROM User obj "
			+ "WHERE obj.email = :email";
		TypedQuery<User> query = this.em
				.createQuery(jpql, User.class);

		query.setParameter("email", email);

		return query.getSingleResult();
	}
}

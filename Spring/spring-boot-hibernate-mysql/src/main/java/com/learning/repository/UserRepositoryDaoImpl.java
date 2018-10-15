package com.learning.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.learning.model.User;
@Repository
public class UserRepositoryDaoImpl implements IUserRepository<User>{

	@Autowired
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	
	@Override
	@Transactional
	public void save(User user) {
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
	}

	@Override
	@Transactional
	public synchronized User loadById(int id) {
		User user = null;
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		user = em.find(User.class, id);
		et.commit();
		return user;
	}

	@Override
	@Transactional
	public boolean deleteById(int id) {
		User user = null;
		user = this.loadById(id);
		if(null == user){
			return false;
		}
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		em.remove(em.contains(user)? user : em.merge(user));
		et.commit();
		user = this.loadById(id);
		return user == null? true:false;
	}

	@Override
	@Transactional
	public User update(User user){
		User updatedUser = null;
		if(!this.isExist(user)){
			return updatedUser;
		}
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		updatedUser = em.merge(user);
		et.commit();
		return updatedUser;
	}
	
	public boolean isExist(User user){
		return this.loadById(user.getId()) != null ? true : false;
	}

	@Override
	public User findByEmail(String email) {
		User user = null;
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
		String query = "SELECT * FROM Users WHERE email = '"+email+"'";
		List list = em.createNativeQuery(query, User.class).getResultList();
		if(list.size() > 0){
			user = (User) list.get(0);
		}
		et.commit();
		return user;
	}
	
}
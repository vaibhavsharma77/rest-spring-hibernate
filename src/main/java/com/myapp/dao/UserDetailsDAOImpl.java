package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.myapp.model.UserDetails;

public class UserDetailsDAOImpl implements UserdetailsDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(UserDetails userDetails) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
	}

	public List<UserDetails> getUsers() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDetails.class);
		List<UserDetails> userDetails = criteria.list();
		session.close();
		return userDetails;
	}

}

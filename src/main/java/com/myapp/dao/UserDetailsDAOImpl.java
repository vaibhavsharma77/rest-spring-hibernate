package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

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

	public List<UserDetails> getAllUsers() {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDetails.class);
		List<UserDetails> userDetails = criteria.list();
		session.close();
		return userDetails;
	}

	public List<UserDetails> updateUser(UserDetails userDetails) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(UserDetails.class);
		//criteria.add(Restrictions.gt(", value))
		return null;
	}

	public UserDetails getUsers(int id) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(UserDetails.class).add(Restrictions.eq("id",id));
		UserDetails user=(UserDetails) criteria.uniqueResult();
		return user;
	}
	
	public void deleteUsers(int id) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(UserDetails.class);
		List<UserDetails> userDetails = criteria.list();
		if(userDetails!=null){
		UserDetails user=userDetails.get(0);
		Query query=session.createQuery("delete from UserDetails where id:id");
		query.setParameter("id",user.getId());
		query.executeUpdate();
		}
		
	
	}

}

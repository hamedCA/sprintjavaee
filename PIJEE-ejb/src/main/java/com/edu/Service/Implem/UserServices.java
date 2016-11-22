package com.edu.Service.Implem;

import com.edu.PiJEE.Comment;
import com.edu.PiJEE.User;
import com.edu.Service.Interface.UserServicesLocal;
import com.edu.Service.Interface.UserServicesRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote, UserServicesLocal {
    @PersistenceContext
	EntityManager em ;
    /**
     * Default constructor. 
     */
    public UserServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public void deletUser(User user) {
		em.remove(em.merge(user));
		
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
		
	}

	@Override
	public User findUserById(String id) {

		return em.find(User.class,id);
	}

	@Override
	public List<User> allUsers() {
		return em.createQuery("SELECT u FROM User u ", User.class)
				.getResultList();
	}

	@Override
	public User bestUser() {
		List<User> users = em.createQuery("SELECT u FROM User u ", User.class)
		.getResultList();
		int max=0;
		User bestUser = new User();
		for (User user : users) {
			int count =0;
		int discution = (int) em.createQuery("SELECT count(d.UserId) FROM User u Join u.Discution d where u.id=?1 " ).setParameter(1,user.getId())
				.getSingleResult();
		int comment = (int) em.createQuery("SELECT count(c.userId) FROM User u Join u.Comment c where u.id=?1 " ).setParameter(1,user.getId())
				.getSingleResult();
		int carpool = (int) em.createQuery("SELECT count(p.userId) FROM User u Join u.Carpool p where u.id=?1 " ).setParameter(1,user.getId())
				.getSingleResult();
		count = discution+comment+carpool ;
		if (count>max){
			max=count;
			bestUser=user;
		}
		}
		return bestUser;
	}

}

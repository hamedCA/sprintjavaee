package com.edu.Service.Implem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.edu.PiJEE.Carpool;
import com.edu.PiJEE.Favorite;
import com.edu.PiJEE.User;
import com.edu.Service.Interface.FavoriteServiceEjbLocalLocal;



/**
 * Session Bean implementation class FavoriteServiceEjbLocal
 */
@Stateless
@LocalBean
public class FavoriteServiceEjbLocal implements FavoriteServiceEjbLocalLocal {
	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public FavoriteServiceEjbLocal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addFavorite(User user, Carpool carpool) {
	    DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		User user2 = em.createQuery("SELECT u FROM User u WHERE u.firstName=?1", User.class)
				.setParameter(1, user.getFirstName()).getSingleResult();
		Carpool carpool2 = em.createQuery("SELECT c FROM Carpool c WHERE c.carpoolId=?1", Carpool.class)
				.setParameter(1, carpool.getCarpoolId()).getSingleResult();
		Favorite favorite = new Favorite(carpool2, user2);
		 LocalDate localDate = LocalDate.now();
		try {
			favorite.setFavoriteDate(sdf.parse(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.persist(favorite);
				

	}

	@Override
	public void updateFavorite(Favorite favorite) {
		
	}
	

}

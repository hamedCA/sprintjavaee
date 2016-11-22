package com.edu.Service.Interface;

import javax.ejb.Local;

import com.edu.PiJEE.Carpool;
import com.edu.PiJEE.Favorite;
import com.edu.PiJEE.User;

@Local
public interface FavoriteServiceEjbLocalLocal {
	public void addFavorite(User user,Carpool carpool);
	public void updateFavorite(Favorite favorite);
	
	

}

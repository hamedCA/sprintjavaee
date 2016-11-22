package com.edu.PiJEE;

import com.edu.PiJEE.Carpool;
import com.edu.PiJEE.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorite
 *
 */
@Entity
@Table(name = "favorite", catalog = "room")
public class Favorite implements Serializable {
	@EmbeddedId	
	private FavoriteId favoriteId;
	private Date favoriteDate;
	@ManyToOne
	@JoinColumn(name = "idCarpool", referencedColumnName = "carpoolId", updatable = false, insertable = false)

	private Carpool carpool;
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", updatable = false, insertable = false)

	private User user;
	private static final long serialVersionUID = 1L;

	public Favorite() {
		super();
	}   
	
	public Favorite(Carpool carpool, User user) {
		super();
		this.carpool = carpool;
		this.user = user;
	}

	public FavoriteId getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(FavoriteId favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Date getFavoriteDate() {
		return this.favoriteDate;
	}

	public void setFavoriteDate(Date favoriteDate) {
		this.favoriteDate = favoriteDate;
	}   
	public Carpool getCarpool() {
		return this.carpool;
	}

	public void setCarpool(Carpool carpool) {
		this.carpool = carpool;
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
}

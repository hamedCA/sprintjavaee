package com.edu.PiJEE;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: FavoriteId
 *
 */
@Embeddable


public class FavoriteId implements Serializable {

	
	private String idUser;
	private int idCarpool;
	private static final long serialVersionUID = 1L;

	public FavoriteId() {
		super();
	}   
	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}   
	public int getIdCarpool() {
		return this.idCarpool;
	}

	public void setIdCarpool(int idCarpool) {
		this.idCarpool = idCarpool;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCarpool;
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteId other = (FavoriteId) obj;
		if (idCarpool != other.idCarpool)
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}
   
}

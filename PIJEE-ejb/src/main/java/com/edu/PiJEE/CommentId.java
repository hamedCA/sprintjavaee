package com.edu.PiJEE;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommentId
 *
 */
@Embeddable

public class CommentId implements Serializable {

	
	private String userId;
	private int discutionId;
	private Date dateCreation;
	private static final long serialVersionUID = 1L;

	public CommentId() {
		super();
	}   
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}   
	public int getDiscutionId() {
		return this.discutionId;
	}

	public void setDiscutionId(int discutionId) {
		this.discutionId = discutionId;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + discutionId;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		CommentId other = (CommentId) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (discutionId != other.discutionId)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public CommentId(String userId, int discutionId, Date dateCreation) {
		super();
		this.userId = userId;
		this.discutionId = discutionId;
		this.dateCreation = dateCreation;
	}
   
}

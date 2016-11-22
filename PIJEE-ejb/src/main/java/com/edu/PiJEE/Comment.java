package com.edu.PiJEE;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity
@Table(name = "comment", catalog = "room")
public class Comment implements Serializable {

	@EmbeddedId
	CommentId commentId ;
	private String text;
	private int note;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "discutionId", referencedColumnName = "discutionGroupId", updatable = false, insertable = false)
	Discution discution ;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId", referencedColumnName = "id", updatable = false, insertable = false)
	User user ;
	
	public CommentId getCommentId() {
		return commentId;
	}
	public void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}
	public Discution getDiscution() {
		return discution;
	}
	public void setDiscution(Discution discution) {
		this.discution = discution;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}   
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}   
	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	public Comment( String text, int note, Discution discution, User user, Date dateCreation) {
		super();
		this.commentId = new CommentId(user.getId(),discution.getDiscutionGroupId(),dateCreation);
		this.text = text;
		this.note = note;
		this.discution = discution;
		this.user = user;
	}
   
}

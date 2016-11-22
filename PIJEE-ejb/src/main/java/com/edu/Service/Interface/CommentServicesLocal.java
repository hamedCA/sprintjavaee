package com.edu.Service.Interface;

import java.util.List;

import javax.ejb.Local;

import com.edu.PiJEE.Comment;

@Local
public interface CommentServicesLocal {
	public void addComment(Comment comment);
	public void updateComment(Comment comment);
	public void deletteComment(Comment comment);
	public List<Comment>  userComments(String id);

}

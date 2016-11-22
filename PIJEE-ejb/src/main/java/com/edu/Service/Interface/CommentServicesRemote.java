package com.edu.Service.Interface;

import java.util.List;

import javax.ejb.Remote;

import com.edu.PiJEE.Comment;

@Remote
public interface CommentServicesRemote {
	public void addComment(Comment comment);
	public void updateComment(Comment comment);
	public void deletteComment(Comment comment);
	public List<Comment>  userComments(String id);
}

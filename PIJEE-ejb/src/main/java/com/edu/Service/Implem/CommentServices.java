package com.edu.Service.Implem;

import com.edu.PiJEE.Comment;
import com.edu.Service.Interface.CommentServicesLocal;
import com.edu.Service.Interface.CommentServicesRemote;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CommentServices
 */
@Stateless
@LocalBean
public class CommentServices implements CommentServicesRemote, CommentServicesLocal {
    @PersistenceContext
	EntityManager em ;
    /**
     * Default constructor. 
     */
    public CommentServices() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addComment(Comment comment) {
		em.persist(comment);
		
	}

	@Override
	public void updateComment(Comment comment) {
		em.merge(comment);
		
	}

	@Override
	public void deletteComment(Comment comment) {
		em.remove(em.merge(comment));
		
	}

	@Override
	public List<Comment> userComments(String id) {
		return em.createQuery("SELECT c FROM Comment c where c.id=?1", Comment.class).setParameter(1,id)
		.getResultList();
		
	}

}

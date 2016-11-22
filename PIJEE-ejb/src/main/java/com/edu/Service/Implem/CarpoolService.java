package com.edu.Service.Implem;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.edu.PiJEE.Carpool;
import com.edu.Service.Interface.CarpoolServiceLocal;
import com.edu.Service.Interface.CarpoolServiceRemote;

/**
 * Session Bean implementation class CarpoolService
 */
@Stateless
@LocalBean
public class CarpoolService implements CarpoolServiceRemote, CarpoolServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="PIJEE-ejb")
    EntityManager em;
	
    public CarpoolService() {
        // TODO Auto-generated constructor stub
    }



	@Override
	public void addCarpool(Carpool Carpool) {
		// TODO Auto-generated method stub
		em.persist(Carpool);
	}

}

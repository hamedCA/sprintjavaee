package com.edu.Service.Interface;

import javax.ejb.Local;

import com.edu.PiJEE.Carpool;

@Local
public interface CarpoolServiceLocal {
	
	void addCarpool(Carpool Carpool);

}

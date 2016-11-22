package com.edu.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.edu.PiJEE.Carpool;
import com.edu.Service.Implem.CarpoolService;

@Singleton
@LocalBean
@Startup
public class DBinit {
@EJB
CarpoolService cp;
public DBinit(){
	
}
@PostConstruct
public void init(){
	Carpool c=new Carpool();
	c.setCarpoolType("daily");
	
	
	
	SimpleDateFormat format = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss");
    String st1="1-JAN-2016,00:00:00";
	
	try {Date date1;
		date1 = format.parse(st1);
	
		// TODO Auto-generated catch block
		
	
	c.setCreationDate(date1);
	c.setStartDate(date1);
	}
	catch (ParseException e) {e.printStackTrace();}
	c.setDescription("un covoiturage chaque jour");
	c.setPrice(30);
	c.setPlaceNumber(5);
	c.setStartPoint("Ouedlil");
	c.setEndPoint("ghazela");
	cp.addCarpool(c);
	
}
	
}

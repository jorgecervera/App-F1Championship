package es.jorge.practica.app.f1.dao;

import java.util.ArrayList;

/*
 * Generated a generic interface to select which methods we are going to use in our DAOs classes
 */

public interface GenericDAO<Tipo> {
	
	public ArrayList<Tipo> findAll();

	public Tipo findByPk(String id);

}

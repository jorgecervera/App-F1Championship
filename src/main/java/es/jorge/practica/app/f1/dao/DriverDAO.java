package es.jorge.practica.app.f1.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.jorge.practica.app.f1.entities.Driver;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DriverDAO implements GenericDAO<Driver> {

	private ArrayList<Driver> drivers;

	public DriverDAO() {
		this.drivers = new ArrayList<Driver>();
	}

	
	//The first method gets all the objects from the JSON and stores them in an Arraylist.

	@Override
	public ArrayList<Driver> findAll() {

		try (Reader reader = new FileReader(getClass().getResource("/f1ChampionshipData.txt").getFile())) {

			List<Driver> jsonDrivers = new Gson().fromJson(reader, new TypeToken<List<Driver>>() {}.getType());
			
			for (Driver driver : jsonDrivers) {
				drivers.add(driver);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(drivers, new Driver());

		int location = 1;
		for (Driver driver : drivers) {
			driver.setPosglobal(location);
			location++;
		}

		return drivers;
	}

	/*
	 * This method return a specific driver, from her PK
	 */

	@Override
	public Driver findByPk(String id) {
		
		if( drivers.isEmpty()) {
			drivers = findAll();
		}
		
		for (Driver driver : drivers) {
			if (driver.getId().equals(id)) {
				return driver;
			}

		}

		return null;

	}


}

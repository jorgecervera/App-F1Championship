package es.jorge.practica.app.f1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.jorge.practica.app.f1.dao.DriverDAO;
import es.jorge.practica.app.f1.entities.Driver;

public class DriverController {
	
	private DriverDAO driverDAO;
	
	public DriverController() {
		this.driverDAO = new DriverDAO();
	}
	
	/*
	 * This method returns all the drivers in JSON format
	 */
	
	@GetMapping("/ranking")
	public String listar() {
		Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(driverDAO.findAll());

	}

	/*
	 * This method returns a driver from a parameter in JSON format
	 */

	@RequestMapping(value = "/driver", params = "id")
	public Driver getid(@RequestParam String id) {
		return driverDAO.findByPk(id);
	}

}

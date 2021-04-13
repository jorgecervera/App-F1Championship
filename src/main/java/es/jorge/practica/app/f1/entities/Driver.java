package es.jorge.practica.app.f1.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/*
 * 
 *Driver Class
 *
 *It has a method to compare the time of different drivers
 *
 */
public class Driver implements Comparator<Driver> {
	
	private String _id;

	private Integer age;

	private String picture;

	private String name;

	private String team;

	private int posglobal;

	private List<Race> races;
	

	public Driver() {
	}

	public Driver(String id, Integer age, String picture, String name, String team, List<Race> races) {
		this._id = id;
		this.age = age;
		this.picture = picture;
		this.name = name;
		this.team = team;
		this.races = races;
	}

	public Driver(Driver driver) {
		_id = driver._id;
		age = driver.age;
		picture = driver.picture;
		name = driver.name;
		team = driver.team;
		races = driver.races;
		posglobal = driver.posglobal;
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

	public int getPosglobal() {
		return posglobal;
	}

	public void setPosglobal(int posglobal) {
		this.posglobal = posglobal;
	}

	/*
	 * Method used to be able to compare the time of two drivers and in this way to be able to order them
	 */

	@Override
	public int compare(Driver driver1, Driver driver2) {
		
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss.SSS");
		formato.setTimeZone(TimeZone.getTimeZone("UTC"));

		List<Race> r1 = driver1.getRaces();
		List<Race> r2 = driver2.getRaces();
		
		int num1 = 0;
		int num2 = 0;
		
		Date date;

		try {
			for (Race race : r1) {
				date = formato.parse(race.getTime());
				num1 += date.getTime();
			}
	
			for (Race race : r2) {
				date = formato.parse(race.getTime());
				num2 += date.getTime();

			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (num1 < num2) {
			return -1;
		} else if (num1 == num2) {
			return 0;
		} else {
			return 1;
		}
	}

}

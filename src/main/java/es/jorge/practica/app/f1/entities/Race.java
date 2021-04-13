package es.jorge.practica.app.f1.entities;


/*
 * Race Class
 */

public class Race {
	
	private String name;
	private String time;
	private int pos;

	public Race() {
		
	}
	public Race(String name, String time) {
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
	

}

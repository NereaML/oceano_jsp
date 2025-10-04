package com.cursogetafe.oceano.modelo;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {
	
	private String calle;
	private String ciudad;
	private int cp;
	
	public Direccion() {
		
	}
	
	public Direccion(String calle, String ciudad, int cp) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
		this.cp = cp;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", ciudad=" + ciudad + ", cp=" + cp + "]";
	}
	
	

}

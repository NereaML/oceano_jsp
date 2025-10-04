package com.cursogetafe.oceano.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "habitat")
public class Habitat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_habitat")
	private int idHabitat;
	
	private String nombre;
	private Double temperatura;
	private Double salinidad;
	
	public Habitat() {
		
	}
	
	public Habitat(int idHabitat, String nombre, Double temperatura, Double salinidad) {
		super();
		this.idHabitat = idHabitat;
		this.nombre = nombre;
		this.temperatura = temperatura;
		this.salinidad = salinidad;
	}

	public int getIdHabitat() {
		return idHabitat;
	}

	public void setIdHabitat(int idHabitat) {
		this.idHabitat = idHabitat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getSalinidad() {
		return salinidad;
	}

	public void setSalinidad(Double salinidad) {
		this.salinidad = salinidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idHabitat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habitat other = (Habitat) obj;
		return idHabitat == other.idHabitat;
	}

	@Override
	public String toString() {
		return "Habitat [idHabitat=" + idHabitat + ", nombre=" + nombre + ", temperatura=" + temperatura
				+ ", salinidad=" + salinidad + "]";
	}
	
	

}

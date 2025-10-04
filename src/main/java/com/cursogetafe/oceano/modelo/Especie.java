package com.cursogetafe.oceano.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name= "especie")
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_especie")
	private int idEspecie;
	
	@Column(name="nombre_cientifico")
	private String nombreCientifico;
	
	@Enumerated(EnumType.STRING)
	private TipoEspecie tipo;
	
	@Column(name="en_peligro")
	private boolean enPeligro; 
	
	public Especie() {
		
	}

	public Especie(int idEspecie, String nombreCientifico, TipoEspecie tipo, boolean enPeligro) {
		super();
		this.idEspecie = idEspecie;
		this.nombreCientifico = nombreCientifico;
		this.tipo = tipo;
		this.enPeligro = enPeligro;
	}

	public int getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(int idEspecie) {
		this.idEspecie = idEspecie;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public TipoEspecie getTipo() {
		return tipo;
	}

	public void setTipo(TipoEspecie tipo) {
		this.tipo = tipo;
	}

	public boolean isEnPeligro() {
		return enPeligro;
	}

	public void setEnPeligro(boolean enPeligro) {
		this.enPeligro = enPeligro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEspecie);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especie other = (Especie) obj;
		return idEspecie == other.idEspecie;
	}

	@Override
	public String toString() {
		return "Especie [idEspecie=" + idEspecie + ", nombreCientifico=" + nombreCientifico + ", tipo=" + tipo
				+ ", enPeligro=" + enPeligro + "]";
	}
	
	
	
	

}

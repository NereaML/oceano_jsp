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
@Table(name = "alimento")
public class Alimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_alimento")
	private int idAlimento;
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private TipoAlimento tipo;

	
	public Alimento() {
		
	}

	public Alimento(int idAlimento, String nombre, TipoAlimento tipo) {
		super();
		this.idAlimento = idAlimento;
		this.nombre = nombre;
		this.tipo = tipo;
	}


	public int getIdAlimento() {
		return idAlimento;
	}


	public void setIdAlimento(int idAlimento) {
		this.idAlimento = idAlimento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TipoAlimento getTipo() {
		return tipo;
	}


	public void setTipo(TipoAlimento tipo) {
		this.tipo = tipo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idAlimento);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return idAlimento == other.idAlimento;
	}


	@Override
	public String toString() {
		return "Alimento [idAlimento=" + idAlimento + ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	

}

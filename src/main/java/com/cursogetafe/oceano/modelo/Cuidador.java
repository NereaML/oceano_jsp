package com.cursogetafe.oceano.modelo;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuidador")
public class Cuidador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuidador")
	private int idCuidador;
	private String nombre;
	private int telefono;
	
	@Embedded
	private Direccion direccion;
	
	@ManyToMany
	@JoinTable(name = "cuidador_criatura", joinColumns = @JoinColumn(name= "id_cuidador"), inverseJoinColumns = @JoinColumn(name="id_criatura"))
	private Set<Criatura> criaturas;

	
	public Cuidador() {
		
	}
	
	public Cuidador(int idCuidador, String nombre, int telefono, Direccion direccion, Set<Criatura> criaturas) {
		super();
		this.idCuidador = idCuidador;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.criaturas = criaturas;
	}

	public int getIdCuidador() {
		return idCuidador;
	}

	public void setIdCuidador(int idCuidador) {
		this.idCuidador = idCuidador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Set<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(Set<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCuidador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuidador other = (Cuidador) obj;
		return idCuidador == other.idCuidador;
	}

	@Override
	public String toString() {
		return "Cuidador [idCuidador=" + idCuidador + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion="
				+ direccion + ", criaturas=" + criaturas + "]";
	}
	
	
	

}

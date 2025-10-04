package com.cursogetafe.oceano.modelo;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "plan_alimentacion")
public class PlanAlimentacion {
	
	@Id
	@Column(name = "id_plan")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlan;
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "id_criatura")
	private Criatura criatura;
	
	@ManyToMany
	@JoinTable(name = "plan_alimento", joinColumns = @JoinColumn (name= "id_plan"), inverseJoinColumns = @JoinColumn(name = "id_alimento"))
	private Set <Alimento> alimentos;
	
	public void PLanAlimentacion() {
		
	}
	
	public PlanAlimentacion(int idPlan, String descripcion, Criatura criatura, Set<Alimento> alimentos) {
		super();
		this.idPlan = idPlan;
		this.descripcion = descripcion;
		this.criatura = criatura;
		this.alimentos = alimentos;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Criatura getCriatura() {
		return criatura;
	}

	public void setCriatura(Criatura criatura) {
		this.criatura = criatura;
	}

	public Set<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Set<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPlan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanAlimentacion other = (PlanAlimentacion) obj;
		return idPlan == other.idPlan;
	}

	@Override
	public String toString() {
		return "PlanAlimentacion [idPlan=" + idPlan + ", descripcion=" + descripcion + ", criatura=" + criatura
				+ ", alimentos=" + alimentos + "]";
	}

	
	
}

package com.cursogetafe.oceano.modelo;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "criatura")
public class Criatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_criatura")
	private int idCriatura;
	
	@Column(name = "nombre_comun")
	private String nombreComun;
	
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;
	
	@ManyToOne
	@JoinColumn(name ="id_habitat")
	private Habitat habitat;
	
	@ManyToOne
	@JoinColumn(name ="id_especie")
	private Especie especies;
	
	@OneToMany(mappedBy = "criatura", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PlanAlimentacion> planesAlimentacion;

	@ManyToMany(mappedBy = "criaturas")
	private Set<Cuidador> cuidadores;

	
	public Criatura() {
		
	}

	public Criatura(int idCriatura, String nombreComun, Date fechaIngreso, Habitat habitat, Especie especies) {
		super();
		this.idCriatura = idCriatura;
		this.nombreComun = nombreComun;
		this.fechaIngreso = fechaIngreso;
		this.habitat = habitat;
		this.especies = especies;
	}

	public int getIdCriatura() {
		return idCriatura;
	}

	public void setIdCriatura(int idCriatura) {
		this.idCriatura = idCriatura;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	public Especie getEspecies() {
		return especies;
	}

	public void setEspecies(Especie especies) {
		this.especies = especies;
	}
	
	
	
	public Set<PlanAlimentacion> getPlanesAlimentacion() {
		return planesAlimentacion;
	}

	public void setPlanesAlimentacion(Set<PlanAlimentacion> planesAlimentacion) {
		this.planesAlimentacion = planesAlimentacion;
	}
	
	

	public Set<Cuidador> getCuidadores() {
		return cuidadores;
	}

	public void setCuidadores(Set<Cuidador> cuidadores) {
		this.cuidadores = cuidadores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCriatura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criatura other = (Criatura) obj;
		return idCriatura == other.idCriatura;
	}

	@Override
	public String toString() {
		return "Criatura [idCriatura=" + idCriatura + ", nombreComun=" + nombreComun + ", fechaIngreso=" + fechaIngreso
				+ ", habitat=" + habitat + ", especies=" + especies + "]";
	}

	
	
	
	

}

package com.cursogetafe.oceano.negocio;

import java.util.Comparator;
import java.util.Set;
import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.modelo.Especie;
import com.cursogetafe.oceano.modelo.Habitat;
import com.cursogetafe.oceano.modelo.TipoEspecie;


public interface Oceano {
	


    /** Devuelve todas las criaturas ordenadas por nombre */
    Set<Criatura> getCriaturasPorNombre(String nombreComun) throws Exception ;

    /** Devuelve todas las criaturas ordenadas por fecha de ingreso */
    Set<Criatura> getCriaturasPorFechaIngreso()  throws Exception;

    /** Devuelve obtener todas las especies disponibles */
    Set<Especie> getEspecies() throws Exception;
    
    /** Devuelve obtener todos los habitats disponibles*/
    Set<Habitat> getHabitats() throws Exception;
  
    
    /** Comparator por nombre común */
    Comparator<Criatura> getComparatorNombre();

    /** Comparator por fecha de ingreso */
    Comparator<Criatura> getComparatorFechaIngreso();

    /** Comparator por especie (nombre científico) */
    Comparator<Criatura> getComparatorEspecie();

    /** Comparator por habitat (nombre) */
    Comparator<Criatura> getComparatorHabitat();
    
    /** Crea una especie si no existe */
    Especie crearEspecieSiNoExiste(String nombre, TipoEspecie tipo) throws Exception;
    
   
    /** Busca especie por id */
    Especie getEspeciePorId(int id) throws Exception;
    
    /** Busca habitat por id */
    Habitat getHabitatPorId(int id) throws Exception;
   
    /** Guarda criatura */
    void guardarCriatura(Criatura c) throws Exception;

    
    
	
    }

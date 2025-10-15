package com.cursogetafe.oceano.negocio;

import java.util.Comparator;
import java.util.Set;
import com.cursogetafe.oceano.modelo.Criatura;


public interface Oceano {
	


    /** Devuelve todas las criaturas ordenadas por nombre */
    Set<Criatura> getCriaturasPorNombre() throws Exception ;

    /** Devuelve todas las criaturas ordenadas por fecha de ingreso */
    Set<Criatura> getCriaturasPorFechaIngreso()  throws Exception;

    /** Comparator por nombre común */
    Comparator<Criatura> getComparatorNombre();

    /** Comparator por fecha de ingreso */
    Comparator<Criatura> getComparatorFechaIngreso();

    /** Comparator por especie (nombre científico) */
    Comparator<Criatura> getComparatorEspecie();

    /** Comparator por habitat (nombre) */
    Comparator<Criatura> getComparatorHabitat();
    
	
    }

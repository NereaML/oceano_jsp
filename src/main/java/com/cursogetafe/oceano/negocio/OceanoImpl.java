package com.cursogetafe.oceano.negocio;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.persistencia.OceanoDao;
import com.cursogetafe.oceano.persistencia.OceanoDaoImpl;

public class OceanoImpl implements Oceano{
	

    private OceanoDao oce;

    public OceanoImpl() {
        oce = new OceanoDaoImpl();
    }

	@Override
	public Set<Criatura> getCriaturasPorNombre() throws Exception {
		Set<Criatura> resu = new TreeSet<>(getComparatorNombre());
        resu.addAll(oce.listarTodas());
        return resu;
	}

	@Override
	public Set<Criatura> getCriaturasPorFechaIngreso() throws Exception {
		Set<Criatura> resu = new TreeSet<>(getComparatorFechaIngreso());
        resu.addAll(oce.listarTodas());
        return resu;
	}

	@Override
	public Comparator<Criatura> getComparatorNombre() {
		 return (c1, c2) -> {
	            Collator col = Collator.getInstance(new Locale("es"));
	            return col.compare(c1.getNombreComun(), c2.getNombreComun());
	        };
	}

	@Override
	public Comparator<Criatura> getComparatorFechaIngreso() {
		return (c1, c2) -> c1.getFechaIngreso().compareTo(c2.getFechaIngreso());
	}

	@Override
	public Comparator<Criatura> getComparatorEspecie() {
		return (c1, c2) -> {
            Collator col = Collator.getInstance(new Locale("es"));
            return col.compare(c1.getEspecies().getNombreCientifico(),
                               c2.getEspecies().getNombreCientifico());
        };
	}

	@Override
	public Comparator<Criatura> getComparatorHabitat() {
		  return (c1, c2) -> {
	            Collator col = Collator.getInstance(new Locale("es"));
	            return col.compare(c1.getHabitat().getNombre(),
	                               c2.getHabitat().getNombre());
	        };
	}

}

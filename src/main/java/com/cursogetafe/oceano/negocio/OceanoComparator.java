package com.cursogetafe.oceano.negocio;

import java.text.Collator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.persistencia.OceanoDao;
import com.cursogetafe.oceano.persistencia.OceanoDaoImpl;

import java.util.Comparator;

public class OceanoComparator {



    private OceanoDao dao;

    public OceanoComparator() {
        dao = new OceanoDaoImpl();
    }

    /** Devuelve todas las criaturas ordenadas por nombre */
    public Set<Criatura> getCriaturasPorNombre() throws Exception {
        Set<Criatura> resu = new TreeSet<>(getComparatorNombre());
        resu.addAll(dao.listarTodas());
        return resu;
    }

    /** Devuelve todas las criaturas ordenadas por fecha de ingreso */
    public Set<Criatura> getCriaturasPorFechaIngreso() throws Exception {
        Set<Criatura> resu = new TreeSet<>(getComparatorFechaIngreso());
        resu.addAll(dao.listarTodas());
        return resu;
    }

    /** Comparator por nombre común */
    private Comparator<Criatura> getComparatorNombre() {
        return (c1, c2) -> {
            Collator col = Collator.getInstance(new Locale("es"));
            return col.compare(c1.getNombreComun(), c2.getNombreComun());
        };
    }

    /** Comparator por fecha de ingreso */
    private Comparator<Criatura> getComparatorFechaIngreso() {
        return (c1, c2) -> c1.getFechaIngreso().compareTo(c2.getFechaIngreso());
    }

    /** Comparator por especie (nombre científico) */
    private Comparator<Criatura> getComparatorEspecie() {
        return (c1, c2) -> {
            Collator col = Collator.getInstance(new Locale("es"));
            return col.compare(c1.getEspecies().getNombreCientifico(),
                               c2.getEspecies().getNombreCientifico());
        };
    }

    /** Comparator por habitat (nombre) */
    private Comparator<Criatura> getComparatorHabitat() {
        return (c1, c2) -> {
            Collator col = Collator.getInstance(new Locale("es"));
            return col.compare(c1.getHabitat().getNombre(),
                               c2.getHabitat().getNombre());
        };
    }

}

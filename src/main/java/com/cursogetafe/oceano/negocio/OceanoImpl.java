package com.cursogetafe.oceano.negocio;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.modelo.Especie;
import com.cursogetafe.oceano.modelo.Habitat;
import com.cursogetafe.oceano.modelo.TipoEspecie;
import com.cursogetafe.oceano.persistencia.OceanoDao;
import com.cursogetafe.oceano.persistencia.OceanoDaoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class OceanoImpl implements Oceano{
	

    private OceanoDao oce;
    private EntityManager em;
    

    public OceanoImpl() {
        oce = new OceanoDaoImpl();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oceano");
        em = emf.createEntityManager();
    }

    
    //criatura
    
	@Override
	public Criatura getBuscarPorId(int idCriatura) {
		return em.find(Criatura.class, idCriatura);
	}
	
	@Override
	public void eliminarCriatura(int idCriatura) {
	    
	    Criatura criatura = em.find(Criatura.class, idCriatura);

	    if (criatura != null) {
	        // Elimina la criatura de los cuidadores
	        criatura.getCuidadores().forEach(c -> c.getCriaturas().remove(criatura));

	        // Limpia la lista
	        criatura.getCuidadores().clear();

	        //Elimina la criatura
	        em.remove(criatura);
	    } else {
	        System.out.println("La criatura con id " + idCriatura + " no existe");
	    }
	}

	
	@Override
	public void guardarCriatura(Criatura c) throws Exception {
		em.getTransaction().begin();
	    em.persist(c);
	    em.getTransaction().commit();
		
	}
	

	
	@Override
	public Set<Criatura> getCriaturasPorNombre(String nombreString) throws Exception {
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
	


	
	
	//Especie
	@Override
	public Set<Especie> getEspecies() throws Exception {
		TypedQuery<Especie> query = em.createQuery("SELECT e FROM Especie e", Especie.class);
        return Set.copyOf(query.getResultList());
	}

	
	@Override
	public Especie crearEspecieSiNoExiste(String nombreCientifico, TipoEspecie tipo) throws Exception {
	    Set<Especie> especies = getEspecies();
	    for(Especie e : especies) {
	        if(e.getTipo() == tipo) {  
	            return e;
	        }
	    }

	    Especie nueva = new Especie();
	    nueva.setNombreCientifico(nombreCientifico);
	    nueva.setEnPeligro(false);
	    nueva.setTipo(tipo); 
	    em.getTransaction().begin();
	    em.persist(nueva);
	    em.getTransaction().commit();
	    return nueva;
	}


	
	@Override
	public Especie getEspeciePorId(int id) throws Exception {
		return em.find(Especie.class, id);
	}
	
	@Override
	public void guardarEspecie(Especie especie) throws Exception {
			em.getTransaction().begin();
		    em.persist(especie);
		    em.getTransaction().commit();
			
	}
		
	

	
	
	//Habitat
	@Override
	public Set<Habitat> getHabitats() throws Exception {
		TypedQuery<Habitat> query = em.createQuery("SELECT h FROM Habitat h", Habitat.class);
        return Set.copyOf(query.getResultList());
	}



	@Override
	public Habitat getHabitatPorId(int id) throws Exception {
		return em.find(Habitat.class, id);
	}
	
	public List<Habitat> getHabitatsOrdenados()throws Exception{
		Set<Habitat> todosHabitat = getHabitats();
		List<Habitat> habitatList = new ArrayList<>(todosHabitat);
		
		Collator collator = Collator.getInstance(new Locale("es"));
		habitatList.sort((h1, h2) -> collator.compare(h1.getNombre(), h2.getNombre()));
		
		return habitatList;
	}






}

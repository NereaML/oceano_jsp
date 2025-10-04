package com.cursogetafe.oceano.persistencia;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cursogetafe.oceano.config.Config;
import com.cursogetafe.oceano.modelo.Criatura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;



public class OceanoDaoImpl implements OceanoDao{
	
	private EntityManagerFactory emf;
	
	
	public OceanoDaoImpl(){
		this.emf = Config.getEmf();
	}
	

	@Override
	public void insertar(Criatura criatura) throws Exception {
		
		try(EntityManager em = emf.createEntityManager()){
			try {
			em.getTransaction().begin();
			em.persist(criatura);
			em.getTransaction().commit();
			
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new PersistenceException();
		}
		}
		
	}

	@Override
	public Criatura buscarPorId(int idCriatura) throws Exception {
		EntityManager em = emf.createEntityManager();
		String jpql =" Select c from Criatura c where c.idCriatura = :id";
		TypedQuery<Criatura> query = em.createQuery(jpql, Criatura.class);
		query.setParameter("id", idCriatura);
		Criatura criatura = query.getSingleResult();
			em.close();
		return criatura;
	}
	

	@Override
	public List<Criatura> listarTodas() throws Exception {
		EntityManager em = emf.createEntityManager();
		String jpql = "Select c from Criatura c";
		TypedQuery<Criatura> query = em.createQuery(jpql, Criatura.class);
		List<Criatura> resu = query.getResultList();
		em.close();
		return resu;
	}

	@Override
	public void actualizar(Criatura criatura) throws Exception {
		try(EntityManager em = emf.createEntityManager()){
			try {
			em.getTransaction().begin();
			em.merge(criatura);
			em.getTransaction().commit();
			
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new PersistenceException();
		}
		}
	}

	@Override
	public void eliminar(int idCriatura) throws Exception {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Criatura criatura = em.find(Criatura.class, idCriatura);
		if( criatura != null) {
			em.remove(criatura);
		}
		em.getTransaction().commit();
		
	}

}

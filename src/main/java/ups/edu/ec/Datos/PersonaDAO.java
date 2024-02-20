package ups.edu.ec.Datos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ups.edu.ec.Model.Persona;

@Stateless
public class PersonaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//@PersistenceContext
	@Inject
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(String cedula ) {
		Persona c = em.find(Persona.class, cedula);
		return c;
	}
	
	public void delete(String cedula ) {
		Persona c = em.find(Persona.class, cedula);
		em.remove(c);
	}
	
	public List<Persona> getAll() {
		String jpql="SELECT p From Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}

package ups.edu.ec.Datos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.Model.DataSet;


@Stateless
public class DataSetDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void insert(DataSet dataset) {
		em.persist(dataset);
	}
	
	public void update(DataSet dataset) {
		em.merge(dataset);
	}
	
	public DataSet read(String codigo ) {
		DataSet c = em.find(DataSet.class, codigo);
		return c;
	}
	
	public void delete(Integer codigo ) {
		DataSet c = em.find(DataSet.class, codigo);
		em.remove(c);
	}
	
	public List<DataSet> listadoDataSet() {
		String jpql="SELECT p From Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}

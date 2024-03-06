package ups.edu.ec.Datos;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ups.edu.ec.Model.DataSet;
import ups.edu.ec.Model.Persona;


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
	
	public DataSet read(int codigo ) {
		DataSet c = em.find(DataSet.class, codigo);
		return c;
	}
	
	public DataSet buscarDataSetPer(String persona) {
		System.out.println("cedula en dao "+persona);
		/*TypedQuery<DataSet> query = em.createQuery("SELECT p FROM Dataset p WHERE p.persona = :persona", DataSet.class);
	    query.setParameter("persona", persona);
	    return query.getResultList();*/
	    
		String jsql="SELECT p FROM dataSet p WHERE p.persona_cedula = :persona";
		Query query=em.createQuery(jsql,DataSet.class);
		query.setParameter("persona", persona);
		DataSet data= (DataSet) query.getSingleResult();
		return data;
	}
	
	public void delete(Integer codigo ) {
		DataSet c = em.find(DataSet.class, codigo);
		em.remove(c);
	}
	
	public List<DataSet> listadoDataSet() {
		String jpql="SELECT p From DataSet p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}

package ups.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.Datos.DataSetDAO;
import ups.edu.ec.Datos.PersonaDAO;
import ups.edu.ec.Model.DataSet;
import ups.edu.ec.Model.Persona;


@ManagedBean
@Singleton
@Startup
public class DataSetController{
	
	private DataSet dataset;
	
	@Inject
	private DataSetDAO daodataset;
	
	private List<DataSet>listardataset;
	private List<Persona>lisdatasetpersonas;
	
	
	@Inject
	private PersonaDAO daopersona;
	
	@PostConstruct
	public void init() {
		dataset= new DataSet();
		leerPersonadata();
	}
	
	public DataSet getDataset() {
		return dataset;
	}

	public void setDataset(DataSet dataset) {
		this.dataset = dataset;
	}

	public DataSetDAO getDaodataset() {
		return daodataset;
	}

	public void setDaodataset(DataSetDAO daodataset) {
		this.daodataset = daodataset;
	}
	
	public List<DataSet> getListardataset() {
		return listardataset;
	}

	public void setListardataset(List<DataSet> listardataset) {
		this.listardataset = listardataset;
	}
	
	public List<Persona> getLisdatasetpersonas() {
		return lisdatasetpersonas;
	}

	public void setLisdatasetpersonas(List<Persona> lisdatasetpersonas) {
		this.lisdatasetpersonas = lisdatasetpersonas;
	}
	
	public void cargarPersonas() {
		lisdatasetpersonas=daopersona.listadoPersonas();
	}
	public void leerPersonadata(){
		List<Persona> per = daopersona.listadoPersonas();
		for(Persona pro: per) {
			System.out.println("====>  "+pro);
		}
	}	
	
	public void listarDataSet() {
		listardataset=daodataset.listadoDataSet();
		for (DataSet data : listardataset) {
			System.out.println(data);
		}
	}
	
	public String guardar() {
		
		System.out.println(dataset);
		daodataset.insert(dataset);
		return null;
	}
}
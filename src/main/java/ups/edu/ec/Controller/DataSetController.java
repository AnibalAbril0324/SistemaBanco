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
public class DataSetController{
	
	private DataSet dataset;
	
	@Inject
	private DataSetDAO daodataset;
	
	private List<DataSet>listardataset;
	private List<Persona>lisdatasetpersonas;
	
	private DataSet datasetbuscado;
	private String valoringresado;
	
	@Inject
	private PersonaDAO daopersona;
	
	private int codigo; 
	
	@PostConstruct
	public void init() {
		dataset= new DataSet();
		//listarDataSet();
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
	
	public DataSet getDatasetbuscado() {
		return datasetbuscado;
	}

	public void setDatasetbuscado(DataSet datasetbuscado) {
		this.datasetbuscado = datasetbuscado;
	}

	public void cargarPersonas() {
		lisdatasetpersonas=daopersona.listadoPersonas();
	}
	
	public String getValoringresado() {
		return valoringresado;
	}

	public void setValoringresado(String valoringresado) {
		this.valoringresado = valoringresado;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
		loadCargarDatasetEditar(codigo);
	}
	
	public String loadCargarDatasetEditar(int codigo) {
		dataset=daodataset.read(codigo);
		return "pagarcredito";
		
	}
	public void listarDataSet() {
		listardataset=daodataset.listadoDataSet();
	}
	
	public String guardar() {
		
		System.out.println(dataset);
		daodataset.insert(dataset);
		return null;
	}
	
	public void buscarDataSet() {
		System.out.println("valor ingresado"+valoringresado);
		System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
		
		
		System.out.println("=====>  "+loadCargarDatasetEditar(1));
		List<DataSet> datos = daodataset.listadoDataSet();
		for(DataSet data: datos) {
			System.out.println(data);
			if(data.getPersona().getCedula().equals(valoringresado)) {
				//System.out.println("valor ingresado ====> "+valoringresado+"  cedula=====> "+data.getPersona().getCedula());
				datasetbuscado=data;
				//System.out.println("========="+datasetbuscado.getPersona().getApellidos());
			}
		}
		System.out.println("==========================");
		System.out.println(datasetbuscado.getPersona().getNombres());
	}
}
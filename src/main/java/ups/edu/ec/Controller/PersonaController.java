package ups.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.bean.ManagedBean;

import javax.inject.Inject;

import ups.edu.ec.Datos.PersonaDAO;
import ups.edu.ec.Model.Persona;

@ManagedBean
@Singleton
@Startup
public class PersonaController {
	
	@Inject
	private PersonaDAO daopersona;
	
	private Persona persona;
	public List<Persona>listarpersonas;
	
	private Persona personabuscada;
	
	private String opcionseleccionada;
	private String valoringresado;
	
	private String codigo;
	
	@PostConstruct
	public void init() {
		persona= new Persona();	
		cargarPersonas();
		buscarPersona();
	}
	
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public List<Persona> getPersonas() {
		return listarpersonas;
	}

	public void setPersonas(List<Persona> personas) {
		this.listarpersonas = personas;
	}
	
	public Persona getPersonabuscada() {
		return personabuscada;
	}

	public void setPersonabuscada(Persona personabuscada) {
		this.personabuscada = personabuscada;
	}
	
	public String getOpcionseleccionada() {
		return opcionseleccionada;
	}

	public void setOpcionseleccionada(String opcionseleccionada) {
		this.opcionseleccionada = opcionseleccionada;
	}

	public String getValoringresado() {
		return valoringresado;
	}

	public void setValoringresado(String valoringresado) {
		this.valoringresado = valoringresado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
		loadDatosEditar(codigo);
	}

	public String loadDatosEditar(String codigo) {
		persona=daopersona.read(codigo);
		return "pagarcredito";
	}
	public void cargarPersonas() {
		listarpersonas=daopersona.listadoPersonas();
	}
	public void leerPersonadata(){
		
		List<Persona> per = daopersona.listadoPersonas();
		for(Persona pro: per) {
			System.out.println("====>  "+pro);
		}
	}	
	public String guardar() {
		
		System.out.println(persona);
		daopersona.insert(persona);
		return null;
	}
	
	/*public void buscarPersona() {
		System.out.println("llego aqui "+persona.getCedula());

		//buscarpersona.add(daopersona.read(persona.getCedula()));
		personabuscada=daopersona.read(persona.getCedula());
		System.out.println(personabuscada);
	}*/
	
	public void buscarPersona() {
		System.out.println("llego aqui");
		List<Persona> per = daopersona.listadoPersonas();
		for(Persona pro: per) {
			System.out.println("====>  "+pro);
		}
		
        /*if(opcionseleccionada.equals("Cedula")) {
        	System.out.println("Opción seleccionada: " + opcionseleccionada);
        	personabuscada=daopersona.read(valoringresado);
        	System.out.println("valor buscado por cedula "+personabuscada);
        }else {
        	System.out.println("Opción seleccionada: " + opcionseleccionada);
        	//System.out.println("Valor ingresado: " + valoringresado);
        	personabuscada=daopersona.buscarPersPass(valoringresado);
        	
        	System.out.println("valor buscado por pass "+personabuscada);
        }*/
	}
}
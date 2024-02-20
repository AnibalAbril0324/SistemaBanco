package ups.edu.ec.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.Datos.PersonaDAO;
import ups.edu.ec.Model.Persona;

@ManagedBean
public class PersonaController {
	
	private Persona persona;
	
	@Inject
	private PersonaDAO daopersona;
	
	@PostConstruct
	public void init() {
		persona= new Persona();
	}
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String guardar() {
		
		System.out.println(persona);
		daopersona.insert(persona);
		return null;
	}
}
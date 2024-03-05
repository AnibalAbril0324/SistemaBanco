package ups.edu.ec.Negocio;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ups.edu.ec.Controller.LeerDataSet;
import ups.edu.ec.Datos.PersonaDAO;
import ups.edu.ec.Model.Persona;


@Startup
@Singleton
public class DatosDemo {

	@Inject
	private PersonaDAO daopersona;
	
	public List<Persona>listarper;
	
	@PostConstruct
	public void init()  {
		
		System.out.println("hola ups");
	
		
		LeerDataSet data= new LeerDataSet();
		
		try {
			
			String[] personaDataSet = data.leerPersonaDataSet();
			 int cont=0;
			for (String elemento : personaDataSet) {
				String [] elementofinal=elemento.split(";");
				/*System.out.println(cont+" | "+elementofinal[0]+" | "+elementofinal[1]+" | "+
				                         elementofinal[2]+" | "+elementofinal[3]+" | "+
				                         elementofinal[4]+" | "+elementofinal[5]+" | "+
				                         elementofinal[6]+" | "+elementofinal[7]+" | ");*/
				cont++;
			
				Persona persona= new Persona();
					persona.setCodigo(cont);
					persona.setCedula(elementofinal[0]);
					persona.setApellidos(elementofinal[1]);
					persona.setNombres(elementofinal[2]);
					persona.setEmail(elementofinal[3]);
					persona.setMovil(elementofinal[4]);
					persona.setEdad(Integer.parseInt(elementofinal[5]));
					persona.setNacionalidad(elementofinal[6]);
					persona.setPasaporte(elementofinal[7]);
					daopersona.insert(persona);
			}
			
			//listado();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		/*List<Persona>personas=daopersona.getAll();
		for(Persona pers:personas) {
			System.out.println(pers);
		}*/
		
	}
	
	public void listado() {
		 listarper = daopersona.listadoPersonas();
		for(Persona pro: listarper) {
			System.out.println("====>  "+pro);
		}
	}
	
	
}
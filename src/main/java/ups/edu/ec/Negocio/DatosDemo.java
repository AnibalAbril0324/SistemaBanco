package ups.edu.ec.Negocio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ups.edu.ec.Datos.PersonaDAO;
import ups.edu.ec.Model.Persona;


@Startup
@Singleton
public class DatosDemo {

	@Inject
	private PersonaDAO daopersona;
	
	
	
	//@PostConstruct
	public void init()  {
		
		System.out.println("hola ups");
		
		Persona c= new Persona ();
		//c.setCodigo(1);
		c.setCedula("0105541510");
		c.setNombres("anibal abril");
		c.setDireccion("cuenca");
		c.setTelefono("1234567890");
		daopersona.insert(c);
		//daocliente.read("0105541510");
		
		Persona c1= new Persona ();
		//c.setCodigo(1);
		c1.setCedula("0123456789");
		c1.setNombres("Freddy Mercury");
		c1.setDireccion("baños"); 
		c1.setTelefono("1234567890");
		daopersona.insert(c1);
		
		Persona c2= new Persona ();
		//c.setCodigo(1);
		c2.setCedula("9876543210");
		c2.setNombres("bob");
		c2.setDireccion("azuay"); 
		c2.setTelefono("1234567890");
		daopersona.insert(c2);
		
		Persona c3= new Persona ();
		//c.setCodigo(1);
		c3.setCedula("9876543211");
		c3.setNombres("Silvia Loja");
		c3.setDireccion("San Roque"); 
		c3.setTelefono("1234567890");
		daopersona.insert(c3);

		
		List<Persona>personas=daopersona.getAll();
		for(Persona pers:personas) {
			System.out.println(pers);
		}
		
	}
}
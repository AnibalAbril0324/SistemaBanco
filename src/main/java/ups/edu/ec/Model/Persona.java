package ups.edu.ec.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "Persona")
public class Persona {
	
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private int codigo;
	
	@Id
	@Column(name = "CEDULA")
	private String cedula;
	
	@Column(name = "APELLIDOS")
	private String apellidos;

	@Column(name = "NOMBRES")
	private String nombres;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "MOVIL")
	private String movil;
	
	@Column(name = "EDAD")
	private int edad;
	
	@Column(name = "NACIONALIDAD")
	private String nacionalidad;
	
	@Column(name = "PASAPORTE")
	private String pasaporte;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", cedula=" + cedula + ", apellidos=" + apellidos + ", nombres=" + nombres
				+ ", email=" + email + ", movil=" + movil + ", edad=" + edad + ", nacionalidad=" + nacionalidad
				+ ", pasaporte=" + pasaporte + "]";
	}
	
}
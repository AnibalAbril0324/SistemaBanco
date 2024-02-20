package ups.edu.ec.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "Persona")
public class Persona {
	
	@Id
	@Column(name = "pers_cedula")
	private String cedula;
	
	@Column(name = "pers_nombres")
	private String nombres;

	@Column(name = "pers_telefono")
	private String telefono;
	
	@Column(name = "pers_direccion")
	private String direccion;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombres=" + nombres + ", telefono=" + telefono + ", direccion="
				+ direccion + "]";
	}		
}
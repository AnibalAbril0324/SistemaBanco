package ups.edu.ec.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DataSet {
	
	
	@Id
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "PLAZOMESES")
	private String plazomeses;
	
	@Column(name = "HISTORIALCREDITO")
	private String historialcredito;
	
	@Column(name = "PROPOSITOCREDITO")
	private String propositocredito;
	
	@Column(name = "MONTOCREDITO")
	private String montocredito;
	
	@Column(name = "SALDOCUENTAAHORROS")
	private String saldocuentaahorros;
	
	@Column(name = "TIEMPOEMPLEO")
	private String tiempoempleo;
	
	@Column(name = "TASAPAGO")
	private String tasapago;
	
	@Column(name = "ESTADOCIVILYSEXO")
	private String estadocivil;
	
	@Column(name = "GARANTE")
	private String garante;
	
	@Column(name = "AVALUOVIVIENDA")
	private String avaluovivienda;
	
	@Column(name = "ACTIVOS")
	private String activos;
	
	@Column(name = "EDAD")
	private String edad;
	
	@Column(name = "VIVIENDA")
	private String vivienda;
	
	@Column(name = "CANTIDADCREDITOSEXISTENTES")
	private String cantidadcreditosexistentes;
	
	@Column(name = "EMPLEO")
	private String empleo;
	
	@Column(name = "TRABAJADOREXTRANJERO")
	private String trabajorextrangero;
	
	@Column(name = "TIPOCLIENTE")
	private String tipocliente;
	
	//@OneToOne
	//@OneToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "cedula_persona")
	private Persona persona;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlazomeses() {
		return plazomeses;
	}

	public void setPlazomeses(String plazomeses) {
		this.plazomeses = plazomeses;
	}

	public String getHistorialcredito() {
		return historialcredito;
	}

	public void setHistorialcredito(String historialcredito) {
		this.historialcredito = historialcredito;
	}

	public String getPropositocredito() {
		return propositocredito;
	}

	public void setPropositocredito(String propositocredito) {
		this.propositocredito = propositocredito;
	}

	public String getMontocredito() {
		return montocredito;
	}

	public void setMontocredito(String montocredito) {
		this.montocredito = montocredito;
	}

	public String getSaldocuentaahorros() {
		return saldocuentaahorros;
	}

	public void setSaldocuentaahorros(String saldocuentaahorros) {
		this.saldocuentaahorros = saldocuentaahorros;
	}

	public String getTiempoempleo() {
		return tiempoempleo;
	}

	public void setTiempoempleo(String tiempoempleo) {
		this.tiempoempleo = tiempoempleo;
	}

	public String getTasapago() {
		return tasapago;
	}

	public void setTasapago(String tasapago) {
		this.tasapago = tasapago;
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getGarante() {
		return garante;
	}

	public void setGarante(String garante) {
		this.garante = garante;
	}

	public String getAvaluovivienda() {
		return avaluovivienda;
	}

	public void setAvaluovivienda(String avaluovivienda) {
		this.avaluovivienda = avaluovivienda;
	}

	public String getActivos() {
		return activos;
	}

	public void setActivos(String activos) {
		this.activos = activos;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getVivienda() {
		return vivienda;
	}

	public void setVivienda(String vivienda) {
		this.vivienda = vivienda;
	}

	public String getCantidadcreditosexistentes() {
		return cantidadcreditosexistentes;
	}

	public void setCantidadcreditosexistentes(String cantidadcreditosexistentes) {
		this.cantidadcreditosexistentes = cantidadcreditosexistentes;
	}

	public String getEmpleo() {
		return empleo;
	}

	public void setEmpleo(String empleo) {
		this.empleo = empleo;
	}

	public String getTrabajorextrangero() {
		return trabajorextrangero;
	}

	public void setTrabajorextrangero(String trabajorextrangero) {
		this.trabajorextrangero = trabajorextrangero;
	}

	public String getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "DataSet [codigo=" + codigo + ", plazomeses=" + plazomeses + ", historialcredito=" + historialcredito
				+ ", propositocredito=" + propositocredito + ", montocredito=" + montocredito + ", saldocuentaahorros="
				+ saldocuentaahorros + ", tiempoempleo=" + tiempoempleo + ", tasapago=" + tasapago + ", estadocivil="
				+ estadocivil + ", garante=" + garante + ", avaluovivienda=" + avaluovivienda + ", activos=" + activos
				+ ", edad=" + edad + ", vivienda=" + vivienda + ", cantidadcreditosexistentes="
				+ cantidadcreditosexistentes + ", empleo=" + empleo + ", trabajorextrangero=" + trabajorextrangero
				+ ", tipocliente=" + tipocliente + ", persona=" + persona + "]";
	}
	
}
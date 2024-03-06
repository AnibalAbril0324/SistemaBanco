package ups.edu.ec.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.ec.Datos.DataSetDAO;
import ups.edu.ec.Datos.PersonaDAO;
import ups.edu.ec.Model.DataSet;
import ups.edu.ec.Model.Persona;
import ups.edu.ec.Negocio.DatosDemo;

@WebServlet("/upload")
@MultipartConfig

public class LeerDataSet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private DataSetDAO daodataset;
	@Inject
	private PersonaDAO daopersona;
	
	public List<Persona>listarper;
	
	
	public LeerDataSet() {
		//cedulapersona= new Persona();
		//listarper= new ArrayList<>();
	}
	/*
	public Persona listarPersonas() {
		listarper = daopersona.listadoPersonas();
		if(listarper !=null )
		for (Persona per : listarper) {
			
		    cedulapersona=per;
		    System.out.println("======== "+cedulapersona);
		    return cedulapersona;
		}
		return null;
	}*/
	
	public List<Persona> listarPersonas() {
	    List<Persona> listaPersonas = daopersona.listadoPersonas();
	    if (listaPersonas != null && !listaPersonas.isEmpty()) {
	        return listaPersonas;
	    } else {
	        return new ArrayList<>(); // Devuelve una lista vacía si no hay datos
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		 List<String> rowData = new ArrayList<>();
		 
				try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))){
					String line;
					int cont=0;
					
					
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					
	                while ((line = br.readLine()) != null && cont<1000) {
	                	rowData.add(line);
	                }
	                String[] resultado = new String[rowData.size() - 1];
	               
	                for (int i = 0; i < rowData.size()-2; i++) {
	                    String []elemento = rowData.get(i).split(",");
	                    resultado=elemento[0].split(";");
	                   // System.out.println(i+" | "+resultado[0]+" | ");
	                    
	                    DataSet dataset= new DataSet();
	                    	dataset.setCodigo(cont);
	                    	dataset.setPlazomesescredito(resultado[0]);
	                    	dataset.setHistorialcredito(resultado[1]);
	                    	dataset.setPropositocredito(resultado[2]);
	                    	dataset.setMontocredito(resultado[3]);
	                    	dataset.setSaldocuentaahorros(resultado[4]);
	                    	dataset.setTiempoempleo(resultado[5]);
	                    	dataset.setTasapago(resultado[6]);
	                    	dataset.setEstadocivil(resultado[7]);
	                    	dataset.setGarante(resultado[8]);
	                    	dataset.setAvaluovivienda(resultado[9]);
	                    	dataset.setActivos(resultado[10]);
	                    	dataset.setEdad(resultado[11]);
	                    	dataset.setVivienda(resultado[12]);
	                    	dataset.setCantidadcreditosexistentes(resultado[13]);
	                    	dataset.setEmpleo(resultado[14]);
	                    	dataset.setTrabajorextrangero(resultado[15]);
	                    	dataset.setTipocliente(resultado[16]);
	                    	
	                    	List<Persona> personas = listarPersonas();
	                       
	                        //System.out.println("====  "+personas.get(i));
	                        dataset.setPersona(personas.get(i));
	                    	
	                    	daodataset.insert(dataset);
	                    	cont++;
	                    	
	                }
	                //response.sendRedirect("resources/buscarpersona.xhtml");
	                response.sendRedirect("resources/buscardataset.xhtml");
	              
	                //listarPersonas();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
	}
	
		
	public String [] leerPersonaDataSet() throws IOException {
		
		System.out.println("============================================================");   
        System.out.println("=======================IMPRIMIR============================="); 
        System.out.println("=======================PERSONA============================="); 
        
		String ExcelFile = "C:/Apps/persona.csv";
		
		 List<String> rowData = new ArrayList<>();
		 	
			try (BufferedReader br = new BufferedReader(new FileReader(ExcelFile))) {
				String linea;
	            while ((linea = br.readLine()) != null) {
	            	rowData.add(linea);
	            }  
	            String[] resultado = new String[rowData.size() - 1];
	            
	            for (int i = 1; i < rowData.size(); i++) {
                    String []elemento = rowData.get(i).split(",");
                    resultado[i - 1] = elemento[0];
                    
                }
	            return resultado;
			}
	}
}

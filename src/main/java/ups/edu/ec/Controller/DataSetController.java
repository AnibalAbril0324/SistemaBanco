package ups.edu.ec.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@WebServlet("/upload")
@MultipartConfig
public class DataSetController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// JDBC URL, usuario y contraseña de la base de datos PostgreSQL
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/DBExamen";
    static final String USER = "ExamenUsuario";
    static final String PASSWORD = "admin";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBExamen", "ExamenUsuario", "admin")){
			Class.forName("org.postgresql.Driver");
			
				CrearTableDataSet();
				CrearTablaPersona();
				leerPersonaDataSet();
				
				try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))){
					String line;
					int cont=0;
					String [] resulcadafila=null;
					
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
	                while ((line = br.readLine()) != null && cont<1000) {
	                    // Procesar cada línea aquí
	                	 
	                	 
	                	resulcadafila = line.split(";");
	                	cont++;
	                	/*System.out.println(cont+" =====>  "+resulcadafila[0]+" | "+resulcadafila[1]+" | "+
								   resulcadafila[2]+" | "+resulcadafila[3]+" | "+resulcadafila[3]+
								   " | "+resulcadafila[4]+" | "+resulcadafila[5]+" | "+resulcadafila[6]+
							       " | "+resulcadafila[7]+" | "+resulcadafila[8]+" | "+resulcadafila[9]+
							       " | "+resulcadafila[10]+" | "+resulcadafila[11]+" | "+resulcadafila[12]+
							       " | "+resulcadafila[13]+" | "+resulcadafila[14]+" | "+resulcadafila[15]+
				                   " | "+resulcadafila[16]); // Imprimir en la consola*/
	                	
	                	String query = "INSERT INTO Dataset (CODIGO,PLAZOMESES, HISTORIALCREDITO, PROPOSITOCREDITO,"
								+ "MONTOCREDITO,SALDOCUENTAAHORROS,TIEMPOEMPLEO,TASAPAGO,ESTADOCIVILYSEXO,"
								+ "GARANTE,AVALUOVIVIENDA,ACTIVOS,EDAD,VIVIENDA,CANTIDADCREDITOSEXISTENTES,"
								+ "EMPLEO,TRABAJADOREXTRANJERO,TIPOCLIENTE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	                    
	                	try (PreparedStatement pstmt = conn.prepareStatement(query)) {
							pstmt.setInt(1, cont);
							pstmt.setString(2, resulcadafila[0]);
	                        pstmt.setString(3, resulcadafila[1]);
	                        pstmt.setString(4, resulcadafila[2]);
	                        pstmt.setString(5, resulcadafila[3]);
	                        pstmt.setString(6, resulcadafila[4]);
	                        pstmt.setString(7, resulcadafila[5]);
	                        pstmt.setString(8, resulcadafila[6]);
	                        pstmt.setString(9, resulcadafila[7]);
	                        pstmt.setString(10, resulcadafila[8]);
	                        pstmt.setString(11, resulcadafila[9]);
	                        pstmt.setString(12, resulcadafila[10]);
	                        pstmt.setString(13, resulcadafila[11]);
	                        pstmt.setString(14, resulcadafila[12]);
	                        pstmt.setString(15, resulcadafila[13]);
	                        pstmt.setString(16, resulcadafila[14]);
	                        pstmt.setString(17, resulcadafila[15]);
	                        pstmt.setString(18, resulcadafila[16]);
	                        
	                        
	                        pstmt.executeUpdate();
	                    }
	                }
	              
                    
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	
	public void CrearTableDataSet() {
		
		// Sentencia SQL para crear la tabla
		String createTableSQL = "CREATE TABLE DataSet (" +
				"CODIGO INT PRIMARY KEY,"+
                "PLAZOMESES VARCHAR(50) ," +
                "HISTORIALCREDITO VARCHAR(50)," +
                "PROPOSITOCREDITO VARCHAR(50)," +
                "MONTOCREDITO VARCHAR(50)," +
                "SALDOCUENTAAHORROS VARCHAR(50)," +
                "TIEMPOEMPLEO VARCHAR(50)," +
                "TASAPAGO VARCHAR(50)," +
                "ESTADOCIVILYSEXO VARCHAR(50)," +
                "GARANTE VARCHAR(50)," +
                "AVALUOVIVIENDA VARCHAR(50)," +
                "ACTIVOS VARCHAR(50)," +
                "EDAD VARCHAR(50)," +
                "VIVIENDA VARCHAR(50)," +
                "CANTIDADCREDITOSEXISTENTES VARCHAR(50)," +
                "EMPLEO VARCHAR(50)," +
                "TRABAJADOREXTRANJERO VARCHAR(50)," +
                "TIPOCLIENTE VARCHAR(50))" ;                

        try (
            // Establecer conexión a la base de datos
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            // Crear objeto Statement
            Statement statement = connection.createStatement()) {

            // Ejecutar la instrucción SQL para crear la tabla
        	
            statement.execute(createTableSQL);
            System.out.println("Tabla DataSet creada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void leerPersonaDataSet() {
		
		System.out.println("============================================================");   
        System.out.println("=======================IMPRIMIR============================="); 
        System.out.println("=======================PERSONA============================="); 
        
		String ExcelFile = "C:/Apps/persona.csv";
		
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBExamen", "ExamenUsuario", "admin")){
			
			Class.forName("org.postgresql.Driver");
			
	      
			try (BufferedReader br = new BufferedReader(new FileReader(ExcelFile))) {
			       
           String line;
           
           int cont=0;     
       		line = br.readLine();
           while ((line = br.readLine()) != null && cont<=1000) {
               String[] rowData = line.split(",");
               //cont++;
               //System.out.println(cont+" | "+line+" | ");
               
               for ( int i= 0; i < rowData.length; i++) {
					
					String[] resulcadafila = rowData[0].split(";");
					System.out.println(cont+" =====>  "+resulcadafila[0]+" | "+resulcadafila[1]+" | "+
									   resulcadafila[2]+" | "+resulcadafila[3]+" | "+resulcadafila[4]+
									   " | "+resulcadafila[5]+" | "+resulcadafila[6]+" | "+resulcadafila[7]);
               cont++;
               
               String query = "INSERT INTO PersonaDataSet (CODIGO,CEDULA,APELLIDOS,"
            		   							+"NOMBRES,EMAIL,MOVIL,EDAD,"
            		   							+"NACIONALIDAD,PASAPORTE)"
            		   							+"VALUES (?,?,?,?,?,?,?,?,?)";
               
               try (PreparedStatement pstmt = conn.prepareStatement(query)) {
					pstmt.setInt(1, cont);
					pstmt.setString(2, resulcadafila[0]);
					pstmt.setString(3, resulcadafila[1]);
					pstmt.setString(4, resulcadafila[2]);
					pstmt.setString(5, resulcadafila[3]);
					pstmt.setString(6, resulcadafila[4]);
					pstmt.setInt(7, Integer.parseInt(resulcadafila[5]));
					//pstmt.setString(7, resulcadafila[5]);
					pstmt.setString(8, resulcadafila[6]);
					pstmt.setString(9, resulcadafila[7]);
					
                   pstmt.executeUpdate();
               }
               }
			}
                         
           }
			    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void CrearTablaPersona() {
		// Sentencia SQL para crear la tabla
		String createTableSQL = "CREATE TABLE PersonaDataSet (" +
								"CODIGO INT PRIMARY KEY,"+
								"CEDULA VARCHAR(10),"+
								"APELLIDOS VARCHAR(50),"+
								"NOMBRES VARCHAR(50),"+
								"EMAIL VARCHAR(50),"+
								"MOVIL VARCHAR(50),"+
								"EDAD INT,"+
								"NACIONALIDAD VARCHAR(30),"+
								"PASAPORTE VARCHAR(12))";               
	
	    try (
	        // Establecer conexión a la base de datos
	        Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
	        // Crear objeto Statement
	        Statement statement = connection.createStatement()) {
	
	        // Ejecutar la instrucción SQL para crear la tabla
	    	
	        statement.execute(createTableSQL);
	        System.out.println("Tabla PersonaDataSet creada correctamente.");
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
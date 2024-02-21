package ups.edu.ec.Negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.Column;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;


@Startup
@Singleton
public class LeerExcel {
	
	
	// JDBC URL, usuario y contraseña de la base de datos PostgreSQL
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/DBExamen";
    static final String USER = "ExamenUsuario";
    static final String PASSWORD = "admin";
    
    
	String[] columns;
	
	@PostConstruct
	public void init() throws CsvValidationException, SQLException, ClassNotFoundException{
		String csvFile = "C:/Apps/DatasetBanco.csv";
		
		System.out.println("==================LEE SOLO UNA PRIMERA LINEA================");   
		System.out.println("============================================================");   
		System.out.println("============================================================");   
		System.out.println("============================================================");   
		
		String linea = "";
        String columnSeparator = ";";
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            if ((linea = reader.readLine()) != null) {
                 columns = linea.split(columnSeparator);
                for (String column : columns) {
                   // System.out.println(columns.length+"   " +column);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("============================================================");   
        System.out.println("=======================IMPRIMIR============================="); 
        
        
        //imprimir();
        
        System.out.println("============================================================");   
        System.out.println("================BASE DE DATOS==============================="); 
        
        
        Guardar();
        
     System.out.println("============================================================");   
     System.out.println("============================================================");   
     System.out.println("============================================================");   
     System.out.println("============================================================");   
     
     System.out.println("===========================LEER TODO EL ARCHIVO==============================");   
     try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/DBExamen", "ExamenUsuario", "admin")) {
         Class.forName("org.postgresql.Driver");
         
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
       
                 String line;
            
            int cont=0;     
            while ((line = br.readLine()) != null && cont<=1000) {
                String[] rowData = line.split(",");
                
                //System.out.println(rowData.length+"   "+rowData[0].toString());
                
                for ( int i= 0; i < rowData.length; i++) {
					
					String[] resulcadafila = rowData[0].split(";");
					System.out.println(cont+" =====>  "+resulcadafila[0]+" | "+resulcadafila[1]+" | "+
									   resulcadafila[2]+" | "+resulcadafila[3]+" | "+resulcadafila[3]+
									   " | "+resulcadafila[4]+" | "+resulcadafila[5]+" | "+resulcadafila[6]+
								       " | "+resulcadafila[7]+" | "+resulcadafila[8]+" | "+resulcadafila[9]+
								       " | "+resulcadafila[10]+" | "+resulcadafila[11]+" | "+resulcadafila[12]+
								       " | "+resulcadafila[13]+" | "+resulcadafila[14]+" | "+resulcadafila[15]+
					                   " | "+resulcadafila[16]);
					
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
					cont++;
				}
                          
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     } 
    
	}
	public void imprimir(){
		System.out.println("tama;o de la primera columna "+columns.length);
		
		for (String column : columns) {
			//if(column.equals("TRABAJADOREXTRANJERO"))
				System.out.println("nombre "+column.toString()+"  "+column.length());
		}
	}
	
	public void Guardar() {
		
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
            System.out.println("Tabla creada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
	    
	    
	}
}

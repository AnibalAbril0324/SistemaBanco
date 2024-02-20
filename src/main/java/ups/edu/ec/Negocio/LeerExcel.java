package ups.edu.ec.Negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	String[] columns;
	
	@PostConstruct
	public void init() throws CsvValidationException{
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
                    System.out.println(columns.length+"   " +column);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        imprimir();
     System.out.println("============================================================");   
     System.out.println("============================================================");   
     System.out.println("============================================================");   
     System.out.println("============================================================");   
     
     System.out.println("===========================LEER TODO EL ARCHIVO==============================");   
		
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
       
                 String line;
            
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(",");
                
                for (String cell : rowData) {
                    System.out.print(cell.length()+ "  " +cell + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
	
	public void imprimir(){
		System.out.println("tama;o de la primera comlumna "+columns.length);
		
		for (String column : columns) {
			//if(column.equals("TRABAJADOREXTRANJERO"))
				System.out.println("nombre "+column.toString());
		}
	}
	
	
}

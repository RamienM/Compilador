package compilador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La siguiente clase se encarga de generar el código de tres direcciones, generará 
 * un archivo llamado "CodigoDirecciones.txt"
 * @author Usuario
 */
public class CodigoDirecciones {
    private int t; //Nos permitirá ir llevando la cuenta de variables temporales a usar
    private int e;
    BufferedWriter escritura;
    
    public CodigoDirecciones(){
        try{
            escritura = new BufferedWriter(new FileWriter("CodigoDirecciones.txt"));
        }catch(IOException e){
            System.out.println("Se ha producido un error al crear el archivo CodigoDirecciones.txt");
        }
        this.t= 0;
        this.e = 0;
    }
    
    public void putLine(String line){
        try{
            escritura.write(line);
        }catch(IOException e){
            System.out.println("Error al escribir en el fichero: " +line + " Error: " + e);
        }
        this.t++;
    }
    
    public void putEtiqueta(String line){
        try{
            escritura.write(line);
        }catch(IOException e){
            System.out.println("Error al escribir en el fichero: " +line + " Error: " + e);
        }
        this.e++;
    }
    
    public void close(){
        try{
            escritura.close();
        }catch(IOException e){
            System.out.println("Error al cerrar en el fichero. Error: " + e);
        }
    }
            
            
    
}

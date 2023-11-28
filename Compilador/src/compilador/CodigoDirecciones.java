package compilador;

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
    
    public CodigoDirecciones(){
        this.t= 0;
        this.e = 0;
    }
    
    public void putLine(String line){
        //Escribir linea
        this.t++;
    }
    
    public void putEtiqueta(String line){
        //Escribir linea 
        this.e++;
    }
    
}

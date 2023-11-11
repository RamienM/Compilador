/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compilador;

import java.io.FileReader;
import java.util.Scanner;
import JFlex.Lector;
import CUP.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;


/**
 *
 * @author Ruben
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Introduzca la ruta del fichero: ");
        Scanner scan = new Scanner(System.in);
        String ruta = scan.nextLine();
        try{
            FileReader in = new FileReader(ruta);
            Lector scanner = new Lector(in);
            SymbolFactory sf = new ComplexSymbolFactory();
            Parser parser = new Parser(scanner, sf);
            parser.parse();
            parser.printVars(System.out);
        }catch(FileNotFoundException e){
            System.out.println("El fichero introducido " + ruta + " no existe");
        }catch(IOException e){
            System.out.println("Error al procesar el fichero de entrada");
        }catch(Exception e){
            System.err.println("Error: "+e);
            e.printStackTrace(System.err);
        }
        
    }
    
}

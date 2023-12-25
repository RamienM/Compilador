/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compilador;

import java.io.FileReader;
import JFlex.Lector;
import CUP.Parser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.SymbolFactory;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Ruben
 */
public class Compilador {

    private static final String gLexico = "Resultados/Front_Tokens.txt";
    private static final String gSimbolos = "Resultados/Front_Simbolos.txt";
    private static final String gErrores = "Resultados/Errores.txt";
    private static final String gVariables = "Resultados/Back_Variables.txt";
    private static final String gIntermedio = "Resultados/Back-CodigoTresDirecciones.txt";
    private static final String gEnsamblador = "Resultados/Back-Ensamblador.txt";
    private static final String gEnsambladorO = "Resultados/Back-Ensamblador_Optimizado.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser fichero = new JFileChooser("./Pruebas");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fichero.setFileFilter(filtro);
        int resultado = fichero.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtiene el archivo seleccionado
            try {
                FileReader in = new FileReader(fichero.getSelectedFile());
                Lector scanner = new Lector(in);
                SymbolFactory sf = new ComplexSymbolFactory();
                Parser parser = new Parser(scanner, sf);
                parser.parse();
                in.close();
                //if (parser.getErroresEncontrados() == 0){
                    //Escritura del Léxico
                    scanner.printVars(new PrintStream(new FileOutputStream(new File(gLexico))));
                    //Escritura de los Simbolos
                    parser.printVarsSimbolos(new PrintStream(new FileOutputStream(new File(gSimbolos))));
                    //Escrituras Variables BACK
                    parser.printVarsVariables(new PrintStream(new FileOutputStream(new File(gVariables))));
                    //Escritura Codigo tres direcciones
                    parser.printVarsCodigo(new PrintStream(new FileOutputStream(new File(gIntermedio))));
                    //generar codigo sin optimizar EASY
                    //Optimizar código 3 direcciones
                    //generar codigo EASY optimizado
                //}
            } catch (FileNotFoundException e) {
                System.out.println("El fichero introducido no existe");
            } catch (IOException e) {
                System.out.println("Error al procesar el fichero de entrada");
            } catch (Exception e) {
                System.err.println("Error: " + e);
                e.printStackTrace(System.err);
            }
        } else {
            System.out.println("Operación cancelada por el usuario");
        }

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablaSimbolos;

import CUP.ParserSym;
import java.io.PrintStream;
import java.util.ArrayList;
/**
 *
 * @author Usuario
 */
public class TablaDeSimbolos {
    private int nivel;
    private ArrayList<TablaDeVariables> ta;
    
    public TablaDeSimbolos(){
        ta = new ArrayList();
        //Inicializamos la sección donde estarán las funciones, main y procedimientos
        ta.add(new TablaDeVariables());
        nivel=1;
        ta.add(new TablaDeVariables());
    }
    public void nuevoBloque(int tipoBloque,String nombre, int tipoReturn){
        switch(tipoBloque){
            case 1 ->{
                TablaDeVariables aux = ta.get(0);
                if(aux.estaVariable("main")); //error
                aux.addProcedure("main");
                ta.get(nivel).setTitulo("MAIN");
            }
            case 2->{
                TablaDeVariables aux = ta.get(0);
                if(aux.estaVariable(nombre)); //error
                switch (tipoReturn) {
                    case ParserSym.INT -> {} //error
                    case ParserSym.BOOL -> {} //error
                    default -> aux.addProcedure(nombre);
                }
                aux.setTitulo("PROCEDURE");
            }
            case 3->{
                TablaDeVariables aux = ta.get(0);
                if(aux.estaVariable(nombre)); //error
                switch (tipoReturn) {
                    case ParserSym.INT -> aux.addFunction(nombre, 0);
                    case ParserSym.BOOL -> aux.addFunction(nombre, 1);
                    default ->{} //error
                }
                aux.setTitulo("FUNCION");
            }
        }
        nivel++;
        ta.add(new TablaDeVariables());
    }
    
    //------------Funciones de agregación en la tabla de variables--------------
    /**
     * Función que añade a la tabla de variables un tipo
     * @param identificador 
     * @param tipo 
     */
    public void addVariable(String identificador, Integer tipo){
        TablaDeVariables auxT = ta.get(nivel);
        auxT.addVariable(identificador, tipo);
    }
    
    //--------------Funciones de Consulta en la tabla de variables--------------
    /**
     * Función que nos permitira saber tipo de dato tiene una variable.
     * @param indentificador 
     * @return Devuelve True si es un tipo de dato entero, False en caso contrario
     */
    public boolean consultaEntero(String indentificador){
        TablaDeVariables auxT = ta.get(nivel);
        if(!auxT.estaVariable(indentificador)) return false;
        return auxT.esInteger(indentificador);
    }
    /**
     * Función que nos permitirá saber que tipo de dato tiene una variable
     * @param indentificador
     * @return Devuelve False si es un tipo de dato booleano, False en caso contrario
     */
    public boolean consultaBoolean(String indentificador){
        TablaDeVariables auxT = ta.get(nivel);
        if(!auxT.estaVariable(indentificador)) return false;
        return auxT.esInteger(indentificador);
    }
    
    public void printVars(PrintStream out) {
        if (ta.isEmpty()) {
            out.println("No hi ha variables declarades");
        } else {
            for(int i =1;i<ta.size();i++){
                TablaDeVariables auxT = ta.get(i);
                auxT.printVars(out,i);
            }
        }
    }
    
    //-------------------Funciones obtencion valores----------------------------
    public TipoDato getValor(String id){
        TablaDeVariables auxT = ta.get(nivel);
        return auxT.getValorEntero(id);
    }
    public int getNivel(){
        return nivel;
    }

}

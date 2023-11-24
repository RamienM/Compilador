/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CUP;

import java.io.PrintStream;
import java.util.HashMap;
import jflex.base.Pair;

/**
 *
 * @author Usuario
 */
public class TablaDeSimbolos {
    /*
        La siguiente tabla esta compuesta por una tupla que contiene:
            -Primer Integer: Tipo de dato -> 
                0 = int, 
                1 = boolean
            -Segundo Integer: Valor
                Para booleanos:
                    0 para false
                    1 para true
                Para enteros:
                    Los números enteros
    */
    private HashMap<String, Pair<Integer,Integer>>tsymbols = new HashMap<>();
    
    /**
     * Las siguientes funciones se encargan de comprobar de si la petición de
     * obtener el valor del identificador id es correcta
     * 
     * @param id Identificador que queremos obtener el valor
     * @return Devuelve un valor si la operación de obtención es correcta, 
     *          en caso contrario se devuelve null.
     */
    public int getSymbolValueInteger(String id){     
        return tsymbols.get(id).snd;
    }
    public boolean getSymbolValueBoolean(String id){
        return tsymbols.get(id).snd != 0; 
    }
    
    public boolean estaInteger(String id){
        if(tsymbols.containsKey(id)){
            Integer tipo= tsymbols.get(id).fst;
            if (tipo == 0) return true;
        }       
        return false;
    }
    public boolean estaBoolean(String id){
        if(tsymbols.containsKey(id)){
            Integer tipo= tsymbols.get(id).fst;
            if (tipo == 1) return true;
        }       
        return false;
    }

    public void addSymbol(String id, int value){
        if(tsymbols.containsKey(id)){
            tsymbols.replace(id,new Pair<>(0,value));
        }else{
            tsymbols.put(id,new Pair<>(0,value));
        }
    }
    public void addSymbol(String id, boolean value){
        int valor = 0;
        if (value) valor = 1;
        if(tsymbols.containsKey(id)){
            tsymbols.replace(id,new Pair<>(1,valor));
        }else{
            tsymbols.put(id, new Pair<>(1,valor));
        }
    }
    
    public void printVars(PrintStream out) {
        if (tsymbols.isEmpty()) {
            out.println("No hi ha variables declarades");
        } else {
            tsymbols.forEach((k,v) -> {
                String fmt ;
                if (v.fst == 0){
                    fmt = "%-8s: %d";
                }else{
                    fmt = "%-8s: %b";
                }
                out.println(String.format(fmt,k,v.snd));
            });
        }
    }
}

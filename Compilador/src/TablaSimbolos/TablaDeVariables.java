/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablaSimbolos;

import java.io.PrintStream;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class TablaDeVariables {
    /*
        La siguiente tabla esta compuesta por una tupla que contiene:
            -Primer Integer: Tipo de dato -> 
                0 = int, 
                1 = boolean,
                2 = null
            -Segundo Integer: Valor
                Para booleanos:
                    0 para false
                    1 para true
                Para enteros:
                    Los números enteros
    */
    private HashMap<String, TipoDato>tvariables;
    private String titulo;
    
    public TablaDeVariables(){
        tvariables = new HashMap<>();
        this.titulo = ""; 
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public boolean esInteger(String id){
        TipoDato tipo= tvariables.get(id);
        return tipo.esEntero();
    }
    public boolean esBoolean(String id){
        TipoDato tipo= tvariables.get(id);   
        return tipo.esBoolean();
    }
    public boolean esNull(String id){
        TipoDato tipo= tvariables.get(id);   
        return tipo.esNull();
    }
    public boolean estaVariable(String id){ 
        return tvariables.containsKey(id);
    }
    
    public void addVariable(String id, Integer tipo){
        if(tvariables.containsKey(id)){
            tvariables.replace(id,new TipoDato(tipo,id));
        }else{
            tvariables.put(id,new TipoDato(tipo,id));
        }
    }
    
    public void addProcedure(String id){
        tvariables.put(id,new TipoDato(2,null,true));
    }
    
    public void addFunction(String id, int tipo){
        tvariables.put(id,new TipoDato(tipo,null,true));
    }
    
    public TipoDato getValor(String id){
        return tvariables.get(id);
    }
    
    public void printVars(PrintStream out, int nivel) {
        if (!tvariables.isEmpty()) {
            String aux= "%-8s";
            out.println(String.format(aux,titulo));
            tvariables.forEach((k,v) -> {
                String fmt= "\t%s: %s,tipo: %s,nivel: "+nivel;
                String var="VARIABLE";
                if(v.esConstante()) var="PARAMETRO";
                if (v.esEntero()){
                    out.println(String.format(fmt,var,k,"INT"));
                }else if(v.esBoolean()){
                    out.println(String.format(fmt,var,k,"BOOL"));
                }else{
                    out.println(String.format(fmt,var,k,"NULL"));
                }
            });
        }
    }
    
    
}

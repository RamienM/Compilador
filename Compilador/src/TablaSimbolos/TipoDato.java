/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TablaSimbolos;

/**
 *
 * @author Usuario
 */
public class TipoDato {
    private Integer tipo;
    private Integer valor;
    private boolean esConstante;
    private String id;
    private boolean esID;
    
    public TipoDato(Integer tipo,Integer valor, boolean esConstante){
        this.tipo = tipo;
        this.valor = valor;
        this.esConstante = esConstante;
        this.id = "";
        this.esID= false;
    }
    public TipoDato(Integer tipo){
        this.tipo = tipo;
        this.valor = null;
        this.esConstante = true;
        this.id = "";
        this.esID= false;
    }
    public TipoDato(Integer tipo, String id){
        this.tipo = tipo;
        this.valor = null;
        this.esConstante = false;
        this.id = id;
        this.esID = true;
    }
    
    public String getID(){
        return this.id;
    }
    public boolean tieneID(){
        return this.esID;
    }
        
    public boolean esEntero(){
        return tipo == 0;
    }
    public boolean esBoolean(){
        return tipo == 1;
    }
    public boolean esNull(){
        return tipo == 2;
    }
    
    public int getValorEntero(){
        return valor;
    }
    public boolean getValorBoolean(){
        return valor==1;
    }
    public boolean esConstante(){
        return esConstante;
    }
}

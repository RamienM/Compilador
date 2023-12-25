/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigoTresDirecciones;

import TablaSimbolos.TipoDato;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Generador {
    private String etiqueta;
    private int contE;
    private String variable;
    private int contV;
    
    private ArrayList<String> tc;
    private TablaVariables3D tv;
    
    public Generador(){
        contE = 0;
        contV = 0;
        this.etiqueta = "e"+contE;
        this.variable = "t"+contV;
        tc = new ArrayList<String>();
        tv = new TablaVariables3D();
    }
    
    public String getEtiqueta(){
        String e= etiqueta;
        contE++;
        this.etiqueta ="e"+contE;
        return e;
    }
    
    public String getVariable(){
        String v= variable;
        contV++;
        this.variable ="t"+contV;
        return v;
    }
    
    public void add(String codigo){
        tc.add(codigo);
    }
    
    public TipoDato generarCodigoOperaciones(String tipo, TipoDato v1, TipoDato v2, boolean aritmetica){
        String destino = getVariable();
        if(v1.tieneID() || v2.tieneID()){
            if(v1.tieneID() && v2.tieneID()){
                tc.add(tipo+", op1="+v1.getID()+", op2="+v2.getID()+",destino="+destino);
            }else if(v1.tieneID()){
                tc.add(tipo+", op1="+v1.getID()+", op2="+v2.getValorEntero()+",destino="+destino);
            }else{
                tc.add(tipo+", op1="+v1.getValorEntero()+", op2="+v2.getID()+",destino="+destino);
            }
        }else{
            tc.add(tipo+", op1="+v1.getValorEntero()+", op2="+v2.getValorEntero()+",destino="+destino);
        }
        TipoDato aux;
        if(aritmetica){
            aux = new TipoDato(0,destino);
            tv.add(aux);
        }else{
            aux = new TipoDato(1,destino);
            tv.add(aux);
        }
        return aux;
    }
    public TipoDato generarCodigoOperacionesNotResta(String tipo, TipoDato v, boolean aritmetica){
        String destino = getVariable();
        if(v.tieneID()){
            tc.add(tipo+", op1="+v.getID()+", op2= ,destino="+destino);
        }else{
            tc.add(tipo+", op1="+v.getValorEntero()+", op2= ,destino="+destino);
        }
        TipoDato aux;
        if(aritmetica){
            aux = new TipoDato(0,destino);
            tv.add(aux);
        }else{
            aux = new TipoDato(1,destino);
            tv.add(aux);
        }
        return aux;
    }
    
    public void generarCodigoAsignación(TipoDato v, String destino, int tipo){
        tc.add("ASIG, op1="+v.getID()+", op2= ,destino="+destino);
        switch(tipo){
            case 0 -> tv.add(new TipoDato(0,destino));
            case 1 -> tv.add(new TipoDato(1,destino));
            default ->tv.add(new TipoDato(2,destino));
        }
    }
    public void generarCodigoIdentificador(String v){
        String destino = getVariable();
        tc.add("ASIG, op1="+v+", op2= ,destino="+destino);
        tv.add(new TipoDato(0,destino));
    }
    
    public void printVarsCodigo(PrintStream out) {
        if (tc.isEmpty()) {
            out.println("No hi ha variables declarades");
        } else {
            String fmt = "%s";
            for(int i =0;i<tc.size();i++){
                out.println(String.format(fmt,tc.get(i)));  
            }
        }
    }
    public void printVarsVariables(PrintStream out) {
        tv.printVars(out);
    } 
}

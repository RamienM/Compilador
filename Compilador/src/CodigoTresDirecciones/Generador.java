/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigoTresDirecciones;

import TablaSimbolos.TipoDato;
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
    
    public void generarCodigoOperaciones(String tipo, TipoDato v1, TipoDato v2, boolean aritmetica){
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
        if(aritmetica){
            tv.add(new TipoDato(0,destino));
        }else{
            tv.add(new TipoDato(1,destino));
        }
    }
    public void generarCodigoOperacionesNotResta(String tipo, TipoDato v, boolean aritmetica){
        String destino = getVariable();
        if(v.tieneID()){
            tc.add(tipo+", op1="+v.getID()+", op2= ,destino="+destino);
        }else{
            tc.add(tipo+", op1="+v.getValorEntero()+", op2= ,destino="+destino);
        }
        if(aritmetica){
            tv.add(new TipoDato(0,destino));
        }else{
            tv.add(new TipoDato(1,destino));
        }
    }
}

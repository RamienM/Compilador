/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodigoTresDirecciones;

import TablaSimbolos.TablaDeSimbolos;
import TablaSimbolos.TipoDato;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class TablaVariables3D extends TablaDeSimbolos{
    private ArrayList<TipoDato> tv;
    
    public TablaVariables3D(){
        tv = new ArrayList<TipoDato>();
    }
    
    public void add(TipoDato str){
        tv.add(str);
    }
    
    @Override
    public void printVars(PrintStream out) {
        if (tv.isEmpty()) {
            out.println("No hi ha variables declarades");
        } else {
            String fmt = "%s, tipo =%s, nivel = %d";
            for(int i =0;i<tv.size();i++){
                TipoDato aux = tv.get(i);
                if(aux.esBoolean()){
                    out.println(String.format(fmt, aux.getID(),"BOOL",getNivel()));
                }else if (aux.esEntero()){
                    out.println(String.format(fmt, aux.getID(),"INT",getNivel()));
                }else{
                    out.println(String.format(fmt, aux.getID(),"NULL",getNivel()));
                }     
            }
        }
    } 
}

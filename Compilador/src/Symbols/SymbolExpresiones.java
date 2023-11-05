/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;

/**
 *
 * @author Usuario
 */
public class SymbolExpresiones extends SymbolBase{
    
    private int operacion;
    
    public SymbolExpresiones(boolean valor){
        super("Expresiones",valor);
    }
    
    public SymbolExpresiones(){
        super();
    }
    
    public SymbolExpresiones(boolean valorExpresionesP, int operacion,
            SymbolExpresiones valorExpresiones){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorExpresiones == null)||(valorExpresiones.isEmpty())){
            valor = valorExpresionesP;
        }else{
            switch(operacion){
                case ParseSym.AND -> valor = valorExpresionesP && (boolean)valorExpresiones.value;
                case ParseSym.OR -> valor = valorExpresionesP || (boolean)valorExpresiones.value;
                case ParseSym.XOR -> valor = valorExpresionesP && (boolean)valorExpresiones.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public SymbolExpresiones(int operacion,
            SymbolExpresiones valorExpresiones){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorExpresiones == null)||(valorExpresiones.isEmpty())){
            System.out.println("No se ha recibido ninguna expresion");
        }else{
            valor = !(boolean)valorExpresiones.value;
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

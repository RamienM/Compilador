/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;
import CUP.ParserSym;
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
                case ParserSym.AND -> valor = valorExpresionesP && (boolean)valorExpresiones.value;
                case ParserSym.OR -> valor = valorExpresionesP || (boolean)valorExpresiones.value;
                case ParserSym.XOR -> valor = valorExpresionesP && (boolean)valorExpresiones.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public SymbolExpresiones(int operacion,
            SymbolExp valorExp){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorExp == null)||(valorExp.isEmpty())){
            System.out.println("No se ha recibido ninguna expresion");
        }else{
            valor = !(boolean)valorExp.value;
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;
import CUP.ParserSym;
/**
 *
 * @author Ruben
 */
public class SymbolExpresionesP extends SymbolBase{
    private int operacion;
    
    public SymbolExpresionesP(boolean valor){
        super("ExpresionesP",valor);
    }
    
    public SymbolExpresionesP(){
        super();
    }
    
    public SymbolExpresionesP(int valorExp, int operacion,
            SymbolExpresionesP valorExpresionesP){
        super("ExpresionesP",false);
        boolean valor = false;
        
        if((valorExpresionesP == null)||(valorExpresionesP.isEmpty())){
            System.out.println("No se ha recibido ninguna expresion para comparar");
        }else{
            switch(operacion){
                case ParserSym.EQUIVALENTE -> valor = valorExp == (int)valorExpresionesP.value;
                case ParserSym.NOEQUIVALENTE -> valor = valorExp != (int)valorExpresionesP.value;
                case ParserSym.MAYORIGUAL -> valor = valorExp >= (int)valorExpresionesP.value;
                case ParserSym.MAYOR -> valor = valorExp > (int)valorExpresionesP.value;
                case ParserSym.MENORIGUAL -> valor = valorExp <= (int)valorExpresionesP.value;
                case ParserSym.MENOR -> valor = valorExp < (int)valorExpresionesP.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

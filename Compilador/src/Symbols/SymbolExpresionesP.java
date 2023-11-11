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
    
    public SymbolExpresionesP(){
        super("ExpresionesP",false);
    }
    
    public SymbolExpresionesP(boolean valorExpresionesC, int operacion,
            SymbolExpresionesP valorExpresionesP){
        super("ExpresionesP",false);
        boolean valor = false;
        
        if((valorExpresionesP == null)||(valorExpresionesP.isEmpty())){
            System.out.println("No se ha recibido ninguna expresion para comparar");
        }else{
            switch(valorExpresionesP.getOperacion()){
                case ParserSym.AND -> valor = valorExpresionesC && (boolean)valorExpresionesP.value;
                case ParserSym.OR -> valor = valorExpresionesC || (boolean)valorExpresionesP.value;
                case ParserSym.XOR -> valor = valorExpresionesC ^ (boolean)valorExpresionesP.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

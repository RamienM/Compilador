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
    
    public SymbolExpresiones(){
        super();
    }
    
    public SymbolExpresiones(boolean valorExpresionesC,
            SymbolExpresionesP valorExpresionesP){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorExpresionesP == null)||(valorExpresionesP.isEmpty())){
            valor = valorExpresionesC;
        }else{
            switch(valorExpresionesP.getOperacion()){
                case ParserSym.AND -> valor = valorExpresionesC && (boolean)valorExpresionesP.value;
                case ParserSym.OR -> valor = valorExpresionesC || (boolean)valorExpresionesP.value;
                case ParserSym.XOR -> valor = valorExpresionesC ^ (boolean)valorExpresionesP.value;
            }
        }
       this.value = valor;
    }
    
}

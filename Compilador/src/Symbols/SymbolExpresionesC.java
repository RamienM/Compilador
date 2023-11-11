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
public class SymbolExpresionesC extends SymbolBase{
    public SymbolExpresionesC(boolean valor){
        super("ExpresionesC",valor);
    }
    public SymbolExpresionesC(int valor){
        super("ExpresionesC",valor);
    }
    
    public SymbolExpresionesC(SymbolExp valorExp,
            SymbolExpresionesCP valorExpresionesCP){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorExpresionesCP == null)||(valorExpresionesCP.isEmpty())){
            System.out.println("No se ha recido ningún valor para comparar");
        }else{
            if ((valorExp.value instanceof Boolean) && (valorExpresionesCP.value instanceof Boolean)){
                switch(valorExpresionesCP.getOperacion()){
                    case ParserSym.EQUIVALENTE -> valor = (boolean)valorExp.value == (boolean)valorExpresionesCP.value;
                    case ParserSym.NOEQUIVALENTE -> valor = (boolean)valorExp.value != (boolean)valorExpresionesCP.value;
                }
            }else if ((valorExp.value instanceof Integer) && (valorExpresionesCP.value instanceof Integer)){
               switch(valorExpresionesCP.getOperacion()){
                    case ParserSym.EQUIVALENTE -> valor = (int)valorExp.value == (int)valorExpresionesCP.value;
                    case ParserSym.NOEQUIVALENTE -> valor = (int)valorExp.value != (int)valorExpresionesCP.value;
                    case ParserSym.MAYORIGUAL -> valor = (int)valorExp.value >= (int)valorExpresionesCP.value;
                    case ParserSym.MAYOR -> valor = (int)valorExp.value > (int)valorExpresionesCP.value;
                    case ParserSym.MENORIGUAL -> valor = (int)valorExp.value <= (int)valorExpresionesCP.value;
                    case ParserSym.MENOR -> valor = (int)valorExp.value < (int)valorExpresionesCP.value;
                }
            }else{
                System.out.println("Se está intentado comparar un booleano con un entero");
            }
        }
       this.value = valor;
    }
}

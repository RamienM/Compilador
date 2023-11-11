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
public class SymbolExpresionesCP extends SymbolBase{
    private int operacion;
    
    public SymbolExpresionesCP(){
        super();
    }
    
    public SymbolExpresionesCP(int valorExp,int operacion){
       super("ExpresionesCP",0);
       this.value = valorExp;
       this.operacion = operacion;
    }
    public SymbolExpresionesCP(boolean valorExp,int operacion){
       super("ExpresionesCP",false);
       this.value = valorExp;
       this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

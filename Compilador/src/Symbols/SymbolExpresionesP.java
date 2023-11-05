/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;

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
    
    public SymbolExpresionesP(boolean valorExp, int operacion,
            SymbolExpresiones valorExpresionesP){
        super("ExpresionesP",false);
        boolean valor = false;
        
        if((valorExpresionesP == null)||(valorExpresionesP.isEmpty())){
            valor = valorExp;
        }else{
            switch(operacion){
                case ParseSym.EQUIVALENTE -> valor = valorExp == (boolean)valorExpresionesP.value;
                case ParseSym.NOEQUIVALENTE -> valor = valorExp != (boolean)valorExpresionesP.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    public SymbolExpresionesP(int valorExp, int operacion,
            SymbolExpresiones valorExpresionesP){
        super("ExpresionesP",false);
        boolean valor = false;
        
        if((valorExpresionesP == null)||(valorExpresionesP.isEmpty())){
            System.out.println("No se ha recibido ninguna expresion para comparar");
        }else{
            switch(operacion){
                case ParseSym.EQUIVALENTE -> valor = valorExp == (int)valorExpresionesP.value;
                case ParseSym.NOEQUIVALENTE -> valor = valorExp != (int)valorExpresionesP.value;
                case ParseSym.MAYORIGUAL -> valor = valorExp >= (int)valorExpresionesP.value;
                case ParseSym.MAYOR -> valor = valorExp > (int)valorExpresionesP.value;
                case ParseSym.MENORIGUAL -> valor = valorExp <= (int)valorExpresionesP.value;
                case ParseSym.MENOR -> valor = valorExp < (int)valorExpresionesP.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

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
public class SymbolExpresiones1 extends SymbolBase{
    
    private int operacion;
    
    public SymbolExpresiones1(boolean valor){
        super("Expresiones",valor);
    }
    
    public SymbolExpresiones1(){
        super();
    }
    
    public SymbolExpresiones1(boolean valorExpresiones, int operacion,
            SymbolExpresiones1 valorExpresiones1){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorExpresiones1 == null)||(valorExpresiones1.isEmpty())){
            valor = valorExpresiones;
        }else{
            switch(operacion){
                case ParserSym.AND -> valor = valorExpresiones && (boolean)valorExpresiones1.value;
                case ParserSym.OR -> valor = valorExpresiones || (boolean)valorExpresiones1.value;
                case ParserSym.XOR -> valor = valorExpresiones && (boolean)valorExpresiones1.value;
                case ParserSym.EQUIVALENTE -> valor = valorExpresiones == (boolean)valorExpresiones1.value;
                case ParserSym.NOEQUIVALENTE -> valor = valorExpresiones != (boolean)valorExpresiones1.value;
            }
        }
       this.value = valor;
       this.operacion = operacion;
    }
    
    public boolean SymbolExpresionesNumericos(int valorExpresiones, int operacion,
            int valorExpresiones1){
        boolean valor = false;

        switch(operacion){
            case ParserSym.EQUIVALENTE -> valor = valorExpresiones == valorExpresiones1;
            case ParserSym.NOEQUIVALENTE -> valor = valorExpresiones != valorExpresiones1;
            case ParserSym.MAYORIGUAL -> valor = valorExpresiones >= valorExpresiones1;
            case ParserSym.MAYOR -> valor = valorExpresiones > valorExpresiones1;
            case ParserSym.MENORIGUAL -> valor = valorExpresiones <= valorExpresiones1;
            case ParserSym.MENOR -> valor = valorExpresiones < valorExpresiones1;
        }
       return valor;
    }
    public boolean SymbolExpresionesBooleanos(boolean valorExpresiones, int operacion,
            boolean valorExpresiones1){
        boolean valor = false;

        switch(operacion){
            case ParserSym.EQUIVALENTE -> valor = valorExpresiones == valorExpresiones1;
            case ParserSym.NOEQUIVALENTE -> valor = valorExpresiones != valorExpresiones1;
            case ParserSym.AND -> valor = valorExpresiones && valorExpresiones1;
                case ParserSym.OR -> valor = valorExpresiones || valorExpresiones1;
                case ParserSym.XOR -> valor = valorExpresiones && valorExpresiones1;
        }
       return valor;
    }
    
    public SymbolExpresiones1(int operacion,
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

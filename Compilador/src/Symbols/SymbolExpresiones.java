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
    public SymbolExpresiones(boolean valor){
        super("Expresiones",valor);
    }
    
    public SymbolExpresiones(SymbolOperaciones valorOperacion,int operacion,
            SymbolOperaciones valorOperacionP){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorOperacionP == null)||(valorOperacionP.isEmpty())){
             if(valorOperacion.value instanceof Boolean){
                valor = (boolean)valorOperacion.value;
            }else{
                System.out.println("No se ha recido ningún valor para comparar");
            }
        }else{
            if ((valorOperacion.value instanceof Boolean) && (valorOperacionP.value instanceof Boolean)){
                switch(operacion){
                    case ParserSym.AND -> valor = (boolean)valorOperacion.value && (boolean)valorOperacionP.value;
                    case ParserSym.OR -> valor = (boolean)valorOperacion.value || (boolean)valorOperacionP.value;
                    case ParserSym.XOR -> valor = (boolean)valorOperacion.value ^ (boolean)valorOperacionP.value;
                    case ParserSym.EQUIVALENTE -> valor = (boolean)valorOperacion.value == (boolean)valorOperacionP.value;
                    case ParserSym.NOEQUIVALENTE -> valor = (boolean)valorOperacion.value != (boolean)valorOperacionP.value;
                }
            }else if ((valorOperacion.value instanceof Integer) && (valorOperacionP.value instanceof Integer)){
               switch(operacion){
                    case ParserSym.EQUIVALENTE -> valor = (int)valorOperacion.value == (int)valorOperacionP.value;
                    case ParserSym.NOEQUIVALENTE -> valor = (int)valorOperacion.value != (int)valorOperacionP.value;
                    case ParserSym.MAYORIGUAL -> valor = (int)valorOperacion.value >= (int)valorOperacionP.value;
                    case ParserSym.MAYOR -> valor = (int)valorOperacion.value > (int)valorOperacionP.value;
                    case ParserSym.MENORIGUAL -> valor = (int)valorOperacion.value <= (int)valorOperacionP.value;
                    case ParserSym.MENOR -> valor = (int)valorOperacion.value < (int)valorOperacionP.value;
                }
            }else{
                System.out.println("Se está intentado comparar un booleano con un entero");
            }
        }
       this.value = valor;
    }
    
}

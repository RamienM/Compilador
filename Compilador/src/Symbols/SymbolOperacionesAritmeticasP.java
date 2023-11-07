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
public class SymbolOperacionesAritmeticasP extends SymbolBase{
    private int operacion;
    
    public SymbolOperacionesAritmeticasP(){
        super("OperacionesAritmeticasP",0);
    }
    
    public SymbolOperacionesAritmeticasP(int operacion, int valorMultiplicacionDivision, 
            SymbolOperacionesAritmeticasP valorOperacionesAritmeticasP){
        super("OperacionesAritmeticasP",0);
        int valor = 0;
        if((valorOperacionesAritmeticasP == null)|| (valorOperacionesAritmeticasP.isEmpty())){
            valor = valorMultiplicacionDivision;
        }else{
            switch(valorOperacionesAritmeticasP.getOperacion()){
                case ParserSym.SUMA -> valor = valorMultiplicacionDivision + (int)valorOperacionesAritmeticasP.value;
                case ParserSym.RESTA -> valor = valorMultiplicacionDivision - (int)valorOperacionesAritmeticasP.value;
            }
        }
        this.operacion = operacion;
        this.value = valor;
    }
    
    public int getOperacion(){
        return operacion;
    }
    
}

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
public class SymbolOperacionesAritmeticas extends SymbolBase{
    
    public SymbolOperacionesAritmeticas(int valor){
        super("OperacionesAritmeticas", valor);
    }
    
    public SymbolOperacionesAritmeticas(int valorMultiplicacionDivision, 
            SymbolOperacionesAritmeticasP valorOperacionesAritmeticasP){
        
        super("OperacionesAritmeticas", 0);
        int valor = 0;
        
        if ((valorOperacionesAritmeticasP == null)|| (valorOperacionesAritmeticasP.isEmpty())){
            valor = valorMultiplicacionDivision;
        }else{
            switch(valorOperacionesAritmeticasP.getOperacion()){
                case ParserSym.SUMA -> valor = valorMultiplicacionDivision + (int)valorOperacionesAritmeticasP.value;
                case ParserSym.RESTA -> valor = valorMultiplicacionDivision - (int)valorOperacionesAritmeticasP.value;
            }
        }
        this.value = valor;
    }
    
    public SymbolOperacionesAritmeticas(){
        super();
    }
}

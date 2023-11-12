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
    
    public SymbolOperacionesAritmeticas(int valorOperacion,int operacion, 
            SymbolOperaciones valorOperacionP){
        
        super("OperacionesAritmeticas", 0);
        int valor = 0;
        
        if ((valorOperacionP == null)|| (valorOperacionP.isEmpty())){
            valor = valorOperacion;
        }else{
            switch(operacion){
                case ParserSym.SUMA -> valor = valorOperacion + (int)valorOperacionP.value;
                case ParserSym.RESTA -> valor = valorOperacion - (int)valorOperacionP.value;
                case ParserSym.MULTIPLICACION -> valor = valorOperacion * (int)valorOperacionP.value;
                case ParserSym.DIVISION -> {
                    int division = (int)valorOperacionP.value;
                    if(division == 0){
                        System.out.println("Error");
                    }else{
                        valor = valorOperacion / division;
                    }
                }
                case ParserSym.MODULO -> {
                    int modulo = (int)valorOperacionP.value;
                    if(modulo == 0){
                        System.out.println("Error");
                    }else{
                        valor = valorOperacion % modulo;
                    }
                }
            }
        }
        this.value = valor;
    }
    
    public SymbolOperacionesAritmeticas(){
        super();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;
import CUP.*;
/**
 *
 * @author Ruben
 */
public class SymbolOperacionesAritmeticas extends SymbolBase{
    
    public SymbolOperacionesAritmeticas(int valor){
        super("OperacionesAritmeticas", valor);
    }
    
    public SymbolOperacionesAritmeticas(int valorOperacion,int operacion, 
            SymbolOperaciones valorOperacionP,Parser parser){
        
        super("OperacionesAritmeticas", 0);
        int valor = 0;
        
        if ((valorOperacionP == null)|| (valorOperacionP.isEmpty())){
            valor = valorOperacion;
        }else{
            if(valorOperacionP.value instanceof Integer){
                switch(operacion){
                    case ParserSym.SUMA -> valor = valorOperacion + (int)valorOperacionP.value;
                    case ParserSym.RESTA -> valor = valorOperacion - (int)valorOperacionP.value;
                    case ParserSym.MULTIPLICACION -> valor = valorOperacion * (int)valorOperacionP.value;
                    case ParserSym.DIVISION -> {
                        int division = (int)valorOperacionP.value;
                        if(division == 0){
                            mensajesError(parser, 1, valorOperacionP,valorOperacion);
                        }else{
                            valor = valorOperacion / division;
                        }
                    }
                    case ParserSym.MODULO -> {
                        int modulo = (int)valorOperacionP.value;
                        if(modulo == 0){
                            mensajesError(parser, 2, valorOperacionP,valorOperacion);
                        }else{
                            valor = valorOperacion % modulo;
                        }
                    }
                }
            }else{
                mensajesError(parser, 0, valorOperacionP,valorOperacion);
            }
        }
        this.value = valor;
    }
    
    public SymbolOperacionesAritmeticas(){
        super();
    }
    
    private void mensajesError(Parser parser, int error, SymbolOperaciones valorOperacionP,int valorOperacion){
        parser.errorEncontrado();
        switch(error){
            case 0 -> parser.report_error("Se ha recibido un valor booleano en una operación aritmética.", valorOperacionP);
            case 1 -> parser.report_error("Se está intentando dividir: "+valorOperacion+"/0.", valorOperacionP);
            case 2 -> parser.report_error("Se está intentando calcular " + valorOperacion+" modulo 0.", valorOperacionP);
        }
    }
}

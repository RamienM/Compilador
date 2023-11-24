/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;
import CUP.*;
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
            SymbolOperaciones valorOperacionP, Parser parser){
        super("Expresiones",false);
        boolean valor = false;
        
        if((valorOperacionP == null)||(valorOperacionP.isEmpty())){
             if(valorOperacion.value instanceof Boolean){
                valor = (boolean)valorOperacion.value;
            }else{
                mensajesError(0,parser,operacion,valorOperacion);
            }
        }else{
            if ((valorOperacion.value instanceof Boolean) && (valorOperacionP.value instanceof Boolean)){
                switch(operacion){
                    case ParserSym.AND -> valor = (boolean)valorOperacion.value && (boolean)valorOperacionP.value;
                    case ParserSym.OR -> valor = (boolean)valorOperacion.value || (boolean)valorOperacionP.value;
                    case ParserSym.XOR -> valor = (boolean)valorOperacion.value ^ (boolean)valorOperacionP.value;
                    case ParserSym.EQUIVALENTE -> valor = (boolean)valorOperacion.value == (boolean)valorOperacionP.value;
                    case ParserSym.NOEQUIVALENTE -> valor = (boolean)valorOperacion.value != (boolean)valorOperacionP.value;
                    default -> mensajesError(1, parser, operacion,valorOperacion);
                }
            }else if ((valorOperacion.value instanceof Integer) && (valorOperacionP.value instanceof Integer)){
               switch(operacion){
                    case ParserSym.EQUIVALENTE -> valor = (int)valorOperacion.value == (int)valorOperacionP.value;
                    case ParserSym.NOEQUIVALENTE -> valor = (int)valorOperacion.value != (int)valorOperacionP.value;
                    case ParserSym.MAYORIGUAL -> valor = (int)valorOperacion.value >= (int)valorOperacionP.value;
                    case ParserSym.MAYOR -> valor = (int)valorOperacion.value > (int)valorOperacionP.value;
                    case ParserSym.MENORIGUAL -> valor = (int)valorOperacion.value <= (int)valorOperacionP.value;
                    case ParserSym.MENOR -> valor = (int)valorOperacion.value < (int)valorOperacionP.value;
                    default -> mensajesError(1, parser, operacion,valorOperacion);
                }
            }else{
                mensajesError(2, parser, operacion,valorOperacion);
            }
        }
       this.value = valor;
    }
    
    private void mensajesError(int tipoError, Parser parser, int operacion, SymbolOperaciones valorOperacion){
        parser.errorEncontrado();
        switch(operacion){
                    case ParserSym.AND -> {
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion AND", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion AND con enteros", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion AND con booleanos y enteros", valorOperacion);
                        }
                    }
                    case ParserSym.OR -> {
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion OR", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion OR con enteros", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion OR con booleanos y enteros", valorOperacion);
                        }   
                    }   
                    case ParserSym.XOR ->{
                        switch (tipoError){
                            case 0 ->  parser.report_error("No se ha recido ningún valor para hacer la operacion XOR", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion XOR con enteros", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion XOR con booleanos y enteros", valorOperacion);
                        }
                    } 
                    case ParserSym.EQUIVALENTE ->{
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion EQUIVALENTE", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion EQUIVALENTE con booleanos y enteros", valorOperacion);
                        }
                    }  
                    case ParserSym.NOEQUIVALENTE ->{
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion NOEQUIVALENTE", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion NOEQUIVALENTE con booleanos y enteros", valorOperacion);
                        }
                    }  
                    case ParserSym.MAYORIGUAL ->{
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion MAYORIGUAL", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion MAYORIGUAL con booleanos", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion MAYORIGUAL con booleanos y enteros", valorOperacion);
                        }
                    }
                    case ParserSym.MAYOR ->{
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion MAYOR", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion MAYOR con booleanos", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion MAYOR con booleanos y enteros", valorOperacion);
                        }
                    }  
                    case ParserSym.MENORIGUAL ->{
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion MENORIGUAL", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion MENORIGUAL con booleanos", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion MENORIGUAL con booleanos y enteros", valorOperacion);
                        }
                    }  
                    case ParserSym.MENOR ->{
                        switch (tipoError){
                            case 0 -> parser.report_error("No se ha recido ningún valor para hacer la operacion MENOR", valorOperacion);
                            case 1 -> parser.report_error("Se está intentado realizar la operacion MENOR con booleanos", valorOperacion);
                            case 2 -> parser.report_error("Se está intentado realizar la operacion MENOR con booleanos y enteros", valorOperacion);
                        }
                    }  
                }
    }
    
}

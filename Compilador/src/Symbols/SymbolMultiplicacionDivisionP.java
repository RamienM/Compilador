/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;

/**
 *
 * @author Ruben
 */
public class SymbolMultiplicacionDivisionP extends SymbolBase{
    private int operacion;
    
        
    public SymbolMultiplicacionDivisionP(){
        super("MultiplicacionDivisionP",0);
    }
    
    public SymbolMultiplicacionDivisionP(int operacion, int valorFinalOperaciones,
            SymbolMultiplicacionDivisionP valorMultiplicacionDivisionP){
        
        super("MultiplicacionDivision", 0);
        int valor = 0;
        
        if ((valorMultiplicacionDivisionP == null)|| (valorMultiplicacionDivisionP.isEmpty())){
            valor = valorFinalOperaciones;
        }else{
            switch(valorMultiplicacionDivisionP.getOperacion()){
                case ParseSym.MULTIPLICACION -> valor = valorFinalOperaciones * (int)valorMultiplicacionDivisionP.value;
                case ParseSym.DIVISION -> {
                    int division = (int)valorMultiplicacionDivisionP.value;
                    if(division == 0){
                        System.out.println("Error");
                    }else{
                        valor = valorFinalOperaciones / division;
                    }
                }
                case ParseSym.MODULO -> {
                    int modulo = (int)valorMultiplicacionDivisionP.value;
                    if(modulo == 0){
                        System.out.println("Error");
                    }else{
                        valor = valorFinalOperaciones % modulo;
                    }
                }
            }
        }
        this.value = valor;
        this.operacion = operacion;
    }
    
    public int getOperacion(){
        return operacion;
    }
}

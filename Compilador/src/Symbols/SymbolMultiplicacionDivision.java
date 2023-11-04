/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;

/**
 *
 * @author Ruben
 */
public class SymbolMultiplicacionDivision extends SymbolBase{
    
    public SymbolMultiplicacionDivision(int valor){
        super("MultiplicacionDivision", valor);
    }
    
    public SymbolMultiplicacionDivision(int valorFinalOperaciones,
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
            }
        }
        this.value = valor;
    }
    
    public SymbolMultiplicacionDivision(){
        super();
    }
}

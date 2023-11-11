/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;

/**
 *
 * @author Ruben
 */
public class SymbolExp extends SymbolBase{
    public SymbolExp(SymbolID valor){
        super("Exp",0);
        if(valor.value instanceof Integer){
            this.value = (int)valor.value;
        }else{
            this.value = (boolean)valor.value;
        }
    }
    
    public SymbolExp(boolean valor){
        super("Exp",valor);
    }
    
    public SymbolExp(int valor){
        super("Exp",valor);
    }
    
    public SymbolExp(){
        super();
    }
}

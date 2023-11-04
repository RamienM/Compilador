/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Symbols;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;

/**
 *
 * @author Ruben
 */
public class SymbolBase extends ComplexSymbol{
    /*
        Identificador es una variable que se va autoincrementado, nos será útil para
        generar el código de tres direcciones
    */
    private static int identificador = 0;
    //Variable que nos permite conocer si un simbolo esta vacio o no.
    protected boolean empty;
    
    /**
     * Constructor que crear una intancia para los valores enteros.
     * @param name      Nombre de la variable.
     * @param valor     Valor de la variable.
     */
    public SymbolBase(String name, int valor) {
        super(name,identificador++, valor);
        this.empty = false;
    }
    
    /**
     * Constructor que crear una intancia para los valores booleanos.
     * @param name      Nombre de la variable.
     * @param valor     Valor de la variable.
     */
    public SymbolBase(String name, boolean valor) {
        super(name,identificador++, valor);
        this.empty = false;
    }
    
    /**
     * Constructor que crea un instacia vacia, nor servirá para los errores o
     * para las proyecciones que derivan a lambda.
     */
    public SymbolBase(){
        super("",identificador++);
        this.empty = true;
    }
    
    /**
     * Funcion que nos permite conocer si un simbolo esta vacio.
     * @return Devuelve true en caso que el simbolo este vacio, o false en caso contrario.
     */
    public boolean isEmpty(){
        return empty;
    }
    
    
}

package JFlex;
import java.io.*;
import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;

import CUP.ParserSym;
import java.util.ArrayList;

%%
%public                                                     //Será una clase pública
%class Lector                                               //Nombre de la clase

%cup                                                        //Analizador sintantico

%char
%line
%column


%{
        //Array list que contendrá los simbolos que se han ido analizando
        private ArrayList<String> sim = new ArrayList<String>();
        /**
            Escribimos los datos
        **/
        public void printVars(PrintStream out) {
        if (sim.isEmpty()) {
            out.println("No se han detectado simbolos");
        } else {
            String fmt = "Simbolo-> %s";
            for(int i =0;i<sim.size();i++){
                out.println(String.format(fmt, sim.get(i)));
            }
        }
    } 
        /**
         Construccion de un simbolo sin atributo asociado
         **/
        private ComplexSymbol symbol(int type) {
            //Sumamos 1 para la primera linea y columna para que no sea 0
            Location izquierda = new Location(yyline+1,yycolumn+1);
            Location derecha = new Location(yyline+1,yycolumn+yytext().length()+1);
            return new ComplexSymbol(ParserSym.terminalNames[type],type, izquierda, derecha);
        }

        /**
         Construccion de un simbolo con atributo asociado
         **/
        private Symbol symbol(int type, Object value) {
             //Sumamos 1 para la primera linea y columna para que no sea 0
             Location izquierda = new Location(yyline+1,yycolumn+1);
             Location derecha = new Location(yyline+1,yycolumn+yytext().length()+1);
             return new ComplexSymbol(ParserSym.terminalNames[type],type, izquierda, derecha,value);
        }
%}

%eofval{
    return symbol(ParserSym.EOF);
%eofval}

//----------------------------------------------------------------------------------------------------------------------
//Declaraciones

//Letras
character = [a-zA-Z]

//Numeros
digit = [0-9]
//signo = [\-]?
//--Enteros
integer = 0 | ([1-9]{digit}*)

//booleano
booleanTrue = true
booleanFalse = false

//asignacion
asignacion = \=

//Operadores
//--Aritmeticos
op_suma     = \+
op_resta    = \-
op_mult     = \*
op_div      = \/
op_mod      = mod


//--Relacionales
op_comp_equal = \=\=
op_comp_not_equal = \!\=
op_menorigual = \<\=
op_mayorigual = \>\=
op_mayor = \>
op_menor = \<
//--Lógicos
op_and = and
op_or =  or
op_xor = xor
op_not = not


//Parentesis
parentesis_l = \(
parentesis_r = \)
llave_l = \{
llave_r = \}

//puntos y comas
punto_coma = ;
coma =       ,

//Condicionales
cond_if = if
cond_else = else
//Bucles
cond_while = while
cond_for = for
cond_do = do

//Palabras reservadas
//res_null = null
res_break = break
res_return = return
res_print = print
res_println = println
res_enter = enter
res_enterln = enterln
res_main = main
res_procedimiento = proc
res_funcion = funt
res_first = \.fst
res_second = \.snd
//--Tipo de Datos
int = int
bool = boolean
tupla = pair


//Identificador
id = {character}({character}|{digit}|_)*

//Espacios
space = [ ,\t,\r,\n]

//Comentarios
linecomment = \/\/({character}|{digit}|{space})*
blockcomment = \/\*({character}|{digit}|{space})*\*\/

%%
//----------------------------------------------------------------------------------------------------------------------
//Reglas

        //tipo de datos
        {integer}                      { 
                                        Integer aux = Integer.parseInt(this.yytext());
                                        sim.add("Entero: "+aux);
                                        return symbol(ParserSym.valor,aux); 
                                       }
        {booleanTrue}                  { 
                                        sim.add("Boolean: true");
                                        return symbol(ParserSym.TRUE); 
                                        }
        {booleanFalse}                 { 
                                        sim.add("Boolean: false");
                                        return symbol(ParserSym.FALSE); 
                                        }

        //Operadores
        //--Aritmeticos
        {op_suma}                      { 
                                        sim.add("Operación: SUMA");
                                        return symbol(ParserSym.SUMA); 
                                       }
        {op_resta}                     { 
                                        sim.add("Operación: RESTA");
                                        return symbol(ParserSym.RESTA); 
                                       }
        {op_mult}                      { 
                                        sim.add("Operación: MULTIPLICACION");
                                        return symbol(ParserSym.MULTIPLICACION); 
                                       }
        {op_div}                       { 
                                        sim.add("Operación: DIVISION");
                                        return symbol(ParserSym.DIVISION); 
                                       }
        {op_mod}                       { 
                                        sim.add("Operación: MODULO");
                                        return symbol(ParserSym.MODULO); 
                                       }
        //--Relacionales
        {op_comp_equal}                { 
                                        sim.add("Operación: EQUIVALENTE");
                                        return symbol(ParserSym.EQUIVALENTE); 
                                       }
        {op_menorigual}                {
                                        sim.add("Operación: MENOR IGUAL");
                                        return symbol(ParserSym.MENORIGUAL); 
                                       }
        {op_mayorigual}                {
                                        sim.add("Operación: MAYOR IGUAL");
                                        return symbol(ParserSym.MAYORIGUAL); 
                                       }
        {op_mayor}                     { 
                                        sim.add("Operación: MAYOR");
                                        return symbol(ParserSym.MAYOR); 
                                       }
        {op_menor}                     { 
                                        sim.add("Operación: MENOR");
                                        return symbol(ParserSym.MENOR); 
                                       }
        {op_comp_not_equal}            {
                                        sim.add("Operación: DISTINTO");
                                        return symbol(ParserSym.NOEQUIVALENTE); 
                                       }
        //--Lógicos
        {op_and}                       { 
                                        sim.add("Operación: AND");
                                        return symbol(ParserSym.AND); 
                                       }
        {op_or}                        {
                                        sim.add("Operación: OR");
                                        return symbol(ParserSym.OR); 
                                        }
        {op_xor}                       {
                                        sim.add("Operación: XOR");
                                        return symbol(ParserSym.XOR); 
                                        }
        {op_not}                       {
                                        sim.add("Operación: NEGACION");
                                        return symbol(ParserSym.NOT); 
                                        }

        //Parentesis
        {parentesis_l}                 {
                                        sim.add("Caracter: PARENTESIS IZQUIERDO");
                                        return symbol(ParserSym.LPARENTESIS); 
                                        }
        {parentesis_r}                 { 
                                        sim.add("Caracter: PARENTESIS DERECHO");
                                        return symbol(ParserSym.RPARENTESIS); 
                                       }
        {llave_l}                      {
                                        sim.add("Caracter: LLAVE IZQUIERDA");
                                        return symbol(ParserSym.LLLAVE); 
                                       }
        {llave_r}                      {
                                        sim.add("Caracter: LLAVE DERECHA");
                                        return symbol(ParserSym.RLLAVE); 
                                       }

        //Puntos y comas
        {punto_coma}                   {
                                        sim.add("Caracter: PUNTO Y COMA");
                                        return symbol(ParserSym.PUNTOCOMA); 
                                       }
        {coma}                         { 
                                        sim.add("Caracter: COMA");
                                        return symbol(ParserSym.COMA); 
                                       }

        //Asignación
        {asignacion}                   { 
                                        sim.add("Caracter: ASIGNACION");
                                        return symbol(ParserSym.ASIGNACION); 
                                       }

        //Condicionales
        {cond_if}                      { 
                                        sim.add("Palabra Reservada: IF");
                                        return symbol(ParserSym.IF); 
                                       }
        {cond_else}                    { 
                                        sim.add("Palabra Reservada: ELSE");
                                        return symbol(ParserSym.ELSE); 
                                       }
        //Bucles
        {cond_while}                   { 
                                        sim.add("Palabra Reservada: WHILE");
                                        return symbol(ParserSym.WHILE); 
                                       }
        {cond_for}                     { 
                                        sim.add("Palabra Reservada: FOR");
                                        return symbol(ParserSym.FOR); 
                                       }
        {cond_do}                      {    
                                        sim.add("Palabra Reservada: DO");
                                        return symbol(ParserSym.DO); 
                                       }


        //Palabras reservadas
        //{res_null}                   {
        //                              sim.add("Palabra Reservada: NULL");
        //                              return symbol(ParserSym.NULL); 
        //                             }
        {res_break}                    { 
                                        sim.add("Palabra Reservada: BREAK");
                                        return symbol(ParserSym.BREAK); 
                                       }
        {res_return}                   { 
                                        sim.add("Palabra Reservada: RETURN");
                                        return symbol(ParserSym.RETURN); 
                                       }
        {res_print}                    { 
                                        sim.add("Palabra Reservada: PRINT");
                                        return symbol(ParserSym.PRINT); 
                                       }
        {res_println}                  {
                                        sim.add("Palabra Reservada: PRINTLN");
                                        return symbol(ParserSym.PRINTLN); 
                                       }
        {res_enter}                    { 
                                        sim.add("Palabra Reservada: ENTER");
                                        return symbol(ParserSym.ENTER); 
                                       }
        {res_enterln}                  { 
                                        sim.add("Palabra Reservada: ENTERLN");
                                        return symbol(ParserSym.ENTERLN); 
                                       }
        {res_main}                     { 
                                        sim.add("Palabra Reservada: MAIN");
                                        return symbol(ParserSym.MAIN); 
                                       }
        {res_procedimiento}            { 
                                        sim.add("Palabra Reservada: PROCEDURE");
                                        return symbol(ParserSym.PROC); 
                                       }
        {res_funcion}                  { 
                                        sim.add("Palabra Reservada: FUNCION");
                                        return symbol(ParserSym.FUNT); 
                                       }
        {res_first}                    {
                                        sim.add("Palabra Reservada TUPLA: FST");
                                        return symbol(ParserSym.FST);
                                       }
        {res_second}                    {
                                        sim.add("Palabra Reservada TUPLA: SND");
                                        return symbol(ParserSym.SND);
                                       }
        //--Tipo de datos
        {int}                          { 
                                        sim.add("Palabra Reservada: INT");
                                        return symbol(ParserSym.INT); 
                                       }
        {bool}                         { 
                                        sim.add("Palabra Reservada: BOOLEAN");
                                        return symbol(ParserSym.BOOL); 
                                       }
        {tupla}                        { 
                                        sim.add("Palabra Reservada: TUPLA");
                                        return symbol(ParserSym.PAIR); 
                                       }

        //Comentarios
        {linecomment}                  {/*Ignore*/}
        {blockcomment}                 {/*Ignore*/}
        //Espacios
        {space}                        {/*Ignore*/}
        //Identificadores
        {id}                           { 
                                        String aux =this.yytext();
                                        sim.add("Identificador: "+aux);
                                        return symbol(ParserSym.IDENTIFICADOR,aux); 
                                       }

        [^]                            { 
                                        sim.add("Desconocido: "+this.yytext());
                                        return symbol(ParserSym.error);
                                       }

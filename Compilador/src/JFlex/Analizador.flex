package JFlex;
import java.io.*;
import java_cup.runtime.*;
import java_cup.runtime.ComplexSymbolFactory.ComplexSymbol;
import java_cup.runtime.ComplexSymbolFactory.Location;

import CUP.ParserSym;

%%
%public                                                     //Será una clase pública
%class Lector                                               //Nombre de la clase
%implements java_cup.runtime.Scanner
%function next_token
%type java_cup.runtime.Symbol

%cup                                                        //Analizador sintantico

%char
%line
%column


%{
        /**
         Construccion de un simbolo sin atributo asociado
         **/
        private ComplexSymbol symbol(int type) {
            //Sumamos 1 para la primera linea y columna para que no sea 0
            Location izquierda = new Location(yyline+1,yycolumn+1);
            Location derecha = new Location(yyline+1,yycolumn+yytext().lenght()+1);
            return new ComplexSymbol(ParserSym.terminalNames[type],type, izquierda, derecha);
        }

        /**
         Construccion de un simbolo con atributo asociado
         **/
        private Symbol symbol(int type, Object value) {
             //Sumamos 1 para la primera linea y columna para que no sea 0
             Location izquierda = new Location(yyline+1,yycolumn+1);
             Location derecha = new Location(yyline+1,yycolumn+yytext().lenght()+1);
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
signo = [\-]?
//--Enteros
integer = 0 | ({signo}[1-9]{digit}*)

//booleano
booleanTrue = true
booleanFalse = false

//constantes
const_final = const

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
op_xor = xr
op_not = not


//Parentesis
parentesis_l = \(
parentesis_r = \)
llave_l = \{
llave_r = \}
//corchete_l = \[
//corchete_r = \]

//puntos y comas
punto_coma = ;
punto =      \.
coma =       ,

//Condicionales
cond_if = if
cond_else = else
//Bucles
cond_while = while
cond_for = for
cond_do = do
cond_switch = switch
cond_case = case
cond_default = default

//Palabras reservadas
res_null = null
res_break = break
res_return = return
res_print = print
res_println = println
res_enter = enter
res_enterln = enterln
res_main = main
//--Tipo de Datos
int = int
bool = boolean


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
        {integer}                      { return symbol(ParserSym.valor, Integer.parseInt(this.yytext())); }
        {booleanTrue}                  { return symbol(ParserSym.valor, Boolean.parseBoolean(this.yytext())); }
        {booleanFalse}                 { return symbol(ParserSym.valor, Boolean.parseBoolean(this.yytext())); }

        //Operadores
        //--Aritmeticos
        {op_suma}                      { return symbol(ParserSym.SUMA); }
        {op_resta}                     { return symbol(ParserSym.RESTA); }
        {op_mult}                      { return symbol(ParserSym.MULTIPLICACION); }
        {op_div}                       { return symbol(ParserSym.DIVISION); }
        {op_mod}                       { return symbol(ParserSym.MODULO); }
        //--Relacionales
        {op_comp_equal}                { return symbol(ParserSym.EQUIVALENTE); }
        {op_menorigual}                { return symbol(ParserSym.MENORIGUAL); }
        {op_mayorigual}                { return symbol(ParserSym.MAYORIGUAL); }
        {op_mayor}                     { return symbol(ParserSym.MAYOR); }
        {op_menor}                     { return symbol(ParserSym.MENOR); }
        {op_comp_not_equal}            { return symbol(ParserSym.NOEQUIVALENTE); }
        //--Lógicos
        {op_and}                       { return symbol(ParserSym.AND); }
        {op_or}                        { return symbol(ParserSym.OR); }
        {op_xor}                       { return symbol(ParserSym.XOR); }
        {op_not}                       { return symbol(ParserSym.NOT); }

        //Parentesis
        {parentesis_l}                 { return symbol(ParserSym.LPARENTESIS); }
        {parentesis_r}                 { return symbol(ParserSym.RPARENTESIS); }
        {llave_l}                      { return symbol(ParserSym.LLLAVE); }
        {llave_r}                      { return symbol(ParserSym.RLLAVE); }

        //Puntos y comas
        {punto_coma}                   { return symbol(ParserSym.PUNTOCOMA); }
        {coma}                         { return symbol(ParserSym.COMA); }
        {punto}                        { return symbol(ParserSym.PUNTO); }

        //Asignación
        {asignacion}                   { return symbol(ParserSym.ASIGNACION); }

        //Condicionales
        {cond_if}                      { return symbol(ParserSym.IF); }
        {cond_else}                    { return symbol(ParserSym.ELSE); }
        //Bucles
        {cond_while}                   { return symbol(ParserSym.WHILE); }
        {cond_for}                     { return symbol(ParserSym.FOR); }
        {cond_do}                      { return symbol(ParserSym.DO); }
        //{cond_switch}                  { return new Symbol(sym.SWITCH, yychar, yyline, yytext()); }
        //{cond_case}                    { return new Symbol(sym.CASE, yychar, yyline, yytext()); }
        //{cond_default}                 { return new Symbol(sym.DEFAULT, yychar, yyline, yytext()); }


        //Palabras reservadas
        //{res_null}                     { return symbol(ParserSym.NULL); }
        {res_break}                    { return symbol(ParserSym.BREAK); }
        {res_return}                   { return symbol(ParserSym.RETURN); }
        {res_print}                    { return symbol(ParserSym.PRINT); }
        {res_println}                  { return symbol(ParserSym.PRINTLN); }
        {res_enter}                    { return symbol(ParserSym.ENTER); }
        {res_enterln}                  { return symbol(ParserSym.ENTERLN); }
        {res_main}                     { return symbol(ParserSym.MAIN); }
        //--Tipo de datos
        {int}                          { return symbol(ParserSym.INT); }
        {bool}                         { return symbol(ParserSym.BOOL); }
        //--constantes
        {const_final}                  { return symbol(ParserSym.CONST);}

        //Comentarios
        {linecomment}                  {/*Ignore*/}
        {blockcomment}                 {/*Ignore*/}
        //Espacios
        {space}                        {/*Ignore*/}
        //Identificadores
        {id}                           { return symbol(ParserSym.IDENTIFICADOR, this.yytext()); }

        [^]                            { return symbol(ParserSym.ERROR);}

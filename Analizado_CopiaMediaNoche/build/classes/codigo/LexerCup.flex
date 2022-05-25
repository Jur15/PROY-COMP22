package codigo;
import java_cup.runtime.*;
%%
%unicode

%class LexerCup
%type Tokens

%type java_cup.runtime.Symbol
%cup
%full
%line
%char

simboloX  = [|°¬!#$%&/()='?¿¡´¨+*{}]`,;.:-_<>]

L_Alone = [a-zA-Z$_]
L = [a-zA-Z$_] [a-zA-Z0-9$_]*
D = [0-9]+
espacio = [ \n|\r|\r\n ]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Comillas */
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}


/* Comillas Simples*/
( "\'" ) {return new Symbol(sym.Comiilas_Simples, yychar, yyline, yytext());}
 
 

/* Tipo de dato Char */
( char ) {return new Symbol(sym.Type_Char, yychar, yyline, yytext());}



/* Tipo de dato float */
( float ) {return new Symbol(sym.Type_Float, yychar, yyline, yytext());}


/* Tipo de dato String */
( string ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}



/* Tipo de dato Return */
( return ) {return new Symbol(sym.Return, yychar, yyline, yytext());}

/* Palabra reservada If */
( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}

/* Palabra reservada Else */
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}
 
/* Palabra reservada While */
( while ) {return new Symbol(sym.While, yychar, yyline, yytext());}


/* Palabra reservada Switch */
( switch ) {return new Symbol(sym.Switch, yychar, yyline, yytext());}
 

/* Palabra reservada true */
( true ) {return new Symbol(sym.True, yychar, yyline, yytext());}

/* Palabra reservada false */
( false ) {return new Symbol(sym.False, yychar, yyline, yytext());}

/* Palabra reservada case */
( case ) {return new Symbol(sym.Case, yychar, yyline, yytext());}

/* S Punto  */
( "." ) {return new Symbol(sym.Punto, yychar, yyline, yytext());}

/* Palabra reservada default */
( default ) {return new Symbol(sym.Default, yychar, yyline, yytext());}

/* Palabra reservada break */
( break ) {return new Symbol(sym.Break, yychar, yyline, yytext());}

/* Palabra reservada null */
( null ) {return new Symbol(sym.Null, yychar, yyline, yytext());}


/* Palabra reservada null */
( bool ) {return new Symbol(sym.Type_Bool, yychar, yyline, yytext());}




/* Palabra reservada null */
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}  

/* Palabra reservada scrut */
( struct ) {return new Symbol(sym.Struct, yychar, yyline, yytext());}  

 

/* Palabra reservada static */
( static ) {return new Symbol(sym.Static, yychar, yyline, yytext());}  



/* Palabra reservada null */
( Def ) {return new Symbol(sym.Def, yychar, yyline, yytext());}  


/* Palabra reservada null */
( print ) {return new Symbol(sym.Print, yychar, yyline, yytext());}  

 
/* Palabra reservada null */
( read ) {return new Symbol(sym.Read, yychar, yyline, yytext());}  





/* Palabra reservada int */
( int ) {return new Symbol(sym.Type_Int, yychar, yyline, yytext());}
  
/* Operador Igual */
( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}

/* Operador Not */
( not ) {return new Symbol(sym.Not, yychar, yyline, yytext());}

/* Operador Suma */
( "+" ) {return new Symbol(sym.Suma, yychar, yyline, yytext());}

/* Operador Resta */
( "-" ) {return new Symbol(sym.Resta, yychar, yyline, yytext());}


/* Operador Resta */
( "^" ) {return new Symbol(sym.Potencia, yychar, yyline, yytext());}


/* Operador Modular */
( "~" ) {return new Symbol(sym.Modular, yychar, yyline, yytext());}


/* Operador Multiplicacion */
( "*" ) {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}

/* Operador Division */
( "/" ) {return new Symbol(sym.Division, yychar, yyline, yytext());}

/* Operadores logicos */
(  "&" | or) {return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" ) {return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" | "=" ) {return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

/* Operadores Incremento y decremento */
( "++" | "--" ) {return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}
 

/* Parentesis de apertura */
( "(" ) {return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(sym.Llave_a, yychar, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(sym.Llave_c, yychar, yyline, yytext());}

/* Corchete de apertura */
( "[" ) {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}

/* Corchete de cierre */
( "]" ) {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

/* Marcador de inicio de algoritmo */
( "main" ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/* Punto y coma xd*/
( "#" ) {return new Symbol(sym.P_coma, yychar, yyline, yytext());}

/* Guion Bajo */
( "_" ) {return new Symbol(sym.G_Bajo, yychar, yyline, yytext());}



/* Guion Bajo */
( "$" ) {return new Symbol(sym.S_Dolar, yychar, yyline, yytext());}



/* Guion Bajo */
( "," ) {return new Symbol(sym.coma, yychar, yyline, yytext());}

/* Guion D_Punto */
( ":" ) {return new Symbol(sym.D_Punto, yychar, yyline, yytext());}

 
/* Identificador */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}

/* Numero */
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}



/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

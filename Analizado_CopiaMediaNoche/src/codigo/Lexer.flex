package codigo;
import static codigo.Tokens.*;

%%
%unicode

%class Lexer
%type Tokens

simboloX  = [|°¬!#$%&/()='?¿¡´¨+*{}]`,;.:-_<>]

L_Alone = [a-zA-Z$_]
L = [a-zA-Z$_] [a-zA-Z0-9$_]*
D = [0-9]+
espacio=   [\n|\r|\r\n]+
%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

/* Salto de linea */
( "\n" ) {return Linea;}

/* Comillas */
( "\"" ) {lexeme=yytext(); return Comillas;}


/* Comillas */
( "\'" ) {lexeme=yytext(); return Comiilas_Simples;}
 
/* Tipos de datos */
( char ) {lexeme=yytext(); return Type_Char;}

/* Tipos de datos */
( float ) {lexeme=yytext(); return Type_Float;}

/* Tipo de dato String */
( string ) {lexeme=yytext(); return Cadena;}



/* Tipo de dato String */
( bool ) {lexeme=yytext(); return Type_Bool;}

/* Palabra reservada If */
( if ) {lexeme=yytext(); return If;}

/* Palabra reservada Else */
( else ) {lexeme=yytext(); return Else;}

 

/* Palabra reservada While */
( while ) {lexeme=yytext(); return While;}


/* Palabra reservada Switch */
( switch ) {lexeme=yytext(); return Switch;}


/* Tipo de dato int */
( int ) {lexeme=yytext(); return Type_Int;}


/* Boolean  true */
( true ) {lexeme=yytext(); return True;}

/* Boolean  false */
( false ) {lexeme=yytext(); return False;}


 
/* Simbolo Punto */
( "." ) {lexeme=yytext(); return Punto;}

/* Palabra reservada  case */
( case ) {lexeme=yytext(); return Case;}

/* Palabra reservada  case */
( Def ) {lexeme=yytext(); return Def;}




/* Palabra reservada  default */
( default ) {lexeme=yytext(); return Default;}


/* Palabra reservada Break */
( break ) {lexeme=yytext(); return Break;}

 


/* Palabra reservada Null */
( print ) {lexeme=yytext(); return Print;}

/* Palabra reservada Null */
( read ) {lexeme=yytext(); return Read;}


/* Palabra reservada Null */
( null ) {lexeme=yytext(); return Null;}



/* Palabra reservada Return */
( return ) {lexeme=yytext(); return Return;}


/* Operador Igual */
( "=" ) {lexeme=yytext(); return Igual;}

/* Operador Suma */
( "+" ) {lexeme=yytext(); return Suma;}

/* Operador Resta */
( "-" ) {lexeme=yytext(); return Resta;}


/* Operador potencias */
( "^" ) {lexeme=yytext(); return Potencia;}



/* Operador potencias */
( "~" ) {lexeme=yytext(); return Modular;}

/* Operador Multiplicacion */
( "*" ) {lexeme=yytext(); return Multiplicacion;}

/* Operador Division */
( "/" ) {lexeme=yytext(); return Division;}

/* Operadores logicos */
(    "&" | or  ) {lexeme=yytext(); return Op_logico;}

/*Operadores Relacionales */
( ">" | "<" | "==" | "!=" | ">=" | "<=" ) {lexeme = yytext(); return Op_relacional;}

/* Operadores Atribucion */
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return Op_atribucion;}

/* Operadores Incremento y decremento */
( "++" | "--" ) {lexeme = yytext(); return Op_incremento;}
 
/* Parentesis de apertura */
( "(" ) {lexeme=yytext(); return Parentesis_a;}

/* Parentesis de cierre */
( ")" ) {lexeme=yytext(); return Parentesis_c;}

/* Llave de apertura */
( "{" ) {lexeme=yytext(); return Llave_a;}

/* Llave de cierre */
( "}" ) {lexeme=yytext(); return Llave_c;}

/* Corchete de apertura */
( "[" ) {lexeme = yytext(); return Corchete_a;}

/* Corchete de cierre */
( "]" ) {lexeme = yytext(); return Corchete_c;}

/* Marcador de inicio de algoritmo */
( "main" ) {lexeme=yytext(); return Main;}

/* Punto y coma xD */
( "#" ) {lexeme=yytext(); return P_coma;}

/* Guion Bajo */
( "_" ) {lexeme=yytext(); return G_Bajo;}

/* Simbolo Dolar */
( "$" ) {lexeme=yytext(); return S_Dolar;}


/* Simbolo Dolar */
( "," ) {lexeme=yytext(); return coma;}


/* Simbolo D_Punto */
( ":" ) {lexeme=yytext(); return D_Punto;}
 
/* Simbolo Not */
( not ) {lexeme=yytext(); return Not;}

 

 
/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* Numero */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}



/* Error de analisis */
 . {return ERROR;}

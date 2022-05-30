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

%{
	//Almacena el valor al leer strings
	StringBuffer string = new StringBuffer();

    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

//---Declaraciones---

FinLinea = \n|\r|\r\n
EspacioBlanco = {FinLinea} | [ \t\f]

CaracterComentario = [^\r\n]
Comentario = {ComentarioMulti} | {ComentarioLinea}
ComentarioMulti = "/*" [^*] ~"*/" | "/*" "*"+ "/"
ComentarioLinea = "//" {CaracterComentario}* {FinLinea}

Identificador = [:jletter:][:jletterdigit:]*

Entero = 0 | {EnteroPositivo} | {EnteroNegativo}
EnteroPositivo = [1-9][0-9]*
EnteroNegativo = -{EnteroPositivo}

Flotante = {FlotanteCero} | {FlotantePositivo} | {FlotanteNegativo}
FlotanteCero = 0 \. [0-9]+
FlotantePositivo = {EnteroPositivo} \. [0-9]+
FlotanteNegativo = - ({FlotanteCero}|{FlotantePositivo})

CaracterString = [^\r\n\"\\]
CaracterChar = [^\r\n\'\\]

//Estados adicionales
%state STRING, CHAR

%%
//---Reglas lexicas---

<YYINITIAL> {
	// Tipos de datos
	( bool )	{return new Symbol(sym.Type_Bool, yychar, yyline, yytext());}
	( char )	{return new Symbol(sym.Type_Char, yychar, yyline, yytext());}
	( float )	{return new Symbol(sym.Type_Float, yychar, yyline, yytext());}
	( int )		{return new Symbol(sym.Type_Int, yychar, yyline, yytext());}
	( string )	{return new Symbol(sym.Cadena, yychar, yyline, yytext());}

	// Palabras reservadas
	( break )	{return new Symbol(sym.Break, yychar, yyline, yytext());}
	( case )	{return new Symbol(sym.Case, yychar, yyline, yytext());}
	( default )	{return new Symbol(sym.Default, yychar, yyline, yytext());}
	( else )	{return new Symbol(sym.Else, yychar, yyline, yytext());}
	( if )		{return new Symbol(sym.If, yychar, yyline, yytext());}
	( "main" )	{return new Symbol(sym.Main, yychar, yyline, yytext());}
	( null )	{return new Symbol(sym.Null, yychar, yyline, yytext());}
	( print )	{return new Symbol(sym.Print, yychar, yyline, yytext());}  
	( read )	{return new Symbol(sym.Read, yychar, yyline, yytext());}  
	( return )	{return new Symbol(sym.Return, yychar, yyline, yytext());}
	( switch )	{return new Symbol(sym.Switch, yychar, yyline, yytext());}
	( while )	{return new Symbol(sym.While, yychar, yyline, yytext());}
	
	( Def )		{return new Symbol(sym.Def, yychar, yyline, yytext());}  
	
	//Extension
	( for )		{return new Symbol(sym.For, yychar, yyline, yytext());}  
	( static )	{return new Symbol(sym.Static, yychar, yyline, yytext());} 
	( struct )	{return new Symbol(sym.Struct, yychar, yyline, yytext());}

	//Separadores
	( "." )		{return new Symbol(sym.Punto, yychar, yyline, yytext());}
	( "(" )		{return new Symbol(sym.Parentesis_a, yychar, yyline, yytext());}
	( ")" )		{return new Symbol(sym.Parentesis_c, yychar, yyline, yytext());}
	( "{" )		{return new Symbol(sym.Llave_a, yychar, yyline, yytext());}
	( "}" )		{return new Symbol(sym.Llave_c, yychar, yyline, yytext());}
	( "[" )		{return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}
	( "]" )		{return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}
	( "#" )		{return new Symbol(sym.P_coma, yychar, yyline, yytext());}
	( ":" )		{return new Symbol(sym.D_Punto, yychar, yyline, yytext());}
	( "," )		{return new Symbol(sym.coma, yychar, yyline, yytext());}
	( "_" )		{return new Symbol(sym.G_Bajo, yychar, yyline, yytext());}
	( "$" )		{return new Symbol(sym.S_Dolar, yychar, yyline, yytext());}
	 
	//Operadores
	( "=" )		{return new Symbol(sym.Igual, yychar, yyline, yytext());}
	( not )		{return new Symbol(sym.Not, yychar, yyline, yytext());}
	
	( "+" )		{return new Symbol(sym.Suma, yychar, yyline, yytext());}
	( "-" )		{return new Symbol(sym.Resta, yychar, yyline, yytext());}
	( "^" )		{return new Symbol(sym.Potencia, yychar, yyline, yytext());}
	( "~" )		{return new Symbol(sym.Modular, yychar, yyline, yytext());}
	( "*" )		{return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
	( "/" )		{return new Symbol(sym.Division, yychar, yyline, yytext());}

	/* Operadores logicos */
	( "&" | or )								{return new Symbol(sym.Op_logico, yychar, yyline, yytext());}

	/*Operadores Relacionales */
	( ">" | "<" | "==" | "!=" | ">=" | "<=" )	{return new Symbol(sym.Op_relacional, yychar, yyline, yytext());}

	/* Operadores Atribucion */
	( "+=" | "-="  | "*=" | "/=" | "%=" | "=" )	{return new Symbol(sym.Op_atribucion, yychar, yyline, yytext());}

	/* Operadores Incremento y decremento */
	( "++" | "--" )								{return new Symbol(sym.Op_incremento, yychar, yyline, yytext());}

	//Literales
	//-Numeros
	{Entero}				{return new Symbol(sym.Lit_Entero, yychar, yyline, yytext());}
	{Flotante}				{return new Symbol(sym.Lit_Flotante, yychar, yyline, yytext());}
	
	( "true" | "false" )	{return new Symbol(sym.Lit_Bool, yychar, yyline, yytext());}
	
	//-Chars (Cambio de seccion)
	( "\'" )				{yybegin(CHAR);}
	
	//-Strings (Cambio de seccion)
	( "\"" )				{yybegin(STRING); string.setLength(0);}
	
	
	//Identificador
	{Identificador}			{return new Symbol(sym.Identificador, yychar, yyline, yytext());}
	
	//Comentarios
	{Comentario}			{ /* Ignorar */ }
	
	//Espacio en blanco
	{EspacioBlanco}			{ /* Ignorar */ }
}
	 
<STRING> {
	\"					{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_String, yychar, yyline, string.toString());}
	{CaracterString}+	{string.append( yytext() );}
	
	//Secuencias de escape de caracteres
	"\\b"				{string.append( '\b' );}
	"\\t"				{string.append( '\t' );}
	"\\n"				{string.append( '\n' );}
	"\\f"				{string.append( '\f' );}
	"\\r"				{string.append( '\r' );}
	"\\\""				{string.append( '\"' );}
	"\\'"				{string.append( '\'' );}
	"\\\\"				{string.append( '\\' );}
}

<CHAR> {
	{CaracterChar}\'	{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, yytext().charAt(0));}
	
	//Secuencias de escape de caracteres
	"\\b"\'				{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\b');}
	"\\t"\'				{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\t');}
	"\\n"\'				{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\n');}
	"\\f"\'				{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\f');}
	"\\r"\'				{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\r');}
	"\\\""\'			{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\"');}
	"\\'"\'				{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\'');}	
	"\\\\"\'			{yybegin(YYINITIAL);
						 return new Symbol(sym.Lit_Char, yychar, yyline, '\\');}
}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
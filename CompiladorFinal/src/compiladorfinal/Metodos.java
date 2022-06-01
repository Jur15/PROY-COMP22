/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiladorfinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Yeudi
 */
public class Metodos {
    
    
    
   public static ArrayList<String> Lista_Declaraciones = new ArrayList<String>();

   public static ArrayList<String> Lista_ErroresSemanticos = new ArrayList<String>();


   public static Map<String , Object> symbolTable  =  new HashMap<String, Object>();

   public static ArrayList<Token> LISTATOKEN  =  new ArrayList<Token>();
 
   
   public static String devuelveTipo_TOKEN(String nombreVar){
       
         // si retorna 1 es porque ya el token esta agregado
                for (Token tok : LISTATOKEN) {
                    if(tok.getNombre().equals(nombreVar)){
                         
                         
                         return tok.getTipo();

                    }
                    
                }
       
      
     return "vacio";
   
   }
   
    
   public static int validaExisteTOKEN(String nombreVar){
          // si retorna 1 es porque ya el token esta agregado
                for (Token cadena : LISTATOKEN) {
                    if(cadena.getNombre().equals(nombreVar)){
                        
                       return 1;
                    }
                    
                }
       
      
     return 0;
   
   }
   
   
   public static void PermiteAgregarToken(String tipo, String nombre){
   
       Boolean band = true;

       
       if(validaExisteTOKEN(nombre) != 1){
          
            Token tk = new Token();
            tk.setTipo(tipo);
            tk.setNombre(nombre);
            LISTATOKEN.add(tk);
            band = false;
       }
       
       if (band == true){
         Lista_ErroresSemanticos.add("La variable "+ nombre +" ya fue declarada. Utilice otro nombre ");
       
       }
       
   }
   
   public static void ConfimarExistencia( String nombre){
   
       Boolean band = true;

       
       if(validaExisteTOKEN(nombre) != 1){
          
          Lista_ErroresSemanticos.add("ERROR SEMANTICO variable "+ nombre +" no ha sido declarada");
       }
       
   }
   
         // se accede puede cambiar el valor de una variable en caso de existir
    public static void ModificaValor(String nombreVar, String valor) {

        if (validaExisteTOKEN(nombreVar) == 1) {
            // EN CASO DE SER INT
             if (devuelveTipo_TOKEN(nombreVar).equals("int")) {
         
                int posVariable = Devuelve_PosicionVariable(nombreVar);
                CambiarValor_STRING_INT(posVariable, valor, nombreVar);
            }
                // EN CASO DE SER CHAR o string
                if (devuelveTipo_TOKEN(nombreVar).equals("char") || devuelveTipo_TOKEN(nombreVar).equals("string")) {

                    int posVar = Devuelve_PosicionVariable(nombreVar); 
                    LISTATOKEN.get(posVar).setVslorString(valor);
                } 
                // EN CASO DE SER FLOAT
                if (devuelveTipo_TOKEN(nombreVar).equals("float")) {

                    int posVariable = Devuelve_PosicionVariable(nombreVar);
                    CambiarValor_STRING_FLOAT(posVariable, valor, nombreVar);

                }
                // EN CASO DE SER BOOL
                if (devuelveTipo_TOKEN(nombreVar).equals("bool")) {

                    int posVariable = Devuelve_PosicionVariable(nombreVar);
                    CambiarValor_STRING_BOOL(posVariable, valor, nombreVar);

                }

        }  
        
    }
   
   public static void  CambiarValor_STRING_INT(int posVariable, String valor, String nombreVar){
     try {
                   int valorInt = Integer.parseInt(valor);
                   
                   LISTATOKEN.get(posVariable).setValorEntero(valorInt);
                   System.out.println("Se ha modificado con exito el valor de la variable " + nombreVar);
                   System.out.println("El valor es " + valorInt);

                   
                } catch (NumberFormatException ex) {

         System.out.println("No se puede hacer la conversion de tipos");
               }
           }
   
   public static void  CambiarValor_STRING_FLOAT(int posVariable, String valor, String nombreVar){
     try {
 
             float valorFlotante = Float.parseFloat(valor);
 
            LISTATOKEN.get(posVariable).setValorFlotante(valorFlotante);
            System.out.println("Se ha modificado con exito el valor de la variable " + nombreVar);
            System.out.println("El valor es " + valorFlotante);

        } catch (NumberFormatException ex) {

            System.out.println("No se puede hacer la conversion de tipos");

            System.out.println("");
        }
    }
   
   
   public static void  CambiarValor_STRING_BOOL(int posVariable, String valor, String nombreVar){
     try {
 

 
                Boolean boolObj = Boolean.valueOf(valor);
            LISTATOKEN.get(posVariable).setValorBool(boolObj);
            System.out.println("Se ha modificado con exito el valor de la variable " + nombreVar);
            System.out.println("El valor es " + boolObj);

        } catch (NumberFormatException ex) {

            System.out.println("No se puede hacer la conversion de tipos");

            System.out.println("");
        }
    }
   
  
    
   
   
   public static int Devuelve_PosicionVariable( String nombre){
      
       for (int i = 0; i < LISTATOKEN.size(); i++) {
           if(LISTATOKEN.get(i).getNombre().equals(nombre)){
              return i;
           }
       }
     return 777;                  
                  
                  
                  
              
              }
        
     
   
   }   
     
     
    
    
 
   

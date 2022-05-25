 
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class Principal {
    
    public static String miRuta = "C:/Users/jeudy/Music/SEGUNDOPROYECTO/Analizado_CopiaMediaNoche";

    public static void main(String[] args) throws Exception {
        
        String ruta1 = miRuta + "/src/codigo/Lexer.flex";
        String ruta2 = miRuta + "/src/codigo/LexerCup.flex";
        //  C:/Users/jeudy/Downloads/Proyecto-_Compiladores-main/Proyecto-_Compiladores-main/AnalizadorLexico/AnalizadorLexico/src/codigo/Sintax.cup
   
        String[] rutaS = {"-parser", "Sintax",miRuta+"/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get(miRuta+"/src/codigo/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(miRuta+"/sym.java"), 
                Paths.get(miRuta+"/src/codigo/sym.java")
        );
        Path rutaSin = Paths.get(miRuta+"/src/codigo/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(miRuta+"/Sintax.java"), 
                Paths.get(miRuta+"/src/codigo/Sintax.java")
        );
    }
}

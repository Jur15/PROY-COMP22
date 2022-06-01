package compiladorfinal;

import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.HashSet;
import java_cup.runtime.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MrCante
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    String Entrada = "";
    int conta = 0;
    public static String[][] ts = new String[100][7]; //Array en donde se almacena en forma temporal todos los ID encontrados

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TxtEntrada = new javax.swing.JTextArea();
        BtnAnalziar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblTS = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtErrores = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TxtErroresLexicos = new javax.swing.JTextArea();
        LblResultado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnAnalziar1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextSemantico = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtEntrada.setColumns(20);
        TxtEntrada.setRows(5);
        TxtEntrada.setText("bool a#\na = true#\nb = false#\na = false#\nint ab#\nint x#\npepe = 2#\nint main(){}");
        jScrollPane1.setViewportView(TxtEntrada);

        BtnAnalziar.setBackground(new java.awt.Color(0, 204, 204));
        BtnAnalziar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnAnalziar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAnalziar.setText("Analizar");
        BtnAnalziar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnalziarActionPerformed(evt);
            }
        });

        TblTS.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        TblTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema ", "Reservada", "ID", "Caracter", "Numeral", "Simbolo", "Tipo"
            }
        ));
        jScrollPane3.setViewportView(TblTS);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Analisis Semantico");

        TxtErrores.setColumns(20);
        TxtErrores.setRows(5);
        jScrollPane2.setViewportView(TxtErrores);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Tabla simbolos");

        TxtErroresLexicos.setColumns(20);
        TxtErroresLexicos.setRows(5);
        jScrollPane4.setViewportView(TxtErroresLexicos);

        LblResultado.setBackground(new java.awt.Color(255, 204, 153));
        LblResultado.setText("RESULTADO:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Analisis Lexico");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Analisis Sintactico");

        BtnAnalziar1.setBackground(new java.awt.Color(0, 204, 204));
        BtnAnalziar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BtnAnalziar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnAnalziar1.setText("Buscar Errores");
        BtnAnalziar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnalziar1ActionPerformed(evt);
            }
        });

        jTextSemantico.setColumns(20);
        jTextSemantico.setRows(5);
        jScrollPane5.setViewportView(jTextSemantico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(LblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAnalziar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAnalziar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(470, 470, 470))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 123, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel6)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(462, 462, 462))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(LblResultado)
                        .addGap(29, 29, 29)
                        .addComponent(BtnAnalziar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnAnalziar1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAnalziarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnalziarActionPerformed

        
        Metodos.Lista_ErroresSemanticos.clear();
        LblResultado.removeAll();
        TxtErrores.removeAll();
        TxtErroresLexicos.removeAll();
        Entrada = TxtEntrada.getText(); //CARGAR TEXTO EN VARIABBLE
        
        
         //Analisis lexico
        try {
            new parser(new Lexico(new BufferedReader(new StringReader(Entrada)))).parse();
            mostrarListas();//MOSTRAR EL VALOR DE LAS LINKEDLISTDE CADA           
            LblResultado.setText("Compilado Exitosamente");
            LblResultado.setForeground(new Color(25, 111, 61));

        } catch (Exception ex) {
            LblResultado.setText("No se ha podido compilar");
            LblResultado.setForeground(Color.RED);

            TxtErroresLexicos.setText("" + Lexico.ErroresLexicos);
            TxtErrores.setText("" + parser.Errores);
        }

    }//GEN-LAST:event_BtnAnalziarActionPerformed

    private void BtnAnalziar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnalziar1ActionPerformed
// Imprime lista de errores semanticos
       jTextSemantico.removeAll();
        Metodos.Lista_ErroresSemanticos.forEach(t -> {
            
            jTextSemantico.append(t+"\n");
             jTextSemantico.setForeground(Color.RED);

        }); // TODO add your handling code here:
    }//GEN-LAST:event_BtnAnalziar1ActionPerformed

    //LISTAS PARA GENERAR TABLA DE SIMBOLOS
    public void mostrarListas() {

        //ELIMINAR DUPLICADOS CON HasSet, se le pasa la lista, se limpia la lista antigua y luego se recarga la nueva lista
        // TOKEN - PR - IDENTIFICADOR - CADENA - NUMERO - SIMBOLO - TIPO
        //PALABRAS RESERVADAS
        HashSet<String> hashSet = new HashSet<String>(parser.PalabraReservada);
        parser.PalabraReservada.clear();
        parser.PalabraReservada.addAll(hashSet);

        for (String cadena : parser.PalabraReservada) {
            System.out.println(conta + " Palabra Reservada: " + cadena);
            ts[conta][0] = conta + ". " + cadena;
            ts[conta][1] = "x";
             
            ts[conta][2] = "";
            ts[conta][3] = "";
            ts[conta][4] = "";
            ts[conta][5] = "";
            ts[conta][6] = "";
            conta++;
        }

        //VALORES VARIABLES
        HashSet<String> hashSet5 = new HashSet<String>(parser.Variables);
        parser.Variables.clear();
        parser.Variables.addAll(hashSet5);

        for (String cadena : parser.Variables) {
            
          
            
            System.out.println(conta + " Variables: " + cadena);
            ts[conta][0] = conta + ". " + cadena;
            
            ts[conta][2] = "x";
            ts[conta][6] = "";
            ts[conta][1] = "";
            ts[conta][3] = "";
            ts[conta][4] = "";
            ts[conta][5] = "";
            ts[conta][6] = "";
            conta++;
        }

        // TOKEN - PR - IDENTIFICADOR - CADENA - NUMERO - SIMBOLO - TIPO
        //CADENAS
        HashSet<String> hashSet3 = new HashSet<String>(parser.Cadenas);
        parser.Cadenas.clear();
        parser.Cadenas.addAll(hashSet3);

        for (String cadena : parser.Cadenas) {
            System.out.println(conta + " Cadena: " + cadena);
            ts[conta][0] = conta + ". " + cadena;
            ts[conta][3] = "x";
            ts[conta][6] = "String";
            ts[conta][2] = "";
            ts[conta][1] = "";
            ts[conta][4] = "";
            ts[conta][5] = "";
            conta++;
        }

        //VALORES NUMÉRICOS
        HashSet<String> hashSet4 = new HashSet<String>(parser.ValoresNumericos);
        parser.ValoresNumericos.clear();
        parser.ValoresNumericos.addAll(hashSet4);

        for (String cadena : parser.ValoresNumericos) {
            System.out.println(conta + " Valores numéricos: " + cadena);
            ts[conta][0] = conta + ". " + cadena;
            ts[conta][4] = "x";
            ts[conta][6] = "Float";
            ts[conta][2] = "";
            ts[conta][3] = "";
            ts[conta][1] = "";
            ts[conta][5] = "";
            conta++;
        }

        //SIMBOLOS
        HashSet<String> hashSet2 = new HashSet<String>(parser.Simbolo);
        parser.Simbolo.clear();
        parser.Simbolo.addAll(hashSet2);

        for (String cadena : parser.Simbolo) {
            System.out.println(conta + " Simbolo: " + cadena);
            ts[conta][0] = conta + ". " + cadena;
            ts[conta][5] = "x";
            ts[conta][2] = "";
            ts[conta][3] = "";
            ts[conta][4] = "";
            ts[conta][1] = "";
            ts[conta][6] = "";
            conta++;
        }

        // TOKEN - PR - IDENTIFICADOR - CADENA - NUMERO - SIMBOLO - TIPO
        for (int i = 0; i < conta - 1; i++) {
            System.out.println("Token: " + ts[i][0] + " Reservada: " + ts[i][1] + " IDENT: " + ts[i][2] + " CADENA: " + ts[i][3] + " NUMERO: " + ts[i][4] + " SIMBOLO: " + ts[i][5] + " TIPO: " + ts[i][6]);
        }
        TblTS.removeAll();

        cargarTabla();
    }

    public void cargarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TblTS.getModel();

        Object[] miTabla = new Object[7]; //Creo un Objeto de tres campos

        for (int i = 0; i < conta - 1; i++) {

            miTabla[0] = ts[i][0]; //token
            miTabla[1] = ts[i][1]; //palabra reservada
            miTabla[2] = ts[i][2]; //identificador
            miTabla[3] = ts[i][3]; //cadena
            miTabla[4] = ts[i][4]; //numero
            miTabla[5] = ts[i][5]; //simbolo
            miTabla[6] = ts[i][6]; //tipo
            modelo.addRow(miTabla); //Se agrega un nuevo registro a la tabla y se envia el objeto creado
            TblTS.setModel(modelo); //se pasa el modelo a la tabla...   
        }
    }

    //RECORRER ARBOL
    public static String recorrido(Nodo raiz) {
        String cuerpo = "";
        for (Nodo hijos : raiz.getHijos()) {

            cuerpo += "\"" + raiz.getIdNod() + "." + raiz.getEtiqueta() + "=" + raiz.getValor() + "\"->\"" + hijos.getIdNod() + "." + hijos.getEtiqueta() + "=" + hijos.getValor() + "\"";
            //System.out.println("Cuerpo: " + cuerpo);
            cuerpo += recorrido(hijos);
        }
        return cuerpo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnalziar;
    private javax.swing.JButton BtnAnalziar1;
    private javax.swing.JLabel LblResultado;
    private javax.swing.JTable TblTS;
    private javax.swing.JTextArea TxtEntrada;
    private javax.swing.JTextArea TxtErrores;
    private javax.swing.JTextArea TxtErroresLexicos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextSemantico;
    // End of variables declaration//GEN-END:variables

}

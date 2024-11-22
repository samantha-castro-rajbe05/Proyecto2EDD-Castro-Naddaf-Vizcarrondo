/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Functions.Cargar;
import Functions.Linaje;
import Interfaces.Menu;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author samantha
 */
public class UploadFile extends javax.swing.JFrame {
    //private javax.swing.JButton cargarArchivoActionPerformed;
    //private javax.swing.JButton buscarArchivoActionPerformed;
    //private javax.swing.JButton exitActionPerformed;
    

    
    /**
     * Creates new form UploadFile
     */
    public UploadFile() {
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ruta = new javax.swing.JTextField();
        cargarArchivo = new javax.swing.JButton();
        buscarArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        archivo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit.setBackground(new java.awt.Color(204, 204, 204));
        exit.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 40, -1));

        jLabel1.setFont(new java.awt.Font("Palatino", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("CARGAR ARCHIVO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        ruta.setBackground(new java.awt.Color(204, 204, 204));
        ruta.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        ruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaActionPerformed(evt);
            }
        });
        jPanel1.add(ruta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 340, -1));

        cargarArchivo.setBackground(new java.awt.Color(204, 204, 204));
        cargarArchivo.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        cargarArchivo.setText("Cargar");
        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(cargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 340, -1));

        buscarArchivo.setBackground(new java.awt.Color(204, 204, 204));
        buscarArchivo.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        buscarArchivo.setText("Buscar archivo");
        buscarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(buscarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        archivo.setBackground(new java.awt.Color(204, 204, 204));
        archivo.setColumns(20);
        archivo.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        archivo.setRows(5);
        jScrollPane1.setViewportView(archivo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 340, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void buscarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarArchivoActionPerformed
        JFileChooser fc = new JFileChooser();
        //para filtrar archivo json :)
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)","json");
        
        //asigno el filtro
        fc.setFileFilter(filtro);
        
        //se abre la ventana y guarda la opcion seleccionada
        int seleccion = fc.showOpenDialog(this);
        
        //si el usuario acepta
        if(seleccion == JFileChooser.APPROVE_OPTION){
            
            //damos la opción para seleccionar el fichero
            File fichero = fc.getSelectedFile();
            
            //lo pasamos a un JTextField
            ruta.setText(fichero.getAbsolutePath());
            try (FileReader fr = new FileReader(fichero)) {
                StringBuilder cadena = new StringBuilder();
                int valor = fr.read(); 
                
                //leemos contenido del json
                while (valor!= -1){
                    cadena.append((char)valor);
                    valor = fr.read();
                }
                
                //Mostramos el archivo en el JTextArea
                archivo.setText(cadena.toString());
                
            } catch(IOException e1){
                   e1.printStackTrace();
            }
            
            }else {//si el usuario no seleccionó ningún archivo mostramos mensaje de error
                JOptionPane.showMessageDialog(this, "No se ha seleccionado ningún archivo");
            }
        
    }//GEN-LAST:event_buscarArchivoActionPerformed

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed
        if (!archivo.getText().isEmpty()) {
            Cargar func = new Cargar();
            func.cargar(ruta.getText());

            //print para ver si esta funcionando esta funcion
            //System.out.println(redApp.toString());
            JOptionPane.showMessageDialog(null, "Archivo cargado exitosamente");
            // Obtenemos el linaje cargado
            String linaje = func.getNombreLinaje();

            // Imprimimos el linaje
            JOptionPane.showMessageDialog(null, linaje);
            Menu menu = new Menu();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún archivo");
        }
        // Dentro del ActionListener del botón "Cargar"
//JFileChooser fileChooser = new JFileChooser();
//int seleccion = fileChooser.showOpenDialog(null);
//if (seleccion == JFileChooser.APPROVE_OPTION) {
//    File archivoSeleccionado = fileChooser.getSelectedFile();
//    String rutaArchivo = archivoSeleccionado.getAbsolutePath();
//
//    // Crear instancia del gestor y cargar el archivo
//    GestorGenealogico gestor = new GestorGenealogico();
//    gestor.cargar(rutaArchivo);
//
//    // Obtener el árbol genealógico y el nombre del linaje
//    Arbol<Persona> arbol = gestor.getArbolGenealogico();
//    String nombreLinaje = gestor.getNombreLinaje();
//
//    // Mostrar el nombre del linaje en la interfaz
//    lblNombreLinaje.setText("Linaje cargado: " + nombreLinaje);
//
//    // Aquí puedes continuar con la visualización del árbol o cualquier otra funcionalidad
//}
//
    }//GEN-LAST:event_cargarArchivoActionPerformed

    private void rutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaActionPerformed

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
        java.util.logging.Logger.getLogger(UploadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(UploadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(UploadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(UploadFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new UploadFile().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea archivo;
    private javax.swing.JButton buscarArchivo;
    private javax.swing.JButton cargarArchivo;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ruta;
    // End of variables declaration//GEN-END:variables
}


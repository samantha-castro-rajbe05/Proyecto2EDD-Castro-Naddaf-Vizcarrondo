/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Cargas.CargarJSON;
import Cargas.FileChooser;
import Funciones.MostrarArbol;
import Funciones.Validar;
import Principal.App;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

/**
 *
 * @author samantha
 */
public class Welcome extends javax.swing.JFrame {

    public static App gestionApp = new App();
    public static Validar validar = new Validar();
    /**
     * Creates new form Welcome
     */
    public Welcome() {
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
        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Palatino", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("BIENVENIDO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        start.setBackground(new java.awt.Color(204, 204, 204));
        start.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        start.setText("Empezar");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        jPanel1.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, -1));

        exit.setBackground(new java.awt.Color(204, 204, 204));
        exit.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jPanel1.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 40, -1));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Integrantes: Samantha Castro, Peter Naddaf, Gabriel Vizcarrondo");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/chair.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        CargarJSON cargarArchivo = new CargarJSON(); // Utiliza la clase CargarJSON
        FileChooser abrir = new FileChooser(this);   // Utiliza la clase FileChooser

        // Abrir selector de archivos para obtener la ruta del archivo JSON
        String ruta = abrir.abrirArchivo();

        try {
            // Intentar cargar el archivo seleccionado
            cargarArchivo.cargarDesdeJSON(ruta);

            // Verificar si se cargó correctamente
            if (cargarArchivo.getArbolGenealogico() != null) {
                JOptionPane.showMessageDialog(null, "Carga exitosa");
                JOptionPane.showMessageDialog(null, cargarArchivo.getLinaje());

                // Configurar la clase App con las estructuras cargadas
                gestionApp.setArbolFamiliar(cargarArchivo.getArbolGenealogico());
                gestionApp.setPersonasHash(cargarArchivo.getTablaPersonas());
                gestionApp.setLinajeFamilia(cargarArchivo.getLinaje());

                Menu menu = new Menu();
                this.dispose(); 
//                System.setProperty("org.graphstream.ui", "swing");
//                MostrarArbol verArbol = new MostrarArbol(gestionApp.getArbolFamiliar());
//                verArbol.setVisible(true);
//                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Hay errores en el JSON");
            }
        } catch (FileNotFoundException ex) {
            // Manejo de excepción si no se encuentra el archivo

        }
               
        
        
    }//GEN-LAST:event_startActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}

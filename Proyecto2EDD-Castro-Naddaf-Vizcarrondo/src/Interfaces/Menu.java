/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;
import Funciones.MostrarArbol;
import Interfaces.BuscarPorNombre;
import static Interfaces.Welcome.gestionApp;
/**
 *
 * @author samantha
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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
        buscarPorNombre = new javax.swing.JButton();
        buscarPorTitulo = new javax.swing.JButton();
        cargarArchivo = new javax.swing.JButton();
        mostrarArbol = new javax.swing.JButton();
        mostrarAntepasados = new javax.swing.JButton();
        listaGeneracion = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("MENÚ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        buscarPorNombre.setBackground(new java.awt.Color(204, 204, 204));
        buscarPorNombre.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        buscarPorNombre.setText("Buscar por nombre");
        buscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorNombreActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        buscarPorTitulo.setBackground(new java.awt.Color(204, 204, 204));
        buscarPorTitulo.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        buscarPorTitulo.setText("Buscar por título");
        buscarPorTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorTituloActionPerformed(evt);
            }
        });
        jPanel1.add(buscarPorTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        cargarArchivo.setBackground(new java.awt.Color(204, 204, 204));
        cargarArchivo.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        cargarArchivo.setText("Cargar archivo");
        cargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarArchivoActionPerformed(evt);
            }
        });
        jPanel1.add(cargarArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        mostrarArbol.setBackground(new java.awt.Color(204, 204, 204));
        mostrarArbol.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        mostrarArbol.setText("Mostrar arbol");
        mostrarArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarArbolActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        mostrarAntepasados.setBackground(new java.awt.Color(204, 204, 204));
        mostrarAntepasados.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        mostrarAntepasados.setText("Mostrar antepasados");
        mostrarAntepasados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAntepasadosActionPerformed(evt);
            }
        });
        jPanel1.add(mostrarAntepasados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, -1));

        listaGeneracion.setBackground(new java.awt.Color(204, 204, 204));
        listaGeneracion.setFont(new java.awt.Font("Palatino", 0, 13)); // NOI18N
        listaGeneracion.setText("Lista integrantes de una generación");
        listaGeneracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaGeneracionActionPerformed(evt);
            }
        });
        jPanel1.add(listaGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/backgroundChair.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void buscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorNombreActionPerformed
        BuscarPorNombre buscarPorNombre = new BuscarPorNombre();
        this.dispose();
    }//GEN-LAST:event_buscarPorNombreActionPerformed

    private void mostrarArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarArbolActionPerformed
        System.setProperty("org.graphstream.ui", "swing");
        MostrarArbol verArbol = new MostrarArbol(gestionApp.getArbolFamiliar());
        verArbol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mostrarArbolActionPerformed

    private void mostrarAntepasadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAntepasadosActionPerformed
        Antepasados mostrarAntepasados = new Antepasados();
        this.dispose();
    }//GEN-LAST:event_mostrarAntepasadosActionPerformed

    private void listaGeneracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaGeneracionActionPerformed
        Generacion contemporaneos = new Generacion();
        this.dispose();
    }//GEN-LAST:event_listaGeneracionActionPerformed

    private void cargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarArchivoActionPerformed

        //abrimos ventana cargar
        UploadFile cargarRed = new UploadFile();
        //cerramos esta ventana
        this.dispose();
    }//GEN-LAST:event_cargarArchivoActionPerformed

    private void buscarPorTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorTituloActionPerformed
        BuscarPorTitulo buscarPorTitulo = new BuscarPorTitulo();
        this.dispose();
    }//GEN-LAST:event_buscarPorTituloActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPorNombre;
    private javax.swing.JButton buscarPorTitulo;
    private javax.swing.JButton cargarArchivo;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton listaGeneracion;
    private javax.swing.JButton mostrarAntepasados;
    private javax.swing.JButton mostrarArbol;
    // End of variables declaration//GEN-END:variables
}

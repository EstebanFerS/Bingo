/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bingo;

import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    Background bg = new Background("/Imagenes/BgMenuPrincipal.png");

    public MenuPrincipal() {
        setSize(1200, 800);
        this.setContentPane(bg);
        initComponents();
        jPanel.setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFullHouse = new javax.swing.JButton();
        BPatron = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BFullHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFullHouseActionPerformed(evt);
            }
        });
        getContentPane().add(BFullHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 480, 140));

        BPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPatronActionPerformed(evt);
            }
        });
        getContentPane().add(BPatron, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 480, 140));

        jPanel.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(jPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPatronActionPerformed
        try {
            int cantJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores: "));

            MenuAdmin ma = new MenuAdmin(cantJugadores);
            ma.setVisible(true);

            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido");
        }
    }//GEN-LAST:event_BPatronActionPerformed

    private void BFullHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFullHouseActionPerformed

        try {
            int cantJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores: "));

            MenuAdmin ma = new MenuAdmin(cantJugadores);
            ma.setVisible(true);

            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido");
        }
    }//GEN-LAST:event_BFullHouseActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFullHouse;
    private javax.swing.JButton BPatron;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bingo;

import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    Imagenes bg = new Imagenes("/Imagenes/BgMenuPrincipal.png");

    public MenuPrincipal() {
        setSize(1200, 800);
        this.setContentPane(bg);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFullHouse = new javax.swing.JButton();
        BPatron = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BFullHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BFullHouse.png"))); // NOI18N
        BFullHouse.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));
        BFullHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFullHouseActionPerformed(evt);
            }
        });
        getContentPane().add(BFullHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 430, 140));

        BPatron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BPatrones.png"))); // NOI18N
        BPatron.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));
        BPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPatronActionPerformed(evt);
            }
        });
        getContentPane().add(BPatron, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 430, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPatronActionPerformed
        try {
            int cantJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores: "));

            PanelControl pc = new PanelControl(cantJugadores);
            pc.setVisible(true);
            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido");
        }
    }//GEN-LAST:event_BPatronActionPerformed

    private void BFullHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFullHouseActionPerformed
        try {
            int cantJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores: "));

            PanelControl pc = new PanelControl(cantJugadores);
            pc.setVisible(true);
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
    // End of variables declaration//GEN-END:variables
}

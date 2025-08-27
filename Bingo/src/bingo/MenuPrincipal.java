/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bingo;

public class MenuPrincipal extends javax.swing.JFrame {

    Background bg = new Background("/Imagenes/BackgroundMenuPrincipal.png");

    public MenuPrincipal() {
        setSize(1200, 800);
        this.setContentPane(bg);
        initComponents();
        jPanel1.setOpaque(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BFullHouse = new javax.swing.JButton();
        BLinea = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 800));
        setMinimumSize(new java.awt.Dimension(1200, 800));
        setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BFullHouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFullHouseActionPerformed(evt);
            }
        });
        getContentPane().add(BFullHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 480, 140));

        BLinea.setLabel("");
        BLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLineaActionPerformed(evt);
            }
        });
        getContentPane().add(BLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 480, 140));
        BLinea.getAccessibleContext().setAccessibleName("");

        jPanel1.setLayout(new java.awt.GridLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLineaActionPerformed
        Linea ln = new Linea();
        ln.setVisible(true);
        ln.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BLineaActionPerformed

    private void BFullHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFullHouseActionPerformed
        FullHouse fh = new FullHouse();
        fh.setVisible(true);
        fh.setLocationRelativeTo(null);
        this.dispose();
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
    private javax.swing.JButton BLinea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

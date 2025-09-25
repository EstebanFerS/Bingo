package bingo;

import javax.swing.*;

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
        setResizable(false);
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
        Patron p = new Patron();
        PanelControl pc = new PanelControl(null, p);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        pc.setVisible(true);
        pc.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BPatronActionPerformed

    private void BFullHouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFullHouseActionPerformed
        String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
        if (nombre == null) {
            JOptionPane.showMessageDialog(this, "Juego cancelado.");
            return;
        }

        FullHouse fh = new FullHouse(nombre);
        fh.setLocationRelativeTo(null);
        fh.setVisible(true);

        PanelControl pc = new PanelControl(fh, null);
        pc.setLocationRelativeTo(null);
        pc.setVisible(true);

        fh.setPanelControl(pc);
        this.dispose();
    }//GEN-LAST:event_BFullHouseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFullHouse;
    private javax.swing.JButton BPatron;
    // End of variables declaration//GEN-END:variables
}

package bingo;

import javax.swing.*;
import java.awt.event.*;

public class Patron extends javax.swing.JFrame {

    private JButton[][] tablero = new JButton[5][5];
    private int[][] numeros = new int[5][5];
    private boolean[][] fichaHabilitada = new boolean[5][5];
    private boolean[][] fichaSeleccionada = new boolean[5][5];
    private boolean[][] patronActual;

    private patronesAleatorios generadorPatrones = new patronesAleatorios();

    public patronesAleatorios getGeneradorPatrones() {
        return generadorPatrones;
    }

    private PanelControl panelControl;

    public void setPanelControl(PanelControl pc) {
        this.panelControl = pc;
    }

    private void Tablero() {
        FichaAleatoria generador = new FichaAleatoria();

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {

                JButton boton = new JButton();
                int numero;

                if (fila == 2 && columna == 2) {
                    numero = 0;
                    fichaHabilitada[fila][columna] = true;
                } else {
                    numero = generador.GeneradorFicha();
                    fichaHabilitada[fila][columna] = false;
                }

                numeros[fila][columna] = numero;

                String ruta = "/Imagenes2/" + numero + ".png";
                boton.setContentAreaFilled(false);
                boton.setBorder(null);
                Imagenes img = new Imagenes(ruta);
                boton.setIcon(img.getIcono(126, 124));

                int f = fila;
                int c = columna;

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (fichaHabilitada[f][c]) {
                            Imagenes imgVolteada = new Imagenes("/Imagenes2/" + numero + ".png");
                            boton.setIcon(imgVolteada.getIcono(126, 124));

                            boton.setEnabled(false);
                            fichaHabilitada[f][c] = false;

                            fichaSeleccionada[f][c] = true;
                        }
                    }
                });

                tablero[fila][columna] = boton;
                jPTablero.add(boton);
            }
        }
    }

    private void generarPatron() {
        String nombrePatron = generadorPatrones.getNombrePatron();

        System.out.println("Nombre del patrón obtenido: " + nombrePatron);

        String ruta = "/Imagenes/" + nombrePatron + ".png";

        Imagenes img = new Imagenes(ruta);
        jLPatron.setIcon(img.getIcono(240, 200));
        jPPatron.revalidate();
        jPPatron.repaint();
    }

    public void mostrarFicha(int numero) {
        JPNumGenerado.removeAll();
        Imagenes img = new Imagenes("/Imagenes/" + numero + ".png");
        jLNumGenerado.setIcon(img.getIcono(190, 190));
        JPNumGenerado.add(jLNumGenerado);
        JPNumGenerado.revalidate();
        JPNumGenerado.repaint();

        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (numeros[fila][columna] == numero) {
                    fichaHabilitada[fila][columna] = true;
                }
            }
        }
    }

    private boolean validarPatron() {
        return generadorPatrones.validar(fichaSeleccionada);
    }

    public Patron() {
        initComponents();
        generarPatron();
        Tablero();

        String nombre = JOptionPane.showInputDialog(this, "Ingrese su nombre:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            jLNombreParticipante.setText(nombre);
        } else {
            jLNombreParticipante.setText("Anónimo");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBgBingo = new javax.swing.JPanel();
        jPTablero = new javax.swing.JPanel();
        jPPatron = new javax.swing.JPanel();
        jLPatron = new javax.swing.JLabel();
        JPNumGenerado = new javax.swing.JPanel();
        jLNumGenerado = new javax.swing.JLabel();
        jBBingo = new javax.swing.JToggleButton();
        jPParticipante = new javax.swing.JPanel();
        jLNombreParticipante = new javax.swing.JLabel();
        jLParticipante = new javax.swing.JLabel();
        lblBgBingo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(960, 700));

        jPBgBingo.setMinimumSize(new java.awt.Dimension(900, 700));
        jPBgBingo.setRequestFocusEnabled(false);
        jPBgBingo.setVerifyInputWhenFocusTarget(false);
        jPBgBingo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPTablero.setBackground(new java.awt.Color(255, 255, 255));
        jPTablero.setLayout(new java.awt.GridLayout(5, 5));
        jPBgBingo.add(jPTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 680));

        jPPatron.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));

        javax.swing.GroupLayout jPPatronLayout = new javax.swing.GroupLayout(jPPatron);
        jPPatron.setLayout(jPPatronLayout);
        jPPatronLayout.setHorizontalGroup(
            jPPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPatron, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );
        jPPatronLayout.setVerticalGroup(
            jPPatronLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLPatron, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        jPBgBingo.add(jPPatron, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 250, 210));

        JPNumGenerado.setBackground(new java.awt.Color(255, 255, 255));
        JPNumGenerado.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0))));
        JPNumGenerado.setForeground(new java.awt.Color(255, 255, 255));
        JPNumGenerado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLNumGenerado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout JPNumGeneradoLayout = new javax.swing.GroupLayout(JPNumGenerado);
        JPNumGenerado.setLayout(JPNumGeneradoLayout);
        JPNumGeneradoLayout.setHorizontalGroup(
            JPNumGeneradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPNumGeneradoLayout.createSequentialGroup()
                .addComponent(jLNumGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        JPNumGeneradoLayout.setVerticalGroup(
            JPNumGeneradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLNumGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPBgBingo.add(JPNumGenerado, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, 250, 190));

        jBBingo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/jBBingo.png"))); // NOI18N
        jBBingo.setText("BINGO");
        jBBingo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));
        jBBingo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBingoActionPerformed(evt);
            }
        });
        jPBgBingo.add(jBBingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 590, 250, 100));

        jPParticipante.setOpaque(false);
        jPParticipante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLNombreParticipante.setBackground(new java.awt.Color(204, 102, 0));
        jLNombreParticipante.setFont(new java.awt.Font("Microsoft Himalaya", 1, 48)); // NOI18N
        jLNombreParticipante.setForeground(new java.awt.Color(231, 144, 0));
        jLNombreParticipante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLNombreParticipante.setToolTipText("");
        jPParticipante.add(jLNombreParticipante, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, 60));

        jLParticipante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/jPParticipante.png"))); // NOI18N
        jLParticipante.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.white)));
        jPParticipante.add(jLParticipante, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 250, 130));

        jPBgBingo.add(jPParticipante, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 250, 140));

        lblBgBingo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bgFH.png"))); // NOI18N
        jPBgBingo.add(lblBgBingo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBgBingo, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBgBingo, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBingoActionPerformed
        if (validarPatron()) {
            JOptionPane.showMessageDialog(this, "¡BINGO! Has completado el patrón.");
            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Quieres jugar otra vez?",
                    "Nuevo Juego",
                    JOptionPane.YES_NO_OPTION
            );
            if (opcion == JOptionPane.YES_OPTION) {
                this.dispose();
                if (panelControl != null) {
                    panelControl.dispose();
                }
                new MenuPrincipal().setVisible(true);
            } else {
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: Todavía no completas el patrón.");
        }
    }//GEN-LAST:event_jBBingoActionPerformed

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
            java.util.logging.Logger.getLogger(Patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patron.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patron().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPNumGenerado;
    private javax.swing.JToggleButton jBBingo;
    private javax.swing.JLabel jLNombreParticipante;
    private javax.swing.JLabel jLNumGenerado;
    private javax.swing.JLabel jLParticipante;
    private javax.swing.JLabel jLPatron;
    private javax.swing.JPanel jPBgBingo;
    private javax.swing.JPanel jPParticipante;
    private javax.swing.JPanel jPPatron;
    private javax.swing.JPanel jPTablero;
    private javax.swing.JLabel lblBgBingo;
    // End of variables declaration//GEN-END:variables
}

package bingo;

import javax.swing.*;
import java.awt.event.*;

public class FullHouse extends javax.swing.JFrame {

    private JButton[][] tablero = new JButton[5][5];
    private int[][] numeros = new int[5][5];
    private boolean[][] fichaHabilitada = new boolean[5][5];
    private boolean[][] fichaSeleccionada = new boolean[5][5];

    private void tablero() {
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
                            Imagenes imgVolteada = new Imagenes("/Imagenes2/" + numeros[f][c] + ".png");
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

    public void tableroLleno() {
        boolean bingo = true;
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (fila == 2 && columna == 2) {
                    continue;
                }
                if (!fichaSeleccionada[fila][columna]) {
                    bingo = false;
                    break;
                }
            }
            if (!bingo) {
                break;
            }
        }
        if (bingo) {
            JOptionPane.showMessageDialog(this, "¡BINGO! Has completado el tablero.");

            int opcion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Quieres jugar otra vez?",
                    "Nuevo Juego",
                    JOptionPane.YES_NO_OPTION
            );

            if (opcion == JOptionPane.YES_OPTION) {
                this.dispose();
                new MenuPrincipal().setVisible(true);
            } else {
                System.exit(0);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error: No has completado el tablero por completo.");
        }
    }

    public FullHouse(String nombre) {
        initComponents();

        if (nombre == null || nombre.trim().isEmpty()) {
            jLNombreParticipante.setText("Anónimo");
        } else {
            jLNombreParticipante.setText(nombre);
        }

        tablero();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBgBingo = new javax.swing.JPanel();
        jPTablero = new javax.swing.JPanel();
        jPFullHouse = new javax.swing.JPanel();
        jLFullHouse = new javax.swing.JLabel();
        JPNumGenerado = new javax.swing.JPanel();
        jLNumGenerado = new javax.swing.JLabel();
        jBBingo = new javax.swing.JToggleButton();
        jPParticipante = new javax.swing.JPanel();
        jLNombreParticipante = new javax.swing.JLabel();
        jLParticipante = new javax.swing.JLabel();
        lblBgBingo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPBgBingo.setMinimumSize(new java.awt.Dimension(900, 700));
        jPBgBingo.setPreferredSize(new java.awt.Dimension(950, 700));
        jPBgBingo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPTablero.setBackground(new java.awt.Color(255, 255, 255));
        jPTablero.setLayout(new java.awt.GridLayout(5, 5));
        jPBgBingo.add(jPTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 670, 680));

        jPFullHouse.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));

        jLFullHouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FullHouse.png"))); // NOI18N

        javax.swing.GroupLayout jPFullHouseLayout = new javax.swing.GroupLayout(jPFullHouse);
        jPFullHouse.setLayout(jPFullHouseLayout);
        jPFullHouseLayout.setHorizontalGroup(
            jPFullHouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLFullHouse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
        );
        jPFullHouseLayout.setVerticalGroup(
            jPFullHouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLFullHouse, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );

        jPBgBingo.add(jPFullHouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 250, 210));

        JPNumGenerado.setBackground(new java.awt.Color(255, 255, 255));
        JPNumGenerado.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0)), javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 0), new java.awt.Color(153, 0, 0))));
        JPNumGenerado.setForeground(new java.awt.Color(255, 255, 204));
        JPNumGenerado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLNumGenerado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout JPNumGeneradoLayout = new javax.swing.GroupLayout(JPNumGenerado);
        JPNumGenerado.setLayout(JPNumGeneradoLayout);
        JPNumGeneradoLayout.setHorizontalGroup(
            JPNumGeneradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLNumGenerado, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPBgBingo, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBgBingo, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBingoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBingoActionPerformed
        tableroLleno();
    }//GEN-LAST:event_jBBingoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPNumGenerado;
    private javax.swing.JToggleButton jBBingo;
    private javax.swing.JLabel jLFullHouse;
    private javax.swing.JLabel jLNombreParticipante;
    private javax.swing.JLabel jLNumGenerado;
    private javax.swing.JLabel jLParticipante;
    private javax.swing.JPanel jPBgBingo;
    private javax.swing.JPanel jPFullHouse;
    private javax.swing.JPanel jPParticipante;
    private javax.swing.JPanel jPTablero;
    private javax.swing.JLabel lblBgBingo;
    // End of variables declaration//GEN-END:variables
}

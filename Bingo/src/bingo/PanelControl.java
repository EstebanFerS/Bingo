package bingo;

import javax.swing.*;
import java.awt.*;

public class PanelControl extends javax.swing.JFrame {

    private FichaAleatoria generador;
    private FullHouse FH;
    private Patron p;
    private JButton[][] tablero = new JButton[16][5];
    private int fichasLlamadas = 0;
    private int fichasRestantes = 75;

    private void GeneradorFicha() {
        int numero = generador.GeneradorFicha();
        if (numero == 0) {
            BSigNumero.setEnabled(false);
            return;
        }

        String ruta = "/Imagenes/" + numero + ".png";
        Imagenes nuevaFicha = new Imagenes(ruta);
        int anchoGrande = 130, altoGrande = 130, anchoChico = 90, altoChico = 90;
        int espaciado = 10, extraSeparacion = 30;
        int panelHeight = jPMostradorFicha.getHeight();
        int contador = 0;

        for (int i = 0; i < jPMostradorFicha.getComponentCount(); i++) {
            java.awt.Component comp = jPMostradorFicha.getComponent(i);
            if (comp instanceof Imagenes) {
                Imagenes fichaVieja = (Imagenes) comp;
                if (contador < 6) {
                    int x = anchoGrande + extraSeparacion + (contador * (anchoChico + espaciado));
                    int y = (panelHeight - altoChico) / 2;
                    fichaVieja.setBounds(x, y, anchoChico, altoChico);
                    contador++;
                } else {
                    fichaVieja.setVisible(false);
                }
            }
        }

        int xNueva = espaciado;
        int yNueva = (panelHeight - altoGrande) / 2;
        nuevaFicha.setBounds(xNueva, yNueva, anchoGrande, altoGrande);
        jPMostradorFicha.add(nuevaFicha, 0);
        jPMostradorFicha.revalidate();
        jPMostradorFicha.repaint();

        if (FH != null) {
            FH.mostrarFicha(numero);
        }
        if (p != null) {
            p.mostrarFicha(numero);
        }

        for (int i = 0; i < jPTablero.getComponentCount(); i++) {
            java.awt.Component comp = jPTablero.getComponent(i);
            if (comp instanceof JButton) {
                JButton boton = (JButton) comp;
                if (boton.getText().equals(String.valueOf(numero))) {
                    Color original = boton.getBackground();
                    boton.setBackground(original.darker());
                }
            }
        }

        fichasLlamadas++;
        fichasRestantes--;
        contador();
    }

    private void tablero() {

        String[] letras = {"B", "I", "N", "G", "O"};
        Color[] colores = {
            new Color(128, 0, 32),
            Color.BLACK,
            new Color(0, 0, 128),
            new Color(184, 134, 11),
            new Color(128, 0, 128)
        };

        for (int col = 0; col < 5; col++) {
            JButton letra = new JButton(letras[col]);
            letra.setForeground(Color.WHITE);
            letra.setFont(new Font("Felix Titling", Font.BOLD, 16));
            letra.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            letra.setFocusPainted(false);
            letra.setContentAreaFilled(false);
            letra.setOpaque(true);
            letra.setBackground(colores[col]);
            tablero[0][col] = letra;
            jPTablero.add(letra);
        }

        int[][] rangos = {
            {1, 15}, {16, 30}, {31, 45}, {46, 60}, {61, 75}
        };

        for (int fila = 1; fila <= 15; fila++) {
            for (int col = 0; col < 5; col++) {
                int numero = rangos[col][0] + (fila - 1);
                JButton boton = new JButton(String.valueOf(numero));
                boton.setForeground(Color.WHITE);
                boton.setFont(new Font("Arial", Font.BOLD, 14));
                boton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                boton.setFocusPainted(false);
                boton.setContentAreaFilled(false);
                boton.setOpaque(true);
                boton.setBackground(colores[col]);
                tablero[fila][col] = boton;
                jPTablero.add(boton);
            }
        }

        jPTablero.revalidate();
        jPTablero.repaint();
    }

    private void contador() {
        String ruta1 = "/Imagenes2/" + fichasLlamadas + ".png";
        Imagenes rutaLlamada = new Imagenes(ruta1);
        BFichasLlamadas.add(rutaLlamada);

        String ruta2 = "/Imagenes2/" + fichasRestantes + ".png";
        Imagenes rutaRestante = new Imagenes(ruta2);
        BFichasRestantes.add(rutaRestante);
    }

    public void mostrarPatron() {
        String ruta = "";
        if (p != null) {
            String nombre = p.getGeneradorPatrones().getNombrePatron();
            ruta = "/Imagenes/" + nombre + ".png";
        } else if (FH != null) {
            ruta = "/Imagenes/FullHouse.png";
        }

        Imagenes patronImagen = new Imagenes(ruta);
        jLPatron.add(patronImagen);
        patronImagen.setBounds(0, 0, jLPatron.getWidth(), jLPatron.getHeight());
        jLPatron.revalidate();
        jLPatron.repaint();

    }

    public PanelControl(FullHouse fh, Patron patron) {
        this.FH = fh;
        this.p = patron;
        generador = new FichaAleatoria();

        setLocationRelativeTo(null);
        initComponents();
        jPMostradorFicha.setLayout(null);
        BSigNumero.addActionListener(e -> GeneradorFicha());
        tablero();
        contador();
        mostrarPatron();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPanelControl = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPTablero = new javax.swing.JPanel();
        jPContador = new javax.swing.JPanel();
        BFichasLlamadas = new javax.swing.JButton();
        BFichasRestantes = new javax.swing.JButton();
        jPPatron = new javax.swing.JPanel();
        jLPatron = new javax.swing.JLabel();
        BSigNumero = new javax.swing.JToggleButton();
        BResetearTablero = new javax.swing.JToggleButton();
        jPMostradorFicha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPPanelControl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LBingo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPPanelControl.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 320, -1));

        jPTablero.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPTablero.setForeground(new java.awt.Color(153, 0, 0));
        jPTablero.setToolTipText("");
        jPTablero.setFont(new java.awt.Font("Felix Titling", 1, 12)); // NOI18N
        jPTablero.setLayout(new java.awt.GridLayout(16, 5));
        jPPanelControl.add(jPTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 790, 580));

        jPContador.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));
        jPContador.setPreferredSize(new java.awt.Dimension(320, 180));
        jPContador.setLayout(new java.awt.GridLayout(1, 0));

        BFichasLlamadas.setBackground(new java.awt.Color(0, 21, 68));
        BFichasLlamadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BFichasLlamadas.setRequestFocusEnabled(false);
        BFichasLlamadas.setRolloverEnabled(false);
        jPContador.add(BFichasLlamadas);

        BFichasRestantes.setBackground(new java.awt.Color(0, 21, 68));
        BFichasRestantes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        BFichasRestantes.setRequestFocusEnabled(false);
        BFichasRestantes.setRolloverEnabled(false);
        jPContador.add(BFichasRestantes);

        jPPanelControl.add(jPContador, new org.netbeans.lib.awtextra.AbsoluteConstraints(844, 144, 330, 190));

        jPPatron.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));
        jPPatron.setLayout(null);
        jPPatron.add(jLPatron);
        jLPatron.setBounds(6, 4, 310, 252);

        jPPanelControl.add(jPPatron, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, 320, 260));

        BSigNumero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BGenerarNumero.png"))); // NOI18N
        BSigNumero.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white)));
        BSigNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSigNumeroActionPerformed(evt);
            }
        });
        jPPanelControl.add(BSigNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 610, 320, 80));

        BResetearTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BResetear.png"))); // NOI18N
        BResetearTablero.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white), javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white)));
        BResetearTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BResetearTableroActionPerformed(evt);
            }
        });
        jPPanelControl.add(BResetearTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 700, 320, 80));

        jPMostradorFicha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPPanelControl.add(jPMostradorFicha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 790, 150));
        jPPanelControl.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPanelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPPanelControl, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BResetearTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BResetearTableroActionPerformed
        jPMostradorFicha.removeAll();
        jPMostradorFicha.revalidate();
        jPMostradorFicha.repaint();

        mostrarPatron();

        Color[] colores = {
            new Color(128, 0, 32),
            Color.BLACK,
            new Color(0, 0, 128),
            new Color(184, 134, 11),
            new Color(128, 0, 128)
        };
        for (int fila = 0; fila < 16; fila++) {
            for (int col = 0; col < 5; col++) {
                JButton boton = tablero[fila][col];
                if (boton != null) {
                    boton.setBackground(colores[col]);
                    boton.setEnabled(true);
                }
            }
        }

        fichasLlamadas = 0;
        fichasRestantes = 75;
        BFichasLlamadas.removeAll();
        BFichasRestantes.removeAll();
        contador();

        BSigNumero.setEnabled(true);
    }//GEN-LAST:event_BResetearTableroActionPerformed

    private void BSigNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSigNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BSigNumeroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BFichasLlamadas;
    private javax.swing.JButton BFichasRestantes;
    private javax.swing.JToggleButton BResetearTablero;
    private javax.swing.JToggleButton BSigNumero;
    private javax.swing.JLabel jLPatron;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPContador;
    private javax.swing.JPanel jPMostradorFicha;
    private javax.swing.JPanel jPPanelControl;
    private javax.swing.JPanel jPPatron;
    private javax.swing.JPanel jPTablero;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

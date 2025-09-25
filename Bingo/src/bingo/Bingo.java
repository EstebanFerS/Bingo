/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bingo;

public class Bingo {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MenuInicial mi = new MenuInicial();
            mi.setVisible(true);
            mi.setLocationRelativeTo(null);
        });
    }
}

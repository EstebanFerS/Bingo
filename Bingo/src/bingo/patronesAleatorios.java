/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.Random;

public class patronesAleatorios {

    private boolean[][] patronActual;
    private String nombrePatron;

    public void generarPatron() {
        Random r = new Random();
        int opcion = r.nextInt(4);
        patronActual = new boolean[5][5];

        switch (opcion) {
            case 0:
                patronM();
                nombrePatron = "M";
                break;
            case 1:
                patronX();
                nombrePatron = "X";

                break;
            case 2:
                patronL();
                nombrePatron = "L";

                break;
            case 3:
                patronT();
                nombrePatron = "T";

                break;
        }
    }

    private void patronX() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                patronActual[i][j] = (i == j) || (i + j == 4);
            }
        }
    }

    private void patronL() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                patronActual[i][j] = (j == 0) || (i == 4);
            }
        }
    }

    private void patronT() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                patronActual[i][j] = (i == 0) || (j == 2);
            }
        }
    }

    private void patronM() {
        for (int i = 0; i < 5; i++) {
            patronActual[i][0] = true;
            patronActual[i][4] = true;
        }
        
        patronActual[1][1] = true;
        patronActual[1][3] = true;
        patronActual[2][2] = true;
    }

    private void tablerolleno(){
        
    }
    
    public boolean[][] getPatronActual() {
        return patronActual;
    }
    
  public String getNombrePatron() {
        return nombrePatron;
    }
  
    public boolean validar(boolean[][] presionados) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (patronActual[i][j] && !presionados[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}

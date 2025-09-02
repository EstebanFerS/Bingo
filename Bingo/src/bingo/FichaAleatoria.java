/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;

import java.util.Random;

public class FichaAleatoria {

    private int[] ficha;
    private int restante;
    private Random aleatorio;

    public FichaAleatoria() {
        ficha = new int[76];
        restante = 75;
        aleatorio = new Random();

        for (int i = 1; i <= 75; i++) {
            ficha[i] = i;
        }
    }

    public int GeneradorFicha() {
        int NumAlea;

        if (restante==0){
           return 0; 
        }
        
        do {
            NumAlea = aleatorio.nextInt(76);
        } while (ficha[NumAlea] == 0);
        int numero = ficha[NumAlea];
        ficha[NumAlea] = 0;
        restante--;

        return numero;
    }

}

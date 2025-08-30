/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bingo;
import java.util.Random;


public class FichaAleatoria {
    private String[] ficha;
    private int restante;
    private Random aleatorio;
    
    public FichaAleatoria(){
        ficha = new String [75];  
        restante = 75;
        aleatorio = new Random();
        
        for(int i=1; i<=75; i++){
            ficha[i]= "/imagenes/" + i + ".png";
        }  
    }  
    
 
            
    
}

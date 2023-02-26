package com.mycompany.actividad_4;

/*5. Realizar un programa que inicialice una lista con 10 valores aleatorios (del 1 al 10) 
y posteriormente muestre en pantalla cada elemento de la lista junto con su cuadrado y su cubo.
*/

import java.util.ArrayList;
import java.util.Random;

public class Proyecto5 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random rand = new Random();
        
        // Agregar 10 valores aleatorios del 1 al 10
        for (int i = 0; i < 10; i++) {
            numeros.add(rand.nextInt(10) + 1);
        }
        
        // Mostrar cada elemento con su cuadrado y cubo
        for (int num : numeros) {
            System.out.println(num + " al cuadrado: " + (num*num) + ", al cubo: " + (num*num*num));
        }
    }
}
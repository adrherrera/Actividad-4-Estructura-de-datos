package com.mycompany.actividad_4;

/*1. A partir de un arreglo que posee N cantidad de promedios de estudiantes colocarlos en una lista
y sacar el promedio global de todos los estudiantes. Se debe verificar que los elementos que están
en la lista son correcto (rango de 0 a 5). Imprimir todos los promedios y el promedio global.*/

import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de promedios de estudiantes: ");
        int n = scanner.nextInt();
        
        ArrayList<Double> promedios = new ArrayList<>();
        double suma = 0;
        
        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el promedio del estudiante " + (i+1) + ": ");
            double promedio = scanner.nextDouble();
            
            if (promedio < 0 || promedio > 5) {
                System.out.println("Error: el promedio debe estar en el rango de 0 a 5.");
                i--; 
            } else {
                promedios.add(promedio);
                suma += promedio;
            }
        }
        
        System.out.println("Los promedios ingresados son: " + promedios);
        double promedioGlobal = suma / promedios.size();
        System.out.println("El promedio global de los estudiantes es: " + promedioGlobal);
    }
}

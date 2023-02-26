package com.mycompany.actividad_4;

/*4. Crear un programa que añada números a una lista hasta que introducimos un número negativo.
A continuación, debe crear una nueva lista igual que la anterior, pero eliminando los números duplicados.
Muestra esta segunda lista para comprobar que hemos eliminados los duplicados.
*/


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Proyecto4 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        List<Integer> listaNumeros = new ArrayList<>();
        
        // Pide al usuario que ingrese números hasta que se ingrese un número negativo
        System.out.println("Ingrese un número (para salir ingrese un número negativo):");
        int numero = scanner.nextInt();
        while(numero >= 0) {
            listaNumeros.add(numero);
            System.out.println("Ingrese un número (para salir ingrese un número negativo):");
            numero = scanner.nextInt();
        }
        
        // Crea una nueva lista sin duplicados utilizando el método Set
        Set<Integer> conjuntoNumeros = new HashSet<>(listaNumeros);
        List<Integer> listaSinDuplicados = new ArrayList<>(conjuntoNumeros);
        
        // Imprime ambas listas para comparar
        System.out.println("La lista original es: " + listaNumeros);
        System.out.println("La lista sin duplicados es: " + listaSinDuplicados);
    }

}

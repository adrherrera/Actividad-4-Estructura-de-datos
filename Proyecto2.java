package com.mycompany.actividad_4;

/*2. Ingresar a una lista enlazada simple n elementos y calcular cual es el
mayor de la lista. Imprimir el número mayor y luego la lista.
*/

public class Proyecto2 {
    private Nodo cabeza;

    private static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo ultimoNodo = cabeza;
            while (ultimoNodo.siguiente != null) {
                ultimoNodo = ultimoNodo.siguiente;
            }
            ultimoNodo.siguiente = nuevoNodo;
        }
    }

    public int encontrarMayor() {
        int mayor = Integer.MIN_VALUE;
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            if (nodoActual.valor > mayor) {
                mayor = nodoActual.valor;
            }
            nodoActual = nodoActual.siguiente;
        }
        return mayor;
    }

    public void imprimirLista() {
        Nodo nodoActual = cabeza;
        while (nodoActual != null) {
            System.out.print(nodoActual.valor + " ");
            nodoActual = nodoActual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Proyecto2 lista = new Proyecto2();
        lista.agregar(10);
        lista.agregar(5);
        lista.agregar(20);
        lista.agregar(15);

        int mayor = lista.encontrarMayor();
        System.out.println("El número mayor es: " + mayor);

        System.out.println("La lista es: ");
        lista.imprimirLista();
    }
}


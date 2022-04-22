package com.company;

/**
 * Clase de números Primos:
 * Esta clase contiene m&eacute;todos para generar los n&uacute;meros primos existentes
 * entre 1 y un n&uacute;mero dado.
 * @author Adri&aacute;n Palenciano Garc&iacute;a
 * @version Branch3-documentacion
 */

public class Primos {
    // Generar números primos de 1 a max
    /**
     * Generar primos:
    *Método para generar los números primos desde 1 hasta el número indicado.
     *@param max El parámetro max define el número hasta el que vamos a generar primos.
     * @return Los números primos de 1 hasta max
    */
    public static int[] generarPrimos (int max) {
        if (max >= 2) {
            // Declaraciones
            int dim = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[dim];

            // Inicializar el array
            inicializaArray(dim, esPrimo);

            // Criba
            criba(dim, esPrimo);

            // ¿Cuántos primos hay?
            int cuenta = cuentaPrimos(dim, esPrimo);

            // Rellenar el vector de números primos
             return vectorPrimos(dim, esPrimo, cuenta);

        }
        else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }

    /**
     * Vector de números primos:
     * Método para generar un vector que contenga los números primos indicados a partir de un vector booleano.
     * @param dim El tamaño del vector booleano.
     * @param esPrimo El vector booleano (La posición indica el número y el contenido si es primo o no).
     * @param cuenta La cantidad de números primos que hay en el vector booleano.
     * @return Vector de enteros que contiene los números primos generados.
     */

    public static int[] vectorPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int j;
        int i;
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    /**
     * Recuento de números primos:
     * Método que calcula la cantidad de números primos que indica un vector booleano.
     * @param  dim El tamaño del vector booleano.
     * @param esPrimo El vector booleano (La posición indica el número y el contenido si es primo o no).
     * @return La cantidad de números primos.
     */
    public static int cuentaPrimos(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * Inicialización del vector booleano:
     * Método para inicializar un vector booleano, poniendo sus valores a true.
     * @param  dim El tamaño del vector booleano.
     * @param esPrimo El vector booleano (La posición indica el número y el contenido si es primo o no).
     */
    public static void inicializaArray(int dim, boolean[] esPrimo) {
        int i;
        for (i=0; i< dim; i++) {
            esPrimo[i] = true;
        }
    }

    /**
     * Criba de números primos:
     * Método que da valor al vector booleano, en función de si la posición (número) es primo o no.
     * @param  dim El tamaño del vector booleano.
     * @param esPrimo El vector booleano (La posición indica el número y el contenido si es primo o no).
     */
    public static void criba(int dim, boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
        int j;
        int i;
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j = 2 * i; j < dim; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }
}
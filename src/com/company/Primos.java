package com.company;
public class Primos {
    // Generar números primos de 1 a max
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

    static int[] vectorPrimos(int dim, boolean[] esPrimo, int cuenta) {
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

    static int cuentaPrimos(int dim, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i]) {
                cuenta++;
            }
        }
        return cuenta;
    }

    static void inicializaArray(int dim, boolean[] esPrimo) {
        int i;
        for (i=0; i< dim; i++) {
            esPrimo[i] = true;
        }
    }

    static void criba(int dim, boolean[] esPrimo) {
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
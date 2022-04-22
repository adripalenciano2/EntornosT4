package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimosTest {

    @Test
    void generarPrimosTest() {
        
        int [] array = {2,3,5,7,11};
        int[]array2 = {2,3,5,7,11,13,17,19,23,29};
        int[] array3 = {2};

        assertArrayEquals(array, Primos.generarPrimos(12));
        assertArrayEquals(array2, Primos.generarPrimos(30));
        assertArrayEquals(array3, Primos.generarPrimos(2));
    }

    @Test
    void generarPrimosFalse() {
        int[] array = {2, 3, 5, 7, 11, 12, 13};
        int[] array2 = {2, 3, 5};
        int[] array3 = {3, 5, 7};

        assertArrayEquals(array, Primos.generarPrimos(13));
        assertArrayEquals(array2, Primos.generarPrimos(7));
        assertArrayEquals(array3, Primos.generarPrimos(7));
    }

    @Test
    void cribaTest(){
        boolean[] array={false, false, true, true, false, true, false, true, false, false, false, true, false};
        boolean[] comprobar={true, true, true, true, true,true, true, true, true, true, true, true, true};

        Primos.criba(13, comprobar);
        assertArrayEquals(array, comprobar);
    }

    @Test
    void cribaFalse(){
        boolean[] array={false, false, true, true, true, true, false, true, false, false, false, true, false};
        boolean[] comprobar={true, true, true, true, true,true, true, true, true, true, true, true, true};

        Primos.criba(13, comprobar);
        assertArrayEquals(array, comprobar);
    }

    @Test
    void inicializarArrayTest(){
        boolean[] comprobar={true, true, true, true, true,true, true, true, true, true, true, true, true};
        boolean[] array = new boolean[13];

        Primos.inicializaArray(13,array);
        assertArrayEquals(comprobar, array);
    }

    @Test
    void inicializarArrayFalse(){
        boolean[] comprobar={false, true, true, true, true,true, true, true, true, true, true, true, true};
        boolean[] array = new boolean[13];

        Primos.inicializaArray(13,array);
        assertArrayEquals(comprobar, array);
    }


}
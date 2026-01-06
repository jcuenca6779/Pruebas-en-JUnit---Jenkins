package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraParametrosTest {

    Calculadora calc = new Calculadora();

    // 1. @ValueSource para probar esPar()
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testEsParValueSource(int numero) {
        assertTrue(calc.esPar(numero));
    }

    // 2. @CsvSource para sumar()
    @ParameterizedTest
    @CsvSource({"1,2,3", "5,5,10", "3,7,10"})
    void testSumarCsvSource(int a, int b, int resultadoEsperado) {
        assertEquals(resultadoEsperado, calc.sumar(a, b));
    }

    // 3. @CsvFileSource

    @ParameterizedTest
    @CsvFileSource(resources = "/datos.csv")
    void testDividirCsvFile(int a, int b, int resultadoEsperado) {
        assertEquals(resultadoEsperado, calc.dividir(a, b));
    }
}

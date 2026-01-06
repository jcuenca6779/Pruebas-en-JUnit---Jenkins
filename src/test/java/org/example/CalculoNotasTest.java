package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculoNotasTest {

    //Pruebas Normales

    @Test
    void testPromedioNotasEnteras() {
        double[] notas = {10.0, 8.0, 9.0};
        double esperado = 9.0;
        double resultado = CalculoNotas.promedio(notas);
        assertEquals(esperado, resultado, 0.01, "El promedio de 10, 8 y 9 debe ser 9");
    }

    @Test
    void testPromedioConDecimales() {
        double[] notas = {7.5, 8.5};
        double esperado = 8.0;
        double resultado = CalculoNotas.promedio(notas);
        assertEquals(esperado, resultado, 0.01, "El promedio de 7.5 y 8.5 debe ser 8.0");
    }

    @Test
    void testArrayVacio() {
        double[] notas = {};
        assertEquals(0.0, CalculoNotas.promedio(notas));
    }

    //Pruebas Parametrizadas

    @ParameterizedTest
    @CsvSource({
            "'10,10,10', 10.0",
            "'0,0,0', 0.0",
            "'5,10', 7.5"
    })
    void testPromediosVariados(String notasStr, double esperado) {
        // Convertimos el string del CSV a array de doubles
        String[] partes = notasStr.split(",");
        double[] notas = new double[partes.length];
        for(int i=0; i<partes.length; i++) notas[i] = Double.parseDouble(partes[i]);

        assertEquals(esperado, CalculoNotas.promedio(notas), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "'20', 20.0",
            "'15.5', 15.5"
    })
    void testUnicoValor(String notasStr, double esperado) {
        double[] notas = { Double.parseDouble(notasStr) };
        assertEquals(esperado, CalculoNotas.promedio(notas), 0.01);
    }
}

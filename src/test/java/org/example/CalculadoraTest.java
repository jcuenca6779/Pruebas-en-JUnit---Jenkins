package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    static Calculadora calc;

    //PARTE 2: Ciclo de Vida

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicio de todas las pruebas.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Fin de todas las pruebas.");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Iniciando una prueba individual...");
        calc = new Calculadora(); // Inicializamos antes de cada prueba
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba individual finalizada.");
    }

    //PARTE 1: Assertions

    @Test
    @DisplayName("Prueba de assertNotNull")
    void testNotNull() {
        assertNotNull(calc, "El objeto calculadora no debería ser nulo");
    }

    @Test
    @DisplayName("Prueba de assertEquals en suma")
    void testSumar() {
        assertEquals(5, calc.sumar(2, 3), "2 + 3 debería ser 5");
    }

    @Test
    @DisplayName("Prueba de assertNotEquals en resta")
    void testRestar() {
        assertNotEquals(0, calc.restar(5, 2), "5 - 2 no debería ser 0");
    }

    @Test
    @DisplayName("Prueba de assertTrue en esPar")
    void testEsParTrue() {
        assertTrue(calc.esPar(4), "4 debería ser par");
    }

    @Test
    @DisplayName("Prueba de assertFalse en esPar")
    void testEsParFalse() {
        assertFalse(calc.esPar(5), "5 no debería ser par");
    }

    @Test
    @DisplayName("Prueba de assertThrows en división por cero")
    void testDividirPorCero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.dividir(10, 0);
        }, "Dividir por cero debería lanzar ArithmeticException");
    }

    @Test
    @DisplayName("Prueba de assertAll (Múltiples aserciones)")
    void testAssertAll() {
        assertAll("Operaciones básicas",
                () -> assertEquals(10, calc.sumar(5, 5)),
                () -> assertEquals(2, calc.restar(4, 2)),
                () -> assertTrue(calc.esPar(100))
        );
    }
}
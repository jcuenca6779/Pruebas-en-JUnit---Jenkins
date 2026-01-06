package org.example;

public class CalculoNotas {
    public static double promedio(double[] notas) {
        // Validación: Si no hay notas, el promedio es 0
        if (notas == null || notas.length == 0) {
            return 0.0;
        }

        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }
}

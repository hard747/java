package sustitucion_regresiva;

import static java.lang.Math.*;

public class matriz {

    double[][] A = new double[3][4];

    public double[][] cargar_sistema(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                if (fila > col) {
                    A[fila][col] = 0;
                } else {
                    A[fila][col] = round(random() * 100);

                }

            }
        }

        return A;

    }

    public void mostrar_sistema(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                int j = col + 1;
                if (col != 2 && col != 3) {
                    System.out.print(String.format("%.2f", A[fila][col]) + " X" + j + " +\t");
                } else if (col == 2) {
                    System.out.print(String.format("%.2f", A[fila][col]) + " X" + j + " = ");
                } else {
                    System.out.println(String.format("%.2f", A[fila][col]));

                }
            }

        }

    }

    public void resultados(double[][] a) {
        double x3 = (a[2][3]) / a[2][2];
        double x2 = (a[1][3] - a[1][2] * x3) / a[1][1];
        double x1 = (a[0][3] - a[0][2] * x3 - a[0][1] * x2) / a[0][0];
        System.out.println("X1" + " = " + String.format("%.3f", x1) + "\n" + "X2" + " = " + String.format("%.3f", x2) + "\n" + "X3" + " = " + String.format("%.3f", x3));

    }

}

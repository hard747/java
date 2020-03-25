package sistema_ecuaciones;

import static java.lang.Math.*;

public class matrices {

 
    public double[][] cargar_sistema(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                A[fila][col] = round(random() * 100);

            }
        }

        return A;

    }

 

    public double[][] triangular(double[][] a) {
        double[][] b = new double[a.length][a[0].length];
        for (int i = 1; i < a.length; i++) {
                for (int k = 0; k < i; k++) {
                    b[i][k]=a[i][k];
                    for (int j = 0; j < a[0].length; j++) {
                    a[i][j] = a[i][j] - (b[i][k]) * (a[k][j]) / (a[k][k]);
                }  
            }
        }
        return a;
    }
    
    
    public double[] resultado(double[][] a) {
        double[] R = new double[a.length];
        double[] m = new double[a.length];

        for (int i = a.length - 1; i >= 0; i--) {
            double s = 0;
            for (int j = i + 1; j < a.length; j++) {

                s = s + a[i][j] * R[j];

            }
            m[i] = s;

            R[i] = (a[i][a.length] - m[i]) / a[i][i];

        }
        return R;

    }

    public void mostrar_sistema(double[][] A) {

        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                int j = col + 1;
                if (col <= A.length - 2) {
                    System.out.print(String.format("%.2f", A[fila][col]) + " X " + j + " +\t");
                } else if (col == A.length - 1) {
                    System.out.print(String.format("%.2f", A[fila][col]) + " X " + j + " = ");
                } else if (col == A.length) {
                    System.out.println(String.format("%.2f", A[fila][col]));

                }
            }

        }

    }

    

    public void mostrar_resultado(double[] R) {
        for (int i = 0; i < R.length; i++) {
            int j = i + 1;
            System.out.println("X" + j + " = " + R[i]);

        }

    }

}

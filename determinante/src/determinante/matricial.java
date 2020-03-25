package determinante;

import static java.lang.Math.*;

public class matricial {

    public double[][] cargar_matrize(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                A[fila][col] = round(random() * 100);
               
            }
        }

        return A;

    }

    public double[][] ordenar_por_filas(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = j + 1; k < A[0].length; k++) {
                    if (A[fila][j] > A[fila][k]) {
                        double buffer = A[fila][k];
                        A[fila][k] = A[fila][j];
                        A[fila][j] = buffer;

                    }
                }

            }

        }
        return A;
    }

    public void mostrar_matriz(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                System.out.print(String.format("%.2f",A[fila][col]) + " ");
                //System.out.print(A[fila][col] + " ");

            }
            System.out.println();

        }

    }

    public double[][] triangular(double[][] a) {

        double x2 = a[1][0];
        double x4 = a[2][0];        
        
        //fila2 menos fila 1
        for (int col = 0; col < a[1].length; col++) {
            a[1][col] = a[1][col] - a[0][col] * (x2/a[0][0]);
        }
     
        //fila3 menos fila 1
        for (int col = 0; col < a[2].length; col++) {
            a[2][col] = a[2][col] - a[0][col] * (x4/a[0][0]);
        }
        //fila3 menos fila 2
        double x5 = a[2][1];        
        for (int col = 1; col < a[1].length; col++) {
            a[2][col] = a[2][col] - a[1][col] *(x5/a[1][1]);
        }

        System.out.println();

        return a;

    }

    public void determinante(double[][] a) {
        double det;

        det = a[0][0] * a[1][1] * a[2][2];
        System.out.println();
        System.out.println("el determinante es: " + String.format("%.3f",det));
        //System.out.println("el determinante es: " + det);

    }

  

}

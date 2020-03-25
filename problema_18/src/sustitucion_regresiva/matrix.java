package sustitucion_regresiva;

import static java.lang.Math.*;

public class matrix {

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

	public void resultado(double[][] a) {
		double[] R = new double[a[0].length]; double[] m = new double[a[0].length-1];
		
		for (int i = a.length-1; i >= 0; i--) {
			double s = 0;
			for (int j = i + 1; j < a.length; j++) {

				s = s + a[i][j] * R[j];

			}
			m[i] = s;

			R[i] = (a[i][3] - m[i]) / a[i][i];

		}
		
		
		System.out.println("X1" + " = " + String.format("%.3f", R[0]) + "\n" + "X2" + " = " + String.format("%.3f", R[1]) + "\n" + "X3" + " = " + String.format("%.3f", R[2]));

	}
	
	
	
	
}

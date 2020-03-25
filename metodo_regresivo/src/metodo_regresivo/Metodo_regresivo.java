
package metodo_regresivo;


public class Metodo_regresivo {

    public static void main(String[] args) {
          double A[][] = new double[3][3];
        matrix m = new matrix();
        double[][] a = m.ordenar_por_filas(m.cargar_matrize(A));
        m.mostrar_matriz(m.ordenar_por_filas(m.cargar_matrize(A)));
        System.out.println();
        m.mostrar_matriz(m.triangular(a));
        m.determinante(a);
        System.out.println("porque no imprime nada");
    }
    
}


package regresivo;


public class Regresivo {
   
    public static void main(String[] args) {
        double A[][] = new double[3][3];
        double B[]=new double[3];
        matrix m = new matrix();
        double[][] a = m.cargar_matrize(A);
        double[] b = m.independientes(B);        
        m.triangular(a);
        System.out.println("***Sistema de ecuaciones*** ");
        m.mostrar_sistema(a, b);
        System.out.println("\n**Valores de Xn** ");
        m.resultados(a, b);
    }
    
}

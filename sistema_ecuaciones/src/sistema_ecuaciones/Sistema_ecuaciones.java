package sistema_ecuaciones;

public class Sistema_ecuaciones {

    public static void main(String[] args) {
        
        matrices m = new matrices();
        double[][] a = new double[4][5];
        double[][] x=m.cargar_sistema(a);
        System.out.println("***SISTEMA DE ECUACIONES***");
        m.mostrar_sistema(x);
        System.out.println("***TRIANGULAR***");
        m.mostrar_sistema(m.triangular(x));
        System.out.println("***SOLUCIONES***");
        m.mostrar_resultado(m.resultado(m.triangular(x)));

    }

}

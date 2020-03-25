
package sustitucion_regresiva;

public class sustitucion_regresiva {

	
	public static void main(String[] args) {
		 matrix m = new matrix();
        System.out.println("***Sistema de ecuaciones*** ");
        m.mostrar_sistema(m.cargar_sistema(m.A));
        System.out.println("\n**Valores de Xn** ");	
		  m.resultado(m.A);	
		  
		  
	}
	
}

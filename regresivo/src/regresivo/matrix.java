
package regresivo;

import static java.lang.Math.*;


public class matrix {
    
     public double[][] cargar_matrize(double[][] A) {
        for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                A[fila][col] =  round(random() * 100);
               
            }
        }

        return A;

    }
     
      public double[] independientes(double[] B) {
       

            for (int col = 0; col < B.length; col++) {
                B[col] = round(random() * 100);
               
            }

        return B;

    }
      
   
    public void mostrar_sistema(double[][] A,double[] B){
         for (int fila = 0; fila < A.length; fila++) {

            for (int col = 0; col < A[fila].length; col++) {
                int j=col+1;
                if(col!=2){
                System.out.print(String.format("%.2f",A[fila][col]) + " X"+j+" +\t");
                }    
                else{
                System.out.print(String.format("%.2f",A[fila][col]) + " X"+j+" "); 
                }
            }
            System.out.println(" = "+ String.format("%.2f",B[fila]));
            

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

        //System.out.println();

        return a;

    }

 
    public void resultados(double[][] a,double[] b){
        double x3=(b[2])/a[2][2];
        double x2=(b[1]-a[1][2]*x3)/a[1][1];
        double x1=(b[0]-a[0][2]*x3-a[0][1]*x2)/a[0][0];      
        System.out.println("X1"+" = "+String.format("%.3f",x1)+"\n"+"X2"+" = "+String.format("%.3f",x2)+"\n"+"X3"+" = "+String.format("%.3f",x3));
        
    }
    
    
    
}

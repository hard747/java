
package arrays;

import static java.lang.Math.random;


public class Arrays {

   
    public static void main(String[] args) {
        practica[] objeto=new practica[30];
        int[] a=new int[30];
        for(int i=0;i<30;i++){
        a[i]=objeto[i].aleatorio;
        System.out.println(a[i]);
        }
        
    }
    
}
class practica{

    int aleatorio;
    
    int[] aleatorio()
    {
        int[] enteros=new int[30];
        for(int i=0;i<30;i++){
        enteros[i] = (int)random();
        }
        return enteros;
    }


}

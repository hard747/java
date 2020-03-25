package arraylist;

import java.util.ArrayList;

public class uso_empleado {

    public static void main(String[] args) {
       /* empleado lista_empleado[] = new empleado[3];
        lista_empleado[0] = new empleado("carlos", 23, 1200);
        lista_empleado[1] = new empleado("alberto", 46, 1800);
        lista_empleado[2] = new empleado("gerardo", 55, 1900);*/
       
       ArrayList <empleado> lista_empleado = new ArrayList <empleado>();
       lista_empleado.add(new empleado("carlos", 23, 1200));
       lista_empleado.add(new empleado("alberto", 32, 1500));
       lista_empleado.add(new empleado("gerardo", 43, 1800));
           
        for(empleado e: lista_empleado){
            System.out.println(e.dameDatos());
        }

    }

}

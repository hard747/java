
package parcial;

import java.util.Scanner;

class cleer {

    String apellido;
    int codigo;
    double promedio_final;
    int orden;
   
    int cleer_orden(int orden){
        return this.orden=orden+1;
     
    }
    
    String cleer_apellido() {
        System.out.println("introduzca el apellido del alumno");
        Scanner apellido = new Scanner(System.in);
        return this.apellido = apellido.nextLine();

    }

    int cleer_codigo() {
        System.out.println("introduzca el codigo del alumno");
        Scanner codigo = new Scanner(System.in);
        return this.codigo = codigo.nextInt();
       
    }

    double cleer_promedio() {
        
        System.out.println("introduzca el promedio del alumno");
        Scanner promedio_final = new Scanner(System.in);
        return this.promedio_final = promedio_final.nextDouble();
        
    }

}

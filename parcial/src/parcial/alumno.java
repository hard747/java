package parcial;

public class alumno {

    String apellido;
    int codigo;
    double promedio_final;
    int orden;

 public   alumno(int orden, int codigo, String apellido, double promedio_final) {
        this.apellido = apellido;
        this.codigo = codigo;
        this.promedio_final = promedio_final;
        this.orden = orden;

    }

 public void imprimir_arreglo() {
        
        System.out.println(orden + "\t " + codigo + "\t  " + apellido + "\t\t    " + promedio_final);
        
    }

}

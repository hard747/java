package arraylist;

public class empleado {

    private String nombre;
    private int edad;
    private double salario;

    public empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
    public String dameDatos(){
    
        return "El empleado se llama "+nombre+" tiene "+edad+" años y su salario es "+salario;
    
    }

}

package clases;

public class Ordenador {
    public String nombres;
    public double velocidad;
    public String sisoperativo; 

    public Ordenador(String nombres, double velocidad, String sisoperativo) {
        this.nombres = nombres;
        this.velocidad = velocidad;
        this.sisoperativo = sisoperativo;
    }
    
   public Ordenador() {
        this.nombres = "SIN NOMBRES";
        this.velocidad = 0;
        this.sisoperativo = "SIN SISTEMA OPERATIVO";
    }  

   // @Override
    public String toString() {
        return "Ordenador{" + "nombres=" + nombres + ", velocidad=" + velocidad + ", sisoperativo=" + sisoperativo + '}';
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public String getSisoperativo() {
        return sisoperativo;
    }

    public void setSisoperativo(String sisoperativo) {
        this.sisoperativo = sisoperativo;
    }

   
    
    
    
    
    
    
}

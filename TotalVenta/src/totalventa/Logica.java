package totalventa;

public class Logica {

    double respuesta;
    double respuesta2;
    double respuesta3;
    String texto1;
    String texto2;
    String texto3;

    public Logica(String texto1, String texto2, String texto3) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
    }

    public Logica() {

    }

    public void PrecioVenta() {

        System.out.println("El precio es del turno " + this.texto1 + " es: " + Turno(this.texto1));
        System.out.println("El precio de la ubicacion " + this.texto2 + " es: " + Ubicacion(this.texto2));
        System.out.println("El precio del impuesto " + this.texto3 + " es: " + Impuesto(this.texto3));
        System.out.println("El precio final es: " + Impuesto(this.texto3));
    }//PrecioVenta()

    public double Turno(String dato) {

        if (dato.equals("manana")) {
            this.respuesta = 35;

        } else if (dato.equals("tarde")) {
            this.respuesta = 45;

        } else if (dato.equals("noche")) {
            this.respuesta = 60;

        }

        return this.respuesta;

    }//Turno()

    public double Ubicacion(String dato2) {

        if (dato2.equals("platea")) {
            this.respuesta2 = this.respuesta;
        } else if (dato2.equals("preferencial")) {
            this.respuesta2 = this.respuesta + 5 * this.respuesta / 100;

        } else if (dato2.equals("vip")) {
            this.respuesta2 = this.respuesta + 10 * this.respuesta / 100;

        }

        return this.respuesta2;

    }//Ubicacion()

    public double Impuesto(String dato3) {

        if (dato3.equals("teatro")) {
            this.respuesta3 = this.respuesta2 + 5 * this.respuesta2 / 100;

        } else if (dato3.equals("concierto")) {
            this.respuesta3 = this.respuesta2 + 8 * this.respuesta2 / 100;
        } else if (dato3.equals("otro")) {
            this.respuesta3 = this.respuesta2 + 10 * this.respuesta2 / 100;
        }

        return this.respuesta3;
    }//Impuesto()

}//Logica

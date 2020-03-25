package Clases;

import java.util.Scanner;

public class Ordenadores {

    double respuestP, respuest1, respuestaPI = 0, precio_1, precio_2, precio_3, factor;
    int cantidad, numero = 0, respuesta;
    String dateo, letra = "si";
    Scanner entrada1 = new Scanner(System.in);
    Scanner entrada = new Scanner(System.in);
    public static double igv;
    public static double garantia;

    static {
        igv = 0;
        garantia = 0;
    }

    public Ordenadores(double precio_1, double precio_2, double precio_3, double factor) {
        this.precio_1 = precio_1;
        this.precio_2 = precio_2;
        this.precio_3 = precio_3;
        this.factor = factor;

    }

    public void Proceso() {

        while (this.letra.equals("si")) {

            System.out.println("\nNumero deProcesador en Mhz: \n 1.6 \n 1.7  \n 1.8 ");
            System.out.print("\nTipo de Procesador(Mhz) que desea comprar: ");

            dateo = entrada.nextLine();
            if (dateo.equals("1.6") || dateo.equals("1.7") || dateo.equals("1.8")) {//restriccion de tipo de procesador(validacion)
                if (dateo.equals("1.6")) {
                    this.respuestP = precio_1 * factor;
                    System.out.println("el precio unitario de una computadora de " + dateo + " Mhz es : " + respuestP);
                    System.out.print("Cantidad: ");
                    this.cantidad = this.entrada1.nextInt();
                    //restriccion de cantidades para 1.6
                    while (cantidad < 0) {
                        System.out.println("Introduzca correctamente las cantidades");
                        System.out.print("Cantidad: ");
                        this.cantidad = this.entrada1.nextInt();
                    }//fin de restriccion

                    this.respuest1 = this.respuestP * (cantidad);

                } else if (this.dateo.equals("1.7")) {

                    this.respuestP = precio_2 * factor;
                    System.out.println("el precio unitario de una computadora de " + dateo + " Mhz es : " + respuestP);
                    System.out.print("Cantidad: ");
                    this.cantidad = this.entrada1.nextInt();
                    //restriccion de cantidades para 1.7
                    while (cantidad < 0) {
                        System.out.println("Introduzca correctamente las cantidades");
                        System.out.print("Cantidad: ");
                        this.cantidad = this.entrada1.nextInt();
                    }//fin de restriccion
                    this.respuesta = cantidad;
                    this.respuest1 = this.respuestP * (cantidad);

                } else if (this.dateo.equals("1.8")) {

                    this.respuestP = precio_3 * factor;
                    System.out.println("el precio unitario de una computadora de " + this.dateo + " Mhz es : " + respuestP);
                    System.out.print("Cantidad: ");
                    this.cantidad = this.entrada1.nextInt();
                    //restriccion de cantidades para 1.8
                    while (cantidad < 0) {
                        System.out.println("Introduzca correctamente las cantidades");
                        System.out.print("Cantidad: ");
                        this.cantidad = this.entrada1.nextInt();
                    }
                    this.respuest1 = this.respuestP * (cantidad);
                }//fin de restriccion
                this.respuestaPI = this.respuestaPI + respuest1;
                this.numero = this.numero + cantidad;

                System.out.print("desea comprar otra computadora (SI o NO) :");
                this.letra = this.entrada.nextLine();

                //restriccion de si o no
                while ((letra.equals("si")) == false && (letra.equals("no")) == false) {
                    System.out.println("\nintroduzca la respuesta correctamente");
                    System.out.print("desea comprar otra computadora (SI o NO) :");
                    this.letra = this.entrada.nextLine();
                }//fin de restriccion de si o no

            } else {//restriccion de tipo de procesador (salida de mensaje de error)
                System.out.println("\nintroduzca correctamente el tipo de procesador");
                letra = "si";
            }

        }//fin de restriccion de tipo de procesador

    }

    public int cantidad_total() {

        return numero;
    }

    public double calculo_subtotal() {
        return respuestaPI;

    }

    public double calculo_igv(double igv) {

        return (respuestaPI) * (igv);
    }

    public double calculo_garantia(double garantia) {

        return (respuestaPI) * (garantia);
    }

    public double precio_final(double igv, double garantia) {
        return respuestaPI * (igv + garantia + 1);
    }

    public int cantidad() {
        return respuesta;
    }
}

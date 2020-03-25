package totalventa;

import java.util.Scanner;

public class TotalVenta {

    public static void main(String[] args) {

        String t;
        Logica objeto2 = new Logica("manana", "preferencial", "otro");
        objeto2.PrecioVenta();

        Logica objeto1 = new Logica();
        Scanner entrada = new Scanner(System.in);
        System.out.print("\nIngresa Turno: ");
        t = entrada.nextLine();
        System.out.println("El precio del turno " + t + " es: " + objeto1.Turno(t));
        System.out.print("Ingrese Ubicacion: ");
        t = entrada.nextLine();
        System.out.println("El precio de la ubicacion " + t + " es: " + objeto1.Ubicacion(t));
        System.out.print("Ingrese Tipo de Evento: ");
        t = entrada.nextLine();
        System.out.println("El precio del impuesto " + t + " es: " + objeto1.Impuesto(t));
        System.out.println("El precio final es: " + objeto1.Impuesto(t));

    }

}

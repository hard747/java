package areaperimetrotriangulo;

public class Logica {

    // Área de un triangulo
    public void area_perimetro(double lado1, double lado2, double lado3) {

        double respuestaArea = 0;
        String tipoTruangulo = "";

        // IMPORTANTE --> lo que se debe saber de un triangulo es que la suma de uno de sus dos lados no puede ser menor o igual que el tercer lado. NUNCA - Validación de un triangulo
        
        if (sumaLados(lado1, lado2) > lado3 && sumaLados(lado2, lado3) > lado1 && sumaLados(lado3, lado1) > lado2) {
            if (lado1 == lado2 && lado2 == lado3) {
                tipoTruangulo = "Equilátero";
                respuestaArea = Math.pow(lado1, 2) * Math.sqrt(lado1) / 4;
            } else if (lado1 == lado2) {
                tipoTruangulo = "Isoceles";
                respuestaArea = (lado3 * Math.sqrt((4 * Math.pow(lado1, 2) - Math.pow(lado3, 2)) / 4)) / 2;
            } else if (lado2 == lado3) {
                tipoTruangulo = "Isoceles";
                respuestaArea = (lado1 * Math.sqrt((4 * Math.pow(lado2, 2) - Math.pow(lado1, 2)) / 4)) / 2;
            } else if (lado3 == lado1) {
                tipoTruangulo = "Isoceles";
                respuestaArea = (lado2 * Math.sqrt((4 * Math.pow(lado3, 2) - Math.pow(lado2, 2)) / 4)) / 2;
            } else if (lado1 != lado2 && lado2 != lado3 && lado3 != lado1) {
                tipoTruangulo = "Escaleno";
                respuestaArea = Math.sqrt((perimetro(lado1, lado2, lado3) / 2) * ((perimetro(lado1, lado2, lado3) / 2) - lado1) * ((perimetro(lado1, lado2, lado3) / 2) - lado2) * ((perimetro(lado1, lado2, lado3) / 2) - lado3));
            }
            System.out.println("\n");
            System.out.println("  El Perímetro del Triangulo " + tipoTruangulo + " es: " + perimetro(lado1, lado2, lado3));
            System.out.println("  El Area del Triangulo " + tipoTruangulo + " es: " + respuestaArea);
        } else {
            System.out.println("\n");
            System.out.println("  El triangulo no existe");
        }
    }

    // Perímetro de un triangulo
    public double perimetro(double lado1, double lado2, double lado3) {

        double respuestaPerimetro = 0;

        respuestaPerimetro = lado1 + lado2 + lado3;
        return respuestaPerimetro;
    }

    public double sumaLados(double valor1, double valor2) {
        return valor1 + valor2;
    }
}

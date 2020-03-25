package Geometria2D;

import java.util.ArrayList;

public class Matemática {

    public static final double pi = 3.14159265358979323846264338327950288419716939937510,
            π = pi,
            e = 2.71828182845904523536028747135266249775724709369995957496696762772407,
            Phi = (1 + Math.sqrt(5)) / 2,
            phi = Phi,
            φ = phi,
            Φ = Phi;

    public static int[] ObtenerPrimos(int Mín, int Máx) {

        int Longitud = Máx - Mín;
        ArrayList<Integer> ListaDinamicaDePrimos = new ArrayList<>();

        for (int i = Mín; i <= Longitud; i++) {
            if (esPrimo(i)) {
                ListaDinamicaDePrimos.add(i);
            }
        }

        int[] PrimosDevolver = new int[ListaDinamicaDePrimos.size()];
        for (int i = 0; i < ListaDinamicaDePrimos.size(); i++) {
            PrimosDevolver[i] = ListaDinamicaDePrimos.get(i);
        }
        return PrimosDevolver;
    }

    public static boolean esPrimo(double numero) {
        /**
         * Descarta el número si no es natural
         */
        if (!esNatural(numero) || numero == 1) {
            return false;
        }
        /**
         * Busca los divisores del número, entre 2 y la mitad del numero
         */
        int contador = 2;
        while (contador <= numero / 2) {
            /**
             * Con un solo divisor que encuentre, retornará falso
             */
            if (numero % contador == 0) {
                return false;
            }
            contador++;
        }
        /**
         * Si pasa todas las pruebas, entonces es verdadero
         */
        return true;
    }

    public static boolean esEntero(double numero) {
        if (numero - (int) numero == 0) {
            return true;
        }
        return false;
    }

    public static boolean tieneParteDecimal(double numero) {
        return !esEntero(numero);
    }

    public static boolean esNatural(double numero) {
        if (esEntero(numero) && numero > 0) {
            return true;
        }
        return false;
    }

    public static boolean esNegativo(double numero) {
        if (numero <= 0) {
            return true;
        }
        return false;
    }

    public static boolean esPositivo(double numero) {
        if (numero >= 0) {
            return true;
        }
        return false;
    }

    public static double Grados(double radian) {
        return Math.toDegrees(radian);
    }

    public static double Radianes(double Grado) {
        return Math.toRadians(Grado);
    }

    public static double ConvertirANúmero(String textoNumerico) {
        return Double.parseDouble(textoNumerico);
    }

    public static double AcortarDecimales(double numero, int decimales) {
        return Double.parseDouble(String.format("%." + decimales + "f", numero));
    }

    public static String recortarDecimales(double Número) {
        return recortarDecimales(Número, 4);
    }

    public static String recortarDecimales(double Número, int DecimalesMáximos) {
        if (Número == (int) Número) {
            return (int) Número + "";
        }
        for (int i = 1; i <= DecimalesMáximos; i++) {
            if (Número == AcortarDecimales(Número, i)) {
                return AcortarDecimales(Número, i) + "";
            }
        }
        return AcortarDecimales(Número, DecimalesMáximos) + "";
    }

    public static double División(double numerador, double denominador) {
        return numerador / denominador;
    }

    public static double Factorial(double numero) {
        if (esEntero(numero)) {

            double factorial = 1;
            double Contador = abs(numero);
            while (Contador > 0) {
                factorial = factorial * Contador;
                Contador--;
            }

            if (esPositivo(numero)) {
                return factorial;
            } else {
                return -factorial;
            }
        }
        return Double.NaN;
    }

    public static double Ln(double numero) {
        return Math.log(numero);
    }

    public static double raízCuarta(double numero) {
        return Math.pow(numero, 1.0 / 4);
    }

    public static double raíz4(double numero) {
        return Math.pow(numero, 1.0 / 4);
    }

    public static double raízCúbica(double numero) {
        return Math.pow(numero, 1.0 / 3);
    }

    public static double raiz3(double numero) {
        return Math.pow(numero, 1.0 / 3);
    }

    public static double raízCuadrada(double numero) {
        return Math.sqrt(numero);
    }

    public static double raíz2(double numero) {
        return Math.sqrt(numero);
    }

    public static double raíz(double numero, double Índice) {
        return Math.pow(numero, 1.0 / Índice);
    }

    public static double poten4(double base) {
        return poten(base, 4);
    }

    public static double poten3(double base) {
        return poten(base, 3);
    }

    public static double poten2(double base) {
        return poten(base, 2);
    }

    public static double poten(double base, double Exponente) {
        return Math.pow(base, Exponente);
    }

    public static double Cot(double θ) {
        return 1 / Tan(θ);
    }

    public static double Coth(double x) {
        return 1 / Tanh(x);
    }

    public static double Csc(double θ) {
        return 1 / Sen(θ);
    }

    public static double Csch(double x) {
        return 1 / Senh(x);
    }

    public static double Sec(double θ) {
        return 1 / Cos(θ);
    }

    public static double Sech(double x) {
        return 1 / Cosh(x);
    }

    public static double Tan(double θ) {
        return Math.tan(θ);
    }

    public static double Tanh(double x) {
        return Math.tanh(x);
    }

    public static double Sgn(double x) {
        return x == 0 ? 0 : x > 0 ? 1 : -1;
    }

    public static double Atan2(double X, double Y) {
        return Math.atan2(Y, X);
    }

    public static double Atan(double m) {
        return Math.atan(m);
    }

    public static double Cos(double θ) {
        return Math.cos(θ);
    }

    public static double Acos(double x) {
        return Math.acos(x);
    }

    public static double Cosh(double x) {
        return Math.cosh(x);
    }

    public static double Sen4(double θ) {
        return poten4(Math.sin(θ));
    }

    public static double Cos4(double θ) {
        return poten4(Math.cos(θ));
    }

    public static double Sen3(double θ) {
        return poten3(Math.sin(θ));
    }

    public static double Cos3(double θ) {
        return poten3(Math.cos(θ));
    }

    public static double Sen2(double θ) {
        return poten2(Math.sin(θ));
    }

    public static double Cos2(double θ) {
        return poten2(Math.cos(θ));
    }

    //Curvas espaciales
    public static Dupla Poligonoide(double t, double k) {
        return Poligonoide(t, k, 0);
    }

    public static Dupla Poligonoide(double t, double k, double θ) {
        double px;
        px = (1.0 / (4 * k)) * ((4 * k - 2) * Cos(t + θ) - Cos((k + 1) * t + θ) + 3 * Cos((k - 1) * t - θ));
        double py;
        py = (1.0 / (4 * k)) * ((5 * k - 4) * Sen(t + θ) - Sen((k + 1) * t + θ) - 3 * Sen((k - 1) * t - θ));
        return new Dupla(px, py);
    }

    public static Dupla Astroide(double t, double k) {
        return Astroide(t, k, 0);
    }

    public static Dupla Astroide(double t, double k, double θ) {
        return new Dupla(((k - 1) * Cos(t + θ) + Cos((k - 1) * t - θ)) / k, ((k - 1) * Sen(t + θ) - Sen((k - 1) * t - θ)) / k);
    }

    public static Dupla Cardioide(double t, double k) {
        return Astroide(t, -k, 0);
    }

    public static Dupla Cardioide(double t, double k, double θ) {
        return Astroide(t, -k, θ);
    }

    public static Dupla Circulo(double t) {
        return Circulo(t, 1, Dupla.ORIGEN);
    }

    public static Dupla Circulo(double t, double r) {
        return Circulo(t, r, Dupla.ORIGEN);
    }

    public static Dupla Circulo(double t, double r, Dupla centro) {
        return new Dupla(Cos(t), Sen(t)).Adicionar(centro).Multiplicar(r);
    }

    public static Dupla AntiCirculo(double t, double k) {
        return Contra(t, (2 * π) / k, (double t1) -> new Dupla(Cos(t1), Sen(t1)));
    }

    public static Dupla AntiAstroide(double t, double k) {
        return Contra(t, (2 * π) / k, (double t1) -> Astroide(t1, k));
    }

    public static Dupla Contra(double t, double k, FunciónProg_XY curva) {
//        k = abs(k); //Relación entre vertices
        double CVR = Piso(abs(t) / k);
        double θi = (Sgn(t) * CVR * k); //Ángulo Inicial del segmento del Lado
        double θf = (θi + Sgn(t) * k); //Ángulo final del segmento del Lado
        double ti = θf - t + θi; //Transformación del parámetro para que recorra el segmento al contrario
        double Tx = curva.XY(θi).X + curva.XY(θf).X;
        double Ty = curva.XY(θi).Y + curva.XY(θf).Y;
        return curva.XY(ti).Multiplicar(-1).Adicionar(new Dupla(Tx, Ty));
    }

    public static FunciónProg_XY ContraF(double t, double k, FunciónProg_XY curva) {
//        k = abs(k); //Relación entre vertices
        return new FunciónProg_XY() {
            @Override
            public Dupla XY(double t) {
                double CVR = Piso(abs(t) / k);
                double θi = (Sgn(t) * CVR * k); //Ángulo Inicial del segmento del Lado
                double θf = (θi + Sgn(t) * k); //Ángulo final del segmento del Lado
                double ti = θf - t + θi; //Transformación del parámetro para que recorra el segmento al contrario
                double Tx = curva.XY(θi).X + curva.XY(θf).X;
                double Ty = curva.XY(θi).Y + curva.XY(θf).Y;
                return curva.XY(ti).Multiplicar(-1).Adicionar(new Dupla(Tx, Ty));
            }
        };
    }

    public static Dupla Poligono(double t, double k) {
        return Circulo(t).Adicionar(AntiCirculo(t, k)).Dividir(2);
    }

    //Fin de Curvas Especiales.
    public static double Sen(double θ) {
        return Math.sin(θ);
    }

    public static double Asen(double y) {
        return Math.asin(y);
    }

    public static double Senh(double x) {
        return Math.sinh(x);
    }

    public static double abs(double Numero) {
        return Math.abs(Numero);
    }

    public static int abs(int Numero) {
        return Math.abs(Numero);
    }

    public static int Redondear_a_entero_más_cercano(double numero) {
        return (int) Math.round(numero);
    }

    public static int Piso(double numero) {
        return (int) numero;
    }

    public static int Floor(double numero) {
        return Piso(numero);
    }

    public static int Techo(double numero) {
        return (int) Math.ceil(numero);
    }

    public static int Ceil(double numero) {
        return Techo(numero);
    }

    public static double TeoremaDePitagoras(double a, double b) {
        return raízCuadrada(poten2(a) + poten2(b));
    }
}

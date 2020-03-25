package Geometria2D;

public abstract class FunciónXY extends Matemática implements FunciónProg_XY {

    /**
     * Es una aproximación numérica con Δx = 0.00000000001, aunque no es un
     * procedimiento analítico se aproxima mucho al resultado.
     *
     * @param x
     * @return
     */
    public double derivadaPuntoX(int x) {
        double Δx = 0.00000000001;
        double Δy = XY(x + Δx).Y - XY(x).Y;
        return Δy / Δx;
    }

    /**
     * Es una aproximación numérica de n divisiones, aunque no es un
     * procedimiento analítico se aproxima mucho al resultado.
     *
     * @param a limite inferior
     * @param b limite superior
     * @param numeroDivisiones
     * @return integral de a hasta b de la función.
     */
    public double IntegralDefinida(int a, int b, int numeroDivisiones) {
        double n = numeroDivisiones;
        double Δx = (b - a) / n;

        double sumatoria = 0;

        for (int i = 0; i <= n - 1; i++) {
            double Xi = a + Δx * i;
            sumatoria += i == 0 ? 0 : (2 * XY(Xi).Y);
        }

        return (Δx / 2) * (XY(a).Y + sumatoria + XY(b).Y);
    }

    /**
     * Es una aproximación numérica con 1000 divisiones, aunque no es un
     * procedimiento analítico se aproxima mucho al resultado.
     *
     * @param a limite inferior
     * @param b limite superior
     * @return integral de a hasta b de la función.
     */
    public double IntegralDefinida(int a, int b) {
        return IntegralDefinida(a, b, 1000);
    }

    /**
     * Es una aproximación numérica con n divisiones, aunque no es un
     * procedimiento analítico se aproxima mucho al resultado.
     *
     * @param a limite inferior
     * @param b limite superior
     * @param numeroDivisiones Cantidad de rebanadas.
     * @return Longitud de la curva de a hasta b
     */
    public double LongitudDeCurva(int a, int b, int numeroDivisiones) {
        double n = numeroDivisiones;
        double Δx = (b - a) / n;

        double sumatoria = 0;

        for (int i = 0; i <= n; i++) {
            double Xi = a + Δx * i;
            double Δy = XY(Xi).Sustraer(XY(Xi - Δx)).Y;
            sumatoria += i == 0 ? 0 : (TeoremaDePitagoras(Δx, Δy));
        }
        return sumatoria;
    }

    /**
     * Es una aproximación numérica con 1000 divisiones, aunque no es un
     * procedimiento analítico se aproxima mucho al resultado.
     *
     * @param a limite inferior
     * @param b limite superior
     * @return Longitud de la curva de a hasta b
     */
    public double LongitudDeCurva(int a, int b) {
        return LongitudDeCurva(a, b, 1000);
    }

    public boolean PuntoPertenece(Dupla punto) {
        return XY(punto.X).X == punto.Y;
    }

    public boolean PuntoPorEncima(Dupla punto) {
        return XY(punto.X).X > punto.Y;
    }

    public boolean PuntoPorDebajo(Dupla punto) {
        return !PuntoPorEncima(punto);
    }

    public boolean PuntoPorDerecha(Dupla punto) {
        return XY(punto.Y).Y < punto.X;
    }

    public boolean PuntoPorIzquierda(Dupla punto) {
        return !PuntoPorDerecha(punto);
    }
    
}

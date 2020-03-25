package Geometria2D;

import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Dupla extends Matemática {

    public double X, Y;
    public static final Dupla ORIGEN = new Dupla(0, 0);
    public static final Dupla HERRAMIENTA = new Dupla(0, 0);

    public Dupla() {
        this.X = 0;
        this.Y = 0;
    }

    public Dupla(double X, double Y) {
        this.X = X;
        this.Y = Y;
    }

    public Dupla(Dupla dupla) {
        this.X = dupla.X;
        this.Y = dupla.Y;
    }

    public Dupla(Point punto) {
        this.X = punto.x;
        this.Y = punto.y;
    }

    public boolean esIgual(Dupla dupla) {
        return esIgual(dupla.X, dupla.Y);
    }

    public boolean esIgual(Dupla[] duplas) {
        for (int i = 0; i < duplas.length; i++) {
            Dupla dupla = duplas[i];
            if (esIgual(dupla.X, dupla.Y)) {
                return true;
            }
        }
        return false;
    }

    public boolean esIgual(double x, double y) {
        if (X == x && Y == y) {
            return true;
        }
        return false;
    }

    public void sustituir(double nuevoX, double nuevoY) {
        X = nuevoX;
        Y = nuevoY;
    }

    public void sustituirX(double nuevoX) {
        X = nuevoX;
    }

    public void sustituirY(double nuevoY) {
        Y = nuevoY;
    }

    public void sustituir(Dupla dupla) {
        X = dupla.X;
        Y = dupla.Y;
    }

    public int intX() {
        return (int) X;
    }

    public int intY() {
        return (int) Y;
    }

    public int intX_rnd() {
        return Redondear_a_entero_más_cercano(X);
    }

    public int intY_rnd() {
        return Redondear_a_entero_más_cercano(Y);
    }

    public Dupla Adicionar(Dupla dupla) {
        return new Dupla(X += dupla.X, Y += dupla.Y);
    }

    public Dupla AdicionarX(Dupla dupla) {
        return new Dupla(X += dupla.X, Y);
    }

    public Dupla AdicionarX(double x) {
        return new Dupla(X += x, Y);
    }

    public Dupla AdicionarY(Dupla dupla) {
        return new Dupla(X, Y += dupla.Y);
    }

    public Dupla AdicionarY(double y) {
        return new Dupla(X, Y += y);
    }

    public Dupla Adicionar(double X, double Y) {
        return Adicionar(new Dupla(X, Y));
    }

    public Dupla Adicionar(double a) {
        return Adicionar(a, a);
    }

    public Dupla Clonar() {
        return new Dupla(X, Y);
    }

    public Dupla Invertir() {
        return new Dupla(Y, X);
    }

    public Dupla Dividir(double Numero) {
        return new Dupla(X /= Numero, Y /= Numero);
    }

    public Dupla Dividir(Dupla dupla) {
        return new Dupla(X /= dupla.X, Y /= dupla.Y);
    }

    public Dupla Multiplicar(double Numero) {
        return new Dupla(X *= Numero, Y *= Numero);
    }

    public Dupla Multiplicar(Dupla dupla) {
        return new Dupla(X *= dupla.X, Y *= dupla.Y);
    }

    public void CambiarX(double X) {
        this.X = X;
    }

    public void CambiarY(double Y) {
        this.Y = Y;
    }

    public double min() {
        return X < Y ? X : Y;
    }

    public double max() {
        return X > Y ? X : Y;
    }

    public void mover1Derecha() {
        X++;
    }

    public void mover1Izquierda() {
        X--;
    }

    public void mover1Abajo() {
        Y++;
    }

    public void mover1Arriba() {
        Y--;
    }

    public double Ángulo(Dupla centro) {
        double θ = Math.atan2(centro.Y - Y, X - centro.X);
        if (θ < 0) {
            θ = θ + 2 * π;
        }
        return θ;
    }

    public double Ángulo(double x, double y) {
        return Ángulo(new Dupla(x, y));
    }

    public double Ángulo() {
        return Ángulo(ORIGEN);
    }

    public void ÁnguloImprimir(Dupla centro) {
        System.out.println(Math.toDegrees(Ángulo(centro)) + "°");
    }

    public void ÁnguloImprimir() {
        ÁnguloImprimir(ORIGEN);
    }

    public void girar(double Δθ) {
        double θ = Atan2(X, Y);
        Δθ = Δθ * π / 180;
        θ -= Δθ;
        double r = Radio();
        double x = r * Cos(θ);
        double y = r * Sen(θ);
        X = x;
        Y = y;
    }

    public void g90Derecha() {
        double temp = X;
        X = -Y;
        Y = temp;
    }

    public void g90Izquierda() {
        double temp = X;
        X = Y;
        Y = -temp;
    }

    public Dupla distanciaDirigidaPunto(Dupla punto) {
        return new Dupla(X - punto.X, Y - punto.Y);
    }

    public double distanciaPunto(Dupla punto) {
        return TeoremaDePitagoras(X - punto.X, Y - punto.Y);
    }

    public double distanciaPunto(double x, double y) {
        return distanciaPunto(new Dupla(x, y));
    }

    public double Radio(Dupla centro) {
        return distanciaPunto(centro);
    }

    public double Radio() {
        return Radio(ORIGEN);
    }

    public double absX() {
        return abs(X);
    }

    public double absY() {
        return abs(Y);
    }

    public Dupla Sustraer(Dupla dupla) {
        return new Dupla(X -= dupla.X, Y -= dupla.Y);
    }

    public Dupla Sustraer(double X, double Y) {
        return Sustraer(new Dupla(X, Y));
    }

    @Override
    public String toString() {
        return "Dupla(" + "X=" + X + ", Y=" + Y + ')';
    }

    public void ImprimirDuplaNombre(String nombre) {
        System.out.println(nombre + this);
    }

    public void ImprimirDupla() {
        System.out.println(this);
    }

    /**
     * Obtener las dimensiones de un texto
     *
     * @param g
     * @param TextoDimensión
     */
    public Dupla(Graphics2D g, String TextoDimensión) {
        this.X = medidoDeString(g, TextoDimensión).X;
        this.Y = medidoDeString(g, TextoDimensión).Y;
    }

    public Dupla UbicarRectanguloDentroDeOtro(Dupla RectanguloGrande, Dupla RectanguloPequeño) {
        return new Dupla((RectanguloGrande.X - RectanguloPequeño.X) / 2, (RectanguloGrande.Y - RectanguloPequeño.Y) / 2);
    }

    public Dupla medidoDeString(Graphics2D g, String Texto) {
        FontMetrics fm = g.getFontMetrics();

        double anchoTexto = fm.stringWidth(Texto);
        double altoTexto = fm.getLineMetrics(Texto, g).getHeight();

        return new Dupla(anchoTexto, altoTexto);
    }

    public void DibujarEtiqueta(Graphics2D g, String Texto, Dupla PosiciónEtiqueta, Dupla TamañoEtiqueta) {
        Dupla tamañoTexto = medidoDeString(g, Texto);
        Dupla PosicionTexto = UbicarRectanguloDentroDeOtro(TamañoEtiqueta, tamañoTexto);
        PosicionTexto.AdicionarY(tamañoTexto.Y);

        g.drawString(Texto,
                PosiciónEtiqueta.intX() + PosicionTexto.intX(),
                PosiciónEtiqueta.intY() + PosicionTexto.intY());
//        
//        g.setColor(new Color(0, 0, 0, 50));
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                g.drawRect(PosiciónEtiqueta.intX() + TamañoEtiqueta.intX() / 2 * i,
//                        PosiciónEtiqueta.intY() + TamañoEtiqueta.intY() / 2 * j,
//                        TamañoEtiqueta.intX() / 2, TamañoEtiqueta.intY() / 2);
//            }
//        }
    }

}

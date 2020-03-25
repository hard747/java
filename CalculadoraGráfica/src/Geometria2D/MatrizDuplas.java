package Geometria2D;

import java.awt.Graphics;
import java.util.ArrayList;

public class MatrizDuplas extends ArrayList<Dupla> {

    public MatrizDuplas() {
    }

    public void Agregar(Dupla Punto) {
        add(Punto);
    }

    public void Agregar(double x, double y) {
        add(new Dupla(x, y));
    }

    public Dupla Obtener(int Punto) {
        return get(Punto);
    }

    /**
     * Remueve un elemento de la matriz, corriendo los demas un puesto a la
     * izquierda, aprovechando un metodo que hereda de ArrayList
     * remove(IndiceElemento).
     *
     * @param IndiceElemento
     */
    public void Eliminar(int IndiceElemento) {
        remove(IndiceElemento);
    }

    /**
     * Remueve todos los elementos de la matriz, aprovechando un metodo que
     * hereda de ArrayList clear().
     */
    public void Reiniciar() {
        clear();
    }

    public void Sustituir(int Punto, Dupla Punto_Nuevo) {
        set(Punto, Punto_Nuevo);
    }

    /**
     * Dibuja los datos en un intervalo de indices especificados,
     * representadolos en un poligono para toda la matriz dentro de un objeto
     * Graphics usando el metodo drawPolygon y un centro relativo.
     *
     * @param g
     * @param centro
     * @param Indice_mín
     * @param Indice_máx
     */
    public void dibujarPoligono(Graphics g, Dupla centro, int Indice_mín, int Indice_máx) {
        g.drawPolygon(intXs(centro, Indice_mín, Indice_máx), intYs(centro), Indice_máx-Indice_mín);
    }

    public void dibujarPoligonoPintado(Graphics g, Dupla centro, int Indice_mín, int Indice_máx) {
        g.fillPolygon(intXs(centro, Indice_mín, Indice_máx), intYs(centro, Indice_mín, Indice_máx), Indice_máx-Indice_mín);
    }

    public void dibujarLinea(Graphics g, Dupla centro, int Indice_mín, int Indice_máx) {
        g.drawPolyline(intXs(centro, Indice_mín, Indice_máx), intYs(centro), Indice_máx-Indice_mín);
    }

    /**
     * Dibuja los datos en un intervalo de indices especificados,
     * representadolos en un poligono para toda la matriz dentro de un objeto
     * Graphics usando el metodo drawPolygon y un centro ubicado en el origen.
     *
     * @param g
     * @param centro
     * @param Indice_mín
     * @param Indice_máx
     */
    public void dibujarPoligono(Graphics g, int Indice_mín, int Indice_máx) {
        dibujarPoligono(g, Dupla.ORIGEN, Indice_mín, Indice_máx);
    }

    public void dibujarPoligonoPintado(Graphics g,int Indice_mín, int Indice_máx) {
        dibujarPoligonoPintado(g, Dupla.ORIGEN, Indice_mín, Indice_máx);
    }

    public void dibujarLinea(Graphics g, int Indice_mín, int Indice_máx) {
        dibujarLinea(g, Dupla.ORIGEN, Indice_mín, Indice_máx);
    }

    /**
     * Dibuja todos los datos, representadolos en un poligono para toda la
     * matriz dentro de un objeto Graphics usando el metodo drawPolygon y un
     * centro relativo.
     *
     * @param g
     * @param centro
     */
    public void dibujarPoligono(Graphics g, Dupla centro) {
        dibujarPoligono(g, centro, 0, size());
    }

    public void dibujarPoligonoPintado(Graphics g, Dupla centro) {
        dibujarPoligonoPintado(g, centro, 0, size());
    }

    /**
     * Dibuja todos los datos, representadolos en una linea para toda la matriz
     * dentro de un objeto Graphics usando el metodo Polyline y un centro
     * relativo.
     *
     * @param g
     * @param centro
     */
    public void dibujarLinea(Graphics g, Dupla centro) {
        dibujarLinea(g, centro, 0, size());
    }

    /**
     * Dibuja todos los datos, representadolos en un poligono para toda la
     * matriz dentro de un objeto Graphics usando el metodo drawPolygon y un
     * centro ubicado en el origen.
     *
     * @param g
     */
    public void dibujarPoligono(Graphics g) {
        dibujarPoligono(g, Dupla.ORIGEN);
    }

    public void dibujarPoligonoPintado(Graphics g) {
        dibujarPoligonoPintado(g, Dupla.ORIGEN);
    }

    public void dibujarLinea(Graphics g) {
        dibujarLinea(g, Dupla.ORIGEN);
    }

    /**
     * Este metodo representa un arreglo unidimensional de enteros que contiene
     * a todos los datos de "X" almacenados en la matriz.
     *
     * @param centro
     * @param mín - Indice mínimo para obtener los puntos
     * @param máx - Indice máximo para obtener los puntos
     * @return
     */
    private int[] intXs(Dupla centro, int mín, int máx) {
        if (mín < 0 || máx > size()) {
            throw new Error("Se ha salido del rango admitido [0," + size() + "] , "
                    + "rango insertado = [" + mín + "," + máx + "]");
        }
        if (mín>máx) {
            throw new Error("Limites trucados Mín>Máx");
        }
        int[] X = new int[máx - mín];
        for (int i = mín; i < máx; i++) {
            X[i] = Obtener(i).intX() + centro.intX();
        }
        return X;
    }

    /**
     * Este metodo representa un arreglo unidimensional de enteros que contiene
     * a todos los datos de "X" almacenados en la matriz, con un centro
     * relativo.
     *
     * @param centro - relativo
     * @return
     */
    private int[] intXs(Dupla centro) {
        return intXs(centro, 0, size());
    }

    /**
     * Este metodo representa un arreglo unidimensional de enteros que contiene
     * a todos los datos de "X" almacenados en la matriz, con un centro
     * relativo.
     *
     * @param x - dato "X" del centro
     * @param y - dato "Y" del centro
     */
    private int[] intXs(double x, double y) {
        return intXs(new Dupla(x, y));
    }

    /**
     * Este metodo representa un arreglo unidimensional de enteros que contiene
     * a todos los datos de "X" almacenados en la matriz, con centro en el
     * origen.
     */
    private int[] intXs() {
        return intXs(Dupla.ORIGEN);
    }

    /**
     * Este metodo representa un arreglo unidimensional de enteros que contiene
     * a todos los datos de "Y" almacenados en la matriz, con centro relativo.
     *
     * @param centro - relativo
     * @param mín - Indice mínimo para obtener los puntos
     * @param máx - Indice máximo para obtener los puntos
     */
    private int[] intYs(Dupla centro, int mín, int máx) {
        if (mín < 0 || máx > size()) {
            throw new Error("Se ha salido del rango admitido [0," + size() + "] , "
                    + "rango insertado = [" + mín + "," + máx + "]");
        }
        int[] Y = new int[máx - mín];
        for (int i = mín; i < máx; i++) {
            Y[i] = this.Obtener(i).intY() + centro.intY();
        }
        return Y;
    }

    private int[] intYs(Dupla centro) {
        return intYs(centro, 0, size());
    }

    private int[] intYs(double x, double y) {
        return intYs(new Dupla(x, y));
    }

    private int[] intYs() {
        return intYs(new Dupla(0, 0));
    }

    private double[] Xs(Dupla centro) {
        double[] X = new double[this.size()];
        for (int i = 0; i < size(); i++) {
            X[i] = this.Obtener(i).X + centro.X;
        }
        return X;
    }

    private double[] Xs(double x, double y) {
        return Xs(new Dupla(x, y));
    }

    private double[] Xs() {
        return Xs(new Dupla(0, 0));
    }

    private double ObtenerX(int posición) {
        return Obtener(posición).X;
    }

    private double[] Ys(Dupla centro) {
        double[] Y = new double[size()];
        for (int i = 0; i < size(); i++) {
            Y[i] = this.Obtener(i).Y + centro.Y;
        }
        return Y;
    }

    private double[] Ys(double x, double y) {
        return Ys(new Dupla(x, y));
    }

    private double[] Ys() {
        return Ys(new Dupla(0, 0));
    }

    private double ObtenerY(int posición) {
        return Obtener(posición).Y;
    }

    public void ImprimirMapa() {
        for (int i = 0; i < size(); i++) {
            System.out.println(Obtener(i) + "Punto " + i);
        }
    }

    /**
     * El arreglo de duplas asume que cada dupla es el vértice de un polígono,
     * halla el área multiplicando la determinante de la matriz por un medio.
     *
     * @return área
     */
    public double ÁreaVertices() {
        double Area = 0;
        for (int i = 0; i < Xs().length; i++) {
            if (i == Xs().length - 1) {
                Area += ObtenerX(i) + ObtenerY(0);
                Area -= ObtenerX(0) + ObtenerY(i);
            } else {
                Area += ObtenerX(i) + ObtenerY(i + 1);
                Area -= ObtenerX(i + 1) + ObtenerY(i);
            }
        }
        return Area / 2;
    }
}

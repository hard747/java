package Geometria2D;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class ObjetoGeometrico2D extends Matemática {

    public Dupla Posición;

    MatrizDuplas MapaFigura = new MatrizDuplas();

    public void cambiarPosición(Dupla NuevaPosición) {
        Posición.sustituir(NuevaPosición);
    }

    public void Mover(Dupla Δxy) {
        Posición.Adicionar(Δxy);
    }

    public void girarPoligono(double Δθ) {
        for (int i = 0; i < MapaFigura.size(); i++) {
            MapaFigura.Obtener(i).girar(Δθ);
        }
    }

    public void dibujarPoligono(Graphics g, Dupla centro) {
        MapaFigura.dibujarPoligono(g, centro);
    }

    public void dibujarPoligonoRelleno(Graphics g, Dupla centro) {
        MapaFigura.dibujarPoligonoPintado(g, centro);
    }

    public void lineaPunteadaUniforme(Graphics2D g, float grosor) {
        float guiones[] = {25.0f, 25.0f};
        g.setStroke(new BasicStroke(grosor, /*Grosor*/
                BasicStroke.CAP_ROUND, /*Estilo de la terminación de la linea*/
                BasicStroke.CAP_ROUND, /*Estilo del vertice*/
                10,
                guiones, /*Estilo de los guiones, separaciones y largores*/
                0 /*Desface*/
        ));
    }

    public void lineaPunteada(Graphics2D g, float grosor) {
        float guiones[] = {
            21.0f, /*Largor Primera linea*/
            9.0f, /*Largor Primer Espacio*/
            3.0f, /*Largor Segunda Linea*/
            9.0f/*Largor segundo espacio*/};
        g.setStroke(new BasicStroke(grosor, /*Grosor*/
                BasicStroke.CAP_ROUND, /*Estilo de la terminación de la linea*/
                BasicStroke.CAP_ROUND, /*Estilo del vertice*/
                10,
                guiones, /*Estilo de los guiones, separaciones y largores*/
                0 /*Desface*/
        ));
    }

    public void GrosorLinea(Graphics2D g, float grosor) {
        g.setStroke(new BasicStroke(grosor, /*Grosor de linea*/
                BasicStroke.CAP_ROUND, /*Estilo puntas*/
                BasicStroke.JOIN_ROUND));
        /*Estilo vertices*/
    }

    public abstract void Dibujar(Graphics g);

    public abstract void DibujarRelleno(Graphics g);

}

package Geometria2D;

import java.awt.Graphics;

public class Astroide extends Poligono_Paramétrico {

    double Radio;
    int Vertices;

    public Astroide(double radio, int Vertices, Dupla posición) {
        this.Posición = posición;
        this.Vertices = Vertices;
        this.Radio = radio;
        girar = false;
        llenarPoligonoMapa(60);
    }

    @Override
    public void Dibujar(Graphics g) {
        dibujarPoligono(g, Posición);
    }
    @Override
    public void DibujarRelleno(Graphics g) {
        dibujarPoligonoRelleno(g, Posición);
    }

    @Override
    public Dupla XY(double t) {
        return new Dupla(-(Radio * (Vertices - 1) * Sen(t) - Radio * Sen((Vertices - 1) * t)),Radio * (Vertices - 1) * Cos(t) + Radio * Cos((Vertices - 1) * t));
    }

}

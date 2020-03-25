package Geometria2D;

import java.awt.Graphics;

public abstract class Poligono_Paramétrico extends ObjetoGeometrico2D implements FunciónProg_XY {

    double desfaceθ = 0;
    boolean girar = true;

    public void DibujarRadio(Graphics g, Dupla punto) {
        double θ = punto.Ángulo(Posición);
        Dupla punto2 = XY(θ).Adicionar(Posición);
        g.drawLine(Posición.intX(), Posición.intY(),
                punto2.intX(), punto2.intY());
    }

    @Override
    public void girarPoligono(double Δθ) {
        if (girar) {
            for (int i = 0; i < MapaFigura.size(); i++) {
                MapaFigura.Obtener(i).girar(Δθ);
            }
            desfaceθ -= Δθ * π / 180;
        }
    }

    public void llenarPoligonoMapa(int puntosDeMapa) {
        MapaFigura.clear();
        llenarPoligonoMapa(puntosDeMapa, 0, 2 * π);
    }

    public void llenarPoligonoMapa(int puntosDeMapa, double θi, double θf) {
        MapaFigura.clear();
        double Δθ = θf / puntosDeMapa;
        for (double θ = θi; θ < θf; θ += Δθ) {
            Dupla punto = XY(θ);
            MapaFigura.Agregar(punto);
        }
    }
    
    public int[] PuntosX() {
        int[] puntosX = new int[MapaFigura.size()];
        for (int i = 0; i < MapaFigura.size(); i++) {
          puntosX[i] = MapaFigura.get(i).intX();
        }
        return puntosX;
    }
    
    public int[] PuntosY() {
        int[] puntosY = new int[MapaFigura.size()];
        for (int i = 0; i < MapaFigura.size(); i++) {
          puntosY[i] = MapaFigura.get(i).intY();
        }
        return puntosY;
    }

}

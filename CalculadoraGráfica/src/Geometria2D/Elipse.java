package Geometria2D;

import java.awt.Graphics;

public class Elipse extends PoligonoPolar {

    double radioX, radioY;

    public Elipse(double radioX, double radioY, Dupla Posición) {
        this.Posición = Posición;
        this.radioX = radioX;
        this.radioY = radioY;
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
        return new Dupla(radioX*Cos(t+desfaceθ),-radioY*Sen(t+desfaceθ));
    }
    
}

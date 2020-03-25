package Herramientas;

import Geometria2D.*;
import calculadoragráfica.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import javax.swing.SwingUtilities;

public class Raton extends MouseAdapter {

    Point posicion;
    SuperficieDeDibujo superficieDeDibujo;

    public Raton(SuperficieDeDibujo superficieDeDibujo) {
        posicion = new Point();
        this.superficieDeDibujo = superficieDeDibujo;
    }

    public Dupla posición() {
         Dupla devolución = new Dupla(posicion);
        return devolución;
    }

    public void actualizarPosicion() {
        Point posicionActual = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(posicionActual, superficieDeDibujo);
        posicion = posicionActual;
    }

    public void dibujar(final Graphics g) {
        actualizarPosicion();
        int tamañoLetra = 12;
        g.setColor(Color.WHITE);
        g.setFont(new Font("verdana", Font.CENTER_BASELINE, tamañoLetra));
        g.drawString("X: " + posicion.getX() + " -  Y: " + posicion.getY(), 0, tamañoLetra);
    }

    private static Dupla DimensionTexto(Graphics g, String Texto) {
        FontMetrics MetricaDeFuente = g.getFontMetrics();
        return new Dupla(MetricaDeFuente.stringWidth(Texto), MetricaDeFuente.getLineMetrics(Texto, g).getHeight());
    }

}

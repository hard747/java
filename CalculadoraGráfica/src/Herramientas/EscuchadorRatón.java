package Herramientas;

import calculadoragráfica.*;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class EscuchadorRatón implements MouseListener, MouseMotionListener, MouseWheelListener {

    private SuperficieDeDibujo superficieDeDibujo;
    public boolean clicIzquierdo_Press = false;
    public boolean clicDerecho_Press = false;
    Raton ratón;

    public EscuchadorRatón(SuperficieDeDibujo superficieDeDibujo) {

        this.ratón = new Raton(superficieDeDibujo);
        this.superficieDeDibujo = superficieDeDibujo;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        switch (me.getButton()) {
            case MouseEvent.BUTTON1://clic izquierdo
                clicIzquierdo_Press = true;
                break;
            case MouseEvent.BUTTON3://clic izquierdo
                clicDerecho_Press = true;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        switch (me.getButton()) {
            case MouseEvent.BUTTON1://clic izquierdo
                clicIzquierdo_Press = false;
                break;
            case MouseEvent.BUTTON3://clic izquierdo
                clicDerecho_Press = false;
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    /**
     * El mouse se presiona y se mueve.
     *
     * @param me
     */
    @Override
    public void mouseDragged(MouseEvent me) {
    }

    /**
     * El Mouse se mueve
     */
    @Override
    public void mouseMoved(MouseEvent me) {
        ratón.actualizarPosicion();
    }

    /**
     * Sentido del Scroll.
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        if (mwe.getWheelRotation() < 0) {
            /*
            (+)
             */
//            Espacio.cambiarZoom(4);
        } else {
            /*
            (-)
             */
//            Espacio.cambiarZoom(-4);
        }
    }

    public void PresionarBotones() {
    }

    public void liberarBotones() {
    }

}

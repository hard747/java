package Herramientas;

import calculadoragráfica.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscuchadorTeclado implements KeyListener {

    SuperficieDeDibujo superficieDeDibujo;
    Plano plano;

    public EscuchadorTeclado(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
        plano = superficieDeDibujo.plano;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Tecla Presionada");
        
        switch (e.getKeyCode()) {

            case KeyEvent.VK_1:
                plano.DibujarLineasGuias = !plano.DibujarLineasGuias;
                return;

            case KeyEvent.VK_2:
                plano.DibujarEjes = !plano.DibujarEjes;
                return;

            case KeyEvent.VK_3:
                plano.DibujarNumeros = !plano.DibujarNumeros;
                return;

            case KeyEvent.VK_PLUS:
                plano.función.n++;
                return;

            case KeyEvent.VK_X:
                if (plano.UnidadDeEscala - plano.d < 1) {
                    plano.UnidadDeEscala /= 2;
                } else {
                    plano.UnidadDeEscala--;
                }
                return;

            case KeyEvent.VK_SPACE:
                plano.cambiarZoom(5);
                return;

            case KeyEvent.VK_Z:
                plano.cambiarZoom(1);
                return;

            case KeyEvent.VK_F:
                plano.función.cometa = plano.función.puntosTabular + 1;
                plano.función.tabular();
                return;

            case KeyEvent.VK_I:
                plano.función.Inversa();
                return;

            case KeyEvent.VK_R:
                plano.función.relleno = !plano.función.relleno;
                return;

            case KeyEvent.VK_A:
                plano.función.V_EnMovimiento = !plano.función.V_EnMovimiento;
                return;

            case KeyEvent.VK_MINUS:
                plano.función.n--;
                return;

            case KeyEvent.VK_0:
                plano.UnidadDeEscala = plano.IntervaloDeSeparaciónEntreUnidades;
                plano.Desplazar_Sustituir(0, 0);
                return;

            case KeyEvent.VK_LEFT:
                plano.Desplazar(3, 0);
                return;

            case KeyEvent.VK_RIGHT:
                plano.Desplazar(-3, 0);
                return;

            case KeyEvent.VK_UP:
                plano.Desplazar(0, -3);
                return;

            case KeyEvent.VK_DOWN:
                plano.Desplazar(0, 3);
                return;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        switch (ke.getKeyCode()) {
            case KeyEvent.VK_CONTROL:
                break;
            case KeyEvent.VK_P:
                superficieDeDibujo.pantallazo();
                break;
        }
    }

}

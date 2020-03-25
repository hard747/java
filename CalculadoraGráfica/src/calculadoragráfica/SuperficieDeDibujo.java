package calculadoragráfica;

import Geometria2D.*;
import Imagen.*;
import Herramientas.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class SuperficieDeDibujo extends Canvas implements Runnable {

    private BufferStrategy buffer;
    private Graphics2D g;
    Imagen imagen;

    boolean selecciónConCursor = false;
    boolean VerFunción = false;

    BufferedImage imagenVerFunción;
    public Plano plano = new Plano();

    EscuchadorTeclado EscuchadorTeclado = new EscuchadorTeclado(this);
    EscuchadorRatón EscuchadorRatón = new EscuchadorRatón(this);

    Thread Hilo = new Thread(this);

    public SuperficieDeDibujo(int ancho, int alto) {
        setSize(ancho, alto);
        addKeyListener(EscuchadorTeclado);
        addMouseListener(EscuchadorRatón);
        addMouseMotionListener(EscuchadorRatón);
        addMouseWheelListener(EscuchadorRatón);
        setFocusable(true);
        imagen = new Imagen(this);
    }

    public void dibujar() throws InterruptedException {
        buffer = getBufferStrategy();
        if (buffer == null) {
            createBufferStrategy(2);
            return;
        }
        g = (Graphics2D) buffer.getDrawGraphics();
        BufferedImage imagenMuestra = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = (Graphics2D) imagenMuestra.getGraphics();
        DibujarElementos(g2);
        g.drawImage(imagenMuestra, 0, 0, null);
        g.dispose();
        buffer.show();
    }

    public void DibujarElementos(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (VerFunción) {
            g.drawImage(imagenVerFunción, 0, 0, null);
        } else {
            plano.dibujar(g, Tamaño());
        }
    }

    public void pantallazo() {
        try {
            BufferedImage imagen
                    = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = (Graphics2D) imagen.getGraphics();
            DibujarElementos(g2);
            imagen = this.imagen.Escalar(imagen, imagen.getWidth() * 2, imagen.getHeight() * 2, false);

            JFileChooser file = new JFileChooser();
            file.setDialogTitle("Guardar Pantallazo - Jeff Aporta");
            file.showSaveDialog(this);
            File File = file.getSelectedFile();
            if (File != null) {
                ImageIO.write(imagen, "png", File);
            } else {
                JOptionPane.showMessageDialog(null, "El pantallazo no ha sido guardado", "Jeff Informa Que", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | IOException ex) {

        }
    }

    public Dupla centro() {
        return new Dupla(this.getWidth() / 2, this.getHeight() / 2);
    }

    public Dupla Tamaño() {
        return new Dupla(this.getWidth(), this.getHeight());
    }

    @Override
    public void run() {
        try {
            while (true) {
                dibujar();
                Thread.sleep(50); //por ahora descansará 1 segundo
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SuperficieDeDibujo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

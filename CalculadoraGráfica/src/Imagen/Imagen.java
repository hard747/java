package Imagen;

import Geometria2D.Dupla;
import calculadoragráfica.SuperficieDeDibujo;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Imagen extends FiltrosDeColor{

    SuperficieDeDibujo superficieDeDibujo;

    public Imagen(SuperficieDeDibujo superficieDeDibujo) {
        this.superficieDeDibujo = superficieDeDibujo;
    }

    public void dibujarImagen(Dupla pos, BufferedImage imagen, Graphics g) {
        g.drawImage(imagen,
                pos.intX(), pos.intY(), superficieDeDibujo);
    }

    public BufferedImage cargarImagen(String nombre, String extension) {
        return cargarImagen(nombre, extension, null);
    }

    public BufferedImage cargarImagen(String nombre, String extension, Dupla Tamaño) {
        BufferedImage Imagen = null;
        try {
            Imagen = ImageIO.read(ClassLoader.class.getResource("/" + nombre + "." + extension));
            if (Tamaño != null) {
                Imagen = Escalar(Imagen, Tamaño.intX(), Tamaño.intY(), false);
            }
        } catch (IOException ex) {
            System.out.println("No hay imagen cargada");
        }
        return Imagen;
    }

}

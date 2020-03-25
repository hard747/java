package calculadoragráfica;

import java.awt.BorderLayout;
import Imagen.*;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Ventana extends JFrame{

    public Ventana(String nombre, SuperficieDeDibujo superficieDeDibujo) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(nombre);
        //this.setSize(600,600);
        this.setResizable(false);
//        BufferedImage iconoVentana = superficieDeDibujo.Imagen.cargarImagen("IconoDelCanal - Jeff Aporta",".PNG");
//        this.setIconImage(iconoVentana);
        this.setLayout(new BorderLayout());
        this.add(superficieDeDibujo);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

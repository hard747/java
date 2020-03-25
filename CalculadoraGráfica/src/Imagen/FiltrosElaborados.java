package Imagen;

import Geometria2D.Dupla;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class FiltrosElaborados extends FiltrosDeFusión {

    public BufferedImage Sepía(BufferedImage ImagenOriginal) {
        BufferedImage grises = EscalaDeGrises(ImagenOriginal);
        BufferedImage solidoNaranja = Sólido(ImagenOriginal, 255, 128, 0, 255);
        BufferedImage sepia = Multiplicar(solidoNaranja, grises);
        sepia = SobreExposiciónLineal(sepia, grises, null);
        sepia = Luminosidad(sepia, ImagenOriginal);
        sepia = ResaltarBrillos(sepia, 15);
        sepia = Normal(sepia, ImagenOriginal);
        return sepia;
    }

    public BufferedImage SepíaColorizado(BufferedImage ImagenOriginal) {
        return SepíaColorizado(ImagenOriginal, 0);
    }

    public BufferedImage SepíaColorizado(BufferedImage ImagenOriginal, float PorcentajeImagenOriginal) {
        BufferedImage sepiaColorizado = Sepía(ImagenOriginal);
        sepiaColorizado = Saturación(sepiaColorizado, ImagenOriginal);
        sepiaColorizado = Normal(sepiaColorizado, ImagenOriginal);
        return sepiaColorizado;
    }

    public BufferedImage Petróleo(BufferedImage ImagenOriginal) {
        return Petróleo(ImagenOriginal, 0);
    }

    public BufferedImage Petróleo(BufferedImage ImagenOriginal, float PorcentajeImagenOriginal) {
        BufferedImage EscalaDeGrises = EscalaDeGrises(ImagenOriginal);
        BufferedImage imagen = Diferencia(EscalaDeGrises, Invertir(EscalaDeGrises));
        imagen = Normal(imagen, ImagenOriginal);
        return imagen;
    }

    public BufferedImage Gasolina(BufferedImage ImagenOriginal) {
        return Gasolina(ImagenOriginal, 0);
    }

    public BufferedImage Gasolina(BufferedImage ImagenOriginal, float PorcentajeImagenOriginal) {
        BufferedImage EscalaDeGrisesInvertido = Invertir(EscalaDeGrises(ImagenOriginal));
        BufferedImage Imagen = Diferencia(ImagenOriginal, EscalaDeGrisesInvertido);
        Imagen = Normal(Imagen, ImagenOriginal);
        return Imagen;
    }

    public BufferedImage Obscuro(BufferedImage ImagenOriginal) {
        BufferedImage Imagen = Gasolina(ImagenOriginal);
        BufferedImage Imagen2 = Clonar(ImagenOriginal);
        Tono(Imagen, Imagen2);
        Normal(Imagen, ImagenOriginal);
        return Imagen;
    }

    public BufferedImage Tiza(BufferedImage ImagenOriginal) {
        BufferedImage Imagen = EscalaDeGrises(ImagenOriginal);
        Imagen = Diferencia(Imagen, ImagenOriginal);
        return Imagen;
    }

    public BufferedImage TintaRoja(BufferedImage ImagenOriginal) {
        return TintaColor(ImagenOriginal, Color.RED);
    }

    public BufferedImage TintaVerde(BufferedImage ImagenOriginal) {
        return TintaColor(ImagenOriginal, Color.GREEN);
    }

    public BufferedImage TintaAzul(BufferedImage ImagenOriginal) {
        return TintaColor(ImagenOriginal, Color.BLUE);
    }

    public BufferedImage TintaCyan(BufferedImage ImagenOriginal) {
        return TintaColor(ImagenOriginal, Color.CYAN);
    }

    public BufferedImage TintaMagenta(BufferedImage ImagenOriginal) {
        return TintaColor(ImagenOriginal, Color.MAGENTA);
    }

    public BufferedImage TintaAmarilla(BufferedImage ImagenOriginal) {
        return TintaColor(ImagenOriginal, Color.YELLOW);
    }

    public BufferedImage TintaColor(BufferedImage ImagenOriginal, Color color) {
        BufferedImage Sólido = Sólido(ImagenOriginal, color);
        Sólido = Brillo(Sólido, ImagenOriginal);
        Sólido = Luminosidad(Sólido, ImagenOriginal);
        Sólido = ResaltarBrillos(Sólido, 20);
        Sólido = ModificarS(Sólido, 15);
        return Sólido;
    }

    public BufferedImage CorrerCanalesRGB(BufferedImage ImagenOriginal, boolean Red, boolean Green, boolean Blue) {
        Dupla PosImg2 = new Dupla(10, 0);

        BufferedImage R = CanalRojo(ImagenOriginal);
        BufferedImage B = CanalAzul(ImagenOriginal);
        BufferedImage G = CanalVerde(ImagenOriginal);

        BufferedImage RG = SobreExposiciónLineal(R, G, PosImg2);
        BufferedImage RB = SobreExposiciónLineal(R, B, PosImg2);
        BufferedImage GB = SobreExposiciónLineal(G, B, PosImg2);

        PosImg2 = new Dupla(-10, 0);
        BufferedImage RGB = SobreExposiciónLineal(RG, B, PosImg2);

        if (Red && Green && Blue) {
            return RGB;
        }
        if (Red && Green) {
            return RG;
        }
        if (Red && Blue) {
            return RB;
        }
        if (Green && Blue) {
            return GB;
        }
        if (Red) {
            return R;
        }
        if (Green) {
            return G;
        }
        if (Blue) {
            return B;
        }
        return EscalaDeGrises(ImagenOriginal);
    }
}

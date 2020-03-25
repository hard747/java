package Imagen;

import Geometria2D.Dupla;
import static Imagen.FiltrosDeImagen.MULTIPLICAR;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class FiltrosDeFusión extends FiltrosDeColor {

    public BufferedImage Multiplicar(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, MULTIPLICAR, null);
    }

    public BufferedImage SobreExposiciónLineal(BufferedImage ImagenOriginal, BufferedImage imagen2, Dupla PosImg2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, PosImg2, SOBREEXPOSICIÓN_LINEAL, null);
    }

    public BufferedImage Diferencia(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, DIFERENCIA, null);
    }

    public BufferedImage Tono(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, TONO, null);
    }

    public BufferedImage Saturación(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, SATURACIÓN, null);
    }

    public BufferedImage Color(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, COLOR, null);
    }

    public BufferedImage Luminosidad(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, LUMINOSIDAD, null);
    }

    public BufferedImage Brillo(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return RecorrerImagen(Clonar(ImagenOriginal), imagen2, null, BRILLO, null);
    }


    @Override
    protected Color MODO_FUSIÓN(int nombreFiltro, Color pixel, Color pixel2, float[] valores) {
        switch (nombreFiltro) {
            case MULTIPLICAR:
                return Modo_Multiplicar(pixel, pixel2);
            case SOBREEXPOSICIÓN_LINEAL:
                return Modo_SobreExposiciónLineal(pixel, pixel2);
            case DIFERENCIA:
                return Modo_Diferencia(pixel, pixel2);
            case TONO:
                return Modo_Tono(pixel, pixel2);
            case SATURACIÓN:
                return Modo_Saturación(pixel, pixel2);
            case COLOR:
                return Modo_Color(pixel, pixel2);
            case LUMINOSIDAD:
                return Modo_Luminosidad(pixel, pixel2);
            case BRILLO:
                return Modo_Brillo(pixel, pixel2);
        }
        return Color.RED;
    }

    private Color Modo_Multiplicar(Color pixel, Color pixel2) {
        int r = AjustarALimitesRGB((pixel.getRed() * pixel2.getRed() / 255));
        int g = AjustarALimitesRGB((pixel.getGreen() * pixel2.getGreen() / 255));
        int b = AjustarALimitesRGB((pixel.getBlue() * pixel2.getBlue() / 255));
        int a = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(r, g, b, a);
    }

    private Color Modo_SobreExposiciónLineal(Color pixel, Color pixel2) {
        int r = AjustarALimitesRGB((pixel.getRed() + pixel2.getRed()));
        int g = AjustarALimitesRGB((pixel.getGreen() + pixel2.getGreen()));
        int b = AjustarALimitesRGB((pixel.getBlue() + pixel2.getBlue()));

        int a = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(r, g, b, a);
    }

    private Color Modo_Tono(Color pixel, Color pixel2) {
        float[] HSB = ObtenerHSBA(pixel);
        float[] HSB2 = ObtenerHSBA(pixel2);
        Color color = new Color(Color.HSBtoRGB(HSB2[H], HSB[S], HSB[B]));
        int Alpha = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Alpha);
    }

    private Color Modo_Saturación(Color pixel, Color pixel2) {
        float[] HSB = ObtenerHSBA(pixel);
        float[] HSB2 = ObtenerHSBA(pixel2);
        Color color = new Color(Color.HSBtoRGB(HSB[H], HSB2[S], HSB[B]));
        int Alpha = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Alpha);
    }

    private Color Modo_Color(Color pixel, Color pixel2) {
        float[] HSB = ObtenerHSBA(pixel);
        float[] HSB2 = ObtenerHSBA(pixel2);
        Color color = new Color(Color.HSBtoRGB(HSB2[H], HSB2[S], HSB[B]));
        int Alpha = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Alpha);
    }

    private Color Modo_Luminosidad(Color pixel, Color pixel2) {
        float[] HSB = ObtenerHSBA(pixel);
        float[] HSB2 = ObtenerHSBA(pixel2);
        Color color = new Color(Color.HSBtoRGB(HSB[H], HSB[S], HSB2[B]));
        int Alpha = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Alpha);
    }

    private Color Modo_Diferencia(Color pixel, Color pixel2) {
        int r = AjustarALimitesRGB(Math.abs(pixel.getRed() - pixel2.getRed()));
        int g = AjustarALimitesRGB(Math.abs(pixel.getGreen() - pixel2.getGreen()));
        int b = AjustarALimitesRGB(Math.abs(pixel.getBlue() - pixel2.getBlue()));
        int a = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(r, g, b, a);
    }

    private Color Modo_Brillo(Color pixel, Color pixel2) {
        float[] HSB = ObtenerHSBA(pixel);
        float[] HSB2 = ObtenerHSBA(pixel2);
        float HSL[] = ObtenerHSL(HSB[H], HSB[S], HSB2[B], 255);
        Color color = new Color(Color.HSBtoRGB(HSB[H], HSB[S], HSB[B]));
        int Alfa = AjustarALimitesRGB(pixel.getAlpha() + pixel2.getAlpha());
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Alfa);
    }
}

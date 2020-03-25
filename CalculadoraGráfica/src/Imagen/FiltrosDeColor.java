package Imagen;

import static Imagen.FiltrosDeImagen.REMOVER_COLOR;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class FiltrosDeColor extends FiltrosDeImagen {

    /**
     * Modifica la transparencia en general de una imagen en un rango de 0% a
     * 100%
     *
     * @param ImagenOriginal
     * @param porcentaje
     * @return
     */
    public BufferedImage Transparencia(BufferedImage ImagenOriginal, float porcentaje) {
        if (porcentaje > 1) {
            porcentaje /= 100;
        }
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, OPACIDAD, new float[]{porcentaje});
    }

    /**
     * Transforma todos los píxeles que coincidan con el RGB del color en
     * transparente
     *
     * @param ImagenOriginal
     * @param color
     * @return
     */
    public BufferedImage RemoverColor(BufferedImage ImagenOriginal, Color color) {
        float[] valores = {color.getRed(), color.getGreen(), color.getBlue()};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, REMOVER_COLOR, valores);
    }

    /**
     * Reemplaza todo el HSB por valores determinados, convirtiendo toda la
     * imagen como en una especie de sólido pero conservando siempre la
     * transparencia de cada pixel.
     *
     * @param ImagenOriginal Está imagen determinará el mapa de transparencia de
     * la imagen retorno
     * @param H si es > 1 tomará los grados de 0 a 360 de lo contrarió los
     * tomará de 0 a 1
     * @param S si es > 1 tomará el radio de la saturación de 0% a 100% de lo
     * contrarió la tomará de 0 a 1
     * @param B si es > 1 tomará la altura del brillo de 0% a 100% de lo
     * contrarió la tomará de 0 a 1
     * @return Un solido que conserva la transparencia de la imagen original
     */
    public BufferedImage ReemplazarHSB(BufferedImage ImagenOriginal, float H, float S, float B, float A) {
        float[] valores;
        if (H > 1 || S > 1 || B > 1) {
            valores = new float[]{H / 360, S / 100, B / 100, A / 255};
        } else {
            valores = new float[]{H, S, B, A / 255};
        }
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, CAMBIAR_HSB, valores);
    }

    public BufferedImage ModificarHSB(BufferedImage ImagenOriginal, float ΔH_Grados, float ΔS, float ΔB) {
        float[] valores = {ΔH_Grados / 360, ΔS / 100, ΔB / 100};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, CAMBIAR_HSB, valores);
    }

    public BufferedImage ModificarH(BufferedImage ImagenOriginal, float ΔH_Grados) {
        return ModificarHSB(Clonar(ImagenOriginal), ΔH_Grados, 0, 0);
    }

    public BufferedImage ModificarS(BufferedImage ImagenOriginal, float ΔS) {
        return ModificarHSB(Clonar(ImagenOriginal), 0, ΔS, 0);
    }

    public BufferedImage ModificarB(BufferedImage ImagenOriginal, float ΔB) {
        return ModificarHSB(Clonar(ImagenOriginal), 0, 0, ΔB);
    }

    public BufferedImage InsertarValoresHSBenRGB_Rojo(BufferedImage ImagenOriginal) {
        float[] valores
                = {B, S, H,
                    0, 0, 0};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_HSB_EN_RGB, valores);
    }

    public BufferedImage InsertarValoresHSBenRGB_Verde(BufferedImage ImagenOriginal) {
        float[] valores
                = {H, B, S,
                    0, 0, 0};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_HSB_EN_RGB, valores);
    }

    public BufferedImage InsertarValoresHSBenRGB_Azul(BufferedImage ImagenOriginal) {
        float[] valores
                = {H, S, B,
                    0, 0, 0};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_HSB_EN_RGB, valores);
    }

    public BufferedImage InsertarValoresRGBenHSB(BufferedImage ImagenOriginal) {
        float[] valores
                = {R, G, B,
                    0, 0, 0};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_RGB_EN_HSB, valores);
    }

    public BufferedImage InsertarValoresRGBenHSB_H_Invertida(BufferedImage ImagenOriginal) {
        float[] valores
                = {R, G, B,
                    INV, 0, 0};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_RGB_EN_HSB, valores);
    }

    public BufferedImage InsertarValoresRGBenHSB_S_Invertida(BufferedImage ImagenOriginal) {
        float[] valores
                = {R, G, B,
                    0, INV, 0};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_RGB_EN_HSB, valores);
    }

    public BufferedImage InsertarValoresRGBenHSB_B_Invertida(BufferedImage ImagenOriginal) {
        float[] valores
                = {R, G, B,
                    0, 0, INV};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INSERTAR_VALORES_RGB_EN_HSB, valores);
    }

    public BufferedImage ModificarBrillo(BufferedImage ImagenOriginal, float ΔR, float ΔG, float ΔB) {
        float[] valores = {ΔR / 100, ΔG / 100, ΔB / 100};
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, MODIFICAR_BRILLO_PIXELES, valores);
    }

    public BufferedImage CanalRojo(BufferedImage ImagenOriginal) {
        return ModificarBrillo(Clonar(ImagenOriginal), 0, 100, 100);
    }

    public BufferedImage CanalVerde(BufferedImage ImagenOriginal) {
        return ModificarBrillo(Clonar(ImagenOriginal), 100, 0, 100);
    }

    public BufferedImage CanalAzul(BufferedImage ImagenOriginal) {
        return ModificarBrillo(Clonar(ImagenOriginal), 100, 100, 0);
    }

    public BufferedImage CanalCyan(BufferedImage ImagenOriginal) {
        BufferedImage imagen = Invertir(ImagenOriginal);
        imagen = CanalRojo(imagen);
        return Invertir(imagen);
    }

    public BufferedImage CanalMagenta(BufferedImage ImagenOriginal) {
        BufferedImage imagen = Invertir(ImagenOriginal);
        imagen = CanalVerde(imagen);
        return Invertir(imagen);
    }

    public BufferedImage CanalAmarillo(BufferedImage ImagenOriginal) {
        BufferedImage imagen = Invertir(ImagenOriginal);
        imagen = CanalAzul(imagen);
        return Invertir(imagen);
    }

    public BufferedImage ApagarRojo(BufferedImage ImagenOriginal, float ΔR) {
        return ModificarBrillo(Clonar(ImagenOriginal), ΔR, 0, 0);
    }

    public BufferedImage ApagarVerde(BufferedImage ImagenOriginal, float ΔG) {
        return ModificarBrillo(Clonar(ImagenOriginal), 0, ΔG, 0);
    }

    public BufferedImage ApagarAzul(BufferedImage ImagenOriginal, float ΔB) {
        return ModificarBrillo(Clonar(ImagenOriginal), 0, 0, ΔB);
    }

    public BufferedImage Invertir(BufferedImage ImagenOriginal) {
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INVERTIR, null);
    }

    public BufferedImage Binarizado(BufferedImage ImagenOriginal) {
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, BINARIZADO, null);
    }

    public BufferedImage PercepciónDeConos(BufferedImage ImagenOriginal) {
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, PERCEPCIÓN_DE_CONOS, null);
    }

    public BufferedImage PercepciónDeBastones(BufferedImage ImagenOriginal) {
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, PERCEPCIÓN_DE_BASTONES, null);
    }

    public BufferedImage EscalaDeGrises(BufferedImage ImagenOriginal) {
        return PercepciónDeBastones(Clonar(ImagenOriginal));
    }

    public BufferedImage InvertirOrden_RGB_A_BGR(BufferedImage ImagenOriginal) {
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, INVERTIR_ORDEN_CANALES_RGB, null);
    }

    public BufferedImage ResaltarBrillos(BufferedImage ImagenOriginal, double radio) {
        radio *= 10;
        return RecorrerImagen(Clonar(ImagenOriginal), null, null, RESALTAR_BRILLOS_ALTOS, new float[]{(float) radio});
    }
    
    @Override
     protected Color FILTRO(int nombreFiltro, Color pixel, float[] valores) {
        switch (nombreFiltro) {

            case CAMBIAR_HSB:
                return Filtro_cambiarHSB(pixel, valores);

            case MODIFICAR_BRILLO_PIXELES:
                return Filtro_ModificarBrilloPixeles(pixel, valores);

            case INVERTIR:
                return Filtro_Invertir(pixel);

            case BINARIZADO:
                return Filtro_Binarizado(pixel);

            case PERCEPCIÓN_DE_CONOS:
                return Filtro_PercepciónDeConos(pixel);

            case PERCEPCIÓN_DE_BASTONES:
                return Filtro_PercepciónDeBastones(pixel);

            case INVERTIR_ORDEN_CANALES_RGB:
                return Filtro_InvertirOrdenCanalesRGB(pixel);

            case INSERTAR_VALORES_HSB_EN_RGB:
                return Filtro_InsertarHSBenRGB(pixel, valores);

            case INSERTAR_VALORES_RGB_EN_HSB:
                return Filtro_InsertarRGBenHSB(pixel, valores);

            case OPACIDAD:
                return Filtro_Opacidad(pixel, valores[0]);

            case RESALTAR_BRILLOS_ALTOS:
                return Filtro_IntensificarBrillos(pixel, valores[0]);

            case REEMPLAZAR_HSB:
                float HSB[] = Color.RGBtoHSB(pixel.getRed(), pixel.getGreen(), pixel.getBlue(), null);
                return Filtro_ReemplazarHSB(new float[]{HSB[H], HSB[S], HSB[B], pixel.getAlpha()});

            case REMOVER_COLOR:
                return Filtro_RemoverColor(pixel, valores);
        }
        return new Color(200, 0, 0);
    }
     
      private Color Filtro_cambiarHSB(Color pixel, float[] Valores) {
        float HSBA[] = Color.RGBtoHSB(pixel.getRed(), pixel.getGreen(), pixel.getBlue(), null);
        float h = AjustarALimitesHSB(HSBA[H] + Valores[H]);
        float s = AjustarALimitesHSB(HSBA[S] + Valores[S]);
        float b = AjustarALimitesHSB(HSBA[B] + Valores[B]);
        int a = (int) (pixel.getAlpha() * Valores[A]);
        Color color = new Color(Color.HSBtoRGB(h, s, b));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), a);
    }

    private Color Filtro_RemoverColor(Color pixel, float[] Valores) {
        if (pixel.getRed() == Valores[R] && pixel.getGreen() == Valores[G] && pixel.getBlue() == Valores[B]) {
            return new Color(255, 255, 255, 0);
        }
        return pixel;
    }

    private Color Filtro_ReemplazarHSB(float[] Valores) {
        float h = AjustarALimitesHSB(Valores[H]);
        float s = AjustarALimitesHSB(Valores[S]);
        float b = AjustarALimitesHSB(Valores[B]);
        int a = (int) Valores[A];
        Color color = new Color(Color.HSBtoRGB(h, s, b));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), a);
    }

    private Color Filtro_ModificarBrilloPixeles(Color pixel, float[] Porcentaje) {
        return new Color(
                AjustarALimitesRGB(pixel.getRed() - pixel.getRed() * Porcentaje[R]),
                AjustarALimitesRGB(pixel.getGreen() - pixel.getGreen() * Porcentaje[ΔG]),
                AjustarALimitesRGB(pixel.getBlue() - pixel.getBlue() * Porcentaje[ΔB]));
    }

    private Color Filtro_Invertir(Color pixel) {
        return new Color(255 - pixel.getRed(), 255 - pixel.getGreen(),
                255 - pixel.getBlue(), pixel.getAlpha());
    }

    private Color Filtro_Opacidad(Color pixel, double porcentaje) {
        return new Color(pixel.getRed(),
                pixel.getGreen(),
                pixel.getBlue(),
                (int) (porcentaje * pixel.getAlpha()));
    }

    private Color Filtro_Binarizado(Color pixel) {
        int r, g, b;
        r = pixel.getRed() >= 128 ? 255 : 0;
        g = pixel.getGreen() >= 128 ? 255 : 0;
        b = pixel.getBlue() >= 128 ? 255 : 0;
        return new Color(r, g, b, pixel.getAlpha());
    }

    private Color Filtro_PercepciónDeConos(Color pixel) {
        float[] HSBA = ObtenerHSBA(pixel);
        Color color = new Color(Color.HSBtoRGB(H, S, 1));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), pixel.getAlpha());
    }

    private Color Filtro_PercepciónDeBastones(Color pixel) {
        Color color = new Color(Color.HSBtoRGB(0, 0, ObtenerHSBA(pixel)[B]));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), pixel.getAlpha());
    }

    private Color Filtro_InvertirOrdenCanalesRGB(Color pixel) {
        return new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue());
    }

    private Color Filtro_IntensificarBrillos(Color pixel, double radio) {
        float brillo
                = ObtenerHSL(new Color(pixel.getRed(), pixel.getGreen(), pixel.getBlue()))[B];
        int r, g, b, a;
        if (brillo > 2 / 3.0) {
            r = AjustarALimitesRGB(radio * (brillo - 2 / 3.0) + pixel.getRed());
            g = AjustarALimitesRGB(radio * (brillo - 2 / 3.0) + pixel.getGreen());
            b = AjustarALimitesRGB(radio * (brillo - 2 / 3.0) + pixel.getBlue());
        } else {
            r = AjustarALimitesRGB(pixel.getRed() - radio * (2 / 3.0 - brillo));
            g = AjustarALimitesRGB(pixel.getGreen() - radio * (2 / 3.0 - brillo));
            b = AjustarALimitesRGB(pixel.getBlue() - radio * (2 / 3.0 - brillo));
        }
        a = pixel.getAlpha();
        return new Color(r, g, b, a);
    }

    private Color Filtro_InsertarHSBenRGB(Color pixel, float[] valores) {
        float[] HSB = ObtenerHSBA(pixel);

        int r = AjustarALimitesRGB((HSB[H] * 255)),
                g = AjustarALimitesRGB((HSB[(int) valores[S]] * 255)),
                b = AjustarALimitesRGB((HSB[(int) valores[B]] * 255));

        r = valores[3] == INV ? 255 - r : r;
        g = valores[4] == INV ? 255 - g : g;
        b = valores[5] == INV ? 255 - b : b;

        return new Color(r, g, b);
    }

    private Color Filtro_InsertarRGBenHSB(Color pixel, float[] valores) {
        float[] RGB = {pixel.getRed(), pixel.getGreen(), pixel.getBlue()};

        float H = RGB[(int) valores[0]] / 255,
                S = RGB[(int) valores[1]] / 255,
                B = RGB[(int) valores[2]] / 255;

        H = valores[3] == INV ? 1 - H : H;
        S = valores[4] == INV ? 1 - S : S;
        B = valores[5] == INV ? 1 - B : B;

        return new Color(Color.HSBtoRGB(H, S, B));
    }
}

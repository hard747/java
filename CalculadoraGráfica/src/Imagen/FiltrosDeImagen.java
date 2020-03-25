package Imagen;

import Geometria2D.Dupla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class FiltrosDeImagen {

    protected final static int CAMBIAR_HSB = 0,
            MODIFICAR_BRILLO_PIXELES = 1,
            INVERTIR = 2,
            BINARIZADO = 3,
            PERCEPCIÓN_DE_CONOS = 4,
            PERCEPCIÓN_DE_BASTONES = 5,
            INVERTIR_ORDEN_CANALES_RGB = 6,
            INSERTAR_VALORES_HSB_EN_RGB = 7,
            INSERTAR_VALORES_RGB_EN_HSB = 8,
            OPACIDAD = 9,
            RESALTAR_BRILLOS_ALTOS = 11,
            REEMPLAZAR_HSB = 12,
            REMOVER_COLOR = 13,
            ///

            MULTIPLICAR = 1,
            SOBREEXPOSICIÓN_LINEAL = 2,
            DIFERENCIA = 3,
            TONO = 4,
            SATURACIÓN = 5,
            COLOR = 6,
            LUMINOSIDAD = 7,
            BRILLO = 8,
            ////

            ΔR = 0, ΔG = 1, ΔH = 0, ΔS = 1, ΔB = 2, R = 0, G = 1, B = 2, H = 0, S = 1, A = 3, INV = 1;

    public BufferedImage Normal(BufferedImage ImagenOriginal, BufferedImage imagen2, Dupla PosImg2) {
        return Modo_Normal(Clonar(ImagenOriginal), imagen2, PosImg2);
    }

    public BufferedImage Normal(BufferedImage ImagenOriginal, BufferedImage imagen2) {
        return Modo_Normal(Clonar(ImagenOriginal), imagen2, Dupla.ORIGEN);
    }

    private BufferedImage Modo_Normal(BufferedImage imagen, BufferedImage imagen2, Dupla PosImg2) {
        Graphics g = imagen.getGraphics();
        g.drawImage(imagen2, PosImg2.intX(), PosImg2.intY(), null);
        return imagen;
    }

    public BufferedImage Sólido(Dupla Tamaño, Color color) {
        BufferedImage imagenSolido = new BufferedImage(Tamaño.intX(), Tamaño.intY(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = imagenSolido.getGraphics();
        g.setColor(color);
        g.fillRect(0, 0, imagenSolido.getWidth(), imagenSolido.getHeight());
        return imagenSolido;
    }

    public BufferedImage Sólido(BufferedImage ImagenOriginal, Color color) {
        return Sólido(new Dupla(ImagenOriginal.getWidth(), ImagenOriginal.getHeight()), color);
    }

    public BufferedImage Sólido(BufferedImage ImagenOriginal, int R, int G, int B, int A) {
        return Sólido(new Dupla(ImagenOriginal.getWidth(), ImagenOriginal.getHeight()), new Color(R, G, B, A));
    }

    /**
     * Devuelve una copia con formato RGBA de una imagen, para transparencia.
     *
     * @param ImagenOriginal
     * @return
     */
    public BufferedImage Clonar(BufferedImage ImagenOriginal) {
        return Escalar(ImagenOriginal, ImagenOriginal.getWidth(), ImagenOriginal.getHeight(), true);
    }
    
        public float[] ObtenerHSL(Color color) {
        float HSB[] = ObtenerHSBA(color);
        return ObtenerHSL(HSB[H], HSB[S], HSB[B], color.getAlpha());
    }

    public float[] ObtenerHSL(float Hue, float Sat, float Bri, float alfa) {
        if (Bri <= 0.5) {
            Sat = Sat * 2 * Bri;
        } else {
            Sat = Sat * (2 - 2 * Bri);
        }
        Bri = Bri + Sat / 2;
        return new float[]{Hue, Sat, Bri, alfa};
    }

    /**
     * este método retornará un arreglo con las coordenadas RGBA a partir de un
     * color.
     */
    private int[] ObtenerRGBA(Color color) {
        return new int[]{color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()};
    }

    /**
     * este método retornará un arreglo con las coordenadas HSBA a partir del
     * arreglo RGBA.
     */
    protected float[] ObtenerHSBA(Color color) {
        int RGBA[] = ObtenerRGBA(color);
        return new float[]{
            Color.RGBtoHSB(RGBA[R], RGBA[G], RGBA[B], null)[H],
            Color.RGBtoHSB(RGBA[R], RGBA[G], RGBA[B], null)[S],
            Color.RGBtoHSB(RGBA[R], RGBA[G], RGBA[B], null)[B],
            color.getAlpha()};
    }

    protected float AjustarALimitesHSB(float num) {
        if (num > 1) {
            num = 1;
        }
        if (num < 0) {
            num = 0;
        }
        return num;
    }

    protected int AjustarALimitesRGB(double num) {
        if (num > 255) {
            num = 255;
        }
        if (num < 0) {
            num = 0;
        }
        return (int) Math.round(num);
    }

    /**
     * Redimensiona una imagen ajustándola a las dimensiones especificadas.
     *
     * @param imagenOriginal
     * @param AnchoNuevo
     * @param AltoNuevo
     * @param ConservarPixeles
     * @return
     */
    public BufferedImage Escalar(BufferedImage imagenOriginal, int AnchoNuevo, int AltoNuevo, boolean ConservarPixeles) {
        Dupla TamañoImagenOriginal = new Dupla(
                /**
                 * El primer dato va a representar la anchura. La anchura es
                 * horizontal por eso la anchura será representada por X
                 */
                imagenOriginal.getWidth(),
                /**
                 * El segundo dato va a representar la altura. La altura es
                 * vertical por eso la altura será representada por Y
                 */
                imagenOriginal.getHeight());

        return Escalar(imagenOriginal,
                (AnchoNuevo / TamañoImagenOriginal.X),
                (AltoNuevo / TamañoImagenOriginal.Y),
                ConservarPixeles);
    }

    public BufferedImage Escalar(BufferedImage imagenOriginal, double porcentaje, boolean ConservarPixeles) {
        return Escalar(imagenOriginal, porcentaje, porcentaje, ConservarPixeles);
    }

    public BufferedImage Escalar(BufferedImage imagenOriginal, double porcentajeX, double porcentajeY, boolean ConservarPixeles) {
        /**
         * TamañoImagenOriginal representará al ancho y alto de la Imagen
         * Original
         */
        Dupla TamañoImagenOriginal = new Dupla(
                /**
                 * El primer dato va a representar la anchura. La anchura es
                 * horizontal por eso la anchura será representada por X
                 */
                imagenOriginal.getWidth() * porcentajeX,
                /**
                 * El segundo dato va a representar la altura. La altura es
                 * vertical por eso la altura será representada por Y
                 */
                imagenOriginal.getHeight() * porcentajeY);

        /**
         * Aunque aún no tenga una imagen cargada la podremos inicializar
         * pasándole algunos parámetros
         */
        BufferedImage imagenEscalada = new BufferedImage(
                /**
                 * Se inicializará con este ancho pero si le declaramos un
                 * tamaño diferente, también funcionará pero si es más pequeño
                 * al de la proporción que escalaremos, entonces la imagen se
                 * recortará
                 */
                TamañoImagenOriginal.intX(),
                /**
                 * Se inicializará con este alto pero si le declaramos un tamaño
                 * diferente, también funcionará pero si es más pequeño al de la
                 * proporción que escalaremos, entonces la imagen se recortará
                 */
                TamañoImagenOriginal.intY(),
                /**
                 * Se inicializará con este tipo de píxeles, ARGB admite píxeles
                 * con transparencia, así que no tendremos problema al escalar
                 * imágenes con transparencia
                 */
                BufferedImage.TYPE_INT_ARGB);

        /**
         * AffineTransform es una clase que cuenta con Herramientas para
         * realizar transformaciones a una imagen, entre ellas hay una que
         * representa la escalación de la imagen
         */
        AffineTransform Transformaciones = new AffineTransform();
        /**
         * La transformación que le aplicaremos será escalar la imagen, Funciona
         * con porcentajes, un porcentaje para X y otro para Y siendo 0 = 0% y 1
         * = 100%
         */
        Transformaciones.scale(
                /**
                 * Aquí se encuentra el porcentaje para escalar la anchura
                 */
                porcentajeX,
                /**
                 * Aquí se encuentra el porcentaje para escalar la altura
                 */
                porcentajeY);

        /**
         * Operación de transformación Recibe un affineTransform para saber que
         * tipo de operación es la que hará y un filtro para los píxeles
         */
        AffineTransformOp Operación = new AffineTransformOp(
                /*Aquí le indicaremos cuántas y cuáles serán las transformaciones que haremos*/
                Transformaciones,
                /*Este filtro por medio de degradados intenta hacer visiblemente mas similar la 
                imagen que se va a transformar*/
                ConservarPixeles ? AffineTransformOp.TYPE_NEAREST_NEIGHBOR : AffineTransformOp.TYPE_BILINEAR);

        /**
         * Una vez que tengamos listas las proporciones, la operación que se va
         * a realizar y el filtro, solo tendremos que aplicar el filtro sobre la
         * imagen original y verter el resultado en la imagen que retornaremos,
         * que en este caso se llama ImagenEscalada
         */
        Operación.filter(imagenOriginal, imagenEscalada);

        /**
         * Después de haber vertido el resultado en la imagen que vamos a
         * retornar todo el proceso ha finalizado ya, solo queda retornarla
         */
        return imagenEscalada;
    }

    /**
     * Motor que recorre todos los píxeles de una imagen para hacerle los
     * cambios especificados.
     */
    protected BufferedImage RecorrerImagen(BufferedImage ImagenOriginal, BufferedImage Imagen2, Dupla PosImg2, int nombreFiltro, float[] valores) {
        if (PosImg2 == null) {
            PosImg2 = Dupla.ORIGEN;
        }
        /**
         * Con el primer ciclo se van a recorrer las columnas de la imagen,
         * sabiendo que una imagen no es más que un arreglo de pequeños
         * cuadritos pintados de un único color
         */
        for (int Columna = 0; Columna < ImagenOriginal.getWidth(); Columna++) {
            for (int Fila = 0; Fila < ImagenOriginal.getHeight(); Fila++) {

                /**
                 * En este arreglo se almacenaran las variables RGB del color
                 * para poder pasárselas al filtro encargado de modificar la
                 * imagen.
                 */
                Color pixel = new Color(ImagenOriginal.getRGB(Columna, Fila), true);

                Color colorPixelNuevo = new Color(0);

                if (Imagen2 == null) {
                    /**
                     * No existe una segunda imagen.
                     */
                    colorPixelNuevo = FILTRO(nombreFiltro, pixel, valores);

                } else if (Columna > PosImg2.X
                        && Imagen2.getWidth() + PosImg2.X > Columna
                        && Fila > PosImg2.Y
                        && Imagen2.getHeight() + PosImg2.Y > Fila) {
                    /**
                     * Existe una segunda imagen.
                     */
                    Color pixel2 = new Color(Imagen2.getRGB(Columna, Fila), true);
                    colorPixelNuevo = MODO_FUSIÓN(nombreFiltro, pixel, pixel2, valores);
                }
                /**
                 * aquí se modificara el pixel después de que el color halla
                 * pasado por el filtro correspondiente.
                 */
                ImagenOriginal.setRGB(Columna, Fila, colorPixelNuevo.getRGB());
            }
        }
        return ImagenOriginal;
    }

    protected Color FILTRO(int nombreFiltro, Color pixel, float[] valores) {
        return null;
    }

    protected Color MODO_FUSIÓN(int nombreFiltro, Color pixel, Color pixel2, float[] valores) {
        return null;
    }
}

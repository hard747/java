package Herramientas;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorRGB {

    /**
     * Indica el color máximo admitido que puede tomar R,G o B.
     */
    public double maxColorRGB; //Coordenada Maxima para RGB
    /**
     * Indica el color mínimo admitido que puede tomar R,G o B.
     */
    public double minColorRGB; //Coordenada Minima para RGB
    /**
     * Indica el color máximo admitido que puede tomar R.
     */
    public double maxColorR; //Coordenada Maxima para RGB
    /**
     * Indica el color mínimo admitido que puede tomar R.
     */
    public double minColorR; //Coordenada Minima para RGB
    /**
     * Indica el color máximo admitido que puede tomar G.
     */
    public double maxColorG; //Coordenada Maxima para RGB
    /**
     * Indica el color mínimo admitido que puede tomar G.
     */
    public double minColorG; //Coordenada Minima para RGB
    /**
     * Indica el color máximo admitido que puede tomar B.
     */
    public double maxColorB; //Coordenada Maxima para RGB
    /**
     * Indica el color mínimo admitido que puede tomar B.
     */
    public double minColorB; //Coordenada Minima para RGB

    /**
     * Almacena de forma ordenada a R,G y B para que se pueda sistematizar muy
     * fácil.
     * <p>
     * en vez de hacer referencia a una variable se hace referencia a una
     * posición.
     * <p>
     * 0 para el canal del rojo (R)
     * <p>
     * 1 para el canal del verde (G)
     * <p>
     * 2 para el canal del azul (B)
     */
    private double CanalesRGB[] = new double[3]; //0: Red - 1: Green - 2: Blue - 4: Alfa
    /**
     * Almacena de forma ordenada a un cambio que sufren R,G y B para que se
     * pueda sistematizar muy fácil.
     * <p>
     * en vez de hacer referencia a una variable se hace referencia a una
     * posición.
     * <p>
     * 0 para el cambio del rojo (R)
     * <p>
     * 1 para el cambio del verde (G)
     * <p>
     * 2 para el cambio del azul (B)
     */
    private double[] VectorDesplazamiento = new double[3];
    /**
     * Representa a la unidad máxima que puede tomar el vector de cambio para
     * R,G o B.
     */
    private double unidadDesplazamiento = 1;

    /**
     * Representa al 100% del valor máximo que puede tomar R,G o B.
     */
    private final static int full = 255;
    /**
     * Representa al 0% del valor máximo que puede tomar R,G o B.
     */
    private final static int nulo = 0;
    /**
     * Representa al 50% del valor máximo que puede tomar R,G o B.
     */
    private final static int medio = (int) Math.round(full * .50);
    /**
     * Representa al 30% del valor máximo que puede tomar R,G o B.
     */
    private final static int poco = (int) Math.round(full * .30);

    /**
     * Crea una tripla de números que representan valores dentro de un espacio
     * RGB
     * <p>
     * Rango de valores (0 - 255).
     * <p>
     * Por el momento no controla canal alfa
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param r Coordenada en rojo.
     * <p>
     * @param g Coordenada en verde.
     * <p>
     * @param b Coordenada en azul.
     */
    public ColorRGB(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new Error(error_CoordenadasExedieronRango());
        } else {
            Canal_Modificar(0, r);
            Canal_Modificar(1, g);
            Canal_Modificar(2, b);
            diferencialesAleatorias();
            restaurar_Max255_Min0_RGB();
        }

    }

    /**
     * Crea una tripla de números que representan valores dentro de un espacio
     * RGB a partir de un color, lo que hace es utilizar los metodos .getRed(),
     * .getGreen() y .getBlue() del objeto Color extraer las coordenadas.
     *
     * <p>
     * Por el momento no controla canal alfa
     * <p>
     *
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param color Color del que extraer las coordenadas RGB.
     */
    public ColorRGB(Color color) {
        CanalesRGB[0] = color.getRed();
        CanalesRGB[1] = color.getGreen();
        CanalesRGB[2] = color.getBlue();
        diferencialesAleatorias();
        restaurar_Max255_Min0_RGB();
    }

    /**
     * Crea una tripla de numeros que representan valores dentro de un espacio
     * RGB a partir otra tripla, lo que hace es utilizar el metodo
     * .Canal_Obtener(int n); de esta misma clase para extraer las coordenadas.
     *
     * <p>
     * Por el momento no controla canal alfa
     * <p>
     *
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param Color dato de tipo <code>TriplaColor</code> del que extraera las
     * coordenadas RGB.
     * @see #Canal_Obtener
     */
    public ColorRGB(ColorRGB Color) {
        CanalesRGB[0] = Color.Canal_Obtener(0);
        CanalesRGB[1] = Color.Canal_Obtener(1);
        CanalesRGB[2] = Color.Canal_Obtener(2);
        diferencialesAleatorias();
        restaurar_Max255_Min0_RGB();
    }

    /**
     * Le asigna a la Tripla los 3 datos ingresados en los canales
     * correspondientes.
     * <p>
     * Por el momento no maneja canal alfa
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param r dato de tipo <code>int</code> que representa la cantidad de rojo
     * @param g dato de tipo <code>int</code> que representa la cantidad de
     * verde
     * @param b dato de tipo <code>int</code> que representa la cantidad de azul
     * @see #Canal_Modificar(int canal, double valor)
     */
    public void AsignarColor(int r, int g, int b) {
        Canal_Modificar(0, r);
        Canal_Modificar(1, g);
        Canal_Modificar(2, b);
    }

    /**
     * Toma las coordenadas del color y las asigna en el arreglo que representa
     * a los canales.
     * <p>
     * Por el momento no maneja canal alfa
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param color dato de tipo <code>Color</code> del que extrae las
     * coordenadas
     * @see #AsignarColor(Color)
     */
    public void AsignarColor(ColorRGB color) {
        for (int i = 0; i < CanalesRGB.length; i++) {
            Canal_Modificar(i, color.Canal_Obtener(i));
        }
    }

    /**
     * Toma las coordenadas del color y las asigna en el arreglo que representa
     * a los canales.
     * <p>
     * Por el momento no maneja canal alfa
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param color dato de tipo <code>Color</code> del que extrae las
     * coordenadas
     * @see #AsignarColor(TriplaColor)
     */
    public void AsignarColor(Color color) {
        Canal_Modificar(0, color.getRed());
        Canal_Modificar(1, color.getGreen());
        Canal_Modificar(2, color.getBlue());
    }

    /**
     * Asigna un valor en uno de las componentes del vector.
     * <p>
     * Por el momento no maneja componente en alfa
     * <p>
 Recuerda que un componente es un valor que le indica a la ColorRGB a
 saber cuanto moverse en cada canal cada vez que se ejecute .Desplazar();
 <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param n dato de tipo <code>int</code> que indica el componente dirección
     * <p>
     * <code>      0 - Para cambiar el componente en r</code>
     * <p>
     * <code>      1 - Para cambiar el componente en g</code>
     * <p>
     * <code>      2 - Para cambiar el componente en b</code>
     * <p>
     * @param valor dato de tipo <code>double</code> que indica la nueva
     * magnitud que tenga la componente
     * @see #Desplazar
     */
    public void CambiarComponenteDelVectorDesplazamiento(int n, double valor) {
        if (n < 0 || n >= VectorDesplazamiento.length) {
            throw new Error(error_NoExisteComponenteDelVectorDesplazamiento());
        } else {
            VectorDesplazamiento[n] = valor;
        }
    }

    /**
     * Multiplica a cada componente de vector desplazamiento por una constante.
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param Velocidad dato de tipo <code>double</code>, todas las componentes
     * del vector de desplazamiento se multiplican por esta constante, lo que
     * hace que si el numero que se pase es menor a 1 entonces se encoja, pero
     * si es mayor se expandira, si es uno el vector permanecera igual y si es
     * negativo cambiara de sentido
     */
    public void CambiarVelocidad(double Velocidad) {
        unidadDesplazamiento = Velocidad;
        for (int i = 0; i < 3; i++) {
            CambiarComponenteDelVectorDesplazamiento(i, VectorDesplazamiento[i] * unidadDesplazamiento);
        }
    }

    /**
     * Devuelve uno de los canales RGB.
     * <p>
     * Por el momento no maneja canal alfa
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param canal dato de tipo <code>int</code> que hace referencia a uno de
     * los canales
     * <p>
     * Canales disponibles:
     * <p>
     * <code> 0 - Rojo (Red) </code>
     * <p>
     * <code> 1 - Verde (Green) </code>
     * <p>
     * <code> 2 - Azul (Blue)</code>
     */
    public int Canal_Obtener(int canal) {
        return (int) CanalesRGB[canal];
    }

    /**
     * Permite asignar un numero entre 0 y 255 a uno de los canales RGB.
     * <p>
     * Por el momento no maneja canal alfa
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     *
     * @param valor dato de tipo <code>int</code> que se depositara en el canal
     * <p>
     * @param canal dato de tipo <code>int</code> que hace referencia a uno de
     * los canales
     * <p>
     * Canales disponibles:
     * <p>
     * <code> 0 - Rojo (Red) </code>
     * <p>
     * <code> 1 - Verde (Green) </code>
     * <p>
     * <code> 2 - Azul (Blue)</code>
     */
    public void Canal_Modificar(int canal, double valor) {
        if (canal < 0 || canal > 2) {
            throw new Error(error_NoExisteElCanal());
        } else {
            if (valor < 0 || valor > 255) {
                throw new Error(error_CoordenadasExedieronRango());
            } else {
                CanalesRGB[canal] = valor;
            }
        }
    }

    /**
     * Pone los 3 diferenciales dr,dg y db en cero, para que el desplazamiento
     * sea adimensional.
     *
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     */
    public void Detener() {
        for (int i = 0; i < 3; i++) {
            VectorDesplazamiento[i] = 0;
        }
    }

    /**
     * a los 3 diferenciales dr,dg y db se les asigna una valor aleatorio entre
     * 0 y 2, para que el desplazamiento de los colores sea a diferentes
     * velocidades y el punto rebote por el espacio RGB de forma impredecible.
     *
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     */
    public void diferencialesAleatorias() {
        for (int i = 0; i < 3; i++) {
            double aleatorio = Math.random() * 2;
            VectorDesplazamiento[i] = aleatorio == 0 ? Math.random() : aleatorio;
        }
    }

    /**
     * Calcula el vector necesario para que el color oscile en linea recta de un
     * color a otro dentro del espacio RGB, esta clase solo calcula el vector
     * con las diferenciales (dr/Dmax,dg/Dmax,db/Dmax) siendo Dmax el mayor
     * entre dr,dg,db
     * <p>
     * Cabe aclarar que este metodo ¡No desplaza el color!, para poder
     * desplazarlo es necesario llamar al metodo Desplazar(); y se desplazara un
     * poquito hacia el color indicado, para poder llevarlo hasta el color
     * deseado hay que iterar muchas veces a Desplazar();.
     * <p>
     * Se recomienda no darle una velocidad muy alta, ya que el espacio RGB es
     * limitado y podria sufrir desfaces inesperados.
     * <p>
     * Sobretodo los desplazamientos inesperados suceden cuando la trayectoria
     * del punto tiene cola o cabeza en puntos representados por estos colores
     * no son entre estos colores (rojo, amarillo, verde, cyan, azul, magenta,
     * negro, blanco) estos colores son los que denomino como esquinas del cubo.
     * <p>
     * Mi recomendacion como programador de esta clase es que lo ideal es que la
     * velocidad sea 1 y mas bien que se itere muchas veces el desplazamiento
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     * @param colorA Objeto de tipo <code>ColorRGB</code>
     * @param colorB Objeto de tipo <code>ColorRGB</code>
     * @param Velocidad es un dato de tipo <code>double</code> que determina la
     * velocidad<p>
     * <code> Velocidad menor a 1 es una velocidad reducida </code><p>
     * <code> Velocidad igual a 1 es una velocidad normal </code>(recomendada)
     * <p>
     * <code> Velocidad Mayor a 1 es una velocidad aumentada</code>
     * @param REPORTE es un dato <code>boolean</code> que lo que hace de
     * determinar si imprimir o no un reporte en la consola acerca de los
     * diferenciales escogidos<p>
     * <code>true = imprimir</code><p>
     * <code>false = no imprimir</code>
     * @see #Desplazar
     */
    public void Vector_paraOscilarEntre2Colores(ColorRGB colorA, ColorRGB colorB, double Velocidad, boolean REPORTE) {
        ColorRGB.this.OscilacionEntre_2Colores(colorA.Retornarse(), colorB.Retornarse(), Velocidad, REPORTE);
    }

    /**
     * Calcula los diferenciales necesarios para que el color oscile en linea
     * recta de un color a otro dentro del espacio RGB, esta clase solo calcula
     * los diferenciales ¡No desplaza el color!, para poder desplazarlo es
     * necesario llamar al metodo Desplazar(); y se desplazara un poquito hacia
     * el color indicado, para poder llevarlo hasta el color deseado hay que
     * iterar muchas veces a Desplazar();.
     * <p>
     * Se recomienda no darle una velocidad muy alta, ya que el espacio RGB es
     * limitado y podria empezar a sufrir desfaces inesperados.
     * <p>
     * Sobretodo losdesplazamientos inesperados suceden cuando las direcciones
     * no son entre estos colores (rojo, amarillo, verde, cyan, azul, magenta,
     * negro, blanco).
     * <p>
     * Mi recomendacion como programador de esta clase es que lo ideal es que la
     * velocidad sea 1 y mas bien que se itere muchas veces el desplazamiento
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     * @param colorA Objeto de tipo <code>ColorRGB</code>
     * @param colorB Objeto de tipo <code>ColorRGB</code>
     * @param Velocidad es un dato de tipo <code>double</code> que determina la
     * velocidad<p>
     * <code> Velocidad menor a 1 es una velocidad reducida </code><p>
     * <code> Velocidad igual a 1 es una velocidad normal </code>(recomendada)
     * <p>
     * <code> Velocidad Mayor a 1 es una velocidad aumentada</code><p>
     *
     * @see #Desplazar
     */
    public void OscilacionEntre_2Colores(ColorRGB colorA, ColorRGB colorB, double Velocidad) {
        ColorRGB.this.OscilacionEntre_2Colores(colorA.Retornarse(), colorB.Retornarse(), Velocidad, false);
    }

    /**
     * Calcula los diferenciales necesarios para que el color oscile en linea
     * recta de un color a otro dentro del espacio RGB, esta clase solo calcula
     * los diferenciales ¡No desplaza el color!, para poder desplazarlo es
     * necesario llamar al metodo Desplazar(); y se desplazara un poquito hacia
     * el color indicado, para poder llevarlo hasta el color deseado hay que
     * iterar muchas veces a Desplazar();.
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     * @param colorA Objeto de tipo <code>ColorRGB</code>
     * @param colorB Objeto de tipo <code>ColorRGB</code>
     *
     * @see #Desplazar
     */
    public void OscilacionEntre_2Colores(ColorRGB colorA, ColorRGB colorB) {
        ColorRGB.this.OscilacionEntre_2Colores(colorA.Retornarse(), colorB.Retornarse(), 1, false);
    }

    private double abs(double a) {
        return (a < 0) ? -a : a;
    }

    private double m(double a, double b) {
        return a - b;
    }

    public void OscilacionEntre_2Colores(Color colorA, Color colorB, double Velocidad, boolean Reporte) {
        AsignarColor(colorA);

        double x1, x2, y1, y2, z1, z2;
        x1 = colorA.getRed();
        x2 = colorB.getRed();
        y1 = colorA.getGreen();
        y2 = colorB.getGreen();
        z1 = colorA.getBlue();
        z2 = colorB.getBlue();

        double dr = abs(x2 - x1);
        double dg = abs(y2 - y1);
        double db = abs(z2 - z1);
        
        maxColorR = Math.max(x1, x2);
        maxColorG = Math.max(y1, y2);
        maxColorB = Math.max(z1, z2);
        minColorR = (x1 < x2) ? x1 : x2;
        minColorG = (y1 < y2) ? y1 : y2;
        minColorB = (z1 < z2) ? z1 : z2;

        msg("Maximos y minimos" + nuevaLinea() + "MaxR = " + maxColorR + " MaxG = " + maxColorG
                + " MaxB = " + maxColorB + nuevaLinea() + " MinR = " + minColorR + " MinG = " + minColorG
                + " MinB = " + minColorB + nuevaLinea());
        double[] arreglo = {dr, dg, db};
        double Dmin = numeroMenor(arreglo);
        double Dmax = abs(numeroMayor(arreglo));

        msg("Max - Min");
        msg(Dmax + " / " + Dmin);

        if (Dmax != 0) {
            double DR = dr / Dmax,
                    DG = dg / Dmax,
                    DB = db / Dmax;
            msg("dr / Dmax = " + DR + nuevaLinea() + "dg / Dmax = " + DG + nuevaLinea() + "db / Dmax = " + DB);
            diferencialesColorAsignar(DR, DG, DB);
        } else {
            diferencialesColorAsignar(0, 0, 0);
        }
        CambiarVelocidad(Velocidad);
    }

    public void diferencialesColorAsignar(double dR, double dG, double dB) {
        VectorDesplazamiento[0] = dR;
        VectorDesplazamiento[1] = dG;
        VectorDesplazamiento[2] = dB;
    }

    public void colorAleatorio() {
        for (int i = 0; i < 3; i++) {
            CanalesRGB[i] = Math.random() * 255;
        }
    }

    /**
     * Pone a los rangos maximos en 255 y a los minimos en 0.
     *
     * <p>
     * <A href="http://www.youtube.com/c/JeffAporta">Jeff Aporta - YouTube</A>
     * <p>
     * <A href="https://www.facebook.com/Jeffrey.lokura.dibujante">
     * Jeffrey Alexander Agudelo Espitia - Facebook</A>
     *
     */
    public void restaurar_Max255_Min0_RGB() {
        maxColorRGB = full;
        minColorRGB = nulo;
        maxColorR = full;
        minColorR = nulo;
        maxColorG = full;
        minColorG = nulo;
        maxColorB = full;
        minColorB = nulo;
    }

    public static ColorRGB selector() {
        Color color = Color.BLACK;
        color = JColorChooser.showDialog(new JFrame(), "Seleccione un color", color);
        return new ColorRGB(color);
    }

    public static ColorRGB aleatorio() {
        return new ColorRGB((int) (Math.random() * full), (int) (Math.random() * full), (int) (Math.random() * full));
    }

    public void Desplazar() {
        controladorDeLimitesColores();
        for (int i = 0; i < 3; i++) {
            Canal_Modificar(i, CanalesRGB[i] + VectorDesplazamiento[i]);
        }
        //imprimirRGB();
    }

    private void controladorDeLimitesColores() {

        double Max[] = {maxColorR, maxColorG, maxColorB};
        double Min[] = {minColorR, minColorG, minColorB};

        double LimMax = maxColorRGB;
        double LimMin = minColorRGB;
        maxColorR = (Max[0] > LimMax) ? LimMax : Max[0];
        maxColorG = (Max[1] > LimMax) ? LimMax : Max[1];
        maxColorB = (Max[2] > LimMax) ? LimMax : Max[2];
        minColorR = (Min[0] < LimMin) ? LimMin : Min[0];
        minColorG = (Min[1] < LimMin) ? LimMin : Min[1];
        minColorB = (Min[2] < LimMin) ? LimMin : Min[2];

        for (int i = 0; i < 3; i++) {

            CanalesRGB[i] = (CanalesRGB[i] > Max[i]) ? Max[i] : CanalesRGB[i];
            CanalesRGB[i] = (CanalesRGB[i] < Min[i]) ? Min[i] : CanalesRGB[i];
            VectorDesplazamiento[i] = (CanalesRGB[i] + VectorDesplazamiento[i] > Max[i]
                    || CanalesRGB[i] + VectorDesplazamiento[i] < Min[i])
                            ? -VectorDesplazamiento[i]
                            : VectorDesplazamiento[i];
            
            if (VectorDesplazamiento[i] > 150) {
                VectorDesplazamiento[i] = 150;
            }
            
        }
    }

    public Color Retornarse() {
        Desplazar();
        return new Color((int) CanalesRGB[0], (int) CanalesRGB[1], (int) CanalesRGB[2]);
    }

    private int abs(int n) {
        return Math.abs(n);
    }

    private double numeroMayor(double[] arreglo) {
        double Mayor = arreglo[0];
        for (int i = 0; i < arreglo.length; i++) {
            Mayor = arreglo[i] > Mayor ? arreglo[i] : Mayor;
        }
        return Mayor;
    }

    private double numeroMenor(double[] arreglo) {
        double Menor = arreglo[0];
        for (int i = 0; i < arreglo.length; i++) {
            Menor = arreglo[i] < Menor ? arreglo[i] : Menor;
        }
        return Menor;
    }

    private void imprimirRGB() {
        msg("Color = R:" + CanalesRGB[0] + " -  G:" + CanalesRGB[1] + " - B: " + CanalesRGB[2]);
        msg("dif = R:" + VectorDesplazamiento[0] + " -  G:" + VectorDesplazamiento[1] + " - B: " + VectorDesplazamiento[2]);
    }

    private void ImpNuevaLinea() {
        System.out.println("\n");
    }

    private String tabulacion(int n) {
        String retorno = "";
        for (int i = 0; i < n; i++) {
            retorno += "\t";
        }
        return retorno;
    }

    private String tabulacion() {
        return "\t";
    }

    private String nuevaLinea(int n) {
        String retorno = "";
        for (int i = 0; i < n; i++) {
            retorno += "\n";
        }
        return retorno;
    }

    private String nuevaLinea() {
        return "\n";
    }

    private String JeffInformaError() {
        return nuevaLinea(2) + "Jeff te informa un error" + nuevaLinea()
                + tabulacion() + "Jeffrey Alexander Agudelo Espitia" + nuevaLinea() + Motivo() + nuevaLinea(2);
    }

    private String Motivo() {
        return nuevaLinea() + tabulacion(2) + "MOTIVO";
    }

    private String error_NoExisteComponenteDelVectorDesplazamiento() {
        return JeffInformaError()
                + nuevaLinea() + "Componente fuera de rango, solo de permite "
                + nuevaLinea() + tabulacion() + "0 para el rojo - Componente en X"
                + nuevaLinea() + tabulacion() + "1 para el verde - Componente en Y"
                + nuevaLinea() + tabulacion() + "2 para el azul - Componente en Z";
    }

    private String error_NoExisteElCanal() {
        return JeffInformaError()
                + nuevaLinea() + "Canal fuera de rango, solo de permite "
                + nuevaLinea() + "0 para el rojo,"
                + nuevaLinea() + "1 para el verde "
                + nuevaLinea() + "2 para el azul";
    }

    private String error_CoordenadasExedieronRango() {
        return JeffInformaError()
                + "Se exedido el espacio RGB "
                + nuevaLinea() + "El valor mínimo para r, g o b es de 0"
                + nuevaLinea() + "El valor Máximo para r, g o b es de 255 "
                + nuevaLinea(2) + "Si no eres capaz de calcular los colores en el espacio RGB, "
                + nuevaLinea() + "he creado una lista de 131 colores que puedes usar, los puedes ver"
                + nuevaLinea() + "En esta Hoja de calculo publica que he creado en google drive para que cualquier"
                + nuevaLinea() + "persona tenga acceso a ella"
                + nuevaLinea() + "https://goo.gl/AN8U2T o https://docs.google.com/spreadsheets/d/1qgxNQ1srP0WtFh-BhmYl1AGdZNBLjJY8f2MH27XWhgU/edit?usp=sharing"
                + nuevaLinea() + "Copia y pega en tu navegador cualquiera de estas dos direcciones para ver la tabla"
                + nuevaLinea(2) + "Posible caso"
                + nuevaLinea()
                + tabulacion() + "Depronto quieres crear una TriplaColor nueva o asignarle "
                + "un nuevo valor a la TriplaColor"
                + nuevaLinea(2) + tabulacion() + "Por ejemplo, para crear una TriplaColor que represente al rojo pones"
                + nuevaLinea() + tabulacion(2) + "TriplaColor nombreCualquiera = TriplaColor.Rojo"
                + nuevaLinea(2) + tabulacion() + "para retornar cualquier TriplaColor con un color de la Tabla solo pon"
                + nuevaLinea() + tabulacion(2) + "TriplaColor. y enseguida el nombre del color"
                + nuevaLinea() + tabulacion(3) + "TriplaColor.nombre_DelColor"
                + nuevaLinea(2) + "Posible caso 2"
                + nuevaLinea()
                + tabulacion() + "la velocidad del era demasiado alta y se salio del espacio"
                + nuevaLinea(2);
    }

    private void msg(String msg) {
        System.out.println(msg);
    }

//Colores en extremos y medios de RGB
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,0,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo = new ColorRGB(255, 0, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,128,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja = new ColorRGB(255, 128, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,255,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo = new ColorRGB(255, 255, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,255,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Limón = new ColorRGB(128, 255, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,255,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde = new ColorRGB(0, 255, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,255,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Primavera = new ColorRGB(0, 255, 128);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,255,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cyan = new ColorRGB(0, 255, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,128,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cielo = new ColorRGB(0, 128, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,0,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul = new ColorRGB(0, 0, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,0,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Morado = new ColorRGB(128, 0, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,0,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta = new ColorRGB(255, 0, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,0,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Fucsia = new ColorRGB(255, 0, 128);

//Colores en extremos y medios de RGB (Claros)
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,80,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Claro = new ColorRGB(255, 80, 80);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,208,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Claro = new ColorRGB(255, 208, 80);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,255,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Claro = new ColorRGB(255, 255, 80);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(208,255,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Limón_Claro = new ColorRGB(208, 255, 80);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,255,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Claro = new ColorRGB(80, 255, 80);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,255,208)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Primavera_Claro = new ColorRGB(80, 255, 208);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>TriplaColor</code> en esta coordenada →
     * <code>(80,255,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,208,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cielo_Claro = new ColorRGB(80, 208, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,80,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Claro = new ColorRGB(80, 80, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(208,80,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Morado_Claro = new ColorRGB(208, 80, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,80,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Claro = new ColorRGB(255, 80, 255);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Claros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,80,208)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Fucsia_Claro = new ColorRGB(255, 80, 208);

//Colores en extremos y medios de RGB (Oscuros)
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(195,0,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Oscuro = new ColorRGB(195, 0, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(195,68,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Oscuro = new ColorRGB(195, 68, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(195,195,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Oscuro = new ColorRGB(195, 195, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(68,195,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Limón_Oscuro = new ColorRGB(68, 195, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,195,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Oscuro = new ColorRGB(0, 195, 0);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,195,68)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Primavera_Oscuro = new ColorRGB(0, 195, 68);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,68,195)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cielo_Oscuro = new ColorRGB(0, 68, 195);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,0,195)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Oscuro = new ColorRGB(0, 0, 195);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(68,0,195)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Morado_Oscuro = new ColorRGB(68, 0, 195);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(195,0,195)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Oscuro = new ColorRGB(195, 0, 195);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Oscuros)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(195,0,68)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Fucsia_Oscuro = new ColorRGB(195, 0, 68);

//Colores en extremos y medios de RGB (Grises)
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(168,128,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Gris = new ColorRGB(168, 128, 128);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(168,148,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Gris = new ColorRGB(168, 148, 128);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(168,168,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Gris = new ColorRGB(168, 168, 128);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(148,168,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Limón_Gris = new ColorRGB(148, 168, 128);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,168,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Gris = new ColorRGB(128, 168, 128);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,168,148)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Primavera_Gris = new ColorRGB(128, 168, 148);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>TriplaColor</code> en esta coordenada →
     * <code>(128,168,168)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,148,168)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cielo_Gris = new ColorRGB(128, 148, 168);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,128,168)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Gris = new ColorRGB(128, 128, 168);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(148,128,168)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Morado_Gris = new ColorRGB(148, 128, 168);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(168,128,168)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Gris = new ColorRGB(168, 128, 168);
    /**
     * Pertenece al grupo de "Colores en extremos y medios de RGB (Grises)."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(168,128,148)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Fucsia_Gris = new ColorRGB(168, 128, 148);

//Rojo y sus matices
    /**
     * Pertenece al grupo de "Rojo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,36,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Escarlata = new ColorRGB(255, 36, 0);
    /**
     * Pertenece al grupo de "Rojo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(229,43,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Amaranto = new ColorRGB(229, 43, 80);
    /**
     * Pertenece al grupo de "Rojo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(227,66,51)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Bermellón = new ColorRGB(227, 66, 51);
    /**
     * Pertenece al grupo de "Rojo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(220,20,60)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Carmesí = new ColorRGB(220, 20, 60);
    /**
     * Pertenece al grupo de "Rojo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(150,0,24)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Carmín = new ColorRGB(150, 0, 24);
    /**
     * Pertenece al grupo de "Rojo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,0,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Rojo_Granate = new ColorRGB(128, 0, 0);

//Verde y sus matices
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(127,255,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Chartreuse = new ColorRGB(127, 255, 0);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,200,120)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Esmeralda = new ColorRGB(80, 200, 120);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,200,120)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Agua = Verde_Esmeralda;
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,200,120)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_AguaMarina = Verde_Esmeralda;
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(80,200,120)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verdeagua = Verde_Esmeralda;
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(76,187,23)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Kelly = new ColorRGB(76, 187, 23);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,168,107)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Jade = new ColorRGB(0, 168, 107);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(123,160,91)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Espárrago = new ColorRGB(123, 160, 91);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(68,148,74)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Arlequín = new ColorRGB(68, 148, 74);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(107,142,35)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Oliva = new ColorRGB(107, 142, 35);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(115,134,120)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Xanadu = new ColorRGB(115, 134, 120);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(64,130,109)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Veronés = new ColorRGB(64, 130, 109);
    /**
     * Pertenece al grupo de "Verde y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(53,94,59)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Verde_Cazador = new ColorRGB(53, 94, 59);

//Azul y sus matices
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(96,80,220)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Majorelle = new ColorRGB(96, 80, 220);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(1,49,180)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Zafiro = new ColorRGB(1, 49, 180);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,71,171)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Cobalto = new ColorRGB(0, 71, 171);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,47,167)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Klein = new ColorRGB(0, 47, 167);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(18,10,143)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Marino = new ColorRGB(18, 10, 143);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(75,0,130)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Índigo = new ColorRGB(75, 0, 130);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(75,0,130)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Añil = Azul_Índigo;
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,0,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Turquí = new ColorRGB(0, 0, 128);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(1,70,99)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_Petróleo = new ColorRGB(1, 70, 99);
    /**
     * Pertenece al grupo de "Azul y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,49,83)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Azul_De_Prusia = new ColorRGB(0, 49, 83);

//Magenta y sus matices
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(253,63,146)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Fucsia2 = new ColorRGB(253, 63, 146);
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(197,75,140)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Morado = new ColorRGB(197, 75, 140);
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(224,176,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Malva = new ColorRGB(224, 176, 255);
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(200,162,200)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Lila = new ColorRGB(200, 162, 200);
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(254,195,172)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Salmón = new ColorRGB(254, 195, 172);
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(230,230,250)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Lavanda = new ColorRGB(230, 230, 250);
    /**
     * Pertenece al grupo de "Magenta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,192,203)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Magenta_Rosa = new ColorRGB(255, 192, 203);

//Cian y sus matices
    /**
     * Pertenece al grupo de "Cian y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(48,213,200)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cyan_Turquesa = new ColorRGB(48, 213, 200);
    /**
     * Pertenece al grupo de "Cian y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(135,206,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cyan_Celeste = new ColorRGB(135, 206, 255);
    /**
     * Pertenece al grupo de "Cian y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(155,196,226)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cyan_Cerúleo = new ColorRGB(155, 196, 226);
    /**
     * Pertenece al grupo de "Cian y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(127,255,212)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Cyan_Aguamarina = new ColorRGB(127, 255, 212);

//Amarillo y sus matices
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(253,232,15)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Lima = new ColorRGB(253, 232, 15);
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(253,232,15)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Limón = new ColorRGB(253, 232, 15);
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,215,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Dorado = Amarillo_Limón;
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,215,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Oro = new ColorRGB(255, 215, 0);
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,192,5)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Ámbar = new ColorRGB(255, 192, 5);
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(240,230,140)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Kaki = new ColorRGB(240, 230, 140);
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(240,230,140)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Caqui = Amarillo_Kaki;
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(227,168,87)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Indio = new ColorRGB(227, 168, 87);
    /**
     * Pertenece al grupo de "Amarillo y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,186,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Amarillo_Selectivo = new ColorRGB(255, 186, 0);

//Marrón y sus matices
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(150,75,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café = new ColorRGB(150, 75, 0);
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(150,75,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café_Pardo = Café;
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(150,75,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Marrón = Café;
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(150,75,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Castaño = Café;
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(150,75,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Chocolate = Café;
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(148,129,43)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café_Caqui = new ColorRGB(148, 129, 43);
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(204,119,34)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café_Ocre = new ColorRGB(204, 119, 34);
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(184,115,51)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café_Siena = new ColorRGB(184, 115, 51);
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(218,138,95)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café_SienaPálido = new ColorRGB(218, 138, 95);
    /**
     * Pertenece al grupo de "Marrón y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,0,32)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Café_Borgoña = new ColorRGB(128, 0, 32);

//Violeta y sus matices
    /**
     * Pertenece al grupo de "Violeta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(139,0,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Violeta = new ColorRGB(139, 0, 255);
    /**
     * Pertenece al grupo de "Violeta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(181,126,220)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Violeta_Lavanda = new ColorRGB(181, 126, 220);
    /**
     * Pertenece al grupo de "Violeta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(153,102,204)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Violeta_Amatista = new ColorRGB(153, 102, 204);
    /**
     * Pertenece al grupo de "Violeta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(102,0,153)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Violeta_Púrpura = new ColorRGB(102, 0, 153);
    /**
     * Pertenece al grupo de "Violeta y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(102,2,60)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Violeta_PúrpuraDeTiro = new ColorRGB(102, 2, 60);

//Naranja y sus matices
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,112,40)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja2 = new ColorRGB(255, 112, 40);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,127,80)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Coral = new ColorRGB(255, 127, 80);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(237,145,33)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Zanahoria = new ColorRGB(237, 145, 33);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,140,105)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Sésamo = new ColorRGB(255, 140, 105);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(251,206,177)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Albaricoque = new ColorRGB(251, 206, 177);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(245,222,179)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Beige = new ColorRGB(245, 222, 179);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(245,222,179)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Beis = Naranja_Beige;
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,200,160)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Naranja_Durazno = new ColorRGB(255, 200, 160);
    /**
     * Pertenece al grupo de "Naranja y sus matices."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,200,160)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Piel = Naranja_Durazno;

//Blancos, grises y negros
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,255,255)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Blanco = new ColorRGB(255, 255, 255);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,250,250)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Nieve = new ColorRGB(255, 250, 250);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(250,240,230)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Lino = new ColorRGB(250, 240, 230);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(245,245,220)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Hueso = new ColorRGB(245, 245, 220);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(255,253,208)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Marfil = new ColorRGB(255, 253, 208);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(192,192,192)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Plata = new ColorRGB(192, 192, 192);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(192,192,192)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Plateado = Plata;
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(186,196,200)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Zinc = new ColorRGB(186, 196, 200);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(128,128,128)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Gris = new ColorRGB(128, 128, 128);
    /**
     * Pertenece al grupo de "Blancos, grises y negros."
     * <p>
     * Devuelve una <code>ColorRGB</code> en esta coordenada →
     * <code>(0,0,0)</code>
     * <p>
     * Puedes ver la tabla de colores en linea para que sepas a que colores
     * puedes hacer referencia con esta clase, entra a:
     * <p>
     * <A href="https://goo.gl/AN8U2T">
     * https://goo.gl/AN8U2T</A>
     * <p>
     * Te recomiendo copiar y pegar el enlace, ya que si das clic no leera la
     * pagína
     */
    public final static ColorRGB Negro = new ColorRGB(0, 0, 0);

}

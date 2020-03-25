package calculadoragráfica;

import Geometria2D.*;
import Herramientas.ColorRGB;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Plano extends Matemática {

    public Dupla centro = new Dupla(0, 0),
            Tamaño;

    public Dupla desplazar = new Dupla(0, 0);

    public int IntervaloDeSeparaciónEntreUnidades = 64,
            decimalesEtiquetas = 4,
            lineas = 0;

    public double UnidadDeEscala = IntervaloDeSeparaciónEntreUnidades,
            d = 1;

    BufferedImage ImagenFondo;

    Color colorFondo = Color.WHITE;

    public ArrayList<Funcion> funciones = new ArrayList<>();

    public Funcion función;

    public boolean DibujarLineasGuias = true,
            DibujarEjes = true,
            DibujarNumeros = true,
            DibujarFuncion = true,
            area = true;

    public Plano() {
        double min = -20 * π, max = 20 * π;
        función = new Funcion(this, "Contra(Cos(3t)Cos(t),v,t)",
                "Contra(Cos(3*t)Sen(t),v,t)", true) {
            @Override
            public Dupla XY(double t) {
                Dupla p = Contra(t, (2 * π) / v, (double t1) -> new Dupla(Cos(3 * t1) * Cos(t1), Cos(3 * t1) * Sen(t1)));
                return p;
            }
        };
        función.Dominio_Mín = min;
        función.Dominio_Máx = max;

        Funcion función2 = new Funcion(this, "Contra(Cos(3*t)Cos(t),v,t)", "Contra(Cos(3*t)Sen(t),v,t)", true) {
            @Override
            public Dupla XY(double t) {
//                return Contra(t, (2 * π) / v, (double t1) -> new Dupla(Cos(3 * t1) * Cos(t1), Cos(3 * t1) * Sen(t1)));
                return new Dupla(Cos(3 * t) * Cos(t), Cos(3 * t) * Sen(t));
            }
        };
        función2.Dominio_Mín = min;
        función2.Dominio_Máx = max;
        función2.MODO_GRAFICA = Funcion.RECTANGULAR;
        función2.ColorDibujado = new Color(230, 230, 230);
        función2.tabular();
        función2.dibujarEtiqueta = false;
        función2.ColorDibujado = Color.LIGHT_GRAY;
        funciones.add(función2);
        funciones.add(función);

        Funcion función3 = new Funcion(this, "ContraMedio(Cos(3t)Cos(t),v,t)", "ContraMedio(Cos(3*t)Sen(t),v,t)", true) {
            @Override
            public Dupla XY(double t) {
                Dupla p = Contra(t, (2 * π) / v, (double t1) -> new Dupla(Cos(3 * t1) * Cos(t1), Cos(3 * t1) * Sen(t1)));
                Dupla p2 = new Dupla(Cos(3 * t) * Cos(t), Cos(3 * t) * Sen(t));
                return p.Adicionar(p2).Multiplicar(1 / 2.0);
            }
        };

        función3.Dominio_Mín = min;
        función3.Dominio_Máx = max;
        función3.MODO_GRAFICA = Funcion.RECTANGULAR;
        función3.tabular();
        función3.dibujarEtiqueta = false;
//        funciones.add(función3);

    }

    public Dupla posCentro() {
        return new Dupla((Tamaño.X / 2) + desplazar.X, (Tamaño.Y / 2) + desplazar.Y);
    }

    public Dupla CentroDelPlano() {
        return ConvertirAPuntoEnElPlanoRectangular(new Dupla((Tamaño.X / 2), (Tamaño.Y / 2)));
    }

    public Dupla ConvertirAPuntoEnElPlanoRectangular(Dupla punto) {
        return new Dupla((punto.X - posCentro().X) / UnidadDeEscala, (posCentro().Y - punto.Y) / UnidadDeEscala);
    }

    public void dibujar(Graphics2D g, Dupla Tamaño) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        this.Tamaño = Tamaño;
        centro.sustituir(posCentro());

        GenerarFondo();

        g.drawImage(ImagenFondo, 0, 0, null);

        if (DibujarFuncion) {
            dibujarFuncion(g);
        }
    }

    public void GenerarFondo() {
        ImagenFondo = new BufferedImage(Tamaño.intX(), Tamaño.intY(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) ImagenFondo.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        fondo((Graphics2D) ImagenFondo.getGraphics());
        if (DibujarLineasGuias) {
            Cuadriculas((Graphics2D) ImagenFondo.getGraphics());
        }
        ejes((Graphics2D) ImagenFondo.getGraphics());
    }

    public void dibujarFuncion(Graphics2D g) {
        for (Funcion funcione : funciones) {
            funcione.dibujar(g);
        }
    }

    public void fondo(Graphics2D g) {
        g.setColor(colorFondo);
        g.fillRect(0, 0, Tamaño.intX(), Tamaño.intY());
    }

    public void ejes(Graphics2D g) {
        if (DibujarEjes) {
            if (función.ColorDibujado == null) {
                g.setColor(Color.BLACK);
            } else {
                g.setColor(función.ColorDibujado);
            }

            g.setStroke(new BasicStroke(1));

            g.drawLine(0, centro.intY(), Tamaño.intX(), centro.intY()); //X
            g.drawLine(centro.intX(), 0, centro.intX(), Tamaño.intY()); //Y
        }
    }

    public double zoomN() {
        return (UnidadDeEscala / IntervaloDeSeparaciónEntreUnidades);
    }

    public boolean zoom() {
        return (UnidadDeEscala / IntervaloDeSeparaciónEntreUnidades) >= 1;
    }

    public void cambiarZoom(double d) {
        Dupla before = CentroDelPlano();
        UnidadDeEscala += d;
        Dupla after = CentroDelPlano();
        Dupla diferencia = new Dupla(before.X - after.X, after.Y - before.Y);
        diferencia.Adicionar(UnidadDeEscala);
        desplazar.Sustraer(diferencia);
        GenerarFondo();
    }

    public void Desplazar(double X, double Y) {
        desplazar.Adicionar(X, Y);
        GenerarFondo();
    }

    public void Desplazar_Sustituir(double X, double Y) {
        desplazar.sustituir(X, Y);
        GenerarFondo();
    }

    public void cambiarColoFondo(Color color) {
        colorFondo = color;
    }

    public int CalcularLimiteSuperior(int ParalelasX, int Lim) {
        int retorno;
        if (ParalelasX > Lim) {
            retorno = Lim;
        } else {
            retorno = ParalelasX;
        }
        if (retorno < Lim / 2) {
            retorno = ParalelasX;

        }
        return retorno;
    }

    public int CalcularParalelas(int c, int t) {
        if (c < t / 2) {
            return (int) (abs(t - c) / UnidadDeEscala);
        } else {
            return (int) (abs(c) / UnidadDeEscala);
        }
    }

    public void Cuadriculas(Graphics2D g) {

        if (función.ColorDibujado == null) {
            g.setColor(Color.BLACK);
        } else {
            g.setColor(función.ColorDibujado);
        }

        int ParalelasX, ParalelasY, c, t;

        c = centro.intY();
        t = Tamaño.intY();
        ParalelasX = CalcularParalelas(c, t);
        int LimMax_X = (int) (t / UnidadDeEscala);

        c = centro.intX();
        t = Tamaño.intX();
        ParalelasY = CalcularParalelas(c, t);
        int LimMax_Y = (int) (t / UnidadDeEscala);

        int limX = CalcularLimiteSuperior(ParalelasX, LimMax_X);
        int iniX = ParalelasX > limX ? (ParalelasX - limX) : 1;

        int limY = CalcularLimiteSuperior(ParalelasY, LimMax_Y);
        int iniY = ParalelasY > limY ? (ParalelasY - limY) : 1;

        double fin;
        if (zoom()) {
            fin = (iniX + limX) * d;
        } else {
            fin = (iniX + limX) / d;
        }

        for (int i = iniX; i <= (int) fin; i++) {
            double altura = zoom() ? i * UnidadDeEscala / d : i * UnidadDeEscala * d;
            double longitud = centro.absX() + Tamaño.X;

            Dupla p1 = ConvertirPunto(longitud, altura);
            Dupla p2 = ConvertirPunto(-longitud, altura);
            Dupla p3 = ConvertirPunto(longitud, -altura);
            Dupla p4 = ConvertirPunto(-longitud, -altura);

            if (DibujarNumeros) {
                int espY = 3;
                int x1 = centro.intX() + espY,
                        x2 = x1,
                        y1 = p1.intY(),
                        y2 = p3.intY();
                DibujarNumerosEjes(i, x1, y1, x2, y2, g);
            }
        }

        if (zoom()) {
            fin = (iniY + limY) * d;
        } else {
            fin = (iniY + limY) / d;
        }

        for (int i = iniY; i <= (int) fin; i++) {
            double anchura = zoom() ? i * UnidadDeEscala / d : i * UnidadDeEscala * d;;
            double longitud = centro.absY() + Tamaño.Y;
            Dupla p1 = ConvertirPunto(anchura, -longitud);
            Dupla p2 = ConvertirPunto(anchura, longitud);
            Dupla p3 = ConvertirPunto(-anchura, -longitud);
            Dupla p4 = ConvertirPunto(-anchura, longitud);

            if (DibujarNumeros) {
                int x1 = p1.intX(),
                        x2 = p3.intX(),
                        y1 = centro.intY(),
                        y2 = y1;
                DibujarNumerosEjes(i, x1, y1, x2, y2, g);
            }

        }
    }

    public void DibujarNumerosEjes(int i, int x1, int y1, int x2, int y2, Graphics2D g) {
        g.drawString(recortarDecimales(i) + "", x1, y1);
        g.drawString(recortarDecimales(-i) + "", x2, y2);
    }

    public Dupla ConvertirPunto(Dupla punto) {
        return new Dupla(punto.X + centro.X + desplazar.X, punto.Y + centro.Y + desplazar.Y);
    }

    public Dupla ConvertirPunto(double a, double b) {
        Dupla punto = new Dupla(a, -b);
        return new Dupla(punto.X + centro.X, punto.Y + centro.Y);
    }

    public void msg(String texto) {
        System.out.println(texto);
    }

}

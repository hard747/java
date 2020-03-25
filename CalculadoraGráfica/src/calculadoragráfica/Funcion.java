package calculadoragráfica;

import Geometria2D.*;
import static Geometria2D.Compilador.*;
import Herramientas.*;
import Imagen.Imagen;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import javax.swing.JTextField;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public abstract class Funcion extends FunciónXY {

    public int n = 0,
            puntosTabular = 6000,
            cometa = puntosTabular + 1,
            tamañoLetra = 20,
            IncrementoCometa = 5,
            MODO_GRAFICA = 1;

    public static final int RECTANGULAR = 0,
            POLAR = 1,
            POLAR2 = 2,
            //

            ASTROIDE_3V = 3, ASTROIDE_4V = 4, ASTROIDE_5V = 5, ASTROIDE_6V = 6, ASTROIDE_7V = 7,
            ASTROIDE_8V = 8, ASTROIDE_9V = 9, ASTROIDE_10V = 10, ASTROIDE_11V = 11, ASTROIDE_12V = 12,
            ASTROIDE_13V = 13, ASTROIDE_14V = 14, ASTROIDE_15V = 15, ASTROIDE_16V = 16, ASTROIDE_17V = 17,
            ASTROIDE_18V = 18, ASTROIDE_19V = 19, ASTROIDE_20V = 20, ASTROIDE_21V = 21, ASTROIDE_22V = 22,
            ASTROIDE_23V = 23, ASTROIDE_24V = 24, ASTROIDE_25V = 25,
            //

            CARDIOIDE_1V = 26, CARDIOIDE_2V = 27, CARDIOIDE_3V = 28, CARDIOIDE_4V = 29, CARDIOIDE_5V = 30,
            CARDIOIDE_6V = 31, CARDIOIDE_7V = 32, CARDIOIDE_8V = 33, CARDIOIDE_9V = 34, CARDIOIDE_10V = 35,
            CARDIOIDE_11V = 36, CARDIOIDE_12V = 37, CARDIOIDE_13V = 38, CARDIOIDE_14V = 39, CARDIOIDE_15V = 40,
            CARDIOIDE_16V = 41, CARDIOIDE_17V = 42, CARDIOIDE_18V = 43, CARDIOIDE_19V = 44, CARDIOIDE_20V = 45,
            CARDIOIDE_21V = 46, CARDIOIDE_22V = 47, CARDIOIDE_23V = 48, CARDIOIDE_24V = 49, CARDIOIDE_25V = 50,
            //

            POLIGONOIDE_1 = 51, POLIGONOIDE_2 = 52, POLIGONOIDE_3 = 53, POLIGONOIDE_4 = 54, POLIGONOIDE_5 = 55,
            POLIGONOIDE_6 = 56, POLIGONOIDE_7 = 57, POLIGONOIDE_8 = 58, POLIGONOIDE_9 = 59, POLIGONOIDE_10 = 60,
            POLIGONOIDE_11 = 61, POLIGONOIDE_12 = 62, POLIGONOIDE_13 = 63, POLIGONOIDE_14 = 64,
            POLIGONOIDE_15 = 65,
            //
            POLIGONO_3 = 66, POLIGONO_4 = 67, POLIGONO_5 = 68,
            POLIGONO_6 = 69, POLIGONO_7 = 70, POLIGONO_8 = 71, POLIGONO_9 = 72, POLIGONO_10 = 73,
            POLIGONO_11 = 74, POLIGONO_12 = 75, POLIGONO_13 = 76, POLIGONO_14 = 77,
            POLIGONO_15 = 78;

    public double Dominio_Mín = -20 * pi,
            Dominio_Máx = 20 * pi,
            v = 3,
            IncrementoV = false ? 0 : 0.00123456789,
            desface_Astroide_Cardioide_Poligonoide = 0,
            Rotación_EspacioParamétrico = 0,
            unidad;

    JTextField representación;

    MatrizDuplas MapaFigura = new MatrizDuplas();

    public boolean V_EnMovimiento = true,
            Cometa_EnMovimiento = false,
            invertirRelacion = false,
            relleno = true,
            area = true,
            DomnioConPi = true,
            funciónProg = false,
            dibujarEtiqueta = true;

    Dupla centro = new Dupla(0, 0);
    Dupla PosTextA = new Dupla(5, 40);

    double AreaPorParabolas, AreaPorTrapecios, AreaPorRectangulos;
    Graphics2D g;
    Plano plano;

    ColorRGB colorDinamico = ColorRGB.aleatorio();
    Color ColorDibujado;

    String FunciónX, FunciónY;
    String Etiqueta_Funcion;

    String CosEspacio, SenEspacio;

    BufferedImage imagenEtiqueta;

    Compilador compilador = new Compilador();

    public Funcion(Plano plano, String X, String Y, boolean FunciónProg) {
        FunciónX = X;
        FunciónY = Y;
        funciónProg = FunciónProg;
        int k = 150;
        colorDinamico.maxColorG = k;
        colorDinamico.maxColorB = k;
        this.plano = plano;
    }

    public Dupla EvaluarFunción(double t) {

        if (funciónProg) {
            return XY(t);
        } else {

            String Parametro = "t = " + t + ";";
            if (FunciónX.contains("v") || FunciónY.contains("v")) {
                Parametro += "v=" + v + ";";
            }
            return new Dupla(
                    ConvertirANúmero(compilador.compilar(Parametro + FunciónX)),
                    ConvertirANúmero(compilador.compilar(Parametro + FunciónY))
            );
        }
    }

    public void tabular() {
        MapaFigura.Reiniciar();
        for (int i = 0; i < puntosTabular + 1; i++) {
            double Intervalo_Tabular = abs((Dominio_Mín - Dominio_Máx) / puntosTabular);;
            double Xi = i == 0 ? Dominio_Mín
                    : i == (puntosTabular) ? Dominio_Máx : Dominio_Mín + (Intervalo_Tabular * i);
            if (MODO_GRAFICA > RECTANGULAR) {
                double r, θ;
                if (invertirRelacion) {
                    r = EvaluarFunción(Xi).X;
                    θ = EvaluarFunción(Xi).Y;
                } else {
                    θ = EvaluarFunción(Xi).X;
                    r = EvaluarFunción(Xi).Y;
                }

                double rot = Rotación_EspacioParamétrico;

                switch (MODO_GRAFICA) {
                    case POLAR:
                        MapaFigura.Agregar(r * Cos(θ + rot), r * Sen(θ + rot));
                        break;
                    case POLAR2:
                        MapaFigura.Agregar(r * Cos(θ + rot) * Sen(θ + rot), r * Sen2(θ + rot));
                        break;
                    case ASTROIDE_3V:
                    case ASTROIDE_4V:
                    case ASTROIDE_5V:
                    case ASTROIDE_6V:
                    case ASTROIDE_7V:
                    case ASTROIDE_8V:
                    case ASTROIDE_9V:
                    case ASTROIDE_10V:
                    case ASTROIDE_11V:
                    case ASTROIDE_12V:
                    case ASTROIDE_13V:
                    case ASTROIDE_14V:
                    case ASTROIDE_15V:
                    case ASTROIDE_16V:
                    case ASTROIDE_17V:
                    case ASTROIDE_18V:
                    case ASTROIDE_19V:
                    case ASTROIDE_20V:
                    case ASTROIDE_21V:
                    case ASTROIDE_22V:
                    case ASTROIDE_23V:
                    case ASTROIDE_24V:
                    case ASTROIDE_25V:
                        double k = MODO_GRAFICA + desface_Astroide_Cardioide_Poligonoide;
                        MapaFigura.Agregar(Astroide(θ, k, rot).Multiplicar(r));
                        break;
                    case CARDIOIDE_1V:
                    case CARDIOIDE_2V:
                    case CARDIOIDE_3V:
                    case CARDIOIDE_4V:
                    case CARDIOIDE_5V:
                    case CARDIOIDE_6V:
                    case CARDIOIDE_7V:
                    case CARDIOIDE_8V:
                    case CARDIOIDE_9V:
                    case CARDIOIDE_10V:
                    case CARDIOIDE_11V:
                    case CARDIOIDE_12V:
                    case CARDIOIDE_13V:
                    case CARDIOIDE_14V:
                    case CARDIOIDE_15V:
                    case CARDIOIDE_16V:
                    case CARDIOIDE_17V:
                    case CARDIOIDE_18V:
                    case CARDIOIDE_19V:
                    case CARDIOIDE_20V:
                    case CARDIOIDE_21V:
                    case CARDIOIDE_22V:
                    case CARDIOIDE_23V:
                    case CARDIOIDE_24V:
                    case CARDIOIDE_25V:
                        k = MODO_GRAFICA - 25 + desface_Astroide_Cardioide_Poligonoide;
                        MapaFigura.Agregar(Cardioide(θ, k, rot).Multiplicar(r));
                        break;
                    case POLIGONOIDE_1:
                    case POLIGONOIDE_2:
                    case POLIGONOIDE_3:
                    case POLIGONOIDE_4:
                    case POLIGONOIDE_5:
                    case POLIGONOIDE_6:
                    case POLIGONOIDE_7:
                    case POLIGONOIDE_8:
                    case POLIGONOIDE_9:
                    case POLIGONOIDE_10:
                    case POLIGONOIDE_11:
                    case POLIGONOIDE_12:
                    case POLIGONOIDE_13:
                    case POLIGONOIDE_14:
                    case POLIGONOIDE_15:
                        k = MODO_GRAFICA - 50 + desface_Astroide_Cardioide_Poligonoide;
                        MapaFigura.Agregar(Poligonoide(θ, k, rot).Multiplicar(r));
                        break;
                    case POLIGONO_3:
                    case POLIGONO_4:
                    case POLIGONO_5:
                    case POLIGONO_6:
                    case POLIGONO_7:
                    case POLIGONO_8:
                    case POLIGONO_9:
                    case POLIGONO_10:
                    case POLIGONO_11:
                    case POLIGONO_12:
                    case POLIGONO_13:
                    case POLIGONO_14:
                    case POLIGONO_15:
                        k = MODO_GRAFICA - 65 + desface_Astroide_Cardioide_Poligonoide;
                        MapaFigura.Agregar(Poligono(θ, k).Multiplicar(r));
                }
            } else if (invertirRelacion) {
                MapaFigura.Agregar(EvaluarFunción(Xi).Invertir());
            } else {
                MapaFigura.Agregar(EvaluarFunción(Xi));
            }
        }
    }

    public BufferedImage ImagenParaNombre(int tamañoLetra, Color FG) {
        TeXFormula formula;

        String variable = "_{v = " + v + "}";

        String Dominio;
        if (DomnioConPi) {
            Dominio = "[" + recortarDecimales(Dominio_Mín / π) + "π\\leq t \\leq" + recortarDecimales(Dominio_Máx / π) + "π]";
        } else {
            Dominio = "[" + recortarDecimales(Dominio_Mín) + "," + recortarDecimales(Dominio_Máx) + "]";
        }

        Etiqueta_Funcion = "x=" + Compilador.FuncionesPropias(FunciónX, LATEX) + "\\\\" + "y=" + Compilador.FuncionesPropias(FunciónY, LATEX);
        if (MODO_GRAFICA > RECTANGULAR) {
            Etiqueta_Funcion
                    = "x=(" + FunciónY.replace("(K-1)", (plano.función.MODO_GRAFICA - 1) + "").replace("K", plano.función.MODO_GRAFICA + "") + ")" + CosEspacio + "\\\\"
                    + "y=(" + FunciónY.replace("(K-1)", (plano.función.MODO_GRAFICA - 1) + "").replace("K", plano.función.MODO_GRAFICA + "") + ")" + SenEspacio;
        }
        String Texto = variable + "\\\\" + Etiqueta_Funcion + "\\\\" + Dominio;
        System.out.println(Texto);
        formula = new TeXFormula(Texto);
        BufferedImage retorno = (BufferedImage) formula.createBufferedImage(TeXConstants.STYLE_DISPLAY, tamañoLetra, FG, plano.colorFondo);
        if (retorno.getWidth() > plano.Tamaño.X) {
            Imagen image = new Imagen(null);
            retorno = image.Escalar(retorno, plano.Tamaño.X / retorno.getWidth(), false);
        }
        return retorno;
    }

    public void dibujar(Graphics2D g) {
        this.g = g;
        this.unidad = plano.UnidadDeEscala;
        this.centro = plano.centro;
        //g.setColor(color.Retornarse());
        if (ColorDibujado == null) {
            colorDinamico.Desplazar();
        }
        if (relleno) {
            DibujarFunción(true);
        } else {
            DibujarFunción(false);
        }
        AumentarCometa();
        if (n > 0) {
            dibujarAreaRectangulos();
            dibujarAreaTrapecios();
            dibujarAreaParabolas();
        }
        if (dibujarEtiqueta) {
            if (imagenEtiqueta == null) {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, Color.BLACK);
            }
            g.drawImage(imagenEtiqueta, 0, 0, null);
        }
        animacion();
    }

    public void DibujarFunción(boolean Pintado) {
        try {
            MatrizDuplas mapaConvertido = new MatrizDuplas();

            for (int i = 0; i < puntosTabular + 1; i++) {
                mapaConvertido.Agregar(ConvertirPunto(MapaFigura.Obtener(i)));
            }
            if (ColorDibujado == null) {
                g.setColor(colorDinamico.Retornarse());
            } else {
                g.setColor(ColorDibujado);
            }
            if (cometa < puntosTabular) {
                if (Pintado) {
                    mapaConvertido.dibujarPoligonoPintado(g, 0, cometa);
                }
                mapaConvertido.dibujarLinea(g, 0, cometa);
            } else {
                if (Pintado) {
                    mapaConvertido.dibujarPoligonoPintado(g);
                }
                mapaConvertido.dibujarLinea(g);
            }

        } catch (Exception e) {
        }
    }

    public void cambiarFTex(String var) {
        String Rel[] = {"x", "y", "r", "θ"};
        for (int i = 0; i < Rel.length; i++) {
            if (FunciónX.contains("f(" + Rel[i] + ")")) {
                FunciónX = FunciónX.replace(Rel[i], var);
                for (int j = 0; j < Rel.length; j++) {
                    FunciónX = FunciónX.replace("\\f" + Rel[j] + "ac", "\\frac");
                    FunciónX = FunciónX.replace("\\sq" + Rel[j] + "t", "\\sqrt");
                }
                return;
            }
        }
    }

    public void Inversa() {
        invertirRelacion = !invertirRelacion;
        tabular();
    }

    public void animacion() {
        if (V_EnMovimiento && (FunciónX.contains("v") || FunciónY.contains("v"))) {
            v += IncrementoV;
            tabular();
            if (representación != null) {
                representación.setText(v + "");
                if (dibujarEtiqueta) {
                    if (ColorDibujado == null) {
                        imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, colorDinamico.Retornarse());
                    } else {
                        imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, ColorDibujado);
                    }
                }
            }
        }
    }

    public void V_Sustitución(double sustitución) {
        v = sustitución;
        if (representación != null && V_EnMovimiento) {
            representación.setText(v + "");
        }
        if (dibujarEtiqueta) {
            if (ColorDibujado == null) {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, colorDinamico.Retornarse());
            } else {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, ColorDibujado);
            }
        }
        tabular();
    }

    public void V_Incremento() {
        v += IncrementoV;
        if (representación != null) {
            representación.setText(v + "");
        }
        if (dibujarEtiqueta) {
            if (ColorDibujado == null) {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, colorDinamico.Retornarse());
            } else {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, ColorDibujado);
            }
        }
        tabular();
    }

    public void V_Decremento() {
        v -= IncrementoV;
        if (representación != null) {
            representación.setText(v + "");
        }
        if (dibujarEtiqueta) {
            if (ColorDibujado == null) {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, colorDinamico.Retornarse());
            } else {
                imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, ColorDibujado);
            }
        }
        tabular();
    }

    public void AumentarCometa() {
        try {
            g.setColor(Color.BLACK);

            if ((cometa + IncrementoCometa) < puntosTabular + 1) {
                if (Cometa_EnMovimiento) {
                    cometa += IncrementoCometa;
                }
                if (dibujarEtiqueta) {
                    if (ColorDibujado == null) {
                        imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, colorDinamico.Retornarse());
                    } else {
                        imagenEtiqueta = (BufferedImage) ImagenParaNombre(tamañoLetra, ColorDibujado);
                    }
                }

                Dupla posición = ConvertirPunto(MapaFigura.Obtener(cometa));
                if (MODO_GRAFICA > RECTANGULAR) {
                    double a = MapaFigura.Obtener(cometa).X;
                    double r = MapaFigura.Obtener(cometa).Y;

                    String Texto = invertirRelacion
                            ? "(" + recortarDecimales(r) + "," + recortarDecimales(a) + ")"
                            : "(" + recortarDecimales(a) + "," + recortarDecimales(r) + ")";

                    g.drawString(Texto,
                            posición.intX(), posición.intY());
                } else {
                    g.drawString("(" + recortarDecimales(MapaFigura.Obtener(cometa).X) + "º,"
                            + recortarDecimales(MapaFigura.Obtener(cometa).Y) + ")", posición.intX(), posición.intY());
                }
                g.fillOval(posición.intX(), posición.intY(), 10, 10);
            } else {
                cometa = puntosTabular + 1;
                Cometa_EnMovimiento = false;
            }
        } catch (Exception e) {
        }
    }

    public double deltaX() {
        return (Dominio_Máx - Dominio_Mín) / n;
    }

    public void DibujarRectangulo(double Xi, double altura, int i) {
        int altoR = (int) abs(altura * unidad);
        int anchoR = (int) (deltaX() * unidad);
        Dupla pos = altura > 0 ? ConvertirPunto(Xi, altura) : ConvertirPunto(Xi, 0);

        int transparenciaArea = 100;
        Color color1_Area = new Color(127, 213, 255, transparenciaArea),
                color2_Area = new Color(20, 156, 255, transparenciaArea);

        Color color = i % 2 != 0 ? color1_Area : color2_Area;

        g.setColor(color);
        g.fillRect(pos.intX(), pos.intY(), anchoR, altoR);
        g.draw(new Rectangle2D.Double(pos.intX(), pos.intY(), anchoR, altoR));
    }

    public void dibujarAreaRectangulos() {
        AreaPorRectangulos = 0;

        for (int i = 0; i < n; i++) {
            double Xi = Dominio_Mín + deltaX() * i;
            double altura = EvaluarFunción(Xi + deltaX() / 2).Y;

            AreaPorRectangulos += altura * deltaX();

            //DibujarRectangulo(Xi, altura, i);
        }

        g.setColor(Color.BLACK);
        g.drawString("Metodo de Rectangulos", PosTextA.intX(), PosTextA.intY());
        g.drawString("Area Aproximada de la curva = " + AreaPorRectangulos, PosTextA.intX(), PosTextA.intY() + 15);
        g.drawString("Cantidad = " + n, PosTextA.intX(), PosTextA.intY() + 30);

    }

    public void dibujarAreaTrapecios() {
        AreaPorTrapecios = 0;

        double sumatoria = 0;
        for (int i = 0; i <= n - 1; i++) {
            double Xi = Dominio_Mín + deltaX() * i;
            sumatoria += i == 0 ? 0 : (2 * EvaluarFunción(Xi).Y);

            int transparenciaArea = 100;
            Color color1_Area = new Color(127, 213, 255, transparenciaArea),
                    color2_Area = new Color(20, 156, 255, transparenciaArea);

            Color color = i % 2 != 0 ? color1_Area : color2_Area;
            g.setColor(color);

            double Xi2 = Dominio_Mín + deltaX() * (i + 1);
            Dupla P1 = ConvertirPunto(Xi, 0);
            Dupla P2 = ConvertirPunto(Xi, EvaluarFunción(Xi).Y);
            Dupla P3 = ConvertirPunto(Xi2, EvaluarFunción(Xi2).Y);
            Dupla P4 = ConvertirPunto(Xi2, 0);
            int Xs[] = {P1.intX_rnd(), P2.intX_rnd(), P3.intX_rnd(), P4.intX_rnd()};
            int Ys[] = {P1.intY_rnd(), P2.intY_rnd(), P3.intY_rnd(), P4.intY_rnd()};

            g.fillPolygon(Xs, Ys, 4);
        }
        AreaPorTrapecios = (deltaX() / 2) * (EvaluarFunción(Dominio_Mín).Y + sumatoria + EvaluarFunción(Dominio_Máx).Y);

        int Pos = 4;
        String TextoR[] = {"Metodo de Trapecios",
            "Area Aproximada = " + AreaPorTrapecios};
        dibujarTextoA(TextoR, Pos);

    }

    public void dibujarAreaParabolas() {
        int npar = n % 2 != 0 ? n + 1 : n;
        double deltaX = (Dominio_Máx - Dominio_Mín) / npar;

        AreaPorParabolas = 0;

        double sumatoria = 0;
        for (int i = 1; i <= npar - 1; i++) {
            double Xi = Dominio_Mín + deltaX * i;
            sumatoria += i % 2 == 0 ? (2 * EvaluarFunción(Xi).Y) : (4 * EvaluarFunción(Xi).Y);
        }

        AreaPorParabolas = (deltaX / 3) * (EvaluarFunción(Dominio_Mín).Y + sumatoria + EvaluarFunción(Dominio_Máx).Y);

        int Pos = 7;
        String TextoR[] = {"Metodo de Parabolas (n-par)",
            "Area Aproximada = " + AreaPorParabolas};
        dibujarTextoA(TextoR, Pos);

    }

    public void dibujarTextoA(String[] TextoR, int Pos) {
        g.setColor(Color.BLACK);
        Pos *= 15;
        g.drawString("n = " + n, PosTextA.intX(), 15);
        for (int i = 0; i < TextoR.length; i++) {
            g.drawString(TextoR[i], PosTextA.intX(), PosTextA.intY() + i * 15 + Pos);
        }
    }

    public Dupla ConvertirPunto(double x, double y) {
        Dupla punto = new Dupla(x * unidad, -y * unidad);
        return new Dupla(punto.X + centro.X, punto.Y + centro.Y);
    }

    public Dupla ConvertirPunto(Dupla dupla) {
        return ConvertirPunto(dupla.X, dupla.Y);
    }

    public void msg(String texto) {
        System.out.println(texto);
    }

}

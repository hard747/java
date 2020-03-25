package Geometria2D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static Geometria2D.Matemática.*;

public class Compilador {

    public final static int LATEX = 0, GEOGEBRA = 1, FOOPLOT = 2;

    public static void main(String[] args) {
        String texto = "Contra(Cos(t),4)";
        Compilador c = new Compilador();
        System.out.println("Resultado compilado: " + c.FuncionesPropias(texto, LATEX));
    }

    final static String separador = ";";
    int DecimalesMáximos = 20;
    Set<Variable> variable = new HashSet<>();

    public String compilar(String texto) {
        //Variables por defecto
        String variablesPorDefecto = "";
        if (texto.contains("π")) {
            variablesPorDefecto = "π = " + π + ";";
        }
        if (texto.contains("φ")) {
            variablesPorDefecto = "φ = " + φ + ";";

        }
        if (texto.contains("Φ")) {
            variablesPorDefecto = "Φ = " + Φ + ";";
        }

        texto = variablesPorDefecto + texto;

        texto = texto.replace(" ", "");//Eliminar espacios
        texto = texto.replace("\n", "");//Eliminar saltos de linea
        texto = texto.replace("--", "+");//Eliminar posible error de multiplicación de signos
        texto = texto.replace("½", "0.5");//Reemplaza el caracter ½ por su valor decimal
        texto = texto.replace("¼", "0.25");//Reemplaza el caracter ¼ por su valor decimal
        texto = texto.replace("¾", "0.75");//Reemplaza el caracter ¾ por su valor decimal
        texto = texto.replace("¹", "");//Elevar un numero a la 1 da como resultado el mismo numero
        texto = texto.replace("²", "^2");//Reemplaza el caracter ² por su operación correspondiente
        texto = texto.replace("³", "3");//Reemplaza el caracter ³ por su operación correspondiente
        texto = texto.replace("×", "*");//Reemplaza el caracter × por su operación correspondiente
        texto = texto.replace("÷", "/");//Reemplaza el caracter ÷ por su operación correspondiente

        String sentencias[] = texto.split(separador);

        for (String sentencia : sentencias) {

            if (sentencia.contains("=") && sentencia.split("=").length == 2) {//Declaración de variable

                String nombre = sentencia.split("=")[0];
                String valor = sentencia.split("=")[1];

                if (variable.stream().anyMatch((var) -> (var.nombre.equals(nombre)))) {
                    //Evita que se genere otra variable con el mismo nombre;
                    variable.stream().filter((var) -> (var.nombre.equals(nombre))).forEach((var) -> {
                        var.valor = valor;
                    });
                } else {
                    //Crea una nueva variable
                    variable.add(new Variable(nombre, generarValorDeExpresión(valor), this));
                }
            } else {
                return generarValorDeExpresión(sentencia);
            }
        }
        return "\\text{No hay expresión}";
    }

    public String generarValorDeExpresión(String expresión) {
        expresión = reemplazarVariablesPorNumeros(expresión);
        if (expresión.contains("(")) {
            expresión = EjecutarFunciones(expresión);
        }
        if (expresión.contains("(")) {
            expresión = EliminarExpresionesAgrupadas(expresión);
        }
        if (expresión.contains("+") || expresión.contains("-") || expresión.contains("*")
                || expresión.contains("/") || expresión.contains("^")) {
            expresión = EfectuarOperacionesBinarias(expresión);
        }
        return expresión;
    }

    public static String FuncionesPropias(String expresión, int TRADUCCIÓN) {
        String[] FuncionesPropias = {"Contra", "ContraMedio"};
        for (String función : FuncionesPropias) {//Buscará coincidencia con todas las funciones para eliminarlas
            if (expresión.contains(función + "(")) {//Determinará si contiene cierta función
                String funciónBuscada = "";
                String ParámetrosDeLaFunción = "";
                int contador = 0;
                boolean coincidencia = false;
                for (char c : expresión.toCharArray()) {//Efectuará la busqueda de la función

                    if (funciónBuscada.equals(función + "(") && !coincidencia) {//Aquí habrá encontrado una coincidencia
                        coincidencia = true;
                        contador++;
                        ParámetrosDeLaFunción += c;
                    } else if (coincidencia) {
                        switch (c) {
                            case '(':
                                ParámetrosDeLaFunción += c;
                                contador++;
                                break;
                            case ')':
                                contador--;
                                if (contador == 0) {
                                    String resultado = "";
                                    switch (función) {
                                        case "Contra":
                                            String Función = ParámetrosDeLaFunción.split(",")[0];
                                            String k = ParámetrosDeLaFunción.split(",")[1] + "";

                                            boolean Rad; //Esta variable se usa para dividir más facilmente una circunferencia

                                            switch (ParámetrosDeLaFunción.split(",").length) {
                                                case 2:
                                                    Rad = false;
                                                    break;
                                                case 3:
                                                    if (ParámetrosDeLaFunción.split(",")[2].equals("t")) {
                                                        Rad = true;
                                                    } else if (ParámetrosDeLaFunción.split(",")[2].equals("f")) {
                                                        Rad = false;
                                                    } else {
                                                        System.err.println(ParámetrosDeLaFunción);
                                                        throw new Error("El tercer parámetro no ha sido reconosido, t = true, f = false");
                                                    }
                                                    break;
                                                default:
                                                    throw new Error("El operador Contra recibe 3 parámetros, siga este orden Contra(\"Curva\",\"Distancia entre divisiones(k)\",\"2π/k?\")");
                                            }
                                            String C1 = "",
                                             C2 = "",
                                             ti = "",
                                             pi = "",
                                             pf = "",
                                             rev = "(2π)";
                                            try {
                                                k = recortarDecimales(abs(ConvertirANúmero(k)));
                                                k = ConvertirANúmero(k) % 2 == 0 && Rad ? ConvertirANúmero(k) / 2 + "" : k;
                                                rev = ConvertirANúmero(k) % 2 == 0 ? "π" : rev;
                                            } catch (Exception e) {
                                            }

                                            if (TRADUCCIÓN == LATEX) {
                                                C1 = Rad ? "\\tfrac{" + rev + "}{" + k + "}" : k;
                                                C2 = Rad ? "\\tfrac{" + k + "}{" + rev + "}" : "\\tfrac{1}{" + k + "}";
                                                ti = C1 + "Sgn(t)(2 ⌊ |" + C2 + "t |⌋+1)-t";
                                                pi = C1 + "Sgn(t) ⌊ |" + C2 + "t |⌋";
                                                pf = C1 + "Sgn(t)(⌊ |" + C2 + "t |⌋+1)";

                                            } else if (TRADUCCIÓN == GEOGEBRA) {
                                                C1 = Rad ? rev + "/" + k : k;
                                                C2 = Rad ? k + "/" + rev : 1 + "/" + k;
                                                ti = C1 + "Sgn(t)(2 floor(|(" + C2 + ") t |)+1)-t";
                                                pi = C1 + "Sgn(t)(floor(|(" + C2 + ") t |))";
                                                pf = C1 + "Sgn(t)(floor(|(" + C2 + ") t |)+1)";
                                            }

                                            if (Función.contains("t^") || Función.contains("/t")) {
                                                pi = "(" + pi + ")";
                                                pf = "(" + pf + ")";
                                            }
                                            ti = "(" + ti + ")";

                                            if (Función.toCharArray()[0] == '-' || Función.toCharArray()[0] == '+') {
                                                resultado = Función.replace("t", pi) + Función.replace("t", pf);
                                                resultado += "+" + Función.substring(1, Función.length()).replace("t", ti);
                                            } else {
                                                resultado = Función.replace("t", pi) + "+" + Función.replace("t", pf);
                                                resultado += "-" + Función.replace("t", ti);
                                            }

                                            //Eliminar signo para las expresiones a las que les es indiferente
                                            resultado = resultado
                                                    .replace(pi + "^2", pi.replace("Sgn(t)", "") + "^2")
                                                    .replace(pi + "^4", pi.replace("Sgn(t)", "") + "^4")
                                                    .replace(pf + "^2", pf.replace("Sgn(t)", "") + "^2")
                                                    .replace(pf + "^4", pf.replace("Sgn(t)", "") + "^4")
                                                    .replace("Cos(" + pi + ")", "Cos(" + pi.replace("Sgn(t)", "") + ")")
                                                    .replace("Cos(" + pf + ")", "Cos(" + pf.replace("Sgn(t)", "") + ")")
                                                    .replace("Sen(" + pi + ")", "Sgn(t)" + "Sen(" + pi.replace("Sgn(t)", "") + ")")
                                                    .replace("Sen(" + pf + ")", "Sgn(t)" + "Sen(" + pf.replace("Sgn(t)", "") + ")");
                                            break;

                                        case "ContraMedio":
                                            System.err.println("Jejeje");
                                            switch (ParámetrosDeLaFunción.split(",").length) {
                                                case 2:
                                                    Rad = false;
                                                    break;
                                                case 3:
                                                    if (ParámetrosDeLaFunción.split(",")[2].equals("t")) {
                                                        Rad = true;
                                                    } else if (ParámetrosDeLaFunción.split(",")[2].equals("f")) {
                                                        Rad = false;
                                                    } else {
                                                        System.err.println(ParámetrosDeLaFunción);
                                                        throw new Error("El tercer parámetro no ha sido reconosido, t = true, f = false");
                                                    }
                                                    break;
                                                default:
                                                    throw new Error("El operador Contra recibe 3 parámetros, siga este orden Contra(\"Curva\",\"Distancia entre divisiones(k)\",\"2π/k?\")");
                                            }

                                            C1 = "";
                                            C2 = "";
                                            ti = "";
                                            pi = "";
                                            pf = "";
                                            rev = "(2π)";
                                            Función = ParámetrosDeLaFunción.split(",")[0];
                                            k = ParámetrosDeLaFunción.split(",")[1] + "";
                                            try {
                                                k = recortarDecimales(abs(ConvertirANúmero(k)));
                                                k = ConvertirANúmero(k) % 2 == 0 && Rad ? recortarDecimales(ConvertirANúmero(k) / 2) + "" : k;
                                                rev = ConvertirANúmero(k) % 2 == 0 ? "π" : rev;
                                            } catch (Exception e) {
                                            }

                                            if (TRADUCCIÓN == LATEX) {
                                                C1 = Rad ? "\\tfrac{" + rev + "}{" + k + "}" : k;
                                                C2 = Rad ? "\\tfrac{" + k + "}{" + rev + "}" : "\\tfrac{1}{" + k + "}";
                                                ti = C1 + "Sgn(t)(2 ⌊ |" + C2 + "t |⌋+1)-t";
                                                pi = C1 + "Sgn(t) ⌊ |" + C2 + "t |⌋";
                                                pf = C1 + "Sgn(t)(⌊ |" + C2 + "t |⌋+1)";

                                            } else if (TRADUCCIÓN == GEOGEBRA) {
                                                C1 = Rad ? rev + "/" + k : k;
                                                C2 = Rad ? k + "/" + rev : 1 + "/" + k;
                                                ti = C1 + "Sgn(t)(2 floor(|(" + C2 + ") t |)+1)-t";
                                                pi = C1 + "Sgn(t)(floor(|(" + C2 + ") t |))";
                                                pf = C1 + "Sgn(t)(floor(|(" + C2 + ") t |)+1)";
                                            }

                                            if (Función.contains("t^") || Función.contains("/t")) {
                                                pi = "(" + pi + ")";
                                                pf = "(" + pf + ")";
                                            }
                                            ti = "(" + ti + ")";

                                            if (Función.toCharArray()[0] == '-' || Función.toCharArray()[0] == '+') {
                                                resultado = Función.replace("t", pi) + Función.replace("t", pf);
                                                resultado += "+" + Función.substring(1, Función.length()).replace("t", ti);
                                            } else {
                                                resultado = Función.replace("t", pi) + "+" + Función.replace("t", pf);
                                                resultado += "-" + Función.replace("t", ti);
                                            }

                                            //Eliminar signo para las expresiones a las que les es indiferente
                                            resultado = resultado
                                                    .replace(pi + "^2", pi.replace("Sgn(t)", "") + "^2")
                                                    .replace(pi + "^4", pi.replace("Sgn(t)", "") + "^4")
                                                    .replace(pf + "^2", pf.replace("Sgn(t)", "") + "^2")
                                                    .replace(pf + "^4", pf.replace("Sgn(t)", "") + "^4")
                                                    .replace("Cos(" + pi + ")", "Cos(" + pi.replace("Sgn(t)", "") + ")")
                                                    .replace("Cos(" + pf + ")", "Cos(" + pf.replace("Sgn(t)", "") + ")")
                                                    .replace("Sen(" + pi + ")", "Sgn(t)" + "Sen(" + pi.replace("Sgn(t)", "") + ")")
                                                    .replace("Sen(" + pf + ")", "Sgn(t)" + "Sen(" + pf.replace("Sgn(t)", "") + ")");

                                            if (TRADUCCIÓN == LATEX) {
                                                if (resultado.toCharArray()[0] == '-' || resultado.toCharArray()[0] == '+') {
                                                    resultado = "\\tfrac{1}{2}(" + Función + resultado + ")";
                                                } else {
                                                    resultado = "\\tfrac{1}{2}(" + Función + "+" + resultado + ")";
                                                }
                                            } else if (TRADUCCIÓN == GEOGEBRA) {
                                                if (resultado.toCharArray()[0] == '-' || resultado.toCharArray()[0] == '+') {
                                                    resultado = "(1/2)(" + Función + resultado + ")";
                                                } else {
                                                    resultado = "(1/2)(" + Función + "+" + resultado + ")";
                                                }
                                            }

                                            break;
                                    }
                                    expresión = expresión.replace(funciónBuscada + ParámetrosDeLaFunción + ")", resultado);
                                } else {
                                    ParámetrosDeLaFunción += c;
                                }
                                break;
                            default:
                                ParámetrosDeLaFunción += c;
                        }
                    } else if (c == función.concat("(").toCharArray()[funciónBuscada.length()]) {
                        funciónBuscada += c;
                    }
                }
            }
        }
        return expresión;
    }

    public String EjecutarFunciones(String expresión) {
        for (String función : Funciones()) {//Buscará coincidencia con todas las funciones para eliminarlas
            if (expresión.contains(función + "(")) {//Determinará si contiene cierta función
                String funciónBuscada = "";
                String ParámetrosDeLaFunción = "";
                int contador = 0;
                boolean coincidencia = false;
                for (char c : expresión.toCharArray()) {//Efectuará la busqueda de la función
                    if (funciónBuscada.equals(función + "(") && !coincidencia) {//Aquí habrá encontrado una coincidencia
                        coincidencia = true;
                        contador++;
                        ParámetrosDeLaFunción += c;
                    } else if (coincidencia) {
                        switch (c) {
                            case '(':
                                ParámetrosDeLaFunción += c;
                                contador++;
                                break;
                            case ')':
                                contador--;
                                if (contador == 0) {
                                    String resultado = "";
                                    switch (función) {
                                        case "ACos":
                                            resultado = Acos(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "ASen":
                                            resultado = Asen(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "ATan":
                                            resultado = Atan(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Cos":
                                            resultado = Cos(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Cosh":
                                            resultado = Cosh(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Cos^2":
                                        case "Cos2":
                                            resultado = Cos2(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Cos^3":
                                        case "Cos3":
                                            resultado = Cos3(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Cos^4":
                                        case "Cos4":
                                            resultado = Cos4(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Sen":
                                            resultado = Sen(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Senh":
                                            resultado = Senh(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Sen^2":
                                        case "Sen2":
                                            resultado = Sen3(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Sen^3":
                                        case "Sen3":
                                            resultado = Sen(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Sen^4":
                                        case "Sen4":
                                            resultado = Sen(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Sec":
                                            resultado = Sec(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Sech":
                                            resultado = Sech(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Csc":
                                            resultado = Csc(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Csch":
                                            resultado = Csch(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Tan":
                                            resultado = Tan(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Tanh":
                                            resultado = Tanh(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Cot":
                                            resultado = Cot(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Coth":
                                            resultado = Coth(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Floor":
                                        case "Piso":
                                            resultado = Piso(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Ln":
                                            resultado = Ln(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Rdnd":
                                            resultado = Redondear_a_entero_más_cercano(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Poten":
                                            double parámetro1 = ConvertirANúmero(compilar(ParámetrosDeLaFunción.split(",")[0]));
                                            double parámetro2 = ConvertirANúmero(compilar(ParámetrosDeLaFunción.split(",")[1]));
                                            resultado = poten(parámetro1, parámetro2) + "";
                                            break;
                                        case "Poten^2":
                                        case "Poten2":
                                            resultado = poten2(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Poten^3":
                                        case "Poten3":
                                            resultado = poten3(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Poten^4":
                                        case "Poten4":
                                            resultado = poten4(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "Raiz":
                                            parámetro1 = ConvertirANúmero(compilar(ParámetrosDeLaFunción.split(",")[0]));
                                            parámetro2 = ConvertirANúmero(compilar(ParámetrosDeLaFunción.split(",")[1]));
                                            resultado = raíz(parámetro1, parámetro2) + "";
                                            break;
                                        case "RaizCuadrada":
                                        case "Raiz2":
                                            resultado = raízCuadrada(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "RaizCubica":
                                        case "Raiz3":
                                            resultado = raízCúbica(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                        case "RaizCuarta":
                                        case "Raiz4":
                                            resultado = raíz4(ConvertirANúmero(compilar(ParámetrosDeLaFunción))) + "";
                                            break;
                                    }
                                    if (resultado.contains("E-")) {
                                        resultado = "0";
                                    }
                                    expresión = expresión.replace(funciónBuscada + ParámetrosDeLaFunción + ")", resultado);
                                } else {
                                    ParámetrosDeLaFunción += c;
                                }

                                break;
                            default:
                                ParámetrosDeLaFunción += c;
                        }
                    } else if (c == función.concat("(").toCharArray()[funciónBuscada.length()]) {
                        funciónBuscada += c;
                    }
                }
            }
        }
        return expresión;
    }

    public String EliminarExpresionesAgrupadas(String expresión) {
        //Buscar expresiones agrupadas
        if (expresión.contains("(")) {
            int ParentesisIzquierdos = 0, ParentesisDerechos = 0;
            //Aquí es para notificar de un error
            for (char c : expresión.toCharArray()) {
                String s = c + "";
                if (s.equals("(")) {
                    ParentesisIzquierdos++;
                }
                if (s.equals(")")) {
                    ParentesisDerechos++;
                }
            }
            if (ParentesisDerechos != ParentesisIzquierdos) {
                throw new Error("Faltan parentesis en la expresión" + expresión);
            }

            //Aqui hay que extraer lo interior del primer parentesis encontrado
            boolean primerParentecisEncontrado = false;
            int contadorDeParentesisAnidados = 0;
            String ExpresiónAgrupada = "";
            String expresiónSinAgrupadores = "";
            for (char c : expresión.toCharArray()) {
                switch (c) {
                    case '(':
                        if (!primerParentecisEncontrado) {
                            primerParentecisEncontrado = true;
                        } else if (contadorDeParentesisAnidados >= 0) {
                            contadorDeParentesisAnidados++;
                            ExpresiónAgrupada += c;
                        }
                        break;
                    case ')':
                        if (contadorDeParentesisAnidados <= 0) {
                            expresiónSinAgrupadores += compilar(ExpresiónAgrupada);
                            ExpresiónAgrupada = "";
                            primerParentecisEncontrado = false;
                        } else {
                            contadorDeParentesisAnidados--;
                            ExpresiónAgrupada += c;
                        }
                        break;
                    default:
                        if (primerParentecisEncontrado) {
                            ExpresiónAgrupada += c;
                        } else {
                            expresiónSinAgrupadores += c;
                        }
                }

            }
            expresión = expresiónSinAgrupadores;
        }
        /**
         * Después de desagrupar los términos, si queda -- es una multiplicación
         * de signos
         */
        expresión = expresión.replace("--", "+");
        return expresión;
    }

    public String EfectuarOperacionesBinarias(String expresión) {
        if (expresión.contains("E-")) {
            expresión = expresión.replace("E-", "*0*");
        }
        /**
         * De aquí para abajo están las expresiones básicas, suma, resta,
         * multiplicación, división y potencia, las operaciones binarias
         */
        String[] terminos = expresión.split("\\+|-");//Los signos + o - separan a un termino de otro

        for (int i = 0; i < terminos.length; i++) {//Ciclo que recorre todos los terminos, en busca de sus factores

            String factores[] = terminos[i].split("\\*|/");//los signos * o / separan a los factores unos de otros.

            if (factores.length > 1) {// si hay más de un factor

                for (int j = 0; j < factores.length; j++) {//Aqui se van a romper las potencias
                    String factor = factores[j];
                    if (factor.contains("^")) {//Primero hay que evaluar las potencias antes que evaluar los factores
                        String Base = factor.split("\\^")[0];
                        String Exp = factor.split("\\^")[1];
                        factores[j] = poten(ConvertirANúmero(Base), ConvertirANúmero(Exp)) + "";
                        //Todos los términos que tengan potencias quedan reducidos a una expresión simple.
                    }
                }

                ArrayList<Integer> exponente = new ArrayList<>();
                /**
                 * Está es la memoria de cada operación en su respectivo orden,
                 * se aprovecha la identidad de la división donde se permite
                 * expresar como una potencia
                 */
                double nuevoTérmino = 1;
                //El primer factor tiene que ser 1, porque al multiplicar el 1 no altera
                exponente.add(1);
                //Ademas el 1, puede ir multiplicando o dividiendo
                //así que el primer exponente puede ser 1 o -1

                for (char c : terminos[i].toCharArray()) {
                    //Ciclo para recorrer todo el término en busca de * o /
                    if (c == '*') {//Multiplicación encontrada
                        exponente.add(1);//Exponente positivo
                    }
                    if (c == '/') {//División encontrada
                        exponente.add(-1);//Exponente negativo
                    }
                }//La busqueda del orden de * o / finalizó

                for (int j = 0; j < factores.length; j++) {
                    //Generar un unico término a base de muchos factores
                    nuevoTérmino *= poten(ConvertirANúmero(factores[j]), exponente.get(j));
                }
                terminos[i] = nuevoTérmino + "";//Se le asigna el valor encontrado al término

            } else if (terminos[i].contains("^")) {
                //Aquí únicamente entra si el término consta de un solo factor y ese factor tiene potencia
                String Base = terminos[i].split("\\^")[0];
                String Exp = terminos[i].split("\\^")[1];
                terminos[i] = poten(ConvertirANúmero(Base), ConvertirANúmero(Exp)) + "";
            }
        }

        double resultado = 0;
        //El resultado serán las sumas de todos los términos
        //empieza en 0 poque el 0 no altera el resultado en la suma

        ArrayList<Integer> Signo = new ArrayList<>();
        Signo.add(1);
        /**
         * Empieza en 1 porque el primer término sera positivo, cuando el primer
         * término empieza con "-" se le antecederá un 0 para que siempre
         * empiece por un positivo
         */

        for (char c : expresión.toCharArray()) {
            //Este ciclo es para la memoria
            //del orden en que aparecen los signos a lo largo de la expresión
            if (c == '+') {
                Signo.add(1);//Positivo (Suma)
            }
            if (c == '-') {
                Signo.add(-1);//Negativo (Resta)
            }
        }
        for (int i = 0; i < terminos.length; i++) {
            //Ciclo para acumular las sumas
            if (terminos[i].equals("")) {//Esto es para corregir cuando la expresión empieza por "-"
                terminos[i] = 0 + "";
                //Aqui es donde nos aseguramos que la expresión siempre empiece por un positivo
            }
            if (terminos[i].contains("*")) {
                resultado += ConvertirANúmero(terminos[i].replace("*", "")) * Signo.get(i) * ConvertirANúmero(terminos[i + 1]) * Signo.get(i + 1);
                i++;
            } else if (terminos[i].contains("/")) {
                resultado += ConvertirANúmero(terminos[i].replace("/", "")) * Signo.get(i) / (ConvertirANúmero(terminos[i + 1]) * Signo.get(i + 1));
                i++;
            } else {
                resultado += ConvertirANúmero(terminos[i]) * Signo.get(i);
            }
            //Aquí es donde se van a acumular las sumas
        }
        return recortarDecimales(resultado);
    }

    /**
     * Busca estructuras de literales que coincidan con las variables que han
     * sido declaradas y las reemplaza por su valor numérico.
     *
     * @param expresión
     * @return
     */
    public String reemplazarVariablesPorNumeros(String expresión) {
        for (Variable variable1 : variable) {
            expresión = expresión.replace(variable1.nombre, variable1.valor);
        }
        return expresión;
    }

    public ArrayList<String> Funciones() {
        ArrayList<String> Funciones = new ArrayList<>();
        Funciones.add("ACos");
        Funciones.add("ASen");
        Funciones.add("ATan");
        Funciones.add("Cos");
        Funciones.add("Cosh");
        Funciones.add("Cos^2");
        Funciones.add("Cos2");
        Funciones.add("Cos^3");
        Funciones.add("Cos3");
        Funciones.add("Cos^4");
        Funciones.add("Cos4");
        Funciones.add("Sen");
        Funciones.add("Senh");
        Funciones.add("Sen^2");
        Funciones.add("Sen^3");
        Funciones.add("Sen^4");
        Funciones.add("Sen2");
        Funciones.add("Sen3");
        Funciones.add("Sen4");
        Funciones.add("Sec");
        Funciones.add("Sech");
        Funciones.add("Csc");
        Funciones.add("Csch");
        Funciones.add("Tan");
        Funciones.add("Tanh");
        Funciones.add("Cot");
        Funciones.add("Coth");
        Funciones.add("Floor");
        Funciones.add("Piso");
        Funciones.add("Ln");
        Funciones.add("Rdnd");
        Funciones.add("Poten");
        Funciones.add("Poten^2");
        Funciones.add("Poten^3");
        Funciones.add("Poten^4");
        Funciones.add("Poten2");
        Funciones.add("Poten3");
        Funciones.add("Poten4");
        Funciones.add("Raiz");
        Funciones.add("RaizCuadrada");
        Funciones.add("Raiz2");
        Funciones.add("RaizCubica");
        Funciones.add("Raiz3");
        Funciones.add("RaizCuarta");
        Funciones.add("Raiz4");
        return Funciones;
    }

    public ArrayList<String> Literales() {
        ArrayList<String> literales = new ArrayList<>();
        char c = 'A';
        while (c <= 'Z') {
            literales.add(c + "");
            c++;
        }
        c = 'a';
        while (c <= 'z') {
            literales.add(c + "");
            c++;
        }
        literales.add("π");
        literales.add("Φ");
        literales.add("φ");
        return literales;
    }

    public class Variable {

        String nombre;
        String valor;
        Compilador c;

        public Variable(String nombre, String valor, Compilador c) {
            this.nombre = nombre;
            this.valor = valor;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Variable{" + "nombre=" + nombre + ", valor=" + valor + '}';
        }

    }

}

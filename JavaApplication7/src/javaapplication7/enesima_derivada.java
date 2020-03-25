package javaapplication7;

import static java.lang.Math.*;

public class enesima_derivada {

    double resul, terce;
    
    double h = 0.001;

    double segunda(double x) {

        resul = (pow(x + h, 3) - 2 * (pow(x, 3)) + pow(x - h, 3)) * (1 / pow(h, 2));
        return  resul;
    }

    double tercera(double y) {
        terce = (-pow(y - 2 * h, 4) + 2 * pow(y - h, 4) - 2 * pow(y + h, 4) + pow(y + 2 * h, 4)) * (1 / (2*( pow(h, 3))));
        return  terce;

    }

}

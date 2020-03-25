package javaapplication7;

import static java.lang.Math.*;

public class JavaApplication7 {

    public static void main(String[] args) {
        enesima_derivada obj = new enesima_derivada();
        System.out.println(obj.segunda(Math.PI));
        System.out.println(obj.tercera(Math.PI));
        System.out.println(sin((Math.PI) / 2));

        array m =new array();
        System.out.println(m.arreglo());
    }

}

class array {

    double[] x;

    double[] arreglo() {
        x = new double[10];
        for(int i=0;i<10;i++){
            x[i]=random();
    }

        return x;
    }

}

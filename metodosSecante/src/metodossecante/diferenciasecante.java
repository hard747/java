/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodossecante;

import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 *
 * @author Luis
 */
public class diferenciasecante{
    
    static double d,x,h;
   
    public diferenciasecante(double x,double h) {
        this.x=x;
        this.h=h;
    }

    public static double getX() {
        return x;
    }


    public double getH() {
        return h;
    }

    
    
    public static double diferencia(double x,double y)
    {
        d=(x-y)/((pow(x,2)+sin(x)-5)-(pow(y,2)+sin(y)-5));//(evaluar(x)-evaluar(y));
        //d=((pow(x+h,2)+sin(x+h)-5)-(pow(x,2)+sin(x)-5))/h;
        //d=((pow(x+h,3)-sin(x+h))-(pow(x,3)-sin(x)))/h;
        return d;
}
    
}

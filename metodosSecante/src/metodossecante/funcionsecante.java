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
public class funcionsecante {
    static double z;

    public funcionsecante() {
    }

    public static double evaluar(double x)
    {   
        z=(pow(x,2)+sin(x)-5);
        //z=pow(x,3)-sin(x);
        return z;
    }
    
}


package evaluador_beta;

import org.nfunk.jep.JEP;


public class funcion {
    
    JEP j=new JEP();

    public funcion(String def) {
        j.addVariable("x",0);
        j.addStandardConstants();
        j.addStandardFunctions();
        j.parseExpression(def);
        if(j.hasError())
        {
            System.out.println(j.getErrorInfo());
        }
        
    }
    public double evaluar(double x){
        double r;
        j.addVariable("x",x);
        r=j.getValue();
         if(j.hasError())
        {
            System.out.println(j.getErrorInfo());
        }
     return r;    
    }
    
}


package clases;

public class computadora {
    //atributos
    double precio_1,precio_2,precio_3,precio_4,resultado,factor,res;int precio_5,cuanto;
    String tipo;
    //constructor
     public computadora(double precio_1 ,double precio_2,double precio_3,double factor)
     {  
         this.precio_1=precio_1;
         this.precio_2=precio_2;
         this.precio_3=precio_3;
         precio_4=0;
         this.factor=factor;
    }
    
     //metodo_precios
    public double precios(String tipo,int cuanto){
        
        if(tipo.equalsIgnoreCase("1.6 Mhz")){
            this.res = this.precio_1*factor;
            this.resultado = this.precio_1*(cuanto);
         
        }
        else if(tipo.equalsIgnoreCase("1.7 Mhz")){
             this.res = this.precio_2*factor;
             this.resultado = this.precio_2*(cuanto);
             this.precio_5 = cuanto;
          
        }
        else if(tipo.equalsIgnoreCase("1.8 Mhz")){
             this.res = this.precio_3*factor;   
             this.resultado = this.precio_3*(cuanto);
           
        }
        this.precio_4= precio_4 + resultado;
        return res;
    }
      //metodo_importe_total
    public double importe_total(){
      return precio_4;
    }
    //metodo_cantidad_computadoras
    public double cantidad(){
      return precio_5;
    }

}

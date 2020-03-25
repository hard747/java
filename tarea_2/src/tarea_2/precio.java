package tarea_2;

public class precio {
    
    public precio(){   
    }//constructor
    
    public double precios_pc(String tipo,int cuanto){
        
        
        if(tipo.equalsIgnoreCase("1.6 Mhz")){
            this.precio_1 = 1200*(cuanto)*1.19;
         
        }
        else if(tipo.equalsIgnoreCase("1.7 Mhz")){
             this.precio_1 = 1800*(cuanto)*1.19;
             this.precio_4 = cuanto;
          
        }
        else if(tipo.equalsIgnoreCase("1.8 Mhz")){
             this.precio_1 = 2140*(cuanto)*1.19;
           
        }
        this.precio_2=this.precio_2 + precio_1;
        return precio_1;
    }
        
    public double precios_laptop(String tipo,int cuanto){
        if(tipo.equalsIgnoreCase("1.6 Mhz")){
            this.precio_1 = 1200*(cuanto)*1.24;
           
        }
        else if(tipo.equalsIgnoreCase("1.7 Mhz")){
             this.precio_1 = 1800*(cuanto)*1.24;
           
        }
        else if(tipo.equalsIgnoreCase("1.8 Mhz")){
             this.precio_1 = 2140*(cuanto)*1.24;
          
        }  
        this.precio_3 = this.precio_3 + precio_1;
        return precio_1;
    }
    
    public double importe_total_PC(){
      return precio_2;
    }
    
    public double importe_total_portatiles(){
      return precio_3;
    }
    public double cantidad_pc_17(){
      return precio_4;
    }
    
     private double precio_1,precio_2=0,precio_3=0; int precio_4;
}
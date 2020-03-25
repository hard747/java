package prytriangulo;

public class Triangulo {

    double a;
    double b;
    double c;
    double sp;
    boolean k = true;
    private int h;
    private static int hs = 2;

    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        h=hs;
        hs++;
    }

    public Triangulo() {
        this.a = 1;
        this.b = 5;
        this.c = 7;
        h=1;
    }

    
    public void peri() {
        if ((Math.abs(b - c) < a) && (a < (b + c)) && (Math.abs(a - c) < b) && (b < (a + c)) && (Math.abs(a - b) < c) && (c < (a + b))) {

            this.a = a;
            this.b = b;
            this.c = c;
          sp = a + b + c;  
        }
        else{
            k = false;
            
        }
    }
   public void perimetro(){
            peri();
            if(k == true){
            System.out.println(sp); 
            }
        
        }
       
    public void area() {
        peri();
        double r = Math.sqrt((sp/2) * ((sp/2) - a) * ((sp/2) - b) * ((sp/2) - c));
        if(k == true){
        System.out.println(r); 
        }
    }
    public void verdad()
    {
        if(k == false)
        {
            System.out.println("el triangulo " + h + " no existe");
        }
     }
    

}

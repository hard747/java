package totallventadeeentradas;

import java.util.Scanner;

public class PrecioVenta {
    double[][] m=new double[3][3];
    double[] x=new double[3];
    String[] turno={"manana", "tarde", "noche"};
    String[] ubicacion={"platea", "preferencial", "vip"};
    String[] tipo={"teatro", "concierto", "otro"};
    String Teclado, Tecla, terminar ;
    
    public PrecioVenta(double a, double b, double c) {
        x[0] = a;
        x[1] = b;
        x[2] = c;
    }

    public void Turno() {
        System.out.println("Ingrese turno: \n Mañana \n Tarde \n Noche");
        Scanner ada = new Scanner(System.in);
        Teclado = ada.nextLine();
        if (Teclado.equals(turno[0])) {
            System.out.println(x[0]);
        } else if (Teclado.equals(turno[1])) {
            System.out.println(x[1]);
        } else if (Teclado.equals(turno[2])) {
            System.out.println(x[2]);
        }
    }

    public void ubicacion() {
        System.out.println("Ingrese Ubicación: \n Platea \n Preferencial  \n Vip");
        Scanner entrada = new Scanner(System.in);
        Tecla = entrada.nextLine();
        for(int i=0;i<=2;i++){    
        if (Teclado.equals(turno[i]) && Tecla.equals(ubicacion[0])) {
            m[i][0] = x[i];
            System.out.println(m[i][0]);
        } else if (Teclado.equals(turno[i]) && Tecla.equals(ubicacion[1])) {
            m[i][1] = (1.05) * x[i];
            System.out.println(m[i][1]);
        } else if (Teclado.equals(turno[i]) && Tecla.equals(ubicacion[2])) {
            m[i][2] = (1.10)*x[i];
            System.out.println(m[i][2]);
        }
        }
    }
    
    public void impuesto() 
        {
        System.out.println("Ingrese tipo de evento: \n teatro \n concierto  \n otro");
        Scanner entrada = new Scanner(System.in);
        terminar = entrada.nextLine();    
        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
            {
                if (Teclado.equals(turno[i]) && Tecla.equals(ubicacion[j]) && terminar.equals(tipo[0])) {
                double terma = (1.05)*m[i][j];
                System.out.println("el precio final es : " + terma);}
         
                else if (Teclado.equals(turno[i]) && Tecla.equals(ubicacion[j]) && terminar.equals(tipo[1])) {
                double termb = (1.08)*m[i][j];
                System.out.println("el precio final es : " + termb);}
                
                else if (Teclado.equals(turno[i]) && Tecla.equals(ubicacion[j]) && terminar.equals(tipo[2])) {
                double termc = (1.1)*m[i][j];
                System.out.println("el precio final es : " + termc); }
            }
        }
    }
}
        
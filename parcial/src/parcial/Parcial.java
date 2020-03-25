package parcial;

import java.util.ArrayList;
import java.util.Scanner;

public class Parcial {

    public static void main(String[] args) {
        System.out.println("Introduzca la cantidad de alumnos");
        Scanner sc = new Scanner(System.in);
        int cantidad = sc.nextInt();

        ArrayList<cleer> a = new ArrayList<cleer>();
        ArrayList<alumno> al = new ArrayList<alumno>();

        for (int i = 0; i < cantidad; i++) {
            a.add(new cleer());
            al.add(new alumno(a.get(i).cleer_orden(i), a.get(i).cleer_codigo(), a.get(i).cleer_apellido(), a.get(i).cleer_promedio()));
        }

        System.out.println("No \t Codigo \t Apellidos \t Promedio");

        for (int i = 0; i < cantidad; i++) {
            al.get(i).imprimir_arreglo();
        }

        //metodo burbuja para ordenar por promedio final       
        System.out.println("\nNo \t Codigo \t Apellidos \t Promedio");

        ArrayList<alumno> alu = new ArrayList<alumno>();

        for (int i = 0; i < cantidad; i++) {
            alu.add(new alumno(al.get(i).orden, al.get(i).codigo, al.get(i).apellido, al.get(i).promedio_final));
        }
//metodo burbuja
        for (int i = 0; i < cantidad; i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (al.get(i).promedio_final < al.get(j).promedio_final) {
                    double buffer = al.get(j).promedio_final;
                    al.get(j).promedio_final = al.get(i).promedio_final;
                    al.get(i).promedio_final = buffer;
                }
            }
        }
//impresion del registro ordenado
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                if (alu.get(j).promedio_final == al.get(i).promedio_final) {
                    alu.add(new alumno(al.get(j).orden, al.get(j).codigo, al.get(j).apellido, al.get(i).promedio_final));
                    alu.get(j).imprimir_arreglo();
                }
            }
        }

    }

}

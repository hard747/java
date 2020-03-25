/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metodossecante;

/**
 *
 * @author Luis
 */
public class MetodosSecante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        secante ventana = new secante();
        ventana.setVisible(true);
        diferenciasecante der = new diferenciasecante(-2,1e-1);
    }
    
}

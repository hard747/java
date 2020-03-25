/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometria2D;

import java.awt.Graphics;

public abstract class PoligonoPolar extends Poligono_Paramétrico {

    public boolean DetectarPuntoDentro(Dupla punto) {
        if (punto.Radio(this.Posición) < XY(punto.Ángulo(this.Posición)).Radio()) {
            return true;
        }
        return false;
    }
}

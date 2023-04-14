/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author alejandro
 */
public class Turismo extends Vehiculo {
    
    final private int TIPO = 0;

    public Turismo() {
    }

    @Override
    public String toString() {
        return this.TIPO + " - " + super.toString();
    }    
}

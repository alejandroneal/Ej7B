/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author alejandro
 */
public class Furgoneta extends Vehiculo {
     final private int TIPO = 2;

    public Furgoneta() {
    }
    
    @Override
    public String toString() {
        return this.TIPO + " - " + super.toString();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * Atributos: matrícula, marca, nombre, color
 */
public class Vehiculo {
    
    private String bastidor;
    private String matricula;
    private Marca marca;
    private String modelo;
    private Color color;
    private boolean disponible;
    private double tarifa;
    private final double [] tarifas = {2.5, 5, 7.5, 8.99, 10};

    public Vehiculo() {
        this.bastidor = RandomStringUtils.randomAlphanumeric(7).toUpperCase();
        this.matricula = RandomStringUtils.randomNumeric(4) 
                + RandomStringUtils.randomAlphabetic(3).toUpperCase();
        this.marca = marcaRandom();
        this.modelo = modeloRandom();
        this.color = colorRandom();
        if (new Random().nextInt(0, 2) == 0) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }
        this.tarifa = tarifas[new Random().nextInt(0, tarifas.length)];
    }

    public String getMatricula() {
        return matricula;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Color getColor() {
        return color;
    }

    public String getBastidor() {
        return bastidor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getTarifa() {
        return tarifa;
    }

    @Override
    public String toString() {
        return bastidor + ":" + matricula + ":" + marca + ":" + modelo + ":" + color + ":" + disponible + ":" + tarifa;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
    
    //Randomizar la marca
    private Marca marcaRandom(){
        //Lista de marcas de coche
        List<Marca> marcas = new ArrayList<>();
        marcas.add(Marca.SEAT);
        marcas.add(Marca.TOYOTA);
        marcas.add(Marca.FORD);
        marcas.add(Marca.AUDI);
        marcas.add(Marca.CUPRA);
        
        return marcas.get(new Random().nextInt(0, 5));
    }
    
    //Randomizar modelos según la marca
    private  String modeloRandom(){
        
        //Lista de modelos de SEAT
        List<String> modelosSeat = new ArrayList<>();
        modelosSeat.add("Mii");
        modelosSeat.add("Arona");
        modelosSeat.add("Ibiza");
        modelosSeat.add("León");
        
        //Lista de modelos de AUDI
        List<String> modelosAudi = new ArrayList<>();
        modelosAudi.add("A3");
        modelosAudi.add("A4");
        modelosAudi.add("TT");
        modelosAudi.add("Q5");
        
        //Lista de modelos de CUPRA
        List<String> modelosCupra = new ArrayList<>();
        modelosCupra.add("Formentor");
        modelosCupra.add("Born");
        modelosCupra.add("León");
        modelosCupra.add("Ateca");
        
        //Lista de modelos de FORD
        List<String> modelosFord = new ArrayList<>();
        modelosFord.add("Mustang");
        modelosFord.add("Focus");
        modelosFord.add("Fiesta");
        modelosFord.add("Kuga");
        
        //Lista de modelos de TOYOTA
        List<String> modelosToyota = new ArrayList<>();
        modelosToyota.add("Yaris");
        modelosToyota.add("Corolla");
        modelosToyota.add("Camry");
        modelosToyota.add("Land Cruiser");
        
        switch (this.marca) {
            case AUDI:
                return modelosAudi.get(new Random().nextInt(0, 4));
            case CUPRA:
                return modelosCupra.get(new Random().nextInt(0, 4));
            case FORD:
                return modelosFord.get(new Random().nextInt(0, 4));
            case SEAT:
                return modelosSeat.get(new Random().nextInt(0, 4));
            default:
                return modelosToyota.get(new Random().nextInt(0, 4));
        }
    }
    
    private Color colorRandom(){
        //Lista de colores
        List<Color> colores = new ArrayList<>();
        colores.add(Color.AZUL);
        colores.add(Color.BLANCO);
        colores.add(Color.NEGRO);
        colores.add(Color.ROJO);
        colores.add(Color.VERDE);
        
        return colores.get(new Random().nextInt(0, 5));
    }
}

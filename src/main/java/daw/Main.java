/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alejandro
 */
public class Main {

    public static void main(String[] args) {
        
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        //Añado 10 vehículos de turismo
        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Turismo());
        }
        //Añado 10 vehículos deportivos
        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Deportivo());
        }
        //Añado 10 vehículos furgonetas
        for (int i = 0; i < 10; i++) {
            listaVehiculos.add(new Furgoneta());
        }
        //Muestro la lista por pantalla
        listaVehiculos.forEach(System.out::println);
        
        escribirListaEnFichero(listaVehiculos);
    }
    
    //Guardar la lista en un fichero llamado "vehículos.txt"
    public static void escribirListaEnFichero(List<Vehiculo> lista){
        List<String> aux = new ArrayList<>();
        for (Object object : lista) {
            aux.add(object.toString());
        }
        
        try {
            Files.write(Paths.get("vehículos.txt"), aux, StandardCharsets.UTF_8, 
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error creando fichero");
        }
    }
    
    //usar split con los :
}

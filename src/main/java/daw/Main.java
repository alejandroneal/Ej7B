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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import static javax.management.Query.lt;

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

        System.out.println("\n============================================================");
        System.out.println("Lista sacada del fichero vehículos.txt");
        List<Vehiculo> listaVehiculos2 = leerFicheroVehiculo();
        
        //Obtener el nº de cocher de color rojo
        Predicate<Vehiculo> criterioColor = (v)->v.getColor().equals(Color.ROJO);
        long contador = 0;
        contador = listaVehiculos2.stream()
                .filter(criterioColor)
                .count();
        System.out.println("Nº de vehículos rojos: " + contador);
        
        System.out.println("\n============================================================");
        System.out.println("Tipos de marcas:");
        listaVehiculos2.stream()
                .map(v->v.getMarca()) //mapeo de las marcas
                .distinct() //solo muestran las diferentes (no se repiten)
                .forEach(System.out::println); //mostrar por pantalla
        
        System.out.println("\n============================================================");
        System.out.println("Lista ordenada por marcas:");
        Comparator<Vehiculo> criterioMarca = (v1,v2)->v1.getMarca().compareTo(v2.getMarca());
        Collections.sort(listaVehiculos2, criterioMarca);
        listaVehiculos2.forEach(System.out::println);

        ficheroDeCadaTipoVehiculo();
    }

    //Guardar la lista en un fichero llamado "vehículos.txt"
    public static void escribirListaEnFichero(List<Vehiculo> lista) {
        List<String> aux = new ArrayList<>();
        //Metemos cada objeto de la lista de Vehiculo en la lista de String gracias al toString()
        for (Object object : lista) {
            aux.add(object.toString());
        }

        //Escribimos línea a línea las cadenas de la lista aux en el fichero vehículos.txt
        try {
            Files.write(Paths.get("vehículos.txt"), aux, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error creando fichero");
        }
    }

    //Lectura del fichero vehículo.txt
    public static List<Vehiculo> leerFicheroVehiculo() {
        List<String> aux = new ArrayList<>();
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        try {
            aux = Files.readAllLines(Paths.get("vehículos.txt"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error leyendo el fichero");
        }

        for (String string : aux) {
            //Filtramos gracias al primer caracter de cada cadena que tipo de vehículo es
            switch (string.substring(0, 1)) {
                case "0": //Turismo
                {
                    //Recortamos de la cadena la primera parte que indica el tipo de vehículo
                    String recortado = string.substring(4);
                    //Con la función split separamos la cadena anterior en subcadenas, usando como divisor :
                    String[] arraySplit = recortado.split(":");

                    //Introducimos los datos del array en un vehículo Turismo
                    Vehiculo auxVehiculo = new Turismo();
                    auxVehiculo.setMatricula(arraySplit[0]);
                    switch (arraySplit[1]) {
                        case "SEAT":
                            auxVehiculo.setMarca(Marca.SEAT);
                            break;
                        case "FORD":
                            auxVehiculo.setMarca(Marca.FORD);
                            break;
                        case "TOYOTA":
                            auxVehiculo.setMarca(Marca.TOYOTA);
                            break;
                        case "AUDI":
                            auxVehiculo.setMarca(Marca.AUDI);
                            break;
                        case "CUPRA":
                            auxVehiculo.setMarca(Marca.CUPRA);
                            break;
                    }
                    auxVehiculo.setModelo(arraySplit[2]);
                    switch (arraySplit[3]) {
                        case "ROJO":
                            auxVehiculo.setColor(Color.ROJO);
                            break;
                        case "AZUL":
                            auxVehiculo.setColor(Color.AZUL);
                            break;
                        case "NEGRO":
                            auxVehiculo.setColor(Color.NEGRO);
                            break;
                        case "BLANCO":
                            auxVehiculo.setColor(Color.BLANCO);
                            break;
                        case "VERDE":
                            auxVehiculo.setColor(Color.VERDE);
                            break;
                    }
                    //Añadimos el vehículo Turísmo en la lista de Vehiculo
                    listaVehiculos.add(auxVehiculo);

                    break;
                }
                case "1": //Deportivo
                {
                    //Recortamos de la cadena la primera parte que indica el tipo de vehículo
                    String recortado = string.substring(4);
                    //Con la función split separamos la cadena anterior en subcadenas, usando como divisor :
                    String[] arraySplit = recortado.split(":");

                    //Introducimos los datos del array en un vehículo Deportivo
                    Vehiculo auxVehiculo = new Deportivo();
                    auxVehiculo.setMatricula(arraySplit[0]);
                    switch (arraySplit[1]) {
                        case "SEAT":
                            auxVehiculo.setMarca(Marca.SEAT);
                            break;
                        case "FORD":
                            auxVehiculo.setMarca(Marca.FORD);
                            break;
                        case "TOYOTA":
                            auxVehiculo.setMarca(Marca.TOYOTA);
                            break;
                        case "AUDI":
                            auxVehiculo.setMarca(Marca.AUDI);
                            break;
                        case "CUPRA":
                            auxVehiculo.setMarca(Marca.CUPRA);
                            break;
                    }
                    auxVehiculo.setModelo(arraySplit[2]);
                    switch (arraySplit[3]) {
                        case "ROJO":
                            auxVehiculo.setColor(Color.ROJO);
                            break;
                        case "AZUL":
                            auxVehiculo.setColor(Color.AZUL);
                            break;
                        case "NEGRO":
                            auxVehiculo.setColor(Color.NEGRO);
                            break;
                        case "BLANCO":
                            auxVehiculo.setColor(Color.BLANCO);
                            break;
                        case "VERDE":
                            auxVehiculo.setColor(Color.VERDE);
                            break;
                    }
                    //Añadimos el vehículo Deportivo en la lista de Vehiculo
                    listaVehiculos.add(auxVehiculo);

                    break;
                }
                case "2": //Furgoneta
                {
                    //Recortamos de la cadena la primera parte que indica el tipo de vehículo
                    String recortado = string.substring(4);
                    //Con la función split separamos la cadena anterior en subcadenas, usando como divisor :
                    String[] arraySplit = recortado.split(":");

                    //Introducimos los datos del array en un vehículo Furgoneta
                    Vehiculo auxVehiculo = new Furgoneta();
                    auxVehiculo.setMatricula(arraySplit[0]);
                    switch (arraySplit[1]) {
                        case "SEAT":
                            auxVehiculo.setMarca(Marca.SEAT);
                            break;
                        case "FORD":
                            auxVehiculo.setMarca(Marca.FORD);
                            break;
                        case "TOYOTA":
                            auxVehiculo.setMarca(Marca.TOYOTA);
                            break;
                        case "AUDI":
                            auxVehiculo.setMarca(Marca.AUDI);
                            break;
                        case "CUPRA":
                            auxVehiculo.setMarca(Marca.CUPRA);
                            break;
                    }
                    auxVehiculo.setModelo(arraySplit[2]);
                    switch (arraySplit[3]) {
                        case "ROJO":
                            auxVehiculo.setColor(Color.ROJO);
                            break;
                        case "AZUL":
                            auxVehiculo.setColor(Color.AZUL);
                            break;
                        case "NEGRO":
                            auxVehiculo.setColor(Color.NEGRO);
                            break;
                        case "BLANCO":
                            auxVehiculo.setColor(Color.BLANCO);
                            break;
                        case "VERDE":
                            auxVehiculo.setColor(Color.VERDE);
                            break;
                    }
                    //Añadimos el vehículo Furgoneta en la lista de Vehiculo
                    listaVehiculos.add(auxVehiculo);

                    break;
                }

            }
        }
        return listaVehiculos;
    }

    //A partir del fichero vehículos.txt, crear tres archivos para almacenar vehículos del mismo tipo
    public static void ficheroDeCadaTipoVehiculo() {
        List<String> principal = new ArrayList<>();
        List<String> turismo = new ArrayList<>();
        List<String> deportivos = new ArrayList<>();
        List<String> furgonetas = new ArrayList<>();

        // Leemos el fichero vehículos.txt y metemos cada línea en la lista principal
        try {
            principal = Files.readAllLines(Paths.get("vehículos.txt"), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println("Error leyendo el fichero");
        }

        for (String string : principal) {
            //Filtro para saber de que tipo es cada vehículo
            switch (string.substring(0, 1)) {
                //Al usar substring de 0 a 1 solo coge el primer caracter de la cadena que sirve de identificador
                //de cada tipo de vehículo
                //Añadimos cada vehículo de un tipo en su lista correspondiente
                case "0": //Turismo
                    turismo.add(string);
                    break;
                case "1": //Deportivo
                    deportivos.add(string);
                break;
                case "2": //Furgoneta
                    furgonetas.add(string);
                break;
            }
        }

        //Escribimos en cada fichero
        //Fichero turismo.txt
        try {
            Files.write(Paths.get("turísmo.txt"), turismo, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error creando el fichero");
        }
        
        //Fichero deportivos.txt
        try {
            Files.write(Paths.get("deportivos.txt"), deportivos, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error creando el fichero");
        }
        
        //Fichero furgonetas.txt
        try {
            Files.write(Paths.get("furgonetas.txt"), furgonetas, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error creando el fichero");
        }
    }
}

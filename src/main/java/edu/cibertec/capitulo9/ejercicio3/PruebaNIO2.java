package edu.cibertec.capitulo9.ejercicio3;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class PruebaNIO2 {

    public static void main(String[] args) {
        File directorio = new File("src/main/resources");
        Path path = Paths.get(directorio.toString(), "propiedades.properties");

        // OBTENIENDO INFORMACION DEL ARCHIVO
        System.out.println("Nombre = " + path.getFileName());
        System.out.println("Primera carpeta = " + path.getName(0));
        System.out.println("Número de nombres = " + path.getNameCount());
        System.out.println("Ruta completa = " + path.toAbsolutePath());

        // TRABAJAR CON CLASE FILES
        try {
            System.out.println("---- INFORMACIÓN DEL ARCHIVO ----");
            Map<String, Object> atributos = Files.readAttributes(path, "*");
            atributos.forEach((k, v)
                    -> System.out.println("Llave: " + k + ": Value: " + v));

            // MOSTRAR LOS ARCHIVOS DE LA CARPETA
            System.out.println("---- ARCHIVOS DE LA CARPETA ----");
            try (Stream<Path> stream = Files.list(directorio.toPath())) {
                stream.map(String::valueOf)
                        .forEach(System.out::println);
            }

            // COPIAR UN ARCHIVO Y LEERLO
            System.out.println("---- COPIA Y MUESTRA ----");
            Path pathCopia = Paths.get(directorio.toString(), "nuevo.properties");
            Files.copy(path, pathCopia);
            try (Stream<String> stream = Files.lines(pathCopia)) {
                stream.map(String::toLowerCase).forEach(System.out::println);
            }
            
            //ELIMINAR EL ARCHIVO NUEVO
            Files.delete(pathCopia);
            System.out.println("Se eliminó el archivo creado!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

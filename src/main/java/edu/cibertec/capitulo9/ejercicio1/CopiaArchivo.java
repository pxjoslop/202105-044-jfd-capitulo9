package edu.cibertec.capitulo9.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopiaArchivo {

    public static void main(String[] args) {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File directorio = new File("src/main/resources");
            fileReader = new FileReader(directorio + "/propiedades.properties");
            fileWriter = new FileWriter(directorio + "/copia.properties");

            BufferedReader br = new BufferedReader(fileReader);

            String linea;
            while ((linea = br.readLine()) != null) {
                fileWriter.write(linea+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

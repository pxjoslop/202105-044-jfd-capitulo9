package edu.cibertec.capitulo9.ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CreaArchivo {

    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        try {
            File directorio = new File("src/main/resources");
            // CREAMOS EL ARCHIVO
            oos = new ObjectOutputStream(
                    new FileOutputStream(directorio+"/Producto1.dat"));
            Producto uno = new Producto(1, "Arroz integral", 15.25);
            oos.writeObject(uno);
            
            // LEEMOS EL ARCHIVO
            ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(directorio+"/Producto1.dat"));
            Producto dos = (Producto)ois.readObject();
            System.out.println(dos);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}

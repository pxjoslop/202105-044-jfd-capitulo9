package edu.cibertec.capitulo9.ejercicio1;

import java.io.File;
import java.io.RandomAccessFile;

public class ModificaArchivo {

    static RandomAccessFile archivo = null;

    public static void main(String[] args) {
        try {
            File directorio = new File("src/main/resources");
            archivo = new RandomAccessFile(directorio
                    + "/propiedades.properties", "rw");
            muestraArchivo();
            archivo.seek(archivo.length());
            archivo.writeUTF("version = 3.2");
            muestraArchivo();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                archivo.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    static void muestraArchivo() {
        try {
            archivo.seek(0);
            while (archivo.read() != -1) {
                System.out.println(archivo.readLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

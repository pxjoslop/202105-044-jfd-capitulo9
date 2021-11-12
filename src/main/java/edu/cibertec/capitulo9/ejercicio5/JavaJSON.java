package edu.cibertec.capitulo9.ejercicio5;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cibertec.capitulo9.ejercicio4.Producto;
import java.io.File;

public class JavaJSON {

    public static void main(String[] args) {
        
        try {
            File directorio = new File("src/main/resources");
            File archivo = new File(directorio+"/empleado.json");
            
            ObjectMapper mapper = new ObjectMapper();
            
            Producto p = mapper.readValue(archivo, Producto.class);
            System.out.println(p);
            System.out.println("Con formato: "+
                    mapper.writerWithDefaultPrettyPrinter().
                            writeValueAsString(p));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

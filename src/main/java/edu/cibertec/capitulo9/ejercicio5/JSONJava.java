package edu.cibertec.capitulo9.ejercicio5;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cibertec.capitulo9.ejercicio4.Producto;
import java.io.File;

public class JSONJava {

    public static void main(String[] args) {
        try {
            Producto p = new Producto(5, "Plumones rojos", 5.98);
            
            ObjectMapper mapper = new ObjectMapper();
            File directorio = new File("src/main/resources");
            File archivo = new File(directorio+"/empleado.json");
            
            mapper.writeValue(archivo, p);
            
            String json = mapper.writerWithDefaultPrettyPrinter().
                    writeValueAsString(p);

            System.out.println(json);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

package edu.cibertec.capitulo9.ejercicio4;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JavaConXML {
    public static void main(String[] args) {
        File directorio = new File("src/main/resources");
        File archivo = new File(directorio+"/empleado.xml");
        
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Producto.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Producto producto = (Producto) jaxbUnmarshaller.unmarshal(archivo);
             
            System.out.println(producto);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}

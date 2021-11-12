package edu.cibertec.capitulo9.ejercicio4;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XMLconJava {

    public static void main(String[] args) {
        
        Producto producto = new Producto(1, "Arroz integral", 15.36);
        ObjectoaXML(producto);
    }

    private static void ObjectoaXML(Producto producto)
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Producto.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
            //Poniendo formato a la salida
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, 
                    Boolean.TRUE);
 
            //Enviar el XML a archivo
            File directorio = new File("src/main/resources");
            File archivo = new File(directorio+"/empleado.xml");
            jaxbMarshaller.marshal(producto, archivo);
 
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

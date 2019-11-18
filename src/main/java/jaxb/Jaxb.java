package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb {

    public static <T> T parseXmlFile(String path, Class<T> className) {
        try {
            JAXBContext jc = JAXBContext.newInstance(className);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void serializeToXmlFile(T data, String fileName) {
        try {
            JAXBContext jc = JAXBContext.newInstance(data.getClass());
            javax.xml.bind.Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(data, new File("./src/main/resources/" + fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}

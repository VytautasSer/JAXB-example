package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Marshaller {

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

}

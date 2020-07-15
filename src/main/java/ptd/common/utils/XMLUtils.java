package ptd.common.utils;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileOutputStream;

public class XMLUtils {

    public static Object toObject(Object obj, String filePath) throws Exception {
        File file = new File(filePath);
        JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
        return jaxbContext.createUnmarshaller().unmarshal(file);
    }

    public static void toXML(Object obj, String filePath) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(obj.getClass());
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(obj, new FileOutputStream(filePath));
    }
}

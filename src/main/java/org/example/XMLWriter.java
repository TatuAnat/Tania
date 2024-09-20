package org.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLWriter {

    public static void writeToXml(Object object, String directory) throws Exception {

        JAXBContext context = JAXBContext.newInstance(object.getClass());
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String fileName = directory + "/req_" + new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()) + ".xml";

        File file = new File(fileName);

        file.getParentFile().mkdirs();

        marshaller.marshal(object,file);

        System.out.println("Xml written to: " + fileName);

    }

}

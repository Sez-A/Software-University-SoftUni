package exam.util.impl;

import exam.util.XmlParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XmlParserImpl implements XmlParser {
    private JAXBContext jaxbContext;

    @Override
    public <E> E fromFile(String filePath, Class<E> eClass) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(eClass);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new File(filePath));

    }
}

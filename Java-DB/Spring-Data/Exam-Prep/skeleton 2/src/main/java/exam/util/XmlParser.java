package exam.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {
    <E> E fromFile(String filePath, Class<E> eClass) throws JAXBException;
}

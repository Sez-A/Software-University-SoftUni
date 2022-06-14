package com.example.xmlprocessingexercises.util.impl;

import com.example.xmlprocessingexercises.util.XMLParser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XMLParserImpl implements XMLParser {
    private JAXBContext jaxbContext;


    @Override
    @SuppressWarnings("unchecked")
    public <E> E fromFile(String filePath, Class<E> eClass) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(eClass);
        Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new File(filePath));
    }

    @Override
    public <E> void writeToFile(String filePath, E entity) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(entity.getClass());
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(entity, new File(filePath));
    }
}

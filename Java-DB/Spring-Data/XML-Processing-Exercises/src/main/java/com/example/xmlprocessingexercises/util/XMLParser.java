package com.example.xmlprocessingexercises.util;

import javax.xml.bind.JAXBException;

public interface XMLParser {
    <E> E fromFile(String filePath, Class<E> eClass) throws JAXBException;

    <E> void writeToFile(String filePath, E entity) throws JAXBException;
}

package com.example.mongodbex1.util;

import org.modelmapper.AbstractConverter;

public class ModelMapperConvertor extends AbstractConverter<String, String>{

    @Override
    protected String convert(String source) {
        return source!=null ? source.toUpperCase():null;
    }
    
}

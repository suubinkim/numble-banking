package com.numble.banking.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class CryptoConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return Seed.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return Seed.decrypt(dbData);
    }
}

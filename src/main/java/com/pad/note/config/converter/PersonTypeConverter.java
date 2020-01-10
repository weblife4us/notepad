package com.pad.note.config.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import static com.pad.note.entity.Clients.Type;

@Converter(autoApply = true)
public class PersonTypeConverter implements AttributeConverter<Type, String> {
    @Override
    public String convertToDatabaseColumn(Type type) {
        return type.getTitle();
    }

    @Override
    public Type convertToEntityAttribute(String s) {
        return Type.getByTitle(s);
    }
}

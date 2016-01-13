package com.birivarmi.birivarmiapp.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.birivarmi.birivarmiapp.model.MetaFieldType;

@Converter(autoApply = true)
public class MetaFieldTypeConverter implements AttributeConverter<MetaFieldType, String> {
	
	@Override
    public String convertToDatabaseColumn(MetaFieldType metaFieldType) {
        return metaFieldType.getType();
    }

    @Override
    public MetaFieldType convertToEntityAttribute(String dbData) {
        for (MetaFieldType metaFieldType : MetaFieldType.values()) {
            if (metaFieldType.getType().equals(dbData)) {
                return metaFieldType;
            }
        }

        throw new IllegalArgumentException("Unknown database value:" + dbData);
    }

}

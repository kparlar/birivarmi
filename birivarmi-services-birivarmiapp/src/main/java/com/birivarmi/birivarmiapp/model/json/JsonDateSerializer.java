package com.birivarmi.birivarmiapp.model.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonDateSerializer extends JsonSerializer<Date> {

	private final static String JSON_DATE_FORMAT = "MM-dd-yyyy";
	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(JsonDateSerializer.JSON_DATE_FORMAT);
		String formattedDate = dateFormat.format(date);
		jsonGenerator.writeString(formattedDate);
		
	}

}

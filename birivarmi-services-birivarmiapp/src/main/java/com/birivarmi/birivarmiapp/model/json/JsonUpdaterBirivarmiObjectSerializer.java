package com.birivarmi.birivarmiapp.model.json;

import java.io.IOException;

import com.birivarmi.birivarmiapp.model.BirivarmiObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonUpdaterBirivarmiObjectSerializer extends JsonSerializer<Object> {

	
	@Override
	public void serialize(Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		BirivarmiObject birivarmiObject = (BirivarmiObject) object;
		String formattedDate = String.format("UpdaterId: %d; Type: %s", birivarmiObject.getId(), birivarmiObject.getType());
		jsonGenerator.writeString(formattedDate);
		
	}
}

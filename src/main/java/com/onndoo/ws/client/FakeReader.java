package com.onndoo.ws.client;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;


@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class FakeReader implements MessageBodyReader<Object> {

	private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Fake.class.isAssignableFrom(type) || List.class.isAssignableFrom(type);
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations,
                           MediaType mediaType, MultivaluedMap<String, String> httpHeaders,
                           InputStream entityStream) throws IOException {
        if (List.class.isAssignableFrom(type)) {
            // Si el tipo es una lista, deserializa como List<Fake>
            return objectMapper.readValue(entityStream, objectMapper.getTypeFactory().constructCollectionType(List.class, Fake.class));
        } else {
            // Si no, deserializa como un solo objeto Fake
            return objectMapper.readValue(entityStream, Fake.class);
        }
    }
    
}
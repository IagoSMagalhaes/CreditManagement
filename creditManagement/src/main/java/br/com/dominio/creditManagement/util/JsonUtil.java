package br.com.dominio.creditManagement.util;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
/**
 * Created by iago.magalhaes on 01/05/2019.
 * Utility class Json responsible for convert Json to Object and Object to Json
 */
public class JsonUtil {

    public static String convertToJson(final Object object) throws IOException {

        final ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);

        final SimpleModule module = new SimpleModule();
        mapper.registerModule(module);

        return mapper.writeValueAsString(object);
    }

    public static <T> T convertToObject(final String json, final Class<T> clazz) throws IOException {

    	final ObjectMapper mapper = new ObjectMapper();

        final SimpleModule module = new SimpleModule();
        mapper.registerModule(module);

        return mapper.readValue(json, clazz);
    }

    public static <T> T convertToListObject(final String json, final TypeReference<T> typeReference) throws IOException {

    	final ObjectMapper mapper = new ObjectMapper();

        final SimpleModule module = new SimpleModule();
        mapper.registerModule(module);

        final T objects = mapper.readValue(json, typeReference);

        return objects;
    }

    
    
}

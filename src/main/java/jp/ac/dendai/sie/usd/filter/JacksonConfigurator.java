package jp.ac.dendai.sie.usd.filter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider

public class JacksonConfigurator implements ContextResolver<ObjectMapper> {
    private final ObjectMapper defaultObjectMapper;

    public JacksonConfigurator() {
        defaultObjectMapper = createDefaultMapper();
    }
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper() {
        final ObjectMapper mapper = new ObjectMapper();
//        mappers.findAndRegisterModules();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper;
    }
}

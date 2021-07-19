package org.aibless.backendjava.studentservice.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    public interface ModelMapperFactory {
        ModelMapper getMapper();
    }

    private ModelMapperFactory modelMapperFactory() {
        return () -> {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return mapper;
        };
    }
    @Bean
    public MappingHelper mappingHelper() {
        return new MappingHelper(modelMapperFactory());
    }
}

package com.sellphones.configuration;

import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@ConfigurationProperties(prefix = "spring.backend")
public class ApplicationConfiguration {

    private String url;

    @Bean
    public ModelMapper modelMapper(
        PromotionToAdminPromotionResponsePropertyMap promotionToAdminPromotionResponse
    ){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new ReviewToReviewResponsePropertyMap(url));
        modelMapper.addConverter(new FilterOptionToAdminFilterOptionResponseConverter());
        modelMapper.addMappings(promotionToAdminPromotionResponse);
        return modelMapper;
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
//        return builder -> builder
//                .modules(new JavaTimeModule(), new Jdk8Module(), new ParameterNamesModule());
//    }
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule()); // hỗ trợ LocalDate, LocalDateTime, ...
//        mapper.registerModule(new Jdk8Module());
//        mapper.registerModule(new ParameterNamesModule());
//        return mapper;
//    }

}

package com.mlfc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建一个 ObjectMapper 对象，用于 JSON 数据的序列化和反序列化
        ObjectMapper objectMapper = new ObjectMapper();

        // 注册 JavaTime 模块，以便正确处理 Java 8 时间类型（如 LocalDateTime）
        objectMapper.registerModule(new JavaTimeModule());

        // 禁用将日期序列化为时间戳的功能，而是以字符串形式进行序列化
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        // 创建一个 MappingJackson2HttpMessageConverter 对象，并设置之前创建的 ObjectMapper
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);

        // 将这个转换器添加到传入的 converters 列表中，以便在 Spring MVC 中使用
        converters.add(converter);
    }

}

package com.self.libraries.restxml.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "self.libraries.test")
public class DummyProperties {

    private String prop1;
    private String prop2;
}

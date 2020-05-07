package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(
    value = "src/test/resources/properties/test1.properties",
    encoding = "UTF-8")
/*
@PropertySource(
    value = "src/test/resources/properties/${execution.environment}.properties",
    encoding = "UTF-8")
 */
public class EnvironmentConfig {}

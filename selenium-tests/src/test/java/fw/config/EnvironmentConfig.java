package fw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "fw")
@PropertySource(value = "properties/${app}/user.properties", encoding = "UTF-8")
@PropertySource(value = "properties/${app}/execution.properties", encoding = "UTF-8")
@PropertySource(value = "properties/${execution.environment}.properties", encoding = "UTF-8")
public class EnvironmentConfig {}

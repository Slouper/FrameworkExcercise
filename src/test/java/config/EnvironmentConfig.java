package config;

import general.AbstractPage;
import general.AbstractStep;
import general.AbstractTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackageClasses = {AbstractPage.class, AbstractTest.class, AbstractStep.class})
@PropertySource(value = "src/test/resources/properties/test1.properties", encoding = "UTF-8")

/*
@PropertySource(
    value = "src/test/resources/properties/${execution.environment}.properties",
    encoding = "UTF-8")
 */
public class EnvironmentConfig {}

# FrameworkExcercise
Java + Selenium + TestNG + Maven + Spring basics

Framework and tests creation, step by step:

Everything create in your own branch (name it according functionality, that you develop in the branch) and after you will have this functionality developed, create pull/merge request on me.

Technologies:
Java, Maven, TestNG, org.apache.logging.log4j.Logger, ChromeDriver - Selenium

========================== 1 ====================================
Create 2 tests
1)
- on the page seznam.cz search the term "Selenium"
- assert that you are on next page
- click on first searched result
2) The same steps as in test above on the google.com page 

Framework will contain following abstract classes, tha are parents for corresponding classes that we need for tests and for handling the driver:
 - AbstractPage
 - AbstractTest
 - AbstractStep
 - DriverFactory (use only chromedriver)
 
  - Driver is available only on the pages through method getDriver(). Until you do not call getDriver() method, driver is not created (window is not open)
  - Implement Logger (org.apache.logging.log4j.Logger) and log to the console:
  Example: 
  private static final Logger LOG = LogManager.getLogger(RefreshToken.class);
  LOG.debug("Some log message")
  - Use maven surefire plugin to run TestNG suiteXml during running through maven:
  
        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.19.1</version>
        <configuration>
          <suiteXmlFiles>
            <suiteXmlFile>${suiteXmlFile}</suiteXmlFile>
          </suiteXmlFiles>
        </configuration>
      </plugin>
      
      Running test from command line (from jenkins for example):
      mvn -DsuiteXmlFile=src/test/resources/suite/TestSuite.xml test
       
========================== 2 ==================================== 
 - Implement maven profiles for test1 and test2
 
 <profiles>
 <profile>
      <id>env-test1</id>
      <build>
        <plugins>
          <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <configuration>
              <systemPropertyVariables>
                <execution.environment>test1</execution.environment>
              </systemPropertyVariables>
            </configuration>
          </plugin>
        </plugins>
      </build>
    </profile>
  </profiles>

If the profile is active (you can check it as active in Intellij IDEA in maven profiles or you enable it through command line as bellow, then into system property "execution.environment" is saved value "test1" and you can use it in your tests.

Then you can run test from command line like:
      mvn -Penv-test1 -DsuiteXmlFile=src/test/resources/suite/TestSuite.xml test

========================== 3 ==================================== 

Implement Spring for loading of properties files. It will ensure, that we eill load only properties, that are general or are connected directly to specififc environment, that we run tests for:

@Configuration
@ComponentScan(basePackages = "your.base.package")
@PropertySource(value = "common/properties/common.properties", encoding = "UTF-8")
@PropertySource(value = "${api.name}/properties/common.properties", encoding = "UTF-8")
@PropertySource(value = "${api.name}/properties/env/${execution.environment}.properties", encoding = "UTF-8")
@PropertySource(value = "${api.name}/properties/testUser/${execution.environment}.user.properties", encoding = "UTF-8")
public class AppEnvConfig {
}

We have to change all objects creation. Spring can not manage objects created through:
Object object = new Object();

We just annotate all AbstractClasses with @Component annotation and we have to change their creation. We have to make PageFactory and there for each new page we have to call following to have the page in spring context:
applicationContext.autowireCapableBeanFactory.autowireBean(page)

Everything where you want to use Spring, has to be in Spring context. You will ensure it by to ways:
 - Annotation @Component above class
 - After creation of new instance by calling "applicationContext.autowireCapableBeanFactory.autowireBean(myObject)"
 
After you have class in Spring context, you can use following annotations:
@Autowired - it injects me the class to my class and I can start to use it without manual instantiation - it is already injected as instance
@Value - loading properties into the fields
...

========================== 4 ==================================== 
Make an example for RestAssured usage.

1) Choose some public rest api to call
2) Make call through RestAssured int @Test
3) Use Object Mapper - what you are sending (JSON) has own class with @json annotations. For transfering json to class/classes you can use oinline methods. They create java classes from inserted json.

package fw.general;

import fw.config.EnvironmentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = {EnvironmentConfig.class})
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

  @Autowired protected ApplicationContext applicationContext;
}

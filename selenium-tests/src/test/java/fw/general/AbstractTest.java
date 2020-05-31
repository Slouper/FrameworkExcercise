package fw.general;

import fw.config.DriverFactory;
import fw.config.EnvironmentConfig;
import fw.factory.PageObjectFactory;
import fw.factory.StepFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;

@Component
@ContextConfiguration(classes = {EnvironmentConfig.class})
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

  @Autowired protected ApplicationContext applicationContext;

  @SafeVarargs
  protected final <P extends AbstractPage> P createPage(P... pageClass) {
    return PageObjectFactory.createPage(applicationContext, pageClass);
  }

  protected final <P extends AbstractPage> P createPage(Class<P> pageClass) {
    return PageObjectFactory.createPage(applicationContext, pageClass);
  }

  @SafeVarargs
  protected final <S extends AbstractStep> S createStep(S... stepClass) {
    return StepFactory.createStep(applicationContext, stepClass);
  }

  @AfterMethod
  protected void teardown() {
    DriverFactory.quitDriver();
  }
}

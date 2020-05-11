package fw.general;

import fw.factory.PageObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractStep {

  @Autowired
  protected ApplicationContext applicationContext;

  @SafeVarargs
  protected final <P extends AbstractPage> P createPage(P... pageClass) {
    return PageObjectFactory.createPage(applicationContext, pageClass);
  }
}

package fw.factory;

import static java.lang.String.format;

import fw.general.AbstractPage;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public interface PageObjectFactory {

  @SuppressWarnings({"unchecked", "ConstantConditions"})
  @SafeVarargs
  static <P extends AbstractPage> P createPage(ApplicationContext applicationContext, P... pageClass) {
    P page = null;

    try {
      Class<P> pageInstance = (Class<P>) pageClass.getClass().getComponentType();
      page = pageInstance.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      throw new RuntimeException(format("Could not create Page of type [%s] ", page.getClass().getSimpleName()), e);
    }
    applicationContext.getAutowireCapableBeanFactory().autowireBean(page);
    return page;
  }
}

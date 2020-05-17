package fw.factory;

import static java.lang.String.format;

import fw.general.AbstractPage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public interface PageObjectFactory {

  @SuppressWarnings({"unchecked"})
  @SafeVarargs
  static <P extends AbstractPage> P createPage(
      ApplicationContext applicationContext, P... pageClass) {
    P page = null;

    Class<P> pageInstance = (Class<P>) pageClass.getClass().getComponentType();
    return createPage(applicationContext, pageInstance);
  }

  @SuppressWarnings({"ConstantConditions"})
  static <P extends AbstractPage> P createPage(
      ApplicationContext applicationContext, Class<P> pageClass) {
    P page = null;

    try {
      Constructor<P> pageInstance = pageClass.getConstructor();
      page = pageInstance.newInstance();
    } catch (IllegalAccessException
        | InstantiationException
        | NoSuchMethodException
        | InvocationTargetException e) {
      throw new RuntimeException(
          format("Could not create Page of type [%s] ", page.getClass().getSimpleName()), e);
    }
    applicationContext.getAutowireCapableBeanFactory().autowireBean(page);
    return page;
  }
}

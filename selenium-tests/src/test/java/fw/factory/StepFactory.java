package fw.factory;

import static java.lang.String.format;

import fw.general.AbstractStep;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public interface StepFactory {

  @SuppressWarnings({"unchecked", "ConstantConditions"})
  @SafeVarargs
  static <S extends AbstractStep> S createStep(ApplicationContext applicationContext, S... stepClass) {
    S step = null;

    try {
      Class<S> stepInstance = (Class<S>) stepClass.getClass().getComponentType();
      step = stepInstance.newInstance();
    } catch (IllegalAccessException | InstantiationException e) {
      throw new RuntimeException(format("Could not create Step of type [%s] ", step.getClass().getSimpleName()), e);
    }
    applicationContext.getAutowireCapableBeanFactory().autowireBean(step);
    return step;
  }
}

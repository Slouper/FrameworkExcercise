package fw.utils;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class Asserts {

  private static final Logger LOG = LogManager.getLogger(Asserts.class);

  public static void assertNumberOfCountriesWithMoreThan4Neighbours(List<String> countries) {
    Assert.assertTrue(countries.size() > 1, "There are no countries with more than 4 neighbours");
    LOG.debug("There are [{}] countries with more than 4 neighbours: [{}]", countries.size(), countries);
  }
}

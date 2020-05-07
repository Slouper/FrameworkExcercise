package test;

import general.AbstractTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;
import pageObject.SeznamPage;
import utils.Asserts;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeznamTest extends AbstractTest {

  @Autowired
  SeznamPage seznamPage;

  @Value("searchedPhrase")
  private String searchedPhrase;

  @Test
  public void searchForSeleniumOnSeznam() {
    seznamPage.openSeznamPage().typeAndSearch(searchedPhrase).openFirstSearchResult();
    new Asserts().assertUrlNotContains("seznam");
  }
}

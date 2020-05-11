package fw.test.seznam.step;

import fw.general.AbstractStep;
import fw.pageObject.SeznamPage;

public class SeznamStep extends AbstractStep {

  public void searchPhrase(SeznamPage seznamPage, String searchedPhrase) {
    seznamPage.openSeznamPage().typeAndSearch(searchedPhrase).openFirstSearchResult();
  }
}

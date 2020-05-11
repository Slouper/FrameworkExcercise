package fw.test.google.step;

import fw.general.AbstractStep;
import fw.pageObject.GooglePage;

public class GoogleStep extends AbstractStep {

  public void searchPhrase(GooglePage googlePage, String searchedPhrase) {
    googlePage.openGooglePage().typeAndSearch(searchedPhrase).openFirstSearchResult();
  }
}

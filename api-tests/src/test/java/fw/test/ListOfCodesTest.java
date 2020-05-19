package fw.test;

import static io.restassured.RestAssured.get;

import fw.general.AbstractTest;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListOfCodesTest extends AbstractTest {

  @Value("${baseUrl}")
  private String baseUrl;

  @Test
  public void listOfCodesForCzechRepublic() {
    // todo add object mapper
    Assert.assertEquals(get(baseUrl + "/alpha?codes=cz").getStatusCode(), 200);
  }
}

package fw.test;

import static io.restassured.RestAssured.get;

import fw.general.AbstractTest;
import fw.pojo.Translations;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class CodeTest extends AbstractTest {

  @Value("${baseUrl}")
  private String baseUrl;

  @Test
  public void codeForCzechRepublic() {
    //todo fix -> everything is inside additionalProperties
    Translations translations =
        get(baseUrl + "/alpha/cz")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(Translations.class);
    System.out.println(translations.getAdditionalProperties());
    System.out.println(translations.getEs());
  }
}

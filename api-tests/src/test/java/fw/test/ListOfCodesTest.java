package fw.test;

import static io.restassured.RestAssured.get;

import fw.general.AbstractTest;
import fw.pojo.code.Code;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class ListOfCodesTest extends AbstractTest {

  @Value("${baseUrl}")
  private String baseUrl;

  @Test
  public void listOfCodesForCZAndSK() {
    Code[] codes =
        get(baseUrl + "/alpha?codes=cz;sk")
            .then()
            .assertThat()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .as(Code[].class);
  }
}

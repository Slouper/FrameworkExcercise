package fw.test;

import static io.restassured.RestAssured.get;

import fw.general.AbstractTest;
import fw.pojo.code.CountryInfo;
import fw.utils.Asserts;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.testng.annotations.Test;

public class ListOfCodesTest extends AbstractTest {

  @Value("${baseUrl}")
  private String baseUrl;

  @Test
  public void listOfCodesForCZAndSK() {
    List<CountryInfo> countryInfoList =
        Arrays.asList(
            get(baseUrl + "/alpha?codes=cz;sk")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CountryInfo[].class));
  }

  @Test
  public void countriesWithMoreThan4Neighbours() {
    List<CountryInfo> countryInfoList =
        Arrays.asList(
            get(baseUrl
                    + "/alpha?codes=cz;esp;chn;svk;nor;nld;be;aus;deu;aut;pol;lux;fra;dnk;lie;ita;che")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CountryInfo[].class));
    List<String> countriesWithMoreThan4Neighbours =
        countryInfoList.stream()
            .filter(p -> p.getBorders().size() > 4)
            .map(CountryInfo::getName)
            .collect(Collectors.toList());
    Asserts.assertNumberOfCountriesWithMoreThan4Neighbours(countriesWithMoreThan4Neighbours);
  }
}

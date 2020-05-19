package fw.pojo.code;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "name",
  "topLevelDomain",
  "alpha2Code",
  "alpha3Code",
  "callingCodes",
  "capital",
  "altSpellings",
  "region",
  "subregion",
  "population",
  "latlng",
  "demonym",
  "area",
  "gini",
  "timezones",
  "borders",
  "nativeName",
  "numericCode",
  "currencies",
  "languages",
  "translations",
  "flag",
  "regionalBlocs",
  "cioc"
})
@Getter
@Setter
public class Code {

  @JsonProperty("name")
  private String name;

  @JsonProperty("topLevelDomain")
  private List<String> topLevelDomain = null;

  @JsonProperty("alpha2Code")
  private String alpha2Code;

  @JsonProperty("alpha3Code")
  private String alpha3Code;

  @JsonProperty("callingCodes")
  private List<String> callingCodes = null;

  @JsonProperty("capital")
  private String capital;

  @JsonProperty("altSpellings")
  private List<String> altSpellings = null;

  @JsonProperty("region")
  private String region;

  @JsonProperty("subregion")
  private String subregion;

  @JsonProperty("population")
  private Integer population;

  @JsonProperty("latlng")
  private List<Double> latlng = null;

  @JsonProperty("demonym")
  private String demonym;

  @JsonProperty("area")
  private Double area;

  @JsonProperty("gini")
  private Double gini;

  @JsonProperty("timezones")
  private List<String> timezones = null;

  @JsonProperty("borders")
  private List<String> borders = null;

  @JsonProperty("nativeName")
  private String nativeName;

  @JsonProperty("numericCode")
  private String numericCode;

  @JsonProperty("currencies")
  private List<Currency> currencies = null;

  @JsonProperty("languages")
  private List<Language> languages = null;

  @JsonProperty("translations")
  private Translations translations;

  @JsonProperty("flag")
  private String flag;

  @JsonProperty("regionalBlocs")
  private List<RegionalBloc> regionalBlocs = null;

  @JsonProperty("cioc")
  private String cioc;
}

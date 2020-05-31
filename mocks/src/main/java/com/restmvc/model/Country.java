package com.restmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "Country")
@Data
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
@Table(name = "COUNTRY")
public class Country {

  @JsonProperty("name")
  private String name;

  @Id
  @JsonProperty("alpha2Code")
  private String alpha2Code;

  @JsonProperty("alpha3Code")
  private String alpha3Code;

  @JsonProperty("capital")
  private String capital;

  @JsonProperty("region")
  private String region;

  @JsonProperty("subregion")
  private String subregion;

  @JsonProperty("population")
  private Integer population;

  @JsonProperty("demonym")
  private String demonym;

  @JsonProperty("nativeName")
  private String native_name;

  @JsonProperty("area")
  private Integer area;

  @JsonProperty("numericCode")
  private String numeric_code;

  @JsonProperty("flag")
  private String flag;

  @JsonProperty("cioc")
  private String cioc;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "country_currencies",
      joinColumns = @JoinColumn(table = "country_alpha2Code"),
      inverseJoinColumns = @JoinColumn(name = "currencies_code"))
  @JsonProperty("currencies")
  private List<Currency> currencies = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JsonProperty("translations")
  @JoinColumn(name = "alpha2Code")
  private Translations translations;

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "country_regional_blocs",
      joinColumns = @JoinColumn(table = "country_alpha2Code"),
      inverseJoinColumns = @JoinColumn(name = "regional_blocs_acronym"))
  @JsonProperty("regionalBlocs")
  private List<RegionalBloc> regionalBlocs = null;

  @JsonProperty("gini")
  private BigDecimal gini;

  @ElementCollection
  @JsonProperty("timezones")
  @Column(name = "timezone")
  private List<String> timezones = new ArrayList<>();

  @ElementCollection
  @JsonProperty("borders")
  private List<String> borders = new ArrayList<>();

  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
      name = "country_languages",
      joinColumns = @JoinColumn(table = "country_alpha2Code"),
      inverseJoinColumns = @JoinColumn(name = "languages_iso639_2"))
  private List<Language> languages = new ArrayList<>();

  @ElementCollection
  @JsonProperty("altSpellings")
  private List<String> altSpellings = new ArrayList<>();

  @ElementCollection
  @JsonProperty("callingCodes")
  private List<String> callingCodes = new ArrayList<>();

  @ElementCollection
  @JsonProperty("topLevelDomain")
  private List<String> topLevelDomain = new ArrayList<>();

  @ElementCollection
  @JsonProperty("latlng")
  private List<BigDecimal> latlng = new ArrayList<>();
}

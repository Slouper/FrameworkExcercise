package fw.pojo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"de", "es", "fr", "ja", "it", "br", "pt", "nl", "hr", "fa"})
public class Translations {

  @JsonProperty("de")
  private String de;

  @JsonProperty("es")
  private String es;

  @JsonProperty("fr")
  private String fr;

  @JsonProperty("ja")
  private String ja;

  @JsonProperty("it")
  private String it;

  @JsonProperty("br")
  private String br;

  @JsonProperty("pt")
  private String pt;

  @JsonProperty("nl")
  private String nl;

  @JsonProperty("hr")
  private String hr;

  @JsonProperty("fa")
  private String fa;

  @JsonIgnore private final Map<String, Object> additionalProperties = new HashMap<>();

  @JsonProperty("de")
  public String getDe() {
    return de;
  }

  @JsonProperty("de")
  public void setDe(String de) {
    this.de = de;
  }

  public Translations withDe(String de) {
    this.de = de;
    return this;
  }

  @JsonProperty("es")
  public String getEs() {
    return es;
  }

  @JsonProperty("es")
  public void setEs(String es) {
    this.es = es;
  }

  public Translations withEs(String es) {
    this.es = es;
    return this;
  }

  @JsonProperty("fr")
  public String getFr() {
    return fr;
  }

  @JsonProperty("fr")
  public void setFr(String fr) {
    this.fr = fr;
  }

  public Translations withFr(String fr) {
    this.fr = fr;
    return this;
  }

  @JsonProperty("ja")
  public String getJa() {
    return ja;
  }

  @JsonProperty("ja")
  public void setJa(String ja) {
    this.ja = ja;
  }

  public Translations withJa(String ja) {
    this.ja = ja;
    return this;
  }

  @JsonProperty("it")
  public String getIt() {
    return it;
  }

  @JsonProperty("it")
  public void setIt(String it) {
    this.it = it;
  }

  public Translations withIt(String it) {
    this.it = it;
    return this;
  }

  @JsonProperty("br")
  public String getBr() {
    return br;
  }

  @JsonProperty("br")
  public void setBr(String br) {
    this.br = br;
  }

  public Translations withBr(String br) {
    this.br = br;
    return this;
  }

  @JsonProperty("pt")
  public String getPt() {
    return pt;
  }

  @JsonProperty("pt")
  public void setPt(String pt) {
    this.pt = pt;
  }

  public Translations withPt(String pt) {
    this.pt = pt;
    return this;
  }

  @JsonProperty("nl")
  public String getNl() {
    return nl;
  }

  @JsonProperty("nl")
  public void setNl(String nl) {
    this.nl = nl;
  }

  public Translations withNl(String nl) {
    this.nl = nl;
    return this;
  }

  @JsonProperty("hr")
  public String getHr() {
    return hr;
  }

  @JsonProperty("hr")
  public void setHr(String hr) {
    this.hr = hr;
  }

  public Translations withHr(String hr) {
    this.hr = hr;
    return this;
  }

  @JsonProperty("fa")
  public String getFa() {
    return fa;
  }

  @JsonProperty("fa")
  public void setFa(String fa) {
    this.fa = fa;
  }

  public Translations withFa(String fa) {
    this.fa = fa;
    return this;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  public Translations withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }
}

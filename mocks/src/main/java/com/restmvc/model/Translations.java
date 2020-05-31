package com.restmvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "TRANSLATIONS")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"de", "es", "fr", "ja", "it", "br", "pt", "nl", "hr", "fa"})
public class Translations {

  @Id @JsonIgnore private String alpha2Code;

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
}

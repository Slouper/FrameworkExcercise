package com.restmvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "Language")
@Data
@Table(name = "Languages")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"iso639_1", "iso639_2", "name", "nativeName"})
public class Language {

  @JsonProperty("iso639_1")
  private String iso639_1;

  @Id
  @JsonProperty("iso639_2")
  private String iso639_2;

  @JsonProperty("name")
  private String name;

  @JsonProperty("nativeName")
  private String native_name;
}

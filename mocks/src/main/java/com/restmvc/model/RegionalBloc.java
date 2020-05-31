package com.restmvc.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "RegionalBlocs")
@Data
@Table(name = "regional_blocs")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"acronym", "name", "otherAcronyms", "otherNames"})
public class RegionalBloc {

  @Id
  @JsonProperty("acronym")
  private String acronym;

  @JsonProperty("name")
  private String name;

  @ElementCollection
  @JsonProperty("otherAcronyms")
  @Column(name = "other_acronyms")
  private List<String> otherAcronyms = new ArrayList<>();

  @ElementCollection
  @JsonProperty("otherNames")
  @Column(name = "other_names")
  private List<String> otherNames = new ArrayList<>();
}

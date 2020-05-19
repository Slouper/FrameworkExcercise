package fw.pojo.code;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"acronym", "name", "otherAcronyms", "otherNames"})
@Getter
@Setter
public class RegionalBloc {

  @JsonProperty("acronym")
  private String acronym;

  @JsonProperty("name")
  private String name;

  @JsonProperty("otherAcronyms")
  private List<Object> otherAcronyms = null;

  @JsonProperty("otherNames")
  private List<Object> otherNames = null;
}

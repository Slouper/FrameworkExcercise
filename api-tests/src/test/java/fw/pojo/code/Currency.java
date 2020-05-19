package fw.pojo.code;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "name", "symbol"})
@Getter
@Setter
public class Currency {

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  @JsonProperty("symbol")
  private String symbol;
}

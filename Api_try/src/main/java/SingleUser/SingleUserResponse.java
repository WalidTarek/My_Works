package SingleUser;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "support"
})
public class SingleUserResponse {

    @JsonProperty("data")
    public ListUsers.UsersData data;
    @JsonProperty("support")
    public ListUsers.Support support;

}
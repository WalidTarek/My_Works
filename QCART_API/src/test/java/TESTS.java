import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.example.Main.*;

public class TESTS {
    @Test
    public void users(){
         given().baseUri("https://645279c3a2860c9ed40d65e4.mockapi.io/api/v1/")
          .when().get("users")
          .then().log().all()
                 .assertThat().statusCode(200)
                 .assertThat().body("[0].name",equalTo("Miss April Anderson"))
                 .assertThat().body("name",hasItem("Judy Auer"),
                         "name",hasItem("Tonya Rice MD"))
                 .assertThat().body("name",hasItems("Muriel Goldner","Ms. Lori Marvin"))
        .assertThat().body("name",not(empty()))
                 .assertThat().body("name",hasSize(25));


    }
    @Test
    public void numberOfUsers() {

        getUsers().equals(expect().body("name.size()",equalTo(25)));
    }
    @Test
    public void everyItem(){
       // getUsers().equals(expect().body("createdAt",startsWith("2023")));
        getUsers().equals(expect().body("[0]",hasKey("name")));
        getUsers().equals(expect().body("[0]",hasEntry("name","Miss April Anderson")));
    }


        @Test
    public void users2(){
            given().baseUri("https://645279c3a2860c9ed40d65e4.mockapi.io/api/v1/")
          .when().get("users")
          .then().log().ifValidationFails()
                    .body("[0].name",equalTo("Miss April Anderson"));


//           String name= JsonPath.from(userResponse.asString()).getString("[0].name");
//String name =userResponse.path("[0].name");
}
    @Test
    public void getNAme(){
        Map<String,String> headermap = new HashMap<>();
        headermap.put("Etag","-931065972");

        given()
                .baseUri("https://645279c3a2860c9ed40d65e4.mockapi.io/")
                .param("name","Miss April Anderson").log().all()
                .headers(headermap).log().all()
                .when()
                .get("/api/v1/users")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("[0].name",equalTo("Miss April Anderson"));
    }

}

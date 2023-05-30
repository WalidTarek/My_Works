import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.Data;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class LoginPlate {

    @Test
    public void loginTest(){

        File body =new File("src/test/resources/Login.json");

     Object response= given()
         .baseUri("https://reqres.in")
                  .body(body).contentType(ContentType.JSON)
          .when()
          .post("/api/login")
          .then()
          .log().all()
                  .assertThat().statusCode(200);

    }
    @Test
    public void loginTestMap(){

        HashMap<String,String> body =new HashMap<>();
        body.put("email","eve.holt@reqres.in");
        body.put("password","cityslicka");

        given()
                .baseUri("https://reqres.in")
                .body(body).contentType(ContentType.JSON)
                .when()
                .post("/api/login")
                .then()
                .log().all()
                .assertThat().statusCode(200);

    }

    @Test
    public void users(){
        given()
                .baseUri(Data.baseurl)
                .header("authorization",Data.token)
                .when()
                .get(Data.listUsersEndPoint)
                .then().log().all()
                .assertThat().body("data[0].id",equalTo(7));
    }
    @Test
    public void usersLogin(){
        given()
                .baseUri(Data.baseurl)
                .auth().oauth2(Data.token)
                .when()
                .get(Data.listUsersEndPoint)
                .then().log().all()
                .assertThat().body("data[0].id",equalTo(7));
    }

}

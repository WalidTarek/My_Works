package Features;

import Responceses.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Talabat {
    public static String Username = "eve.holt@reqres.in";
    public static String password = "cityslicka";
    public static String baseurl = "https://reqres.in/api";
    public static String loginendpoint = "/login";
    public static String token = "";
    public static String singleuserendpoint = "/users";
    public static String listuersendpoint2 = "/users?page=2";

    public static Response login(String userName, String password) {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.email = userName;
        loginRequest.password = password;
        Response loginResponse = RestAssured.given().log().all().contentType("application/json")
                .body(Helper.getObjectAsString(loginRequest)).post(baseurl + loginendpoint);
        return loginResponse;
    }
}

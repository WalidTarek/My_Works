package org.example;


import ListUsers.Helper;
import LoginModels.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class Requests {
    public static String userName = "eve.holt@reqres.in";
    public static String password = "cityslicka";
    public static String baseurl = "https://reqres.in/api";
    public static String loginendpoint = "/login";
    public static String userendpoint = "/users";
    public static String singleuserendpoint = "/users";



   /* public static Response login(String userName, String password) {

        Response loginResponse = RestAssured.given().log().all()
                .contentType("application/json")
                .body("{\n    \"email\": \"" + userName+ "\",\n    \"password\": \"" + password + "\"\n}")
                .post(baseurl+loginendpoint);
        System.out.println(loginResponse.statusCode());
        loginResponse.prettyPrint();
        return loginResponse;
    }*/
   public static Response login(String userName, String password) {
       LoginRequest loginRequest= new LoginRequest();
       loginRequest.email=userName;
       loginRequest.password=password;
       Response loginResponsr=RestAssured.given().log().all().contentType("application/json")
               .body(Helper.getObjectAsString(loginRequest)).get(baseurl+loginendpoint);
   return loginResponsr;
   }

       public static Response listusers(Map<String,String> headers,Map<String,String> queryparams){
     Response lidtuserResponse = RestAssured.given().log().all()
             .headers(headers).queryParams(queryparams).get(baseurl+userendpoint);
     return lidtuserResponse;


    }

public static Response singlruser (Map<String,String> headers,Map<String,String> queryparams){

        Response singleuserResponse = RestAssured.given().log().all()
                .headers(headers).queryParams(queryparams).get(baseurl+singleuserendpoint);

return singleuserResponse;

    }
}




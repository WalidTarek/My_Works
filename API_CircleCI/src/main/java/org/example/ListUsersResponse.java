package org.example;
import static org.example.Data.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ListUsersResponse {
public static JsonPath listUsers(String header2,String queryParam1,String queryParam2){
    Map<String, String> header = new HashMap<>();
    header.put("Authorization", header2);
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put(queryParam1, queryParam2);

    Response listUsersResponse = RestAssured.given().log().all().headers(header).queryParams(queryParams)
            .get(baseurl+listUsersEndPoint);
    JsonPath listUsersJson = listUsersResponse.jsonPath();
    listUsersResponse.prettyPrint();
    return listUsersJson;
}
//    Response listUsers=ListUsersResponse.listUsers(LoginResponse.loginToken(Data.Username,Data.password),"page","2");
//    JsonPath listUsersJson = listUsers.jsonPath();
}

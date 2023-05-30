package RestassuredPk;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.Requests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SingleUser {
    public static String token = "";
    public static String password = "cityslicka";
    public static String Username = "eve.holt@reqres.in";
    public static Map<String,String> queryparams = new HashMap<>();
    public static Map<String,String> headers = new HashMap<>();

   @BeforeTest
    public static void loginsuccess(){
        Response loginsuccess = Requests.login(Username,password);
        token = loginsuccess.jsonPath().getString("token");
    }
    @Test
    public static void singleuser(){
        headers.put("Authorization",token);
        queryparams.put("id","2");



      /*  Map<String,String> headers =new HashMap<>();
        headers.put("Authorization",LoginTc.token);
        Map<String,String> queryparams = new HashMap<>();
        queryparams.put("id","2");
*/
        Response singleUser = RestAssured.given().log().all()
                .headers(headers)
                .queryParams(queryparams)
                .get(LoginTc.baseurl+ListusersTc.singleuserendpoint);
        System.out.println(singleUser);

        JsonPath singleuserjsonpath = singleUser.jsonPath();
        singleuserjsonpath.prettyPrint();

        //test1

        Assert.assertEquals(singleuserjsonpath.getString("data.id"),"2","fail Id test");
        System.out.println("this is siggle user test : "+ singleuserjsonpath.getString("data.id"));
/*
        //test2
        Assert.assertEquals(singleuserjsonpath.getString("data.first_name"),"Janet","fail id t3");
        System.out.println("this is actual : "+singleuserjsonpath.getString("data.first_name")+"\n this is expect: Janet");
*/
    }

}


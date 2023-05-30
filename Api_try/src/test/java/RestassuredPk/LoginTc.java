package RestassuredPk;

import ListUsers.Helper;
import LoginModels.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.security.jarsigner.JarSigner;
import org.apache.groovy.json.internal.Exceptions;
import org.example.LoginResponce;
import org.example.Requests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class LoginTc
{   public static String userName = "eve.holt@reqres.in";
    public static String password = "cityslicka";
    public static String baseurl = "https://reqres.in/api";
    public static String loginendpoint = "/login";
    public static String token = "";
    public static String singleuserendpoint = "/users";

    @Test
    public void loginteststring (){
        Response loginstrResponse = Requests.login(userName,password);
        LoginResponce loginResponceSuccess = loginstrResponse.as(LoginResponce.class);
        Assert.assertEquals(loginResponceSuccess.token,"QpwL5tke4Pnpja7X4");
    }

/*
    @Test

    public static void loginsuccess(){
        Response loginsuccessResponse = Requests.login(Username,password);
        LoginResponce loginResponceObject =loginsuccessResponse.as(LoginResponce.class);
        LoginResponce tokenjson = loginsuccessResponse.as(LoginResponce.class);
        token = tokenjson.token;
        System.out.println(token);


     //   Assert.assertEquals(loginsuccessResponse.statusCode(),200,"error");


       // Assert.assertNotNull(loginResponceObject.token);
        //System.out.println(loginResponceObject.token);

      //  String token = tokenjson.getString("token");
      //  System.out.println("token is :"+ token);

    }*/

/*    @Test
    public static void emptypassword(){
        Response emptypasswordResponse = Requests.login(Username,"");
        Assert.assertEquals(emptypasswordResponse.statusCode(),400,"testcase empty fail");
       JsonPath emptpasswordjasompath = emptypasswordResponse.jsonPath();
       String errormassegeemptypassword = emptpasswordjasompath.getString("error");
        System.out.println("error massege is :"+errormassegeemptypassword);
        Assert.assertEquals(errormassegeemptypassword,"Missing password");
    }
/*
    @Test
    public static void emptyusername(){
        Response emptyUsername = login("",password);
        Assert.assertEquals(emptyUsername.statusCode(),400,"fail test case empty password");
        JsonPath emptuusernamejasonpath = emptyUsername.jsonPath();
        String errormassegeemptuusername = emptuusernamejasonpath.getString("error");
        System.out.println("error massege is :"+errormassegeemptuusername);
    }
@Test
    public static void spacespassword (){
        Response spacesPassword = login(Username,"    ");
        Assert.assertEquals(spacesPassword.statusCode(),200,"fail test spacespass");

}*/

}

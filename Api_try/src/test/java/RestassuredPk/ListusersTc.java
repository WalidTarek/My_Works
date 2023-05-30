package RestassuredPk;

import ListUsers.ListUsersResponse;
import ListUsers.UsersData;
import groovyjarjarantlr4.runtime.tree.RewriteEmptyStreamException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.Requests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ListusersTc
{   public static String Username = "eve.holt@reqres.in";
    public static String password = "cityslicka";
    public static String baseurl = "https://reqres.in/api";
    public static String loginendpoint = "/login";
    public static String token = "";
    public static String userendpoint = "/users";
    public static String singleuserendpoint = "/users";

    public static Response listUsersres;
    public static Map<String,String> queryparams = new HashMap<>();
    public static Map<String,String> headers = new HashMap<>();


    @BeforeTest
    public static void loginsuccess(){
        Response loginsuccess = Requests.login(Username,password);
        token = loginsuccess.jsonPath().getString("token");
    }
@Test
    public static void listusers(){

        headers.put("Authorization",token);

        queryparams.put("page","2");
//JsonPath listuserjson = Requests.listusers(headers,queryparams).jsonPath();
    ListUsersResponse listuserrespose = Requests.listusers(headers,queryparams).as(ListUsersResponse.class);
//Assert.assertEquals(listuserrespose.data.get(0).id,7,"");
//Assert.assertEquals(listuserrespose.data.get(0).email,"michael.lawson@reqres.in");
//Assert.assertNotNull(listuserrespose.data,"");
//Assert.assertTrue(listuserrespose.data.get(0).id instanceof Integer);
 //   Assert.assertTrue(listuserrespose.data.get(1).firstName instanceof String);

    for (int i=0 ; i<listuserrespose.data.size() ; i++)
    {
        Assert.assertNotNull(listuserrespose.data.get(i).id);
        System.out.println(listuserrespose.data.get(i).id);

    }






   /* JsonPath listuserjson = listUsersres.jsonPath();
    //List<Map<String,String>> userlist = listuserjson.getList("data");
    for(int i=0;i<listuserjson.getList("data").size();i++){
        Assert.assertNotNull(listuserjson.getString("data["+i+"].first_name"));


       System.out.println("first name "+(i+1)+"/is: "+listuserjson.getString("data["+i+"].first_name"));*/
    }




    //test1

    /*String massage =listuserjson.getString("page");
    Assert.assertEquals(massage,"2");
    System.out.println(massage);

    //test2
    //Assert.assertEquals(listuserjson.getString("data[0].id"),"7");

    //test3
    Assert.assertEquals(listuserjson.getInt("per_page"),listuserjson.getInt("total")
            /listuserjson.getInt("total_pages"),"error test3");
    System.out.println("actual is: "+listuserjson.getInt("per_page")+"\n expected is :"+
            listuserjson.getInt("total")
                    /listuserjson.getInt("total_pages"));*/




}




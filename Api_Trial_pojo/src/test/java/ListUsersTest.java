import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ListUsersTest {
@Test
    public void listUserPage2(){
    JsonPath listUsersJson = ListUsersResponse.listUsers(LoginResponse.loginToken(Data.Username,Data.password),
            "page","2");

    Assert.assertEquals(listUsersJson.getInt("data[0].id"),7);
}
    @Test
    public void listUserPage1(){
        JsonPath listUsersJson = ListUsersResponse.listUsers(LoginResponse.loginToken(Data.Username,Data.password),
                "page","1");

        Assert.assertEquals(listUsersJson.getInt("data[0].id"),1);
    }
@Test
    public void listUserPerPage(){
        JsonPath listUsersJson = ListUsersResponse.listUsers(LoginResponse.loginToken(Data.Username,Data.password),"page","2");
        Assert.assertEquals(listUsersJson.getInt("per_page"),6);
    }
}

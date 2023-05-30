import io.restassured.path.json.JsonPath;
import org.example.Data;
import org.example.LoginResponse;
import org.example.SingleUserResponse;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleUserTest {
    @Test
    public void singleUser(){
        JsonPath singleUserJson= SingleUserResponse.SingleUser(LoginResponse.loginToken(Data.Username,Data.password));
        //Assert.assertEquals(singleUserJson.getInt("data.id"),2);
        Assert.assertEquals(singleUserJson.getString("support.url"),"https://reqres.in/#support-heading");
    }
}

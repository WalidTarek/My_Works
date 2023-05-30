import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.example.Data;
import org.example.LoginResponse;
import org.example.SingleUserNotFoundResponse;
import org.example.SingleUserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleUserNotFoundTest {
    @Test
    public void singleUserNotFound(){
       Response userNotFound= SingleUserNotFoundResponse.SingleUserNotFound(LoginResponse.loginToken(Data.Username,Data.password));
        Assert.assertEquals(userNotFound.statusCode(),404);
        Assert.assertFalse(userNotFound.statusCode()==200);
    }
}

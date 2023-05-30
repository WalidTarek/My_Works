import org.example.HelperMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example. LoginResponse;
import org.example.Data;

public class LoginResponseTest {

    @Test
    public void loginToken(){
        Assert.assertEquals(LoginResponse.loginToken(Data.Username,Data.password),Data.token);
    }
@Test
    public void loginStatusCode(){
        Assert.assertEquals(LoginResponse.login(Data.Username,Data.password).statusCode(),200);
}




}

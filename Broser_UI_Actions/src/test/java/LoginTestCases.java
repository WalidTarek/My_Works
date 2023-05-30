import org.example.PomLogin;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTestCases {
    PomLogin pomLogin = new PomLogin();

    @Test
    public void loginSuccessTest() {
        Assert.assertTrue(pomLogin.loginSuccess());
    }

}
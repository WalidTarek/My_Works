
import Features.LoginErrorResponse;
import Features.LoginResponse;
import Features.Talabat;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTest {
/*
    @Test
    public void loginTestSeri (){
        Response loginRespSuccess = Talabat.login(Talabat.Username,Talabat.password);
        LoginResponse login= loginRespSuccess.as(LoginResponse.class);
        System.out.println(login.token);
        //Assert.assertTrue(login.token !=null);

}*/


@Test
    public void errorlogin(){
        Response errorpassLoginResponse=Talabat.login(Talabat.Username,"");
      LoginErrorResponse loginError=  errorpassLoginResponse.as(LoginErrorResponse.class);
        Assert.assertNotNull(loginError.error);
    System.out.println(loginError.error);
    Assert.assertEquals(loginError.error,"Missing password");

}

}

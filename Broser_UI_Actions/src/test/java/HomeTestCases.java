import org.example.Data;
import org.example.PomLogin;
import org.example.UIActions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomeTestCases {
    UIActions uiActions=new UIActions();
    PomLogin pomLogin =new PomLogin();

    public String locatorOfPriceByName="//div[text()='%s']//ancestor::div[@class='inventory_item_description']//div[@class='inventory_item_price']";
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object [][] {
                {"Sauce Labs Backpack","$29.99"},
                {"Sauce Labs Bike Light","$9.99"},
                {"Sauce Labs Bolt T-Shirt","$15.99"},
                {"Sauce Labs Fleece Jacket","$49.99"},
                {"Sauce Labs Onesie","$7.99"},
                {"Test.allTheThings() T-Shirt (Red)","$15.99"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void checkPrices(String name,String expectPrice)
    {
        pomLogin.loginSuccess();
        String locator = String.format(locatorOfPriceByName,name);
        Data.webElement=uiActions.findElementNew(UIActions.ByType.xpath,locator);
        String actualPrice=Data.webElement.getText();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(actualPrice,expectPrice);
        softAssert.assertAll();
    }
}

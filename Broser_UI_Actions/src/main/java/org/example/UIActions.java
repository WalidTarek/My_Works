package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.example.BrowserActions.driver;

public class UIActions {
    public enum ByType {
        ID,
        CSS,
        xpath,
        name,
        className,
        tagNAme

    }
    public WebElement findElementNew(ByType byType,String stringOfPath){
        WebElement webElement=null;

        switch (byType) {
            case ID:
                webElement = driver.findElement(By.id(stringOfPath));
                break;
            case CSS:
                webElement = driver.findElement(By.cssSelector(stringOfPath));
                break;
            case xpath:
                webElement = driver.findElement(By.xpath(stringOfPath));
                break;
            case name:
                webElement = driver.findElement(By.name(stringOfPath));
                break;
            case className:
                webElement = driver.findElement(By.className(stringOfPath));
                break;
            case tagNAme:
                webElement = driver.findElement(By.tagName(stringOfPath));
                break;
            default:
                throw new IllegalArgumentException("Invalid locator type specified: " + byType);
        }
return webElement;
    }
public void setTextField(ByType byType,String stringOfPath,String text){
    WebElement webElement =findElementNew(byType,stringOfPath);
       webElement.sendKeys(text);
}
public void clickButton(ByType byType,String stringOfPath){
WebElement webElement =findElementNew(byType,stringOfPath);
        webElement.click();
}
}

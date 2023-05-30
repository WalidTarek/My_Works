package org.example;

import org.openqa.selenium.WebElement;

import static org.example.Data.*;
import static org.example.Data.PathOfPassword;

public class PomLogin {
    UIActions uiActions=new UIActions();
    public boolean loginSuccess(){
        BrowserActions.openBrowser();
        uiActions.setTextField(UIActions.ByType.ID,pathOfUserName, userName);
        uiActions.setTextField(UIActions.ByType.ID,PathOfPassword,password);
        uiActions.clickButton(UIActions.ByType.ID,pathOfButton);
        return true;
    }
    public void setUserName(){
        BrowserActions.openBrowser();
        uiActions.setTextField(UIActions.ByType.ID,pathOfUserName,userName);
    }
    public String getUserName(){

        WebElement webElement= uiActions.findElementNew(UIActions.ByType.ID,pathOfUserName);
        return webElement.getText();

    }


}

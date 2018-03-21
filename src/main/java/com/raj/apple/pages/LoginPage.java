package com.raj.apple.pages;

import com.raj.apple.lib.SuperPage;
import com.raj.apple.utility.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by kshitij on 3/19/18.
 */

public class LoginPage extends SuperPage
{

    private static final String AUTH_FRAME = "auth-frame";
    private final Utils utils;

    @FindBy(css = ".login-pane")
    private WebElement loginPane;

    @FindBy(css = ".cnsmr-app-image")
    private WebElement logo;

    @FindBy(css = "input#appleId")
    private WebElement appleId;

    @FindBy(id = "pwd")
    private WebElement applePassword;

    @FindBy(id = "sign-in")
    private WebElement signIn;

    @FindBy(xpath = "//*[text() = 'Setup Instructions']")
    private WebElement setupInstruction; // loads before auth-frame


    LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        _waitTillPageLoads();
        utils = new Utils(driver);
    }

    private void _waitTillPageLoads()
    {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(AUTH_FRAME)));
        waitTillVisibilityOf(logo);
    }

    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }

    public Boolean areLoginFieldEnabled()
    {
        return utils.isFieldEnabled(appleId) && utils.isFieldEnabled(applePassword);
    }

    public DashBoardPage login(String username, String password)
    {
        clearAndType(appleId, username);
        clearAndType(applePassword, password);
        click(signIn);
        return new DashBoardPage(driver);
    }

}

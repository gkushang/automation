package com.raj.apple.page;

import com.raj.apple.pageobject.PageObject;
import com.raj.apple.utility.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.raj.apple.utility.ConstantValues.LOGIN_PAGE_URL;
import static com.raj.apple.utility.ConstantValues.PASSWORD;
import static com.raj.apple.utility.ConstantValues.USERNAME;

/**
 * Created by kshitij on 3/19/18.
 */

public class LoginPage extends PageObject {

    Utils utils = new Utils(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(id = "appleId")
    private WebElement username;

    @FindBy(id = "pwd")
    private WebElement password;

    @FindBy(id = "sign-in")
    private WebElement signIn;

    @FindBy(xpath = "//*[text() = 'Setup Instructions']")
    private WebElement setupInstruction; // loads before auth-frame


    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOf(setupInstruction));
    }

    public Boolean areLoginFieldEnabled() {
        driver.switchTo().frame("auth-frame");
        return utils.isFieldEnabled(username) && utils.isFieldEnabled(password);
    }

    public Boolean isSignInEnabled() {
        return utils.isFieldEnabled(signIn);
    }

    public void setUsername() {
        utils.enterKey(username, USERNAME);
    }

    public void setPassword() {
        utils.enterKey(password, PASSWORD);
    }

    public void clickSignIn() {
        utils.clickElement(signIn);
    }

    public String getLoginPageUrl() {
        return utils.getCurrentPageUrl();
    }

    public void waitLoginPageToLoadProperly(){
        driver.switchTo().frame("auth-frame");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(username));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        driver.switchTo().defaultContent(); // give driver instance back to main page

    }




}

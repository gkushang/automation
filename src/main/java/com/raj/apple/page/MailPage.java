package com.raj.apple.page;

import com.raj.apple.pageobject.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kshitij on 3/19/18.
 */
public class MailPage extends PageObject {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public MailPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Inbox']")
    WebElement inbox;

    @FindBy(xpath = "/*//*[@title='Sent']")
    WebElement sent;

    @FindBy(name = "search-key-field")
    WebElement searchBox;

    public String getMailPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getMailPageTitle() {
        return driver.getTitle();
    }

    public void waitMailPageToLoadProperly() {
        driver.switchTo().frame("mail");
        wait.until(ExpectedConditions.elementToBeClickable(inbox));
        wait.until(ExpectedConditions.elementToBeClickable(sent));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
    }

    public Boolean isMailPageItemClickable() {
        return searchBox.isEnabled();
    }

    public void getToSentFolder() {
        sent.click();
    }

    public void enterTextInSearchBox(String text) {
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER);
    }


}

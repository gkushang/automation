package com.raj.apple.utility;

import com.raj.apple.lib.SuperPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by kshitij on 3/19/18.
 */
public class Utils extends SuperPage
{
    public Utils(WebDriver driver)
    {
        super(driver);
    }

    public String getCurrentPageUrl()
    {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle()
    {
        return driver.getTitle();
    }

    public Boolean isFieldEnabled(WebElement webElement)
    {
        return webElement.isEnabled();
    }

    public void enterKey(WebElement webElement, String text)
    {
        webElement.sendKeys(text);
    }

    public void clickElement(WebElement webElement)
    {
        webElement.click();
    }


}

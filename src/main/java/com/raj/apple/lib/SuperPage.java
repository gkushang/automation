package com.raj.apple.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kshitij on 3/19/18.
 */
public class SuperPage
{
    protected final WebDriverWait wait;
    protected WebDriver driver;

    public SuperPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void navigate(String url)
    {
        driver.get(url);
    }

    public void switchToFrame(String id)
    {
        driver.switchTo().frame(id);
    }

    public void waitTillVisibilityOf(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clearAndType(WebElement webElement, String text)
    {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public void click(WebElement element)
    {
        element.click();
    }

    public String getCurrentPageUrl()
    {
        return driver.getCurrentUrl();
    }
}

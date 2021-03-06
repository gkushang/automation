package com.raj.apple.page;

import com.raj.apple.pageobject.PageObject;
import com.raj.apple.utility.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by kshitij on 3/19/18.
 */
public class DashBoardPage extends PageObject {
    Utils utils = new Utils(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public DashBoardPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Mail")
    WebElement mail;

    @FindBy(linkText = "Photos")
    WebElement photos;

    @FindBy(linkText = "Find iPhone")
    WebElement findIphone;

    public void clickMail(){
        mail.click();
    }

    /**
     * wait for dasboard page to load properly
     * conditions to be fulfilled are
     *  :mail element is clickable
     *  :photos element is clickable
     *  :findIphone element is clickable
     */
    public void waitDashboardPageToLoadProperly(){
        wait.until(ExpectedConditions.elementToBeClickable(mail));
        wait.until(ExpectedConditions.elementToBeClickable(photos));
        wait.until(ExpectedConditions.elementToBeClickable(findIphone));
    }


    public String getDashboardPageTitle(){
        return driver.getTitle();
    }

    /**
     * checks to see if dashboard item are clickable
     * conditions to be fulfilled are
     *  :mail element is clickable
     *  :photos element is clickable
     *  :findIphone element is clickable
     * @return {Boolean}
     */
    public Boolean isDashboardItemClikable(){
        return mail.isEnabled() && photos.isEnabled() && findIphone.isEnabled();
    }




}

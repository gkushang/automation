package com.raj.apple.pageobject;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by kshitij on 3/19/18.
 */
public class PageObject {
    protected ChromeDriver driver;

    public PageObject(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
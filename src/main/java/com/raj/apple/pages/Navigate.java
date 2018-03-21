package com.raj.apple.pages;

import com.raj.apple.lib.SuperPage;
import org.openqa.selenium.WebDriver;

import static com.raj.apple.utility.ConstantValues.LOGIN_PAGE_URL;

/**
 * Created by kshitij on 3/19/18.
 */

public class Navigate extends SuperPage
{
    public Navigate(WebDriver driver)
    {
        super(driver);
    }

    public LoginPage toLoginPage()
    {
        navigate(LOGIN_PAGE_URL);
        return new LoginPage(driver);
    }
}

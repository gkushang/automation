package com.raj.apple;

import com.raj.apple.pages.DashBoardPage;
import com.raj.apple.pages.LoginPage;
import com.raj.apple.pages.MailPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.raj.apple.utility.ConstantValues.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by kshitij on 3/19/18.
 */
public class LoginPageTest extends BeforeAfterHooks
{

    private LoginPage loginPage;
    private DashBoardPage dashBoardPage;
    private MailPage mailPage;

    @BeforeMethod
    public void setup()
    {
        loginPage = navigate.toLoginPage();
        dashBoardPage = new DashBoardPage(driver);
        mailPage = new MailPage(driver);
    }

    @Test
    public void userShouldBeOnLoginPage()
    {
        assertEquals(loginPage.getCurrentPageUrl(), LOGIN_PAGE_URL);
        assertEquals(loginPage.getLoginPageTitle(), ICLOUD);
        assertTrue(loginPage.areLoginFieldEnabled());
    }


    @Test
    public void userShouldBeAbleToLoginSuccessfully()
    {
        dashBoardPage = loginPage.login("enterusername", "enterpassword");

        assertEquals(dashBoardPage.getDashboardPageTitle(), ICLOUD);
        assertTrue(dashBoardPage.isDashboardItemClikable());
    }

    @Test
    public void mailCanBeReachedFromDashboardPage()
    {
        dashBoardPage.clickMail();
        mailPage.waitMailPageToLoadProperly();

        assertEquals(mailPage.getMailPageUrl(), MAIL_PAGE_URL);
        assertTrue(mailPage.getMailPageTitle().contains(MAIL_PAGE_TITLE)); // title is dynamic due to number of messages
        assertTrue(mailPage.isMailPageItemClickable());
    }

    @Test
    public void mailInSentFolderCanBeSearched()
    {
        mailPage.getToSentFolder();
        mailPage.enterTextInSearchBox(TEXT_FOR_SEARCH);
    }


}

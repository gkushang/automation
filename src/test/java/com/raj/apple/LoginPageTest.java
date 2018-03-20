package com.raj.apple;

import com.raj.apple.page.DashBoardPage;
import com.raj.apple.page.LoginPage;
import com.raj.apple.page.MailPage;
import org.testng.annotations.Test;

import static com.raj.apple.utility.ConstantValues.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by kshitij on 3/19/18.
 */
public class LoginPageTest extends TestLifeCycle {
    LoginPage loginPage = new LoginPage(driver);
    DashBoardPage dashBoardPage = new DashBoardPage(driver);
    MailPage mailPage = new MailPage(driver);

    @Test
    public void LoginPageCanBeOpened() {
        loginPage.openLoginPage();
        loginPage.waitLoginPageToLoadProperly();

        assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
        assertEquals(loginPage.getLoginPageTitle(), ICLOUD);
    }

    @Test
    public void LoginfieldsAreEnabled() {
        assertTrue(loginPage.areLoginFieldEnabled());
    }

    @Test
    public void loginIsSuccessFull() {
        loginPage.setUsername();
        loginPage.setPassword();
        loginPage.clickSignIn();

        dashBoardPage.waitDashboardPageToLoadProperly();

        assertEquals(dashBoardPage.getDashboardPageTitle(), ICLOUD);
        assertTrue(dashBoardPage.isDashboardItemClikable());
    }

    @Test
    public void mailCanBeReachedFromDashboardPage() {
        dashBoardPage.clickMail();
        mailPage.waitMailPageToLoadProperly();

        assertEquals(mailPage.getMailPageUrl(), MAIL_PAGE_URL);
        assertTrue(mailPage.getMailPageTitle().contains(MAIL_PAGE_TITLE)); // title is dynamic due to number of messages
        assertTrue(mailPage.isMailPageItemClickable());
    }

    @Test
    public void mailInSentFolderCanBeSearched() {
        mailPage.getToSentFolder();
        mailPage.enterTextInSearchBox(TEXT_FOR_SEARCH);
    }


}

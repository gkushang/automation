package com.raj.apple;


import com.raj.apple.pages.Navigate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by kshitij on 3/18/18.
 */
public class BeforeAfterHooks
{
    WebDriver driver;
    Navigate navigate;

    @BeforeMethod
    public void launchBrowser()
    {
        driver = new ChromeDriver();
        navigate = new Navigate(driver);
    }

    @BeforeClass
    public void setUp()
    {
        // Since i have used wait conditions in required places myself
        // the implicit wait at beiginning is not else else this is the way
        // although, always go with explicit wait whenever possible
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {
        try
        {
            if (result.getStatus() == ITestResult.FAILURE)
            {
                //your screen-shot code goes here
            }
        } finally
        {
            driver.close();
        }

    }
}

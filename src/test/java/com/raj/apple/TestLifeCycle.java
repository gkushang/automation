package com.raj.apple;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by kshitij on 3/18/18.
 */
public class TestLifeCycle {

    protected static ChromeDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUp() {
        // Since i have used wait conditions in required places myself
        // the implicit wait at beiginning is not else else this is the way
        // although, always go with explicit wait whenever possible
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}

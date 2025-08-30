package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/login"); // replace with deployed app URL
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.login("testuser@example.com", "Test@123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),
                "Login failed - Dashboard not loaded!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

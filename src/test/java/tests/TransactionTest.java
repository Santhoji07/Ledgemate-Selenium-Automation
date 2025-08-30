package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.TransactionPage;

public class TransactionTest {
    WebDriver driver;
    LoginPage loginPage;
    TransactionPage transactionPage;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/login");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        transactionPage = new TransactionPage(driver);

        // Login
        loginPage.login("testuser@example.com", "Test@123");
    }

    @Test
    public void addIncomeTransaction() throws InterruptedException {
        transactionPage.addTransaction("Income", "5000", "Salary");
        Thread.sleep(2000); // wait for UI update
        Assert.assertTrue(driver.getPageSource().contains("5000"),
                "Transaction not added or displayed!");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

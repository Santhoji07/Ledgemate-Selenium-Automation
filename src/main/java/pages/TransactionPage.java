package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionPage {
    WebDriver driver;

    By addBtn = By.id("addTransactionBtn");
    By typeField = By.id("type");
    By amountField = By.id("amount");
    By categoryField = By.id("category");
    By submitBtn = By.id("submitBtn");

    public TransactionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTransaction(String type, String amount, String category) {
        driver.findElement(addBtn).click();
        driver.findElement(typeField).sendKeys(type);
        driver.findElement(amountField).sendKeys(amount);
        driver.findElement(categoryField).sendKeys(category);
        driver.findElement(submitBtn).click();
    }
}

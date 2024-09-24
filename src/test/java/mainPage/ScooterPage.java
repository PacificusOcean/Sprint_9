package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;
import scooter.Scooter;

public abstract class ScooterPage {

    WebDriver driver;
    WebDriverWait wait;
    Scooter scooter;
    public ScooterPage(WebDriver driver) {
        this.driver = driver;


    }
    @Before
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        scooter = new Scooter(driver);
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("rcc-confirm-button")));
        cookieButton.click();
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрываем браузер после выполнения тестов
        }

    }
}


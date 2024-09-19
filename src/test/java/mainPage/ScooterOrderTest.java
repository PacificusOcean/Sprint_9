package mainPage;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScooterOrderTest {

    private static WebDriver driver;
    private static ScooterPage scooterPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("web driver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        scooterPage = new ScooterPage(driver);
    }
    @Test
    public void testDropdownList() {
        scooterPage.clickDropdownArrow();
        Assert.assertTrue(scooterPage.isDropdownTextDisplayed());
    }
    @Test
    public void testScooterOrder() {
        scooterPage.clickOrderTopButton();
        Assert.assertTrue(scooterPage.isOrderButtonsDisplayed());

        scooterPage.fillOrderForm("John Doe", "johndoe@example.com", "123456789");
        scooterPage.clickOrderButton1();

        Assert.assertTrue(scooterPage.isSuccessMessageDisplayed());
    }
    @Test
    public void testScooterOrderSecondSet() {
        scooterPage.clickOrderBottomButton();

        // Повторяем те же шаги, что и в предыдущем тесте для второго набора данных
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

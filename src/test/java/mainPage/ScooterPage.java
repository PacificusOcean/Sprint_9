package mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScooterPage {

    private WebDriver driver;

    public ScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dropdownArrow = By.xpath("//div[@class='important-questions']//button[@class='dropdown-toggle']");
    private By dropdownText = By.xpath("//div[@class='important-questions']//div[@class='dropdown-menu']");
    private By orderTopButton = By.id("order-top");
    private By orderButton1 = By.xpath("//button[contains(text(), 'Заказать сейчас')]");
    private By orderButton2 = By.xpath("//button[contains(text(), 'Заказать комбо')]");
    private By nameInput = By.id("name");
    private By emailInput = By.id("email");
    private By phoneInput = By.id("phone");
    private By successMessage = By.xpath("//div[@class='order-success']");
    private By orderBottomButton = By.id("order-bottom");

    public void clickDropdownArrow() {
        driver.findElement(dropdownArrow).click();
    }

    public boolean isDropdownTextDisplayed() {
        return driver.findElement(dropdownText).isDisplayed();
    }

    public void clickOrderTopButton() {
        driver.findElement(orderTopButton).click();
    }

    public boolean isOrderButtonsDisplayed() {
        return driver.findElement(orderButton1).isDisplayed() && driver.findElement(orderButton2).isDisplayed();
    }

    public void fillOrderForm(String name, String email, String phone) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void clickOrderButton1() {
        driver.findElement(orderButton1).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public void clickOrderBottomButton() {
        driver.findElement(orderBottomButton).click();
    }


}


//fix branch

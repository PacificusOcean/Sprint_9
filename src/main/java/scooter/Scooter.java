package scooter;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class Scooter {

    private final WebDriver driver;

        // кнопки заказать
        private final By topOrderButton = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");
        private final By downOrderButton = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button[text()='Заказать']");

        //  поля оформление заказа
private final By nameField = By.xpath(".//div[starts-with(@class, 'Input_InputContainer')]/input[contains(@placeholder, 'Имя')]");
private final By lastNameField = By.xpath(".//div[starts-with(@class, 'Input_InputContainer')]/input[contains(@placeholder, 'Фамилия')]");
private final By addressField = By.xpath(".//div[starts-with(@class, 'Input_InputContainer')]/input[contains(@placeholder, 'Адрес')]");
private final By metroField = By.xpath(".//div[@class='select-search__value']/input[contains(@placeholder, 'Станция метро')]");
private final By metroStation = By.xpath(".//div[@class='Order_Text__2broi']/parent::*/parent::*");
private final By phoneField = By.xpath(".//div[starts-with(@class, 'Input_InputContainer')]/input[contains(@placeholder, 'Телефон')]");
private final By nextButton = By.xpath(".//div[starts-with(@class, 'Order_NextButton')]/button[text()='Далее']");

// детали заказа
private final By dateField = By.xpath(".//div[@class='react-datepicker-wrapper']//input[contains(@placeholder, 'Когда привезти самокат')]");
private final By selectDate = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-control']/div[contains(text(), 'Срок аренды')]");
private final By rentalPeriodDropDown = By.xpath(".//div[@class='Dropdown-menu']");
private final By rentalDropDownOption = By.xpath(".//div[@class='Dropdown-option']");
private final By CheckBox = By.xpath(".//div[starts-with(@class, 'Order_Checkboxes')]/label[@for='black']");
private final By orderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать'] ");
private final By modalHeader = By.xpath(".//div[starts-with(@class, 'Order_Modal')]/div[text()='Хотите оформить заказ?']");
private final By buttonYes = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//button[text()='Да']");
private final By orderCompleted = By.xpath(".//div[starts-with(@class, 'Order_ModalHeader') and text()='Заказ оформлен']");
private final By orderHeader = By.xpath(".//div[starts-with(@class, 'Order_Header') and text()='Про аренду']");

//Выпадающий список
        private final By[] questions = {
                By.id("accordion__heading-0"),
                By.id("accordion__heading-1"),
                By.id("accordion__heading-2"),
                By.id("accordion__heading-3"),
                By.id("accordion__heading-4"),
                By.id("accordion__heading-5"),
                By.id("accordion__heading-6"),
                By.id("accordion__heading-7")
        };
        private final By[] answers = {
                By.id("accordion__panel-0"),
                By.id("accordion__panel-1"),
                By.id("accordion__panel-2"),
                By.id("accordion__panel-3"),
                By.id("accordion__panel-4"),
                By.id("accordion__panel-5"),
                By.id("accordion__panel-6"),
                By.id("accordion__panel-7")
        };

    public Scooter(WebDriver driver) {
        this.driver = driver;
}
  //клик по кнопкам
        public Scooter clickTopOrderButton() {
            driver.findElement (topOrderButton).click();
            return new Scooter (driver);
        }
        public Scooter clickDownOrderButton () {
            driver.findElement(downOrderButton).click();
            return new Scooter (driver);

        }

// клик на вопрос
        public void clickOnQuestion(int index) {
            driver.findElement(questions[index]).click();
        }
//получить текст ответа
        public String getAnswerText(int index) {
            return driver.findElement(answers[index]).getText();
        }
// вводим текст
    private void putText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void setNameField(String name) {
        putText(driver.findElement(nameField), name);
    }
    public void setLastNameField(String name) {
        putText(driver.findElement(lastNameField), name);
    }
    public void setAddressField(String address) {
        putText(driver.findElement(addressField), address);
    }
    public void setMetroField(String metro) {
        putText(driver.findElement(metroField), metro);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(metroStation));
        WebElement element = driver.findElement(metroStation);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    public void setPhoneField(String phone) {
        putText(driver.findElement(phoneField), phone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void setDateField(String date) {
        putText(driver.findElement(dateField), date);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(selectDate));
        WebElement element = driver.findElement(selectDate);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.sendKeys(Keys.ENTER);
    }

    public void choiceRentPeriod(String period) {
        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(rentalPeriodDropDown));
        List<WebElement> dropDownItems = driver.findElement(rentalPeriodDropDown).findElements(rentalDropDownOption);
        for (WebElement element : dropDownItems) {
            System.out.println(element.getText());
            if (element.getText().equals(period)) {
                element.click();
                break;

            }
        }
    }

    public void selectCheckbox() {
        driver.findElement(CheckBox).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();

    }
    public boolean isWindowOrderVisible() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(modalHeader));
        return driver.findElement(modalHeader).isDisplayed();
    }
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    public boolean isOrderCompleted() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderCompleted));
        return driver.findElement(orderHeader).isDisplayed();
    }


        }

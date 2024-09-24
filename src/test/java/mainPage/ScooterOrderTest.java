package mainPage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import scooter.Scooter;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)

public class ScooterOrderTest extends ScooterPage{

    private static WebDriver driver;
    private static ScooterPage scooterPage;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;


        public ScooterOrderTest( String name, String lastName, String address, String metro, String phone, String date, String period) {
        super(driver);
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;

    }
    @Parameterized.Parameters // Тестовые данные
    public static Object[][] orderButton() {
        return new Object[][]{
                {"Семён", "Семёныч", "Усачева", "Вернадского", "89112111111", "25.09.2024", "сутки"},
                {"Егор", "Егорыч", "Берег", "Университет", "89112111122", "25.09.2024", "двое суток"}
        };
    }
    @Test
    public void checkOrderByUpButton() {
        scooter = scooter.clickTopOrderButton();
        scooter1(scooter);
    }
    @Test
    public void checkOrderByDownButton() {
        scooter = scooter.clickDownOrderButton();
        scooter1(scooter);
    }


    private void scooter1(Scooter scooter) {

        scooter.setNameField(name);
        scooter.setLastNameField(lastName);
        scooter.setAddressField(address);
        scooter.setMetroField(metro);
        scooter.setPhoneField(phone);

        scooter.clickNextButton();
        scooter.setDateField(date);
        scooter.choiceRentPeriod(period);
        scooter.selectCheckbox();
        scooter.clickOrderButton();
        assertTrue(scooter.isWindowOrderVisible()); // Подтверждение заказа
        scooter.clickButtonYes();
        assertTrue( scooter.isOrderCompleted());
    }
}

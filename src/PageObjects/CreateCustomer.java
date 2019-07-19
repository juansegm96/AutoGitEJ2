package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomer {

    WebDriver driver;
    By newCustomer = By.xpath("/html/body/div[3]/div/ul/li[2]/a");
    By custName = By.name("name");
    By gender = By.name("rad1");
    By date = By.id("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By telephone = By.name("telephoneno");
    By email = By.name("emailid");
    By password = By.name("password");
    By submit = By.name("sub");

    public CreateCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewCustomer() {
        driver.findElement(newCustomer).click();
    }

    public void setName(String strName) {
        driver.findElement(custName).sendKeys(strName);
    }

    public void setGender() {
        driver.findElement(gender).click();
    }

    public void setDate(String strDate) {
        driver.findElement(date).sendKeys(strDate);
    }

    public void setAddress(String strAddress) {
        driver.findElement(address).sendKeys(strAddress);
    }

    public void setCity(String strCity) {
        driver.findElement(city).sendKeys(strCity);
    }

    public void setState(String strState) {
        driver.findElement(state).sendKeys(strState);
    }

    public void setPin(String strPin) {
        driver.findElement(pin).sendKeys(strPin);
    }

    public void setTelephone(String strTelephone) {
        driver.findElement(telephone).sendKeys(strTelephone);
    }

    public void setEmail(String strEmail) {
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setPassword(String strpassword) {
        driver.findElement(password).sendKeys(strpassword);
    }

    public void submit() {
        driver.findElement(submit).click();
    }

    public void Register(String strName, String strDate, String strAddress, String strCity, String strState, String strPin, String strTelephone, String strEmail, String strpassword) {
        this.clickNewCustomer();
        this.setName(strName);
        this.setGender();
        this.setDate(strDate);
        this.setAddress(strAddress);
        this.setCity(strCity);
        this.setState(strState);
        this.setPin(strPin);
        this.setTelephone(strTelephone);
        this.setEmail(strEmail);
        this.setPassword(strpassword);
        this.submit();
    }
}

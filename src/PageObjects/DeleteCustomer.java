package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class DeleteCustomer {

    WebDriver driver;
    By deleteCustomer = By.xpath("/html/body/div[3]/div/ul/li[4]/a");
    By customerID = By.name("cusid");
    By submit = By.name("AccSubmit");
    public static String AlertC = "";

    public DeleteCustomer(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteCustomer() {
        driver.findElement(deleteCustomer).click();
    }

    public void setCusID(String strCusID) {
        driver.findElement(customerID).sendKeys(strCusID);
    }

    public void submitC() throws NoAlertPresentException, InterruptedException {
        driver.findElement(submit).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert = driver.switchTo().alert();
        AlertC = driver.switchTo().alert().getText();
        alert.accept();
    }

    public void borrarCustomer(String strCusID) throws NoAlertPresentException, InterruptedException {
        this.clickDeleteCustomer();
        this.setCusID(strCusID);
        this.submitC();
    }
}

package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class DeleteAccount {

    WebDriver driver;
    By deleteAccount = By.xpath("/html/body/div[3]/div/ul/li[7]/a");
    By accountID = By.name("accountno");
    By submit = By.name("AccSubmit");
    public static String AlertA = "";

    public DeleteAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccount).click();
    }

    public void setAccID(String strAccID) {
        driver.findElement(accountID).sendKeys(strAccID);
    }

    public void submitA() throws NoAlertPresentException, InterruptedException {
        driver.findElement(submit).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert = driver.switchTo().alert();
        AlertA = driver.switchTo().alert().getText();
        alert.accept();
    }

    public void borrarCuenta(String strAccID) throws NoAlertPresentException, InterruptedException {
        this.clickDeleteAccount();
        this.setAccID(strAccID);
        this.submitA();
    }
}

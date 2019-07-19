package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
    WebDriver driver;
    By newAccount = By.xpath("/html/body/div[3]/div/ul/li[5]/a");
    By custID = By.name("cusid");
    By accType = By.name("selaccount");
    By initialDeposit = By.name("inideposit");
    By submit = By.name("button2");
    
    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewAccount() {
        driver.findElement(newAccount).click();
    }

    public void setID(String strID) {
        driver.findElement(custID).sendKeys(strID);
    }

    public void setAccType() {
        Select optAccType = new Select(driver.findElement(accType));
        optAccType.selectByVisibleText("Current");
    }

    public void setInitDeposit(String strInitDeposit) {
        driver.findElement(initialDeposit).sendKeys(strInitDeposit);
    }
    
    public void submit() {
        driver.findElement(submit).click();
    }
    
    public void accountRegister(String strID, String strInitDeposit) {
        this.clickNewAccount();
        this.setID(strID);
        this.setAccType();
        this.setInitDeposit(strInitDeposit);
        this.submit();
    }
}

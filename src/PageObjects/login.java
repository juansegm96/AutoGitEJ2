package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {

    WebDriver driver;
    By userName = By.name("uid");
    By password = By.name("password");
    By signIn = By.name("btnLogin");

    public login(WebDriver driver) {

        this.driver = driver;

    }

    public void setUserName(String strUserName) {

        driver.findElement(userName).sendKeys(strUserName);

    }

    public void setPassword(String strPassword) {

        driver.findElement(password).sendKeys(strPassword);

    }

    public void clickLogin() {

        driver.findElement(signIn).click();

    }

    public void loginApplication(String userName, String password) {

        this.setUserName(userName);

        this.setPassword(password);

        this.clickLogin();
    }
}

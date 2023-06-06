package html.demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    String nameLocator = "input1";
    String passwordLocator = "input2";
    String humanLocator = "input3";
    String btnSubmitLocator = "enter";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage fillName(String name) {
        WebElement inputName = driver.findElement(By.id(nameLocator));
        inputName.sendKeys(name);
        return this;
    }

    public LoginPage fillPWD(String password) {
        WebElement inputPWD = driver.findElement(By.id(passwordLocator));
        inputPWD.sendKeys(password);
        return this;
    }

    public LoginPage clickHuman() {
        WebElement inputHuman = driver.findElement(By.id(humanLocator));
        inputHuman.click();
        return this;
    }

    public LoginPage clickSubmitBtn() {
        WebElement buttonSubmit = driver.findElement(By.id(humanLocator));
        buttonSubmit.click();
        return this;
    }
}


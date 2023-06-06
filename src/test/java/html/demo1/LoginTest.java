package html.demo1;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.get("file:///C:/HTML%20files/LeonidVladislawTatjana.html");
    }

    @Test
    public void testLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillName("Borys").fillPWD("fhgr566g").clickHuman().clickSubmitBtn();
        Assertions.fail();
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}

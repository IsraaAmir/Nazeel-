package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120000));

    By username = By.id("usern");
    By password = By.id("pass");
    By accessCode = By.id("acc");
    By loginButton = By.cssSelector("button.n-button.n-button--primary");

    public void login(String user, String pass,String code) throws InterruptedException {
       type(username,user);
       type(password,pass);
       type(accessCode,code);

       Thread.sleep(20000);

       click(loginButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.//span[normalize-space()='Later']]")));
    }
}

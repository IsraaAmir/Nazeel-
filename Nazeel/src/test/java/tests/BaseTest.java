package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app-simulation.nazeel.net/login");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}


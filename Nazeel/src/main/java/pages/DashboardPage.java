package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DashboardPage extends BasePage{
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    By laterBtn = By.xpath("//button[.//span[normalize-space()='Later']]");
    By closeButton = By.xpath("//button[normalize-space()='Close']");
    By reservationMenu = By.xpath("//span[normalize-space()='Reservations']");

    public void handlePopups(){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(laterBtn));
            click(laterBtn);
        //    click(closeButton);
        } catch (Exception ex) {}
    }
    public void openReservationPage(){
        click(reservationMenu);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='New Reservation']")));
    }


}

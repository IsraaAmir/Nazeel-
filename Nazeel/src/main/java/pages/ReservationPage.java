package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReservationPage extends BasePage {
    public ReservationPage(WebDriver driver){
        super(driver);
    }

    By NewReservation = By.xpath("//button[normalize-space()='New Reservation']");
    By visitPurpose = By.xpath("//span[contains(text(),'Select visit purpose')]/ancestor::span[contains(@class,'k-dropdown-wrap')]");
    By reservationSource = By.xpath("//span[contains(@class,'k-dropdown-wrap')][.//div[contains(text(),'Select reservation source')]]");
    By selectUnitBtn = By.xpath("//div[contains(@class,'n-table__no-data-msg')]//span[normalize-space()='Select unit now']");
    By loadMoreBtn = By.className("Load_More");
    By unitCard = By.xpath("//p[contains(@class,'unit-card__no') and normalize-space(text())='17']/ancestor::div[contains(@class,'unit-card')]");
    By confirmUnit = By.xpath("//h3[text()='Confirmation Title']/following-sibling::button[contains(@class, 'button--primary') and .//span[text()='Confirm']]");

    By selectGuestBtn = By.xpath("//span[normalize-space()='Select guest now']");
    By guestIdField = By.xpath("//input[@placeholder='ID Number']");
    By guestRecord = By.xpath("//span[normalize-space()='+NewGuest']");

    By confirmBtn2 = By.xpath("//button[contains(@class,'n-button--primary') and normalize-space()='Confirm']");

    By checkInBtn = By.xpath("//button[.//use[contains(@xlink:href,'icon-checkin')]]");
    By checkInBtn2 = By.cssSelector("button.button.button--primary");

    By successMsg = By.xpath("//*[contains(text(),'success')]");

    public void addReservation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));

        click(NewReservation);
        wait.until(ExpectedConditions.visibilityOfElementLocated(visitPurpose));

        // Visit Purpose
        click(visitPurpose);
        By firstVisitPurposeOption = By.cssSelector("ul.k-list li:first-child");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstVisitPurposeOption));
        click(firstVisitPurposeOption);

        // Reservation Source
       // click(reservationSource);
        By firstReservationSourceOption = By.cssSelector("ul.k-list li:first-child");
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(reservationSource));
        dropdown.click();
        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstReservationSourceOption));
        firstOption.click();

        WebElement selectUnit = wait.until(ExpectedConditions.elementToBeClickable(selectUnitBtn));
        selectUnit.click();

        WebElement loadMore = wait.until(ExpectedConditions.elementToBeClickable(loadMoreBtn));
        actions.moveToElement(loadMore).click().perform();

        // Wait for units to load

// Hover over unit 17
        WebElement card = driver.findElement(unitCard);
        hover(unitCard);
        // Wait for the card to be clickable
        // Click the unit card
        card.click();

// Locator for the Confirm butto wait.until(ExpectedConditions.visibilityOfElementLocated(unitCard));n
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(confirmUnit));
        confirmButton.click();        //click(unitCard);

       // click(confirmUnit);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectGuestBtn));
        click(selectGuestBtn);

        type(guestIdField, "123456789");

        hover(guestRecord);

        click(confirmBtn2);

        click(checkInBtn);
        wait.until(ExpectedConditions.elementToBeClickable(checkInBtn2));
        click(checkInBtn2);

    }

    public Boolean isReservationCreated(){
        return driver.findElement(successMsg).isDisplayed();
    }
}

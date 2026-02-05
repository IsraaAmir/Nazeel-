package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddReservationTest extends BaseTest {

    @Test
    public void createNewReservation() throws InterruptedException {

        LoginPage login  = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        ReservationPage reservation = new ReservationPage(driver);

        login.login("IsraaMohamed" , "Im&123456" , "01373");
        dashboard.handlePopups();
        dashboard.openReservationPage();
        reservation.addReservation();

        Assert.assertTrue(reservation.isReservationCreated(),
                "Reservation was not created successfully");

    }
}

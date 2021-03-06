package regression.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import page_objects.abh_restaurant.LoginPage;
import page_objects.abh_restaurant.Registration;
import page_objects.abh_restaurant.UserDetails;
import testUtils.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginNegativeEmail extends TestBase {
    private static final String FIRST_NAME = "Alice";
    private static final String LAST_NAME = "Lopez";
    private static final String EMAIL = "alic1@live.com";
    private static final String PHONE_NUMBER = "12345";
    private static final String ADDRESS = "Pijacna 118";
    private static final String PASSWORD = "1234";
    private static final String INVALID_EMAIL = "malimis@gmail.com";
    private static final String USERNAME_TEXT = "Alice Lopez";


    SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmm");
    Date date = new Date();

    @Test(priority = 0)
    public void openLogInPage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 1)
    public void openRegistrationPage() {
        new LoginPage(driver)
                .clickRegisterButton();
    }

    @Test(priority = 2)
    public void populateRegistrationForm() {
        new Registration(driver)
                .makeRegistration(FIRST_NAME, LAST_NAME, formatter.format(date)+EMAIL, PHONE_NUMBER, ADDRESS, PASSWORD, PASSWORD);
    }

    @Test(priority = 3)
    public void checkUserIsRegistered(){
        Assert.assertTrue(new HomePage(driver)
                .checkUsernameText(USERNAME_TEXT));
    }

    @Test(priority = 4)
    public void openUserDetails() {
        new HomePage(driver)
                .clickUserDetails(2);
    }

    @Test(priority = 5)
    public void logOut() {
        new UserDetails(driver)
                .clickLogoutButton();
        driver.get("https://abh-restaurants-dev-days.herokuapp.com/");
    }


    @Test(priority = 6)
    public void openLoginPage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 7)
    public void loginToRestaurantsPage() {
        new LoginPage(driver)
                .loginToRestaurants(INVALID_EMAIL, PASSWORD);
    }

    @Test(priority = 8)
    public void checkUserLoginIsSuccessful(){
        Assert.assertTrue(new HomePage(driver)
                .checkUsernameText(USERNAME_TEXT));
    }

    @Test(priority = 9)
    public void checkErrorMessage(){
        Assert.assertTrue(new LoginPage(driver)
                .checkErrorMessage());
    }
}

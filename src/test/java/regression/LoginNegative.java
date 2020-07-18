package regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import page_objects.abh_restaurant.LoginPage;
import page_objects.abh_restaurant.Registration;
import page_objects.abh_restaurant.UserDetails;
import testUtils.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginNegative extends TestBase {

    private static final String FIRST_NAME = "Alice";
    private static final String LAST_NAME = "Lopez";
    private static final String EMAIL = "alic6@live.com";
    private static final String PHONE_NUMBER = "12345";
    private static final String ADDRESS = "Pijacna 118";
    private static final String PASSWORD = "1234";
    private static final String USERNAME_TEXT = "Alice Lopez";
    private static final String NONEXISTENT_EMAIL = "void@live.com";
    private static final String INCORRECT_PASSWORD = "12";


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
    public void loginWithFalseEmail() {
        new LoginPage(driver)
                .loginToRestaurants(NONEXISTENT_EMAIL, PASSWORD);
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

    @Test(priority = 10)
    public void clearInputs() {
        new LoginPage(driver)
                .clearInputs();
    }

    @Test(priority = 11)
    public void openLogINPage() {
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 12)
    public void loginWithIncorrectPassword() {
        new LoginPage(driver)
                .loginToRestaurants(EMAIL, INCORRECT_PASSWORD);
    }

    @Test(priority = 13)
    public void checkUserLogInIsSuccessful(){
        Assert.assertTrue(new HomePage(driver)
                .checkUsernameText(USERNAME_TEXT));
    }

}

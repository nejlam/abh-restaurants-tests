package regression.registration;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import page_objects.abh_restaurant.LoginPage;
import page_objects.abh_restaurant.Registration;
import page_objects.abh_restaurant.UserDetails;
import testUtils.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPositive extends TestBase {
    private static final String FIRST_NAME = "Alice";
    private static final String LAST_NAME = "Lopez";
    private static final String EMAIL = "alic6@live.com";
    private static final String PHONE_NUMBER = "12345";
    private static final String ADDRESS = "Pijacna 118";
    private static final String PASSWORD = "1234";
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
    public void registerWithIncorrectEmail() {
        new Registration(driver)
                .makeRegistration(FIRST_NAME, LAST_NAME, formatter.format(date)+EMAIL, PHONE_NUMBER, ADDRESS, PASSWORD, PASSWORD);
    }

    @Test(priority = 3)
    public void checkUserIsRegistered(){
        Assert.assertTrue(new HomePage(driver)
                .checkUsernameText(USERNAME_TEXT));
    }

    @Test(priority = 4)
    public void checkNoErrorMessage(){
        Assert.assertFalse(new Registration(driver)
                .checkErrorMessage());
    }

}

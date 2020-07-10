package regression;

import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import page_objects.abh_restaurant.LoginPage;
import testUtils.TestBase;

public class AddRestaurant extends TestBase {

    private static final String USERNAME_TEXT = "Admin";


    @Test(priority = 0)
    public void openLoginPage(){
        new HomePage(driver)
                .getLoginButton().click();
    }

    @Test(priority = 1)
    public void loginAdmin(){
        new LoginPage(driver)
                .loginToRestaurants("admin@example.com", "admin");
    }

    @Test(priority = 2)
    public void checkUserLoginIsSuccessful(){
        Assert.assertTrue(new HomePage(driver)
                .checkUsernameText(USERNAME_TEXT));
    }

    @Test(priority = 3)
    public void openAdminPage(){
        new HomePage(driver)
                .clickLoginButton(2);
    }

    @Test(priority = 4)
    public void clickAddRestaurant(){

    }

}

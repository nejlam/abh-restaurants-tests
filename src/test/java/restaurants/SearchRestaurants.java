package restaurants;

import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import page_objects.abh_restaurant.Restaurants;
import testUtils.TestBase;

public class SearchRestaurants extends TestBase {

    private static final String SEARCH_EXISTING = "Friends";
    private static final String SEARCH_NONEXISTING = "Mali Mrav";


    @Test(priority = 0)
    public void openRestaurantsHomePage() {
        new HomePage(driver)
                .openRestaurantsPage(1);
    }

    @Test(priority = 1)
    public void searchForARestaurant(){
        new Restaurants(driver)
            .getSearchButton().sendKeys(SEARCH_EXISTING);
    }


}

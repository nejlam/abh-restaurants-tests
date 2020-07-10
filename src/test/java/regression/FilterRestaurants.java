package regression;

import org.testng.annotations.Test;
import page_objects.abh_restaurant.HomePage;
import testUtils.TestBase;

public class FilterRestaurants extends TestBase {


    @Test(priority = 0)
    public void openRestaurantsHomePage() {
        new HomePage(driver)
                .openRestaurantsPage(1);
    }

    //odaberi Sort By Name

    //odaberi sort by Prize

    //Odaberi sort by rating

    //Odaberi Filter By

}

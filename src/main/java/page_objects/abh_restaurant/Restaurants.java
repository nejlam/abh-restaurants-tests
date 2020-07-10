package page_objects.abh_restaurant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

public class Restaurants extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurants\\d*";

    final static private String SEARCH_INPUT_ID = "search";
    final static private String SORT_DROPDOWN_XPATH = "//*[@id=\"ember9\"]/div/div[1]/div/form/button[1]";
    final static private String FILTER_DROPDOWN_XPATH = "//*[@id=\"ember9\"]/div/div[1]/div/form/button[1]";
    final static private String RESERVE_BUTTON_CSS = "button[class*='reserve-now-button']";

    final static private String FIRST_RESTAURANT_XPATH = "//*[@id=\"ember459\"]";




    public Restaurants(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(id = SEARCH_INPUT_ID)
    private WebElement getSearchButton;

    @FindBy(id = SORT_DROPDOWN_XPATH)
    private WebElement getSortDropDown;

    @FindBy(id = FILTER_DROPDOWN_XPATH)
    private WebElement getFilterDropDown;

    @FindBy(css = RESERVE_BUTTON_CSS)
    private WebElement getReserveButton;


    public WebElement getSearchButton() {
        return getSearchButton;
    }

    public WebElement getSortDropDown() {
        return getSortDropDown;
    }

    public WebElement getFilterDropDown() {
        return getFilterDropDown;
    }

    public WebElement getReserveButton(){
        return getReserveButton;
    }

    public Restaurant reserveRestaurant(){
        //WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class*='reserve-now-button']")));
        getReserveButton().click();
        return new Restaurant(getDriver());
    }


}

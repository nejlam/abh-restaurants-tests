package page_objects.abh_restaurant;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;
import java.util.List;

public class HomePage extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/";

    final static private String NAV_BAR_LIST_CSS = "#bs-example-navbar-collapse-1 > ul > li >a";
    final static private String MAIN_TEXT_CSS = "#main > div > div > h1";
    final static private String LOGGED_USER_TEXT_ID = "ember223";
    final static private String LOGIN_BUTTON_CSS = "ember38";




    public HomePage(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }


    @FindBy(css = NAV_BAR_LIST_CSS)
    private List<WebElement> navBarList;

    @FindBy(css = MAIN_TEXT_CSS)
    private WebElement mainText;

    @FindBy(id = LOGGED_USER_TEXT_ID)
    private WebElement loggedUser;

    @FindBy(css = LOGIN_BUTTON_CSS)
    private WebElement loginButton;

    public List<WebElement> getNavBarList(){
        return navBarList;
    }

    public WebElement getMainText(){
        return mainText;
    }

    public WebElement getLoggedUser(){
        return loggedUser;
    }

    public WebElement getLoginButton(){
        return loginButton;
    }



    public LoginPage clickLoginButton(int index){
       // WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //wait.until(ExpectedConditions.elementToBeClickable(getLoginButton()));

        getNavBarList().get(index).click();
        return new LoginPage(getDriver());
    }

    public Restaurants openRestaurantsPage(int index){
        getNavBarList().get(index).click();
        return new Restaurants(getDriver());
    }

    public UserDetails clickUserDetails(int index){
        getNavBarList().get(index).click();
        return new UserDetails(getDriver());
    }

    public Boolean checkMainText(String headerText){
        return headerText.equals(getMainText().getText());
    }

    public Boolean checkUsernameText(String usernameText){
        return usernameText.equals(getLoggedUser().getText());
    }

    public void verifyLoggedOut() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li:nth-child(3)")));

    }

    public void verifyLoginIn() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
       // wait.until(ExpectedConditions.urlMatches("/login"));
        wait.until(ExpectedConditions.urlToBe("/login"));
    }

    public HomePage openHomePage(){
        return new HomePage(getDriver());
    }

}

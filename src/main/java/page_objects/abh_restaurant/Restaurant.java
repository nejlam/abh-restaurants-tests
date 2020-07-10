package page_objects.abh_restaurant;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.PageBase;

import java.net.BindException;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;

public class Restaurant extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/restaurant\\d*";
    final static private String PEOPLE_DROPDOWN_CSS = "form[class='reservation-form'] select";
     final static private String DATE_INPUT_XPATH = "/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/input[1]";
     final static private String TIME_INPUT_XPATH = "/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/input[2]";
     final static private String SUBMIT_BUTTON_XPATH = "/html/body/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/input[2]";

    final static private String RESERVATION_FORM_CSS = "form.reservation-form";




    public Restaurant(WebDriver driver) {
        super(driver, PAGE_URL_REGEX);
        initElements();
    }

    @FindBy(id = RESERVATION_FORM_CSS)
    private List<WebElement> getReservationForm;

    @FindBy(css = PEOPLE_DROPDOWN_CSS)
    private WebElement getPeopleDropDown;

        @FindBy(xpath = DATE_INPUT_XPATH)
        private WebElement getDateInput;

        @FindBy(xpath = TIME_INPUT_XPATH)
        private WebElement getTimeInput;

        @FindBy(xpath = SUBMIT_BUTTON_XPATH)
        private WebElement getSubmitButton;


    public List<WebElement> getReservationForm() {
        return getReservationForm;
    }

    public WebElement getPeopleDropDown() {
        return getPeopleDropDown;
    }

        public WebElement getDateInput() {
            return getDateInput;
        }

        public WebElement getTimeInput() {
            return getTimeInput;
        }

        public WebElement getSubmitButton() {
            return getSubmitButton;
        }

    //dropdown
    public void selectFromDropdown(String option){
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOption(){
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
        return new Select(getPeopleDropDown());
    }

    //get form option
    public void clickOnFormOption(int index){
        getReservationForm().get(index).click();
    }

    public void selectOptions(String option, String date, String time){
        selectFromDropdown("2 People");
        WebElement datePick = getDateInput();
        WebElement timePick = getTimeInput();
        datePick.sendKeys(date);
        timePick.sendKeys(time);
        getSubmitButton().click();
    }
}

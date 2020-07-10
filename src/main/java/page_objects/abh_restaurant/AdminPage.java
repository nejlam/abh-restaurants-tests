package page_objects.abh_restaurant;

import page_objects.PageBase;

public class AdminPage extends PageBase {
    final static private String PAGE_URL_REGEX = "\\/admin\\d*";
    final static private String CREATE_ACCOUNT_BUTTON_CSS = "form[class = 'login-register-form'] div h5 a[href= '/register']";
    final static private String USER_NAVBAR_XPATH = "\\/admin\\d*";

}

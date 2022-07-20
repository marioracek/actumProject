package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPO {

    WebDriver driver;

    By heading = By.className("page-heading");
    By breadcrumbs = By.className("navigation_page");
    By subHeadingRegistration = By.className("page-subheading");
    By enterEmailText = By.cssSelector(".form_content.clearfix");
    By emailText = By.cssSelector(".form-group.form-error");
    By emailInput = By.id("email_create");
    By alertError = By.cssSelector(".alert.alert-danger");
    By createButton = By.id("SubmitCreate");


    By gender1 = By.id("id_gender1");
    By gender2 = By.id("id_gender2");
    By firstNameInput = By.id("customer_firstname");
    By lastNameInput = By.id("customer_lastname");
    By email = By.id("email");
    By password = By.id("passwd");
    By newsletter = By.id("newsletter");
    By offers = By.id("optin");
    By firstNameAddress = By.id("firstname");
    By lastNameAddress = By.id("lastname");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By city = By.id("city");
    By postcode = By.id("postcode");
    By phone = By.id("phone");
    By phoneMobile = By.id("phone_mobile");
    By alias = By.id("alias");

    public RegistrationPO(WebDriver driver) {
        this.driver = driver;
    }
}

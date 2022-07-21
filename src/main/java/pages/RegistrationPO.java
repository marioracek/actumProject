package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPO {

    WebDriver driver;

    By signInElement = By.className("login");
    By headingElement = By.className("page-heading");
    By breadcrumbsElement = By.className("navigation_page");
    By subHeadingRegistrationElement = By.className("page-subheading");
    By enterEmailTextElement = By.cssSelector(".form_content.clearfix");
    By emailTextElement = By.cssSelector(".form-group.form-error");
    By emailInputElement = By.id("email_create");
    By alertErrorElement = By.cssSelector(".alert.alert-danger");
    By createButtonElement = By.id("SubmitCreate");


    By gender1Element = By.id("id_gender1");
    By gender2Element = By.id("id_gender2");
    By firstNameInputElement = By.id("customer_firstname");
    By lastNameInputElement = By.id("customer_lastname");
    By yearElement = By.id("years");
    By monthElement = By.id("months");
    By dayElement = By.id("days");
    By passwordElement = By.id("passwd");
    By newsletterElement = By.id("newsletter");
    By offersElement = By.id("optin");
    By firstNameAddressElement = By.id("firstname");
    By lastNameAddressElement = By.id("lastname");
    By address1Element = By.id("address1");
    By address2Element = By.id("address2");
    By cityElement = By.id("city");
    By countrySelectElement = By.id("id_country");
    By stateSelectElement = By.id("id_state");
    By additionalInfoElement = By.id("other");
    By postcodeElement = By.id("postcode");
    By phoneElement = By.id("phone");
    By phoneMobileElement = By.id("phone_mobile");
    By aliasReferenceElement = By.id("alias");
    By registerButtonElement = By.id("submitAccount");

    public RegistrationPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSignIn() {
        driver.findElement(signInElement).click();
    }

    public String getBreadcrumbsText() {
        return driver.findElement(breadcrumbsElement).getText();
    }

    public String getHeadingText() {
        return driver.findElement(headingElement).getText();
    }

    public String getSubHeadingText() {
        return driver.findElement(subHeadingRegistrationElement).getText();
    }

    public void enterEmailCreateAccount(String email) {
        driver.findElement(emailInputElement).sendKeys(email);
    }

    public void clickCreateAnAccount() {
        driver.findElement(createButtonElement).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registerButtonElement).click();
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameInputElement).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameInputElement).sendKeys(lastName);
    }

    public void enterPassword(String pwd) {
        driver.findElement(passwordElement).sendKeys(pwd);
    }

    public void enterDateOfBirth(String yearToSelect, String monthToSelect, String dayToSelect) {
        Select selectYear = new Select(driver.findElement(yearElement));
        selectYear.selectByValue(yearToSelect);

        Select selectMonth = new Select(driver.findElement(monthElement));
        selectMonth.selectByValue(monthToSelect);

        Select selectDay = new Select(driver.findElement(dayElement));
        selectDay.selectByValue(dayToSelect);
    }

    public void checkNewsletter() {
        driver.findElement(newsletterElement).click();
    }

    public void checkSpecialOffer() {
        driver.findElement(offersElement).click();
    }

    public void enterFirstNameAddress(String firstName) {
        driver.findElement(firstNameAddressElement).sendKeys(firstName);
    }

    public void enterLastNameAddress(String lastName) {
        driver.findElement(lastNameAddressElement).sendKeys(lastName);
    }

    public void enterAddressLine1(String address) {
        driver.findElement(address1Element).sendKeys(address);
    }

    public void enterAddressLine2(String address) {
        driver.findElement(address2Element).sendKeys(address);
    }

    public void enterCity(String cityToEnter) {
        driver.findElement(cityElement).sendKeys(cityToEnter);
    }

    public void selectCountry(String value) {
        Select countryToSelect = new Select(driver.findElement(countrySelectElement));
        countryToSelect.selectByValue(value);
    }

    public void selectState(String value) {
        Select countryToSelect = new Select(driver.findElement(stateSelectElement));
        countryToSelect.selectByValue(value);
    }

    public void enterAdditionalInfo(String info) {
        driver.findElement(additionalInfoElement).sendKeys(info);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneElement).sendKeys(phone);
    }

    public void enterMobilePhone(String mobilePhone) {
        driver.findElement(phoneMobileElement).sendKeys(mobilePhone);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postcodeElement).sendKeys(postalCode);
    }

    public void enterGender(String gender) {
        switch (gender) {
            case "Mr.":
                driver.findElement(gender1Element).click();
                break;
            case "Mrs.":
                driver.findElement(gender2Element).click();
                break;
            default:
                break;
        }
    }

    public void enterAliasReference(String reference) {
        driver.findElement(aliasReferenceElement).sendKeys(reference);
    }
}

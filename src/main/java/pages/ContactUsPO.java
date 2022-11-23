package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPO {

    WebDriver driver;

    //TODO test commit email
    By emailInput = By.id("email");
    By contactLink = By.id("contact-link");
    By orderReferenceInput = By.id("id_order");
    By subjectHeadingInput = By.id("id_contact");
    By sendButton = By.id("submitMessage");
    By messageInput = By.id("message");
    By heading = By.cssSelector(".page-heading.bottom-indent");
    By breadcrumbs = By.className("navigation_page");
    By alertError = By.cssSelector(".alert.alert-danger");
    By alertSuccess = By.cssSelector(".alert.alert-success");

    public ContactUsPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnContactUs() {
        driver.findElement(contactLink).click();
    }

    public void clickOnSubmitButton() {
        driver.findElement(sendButton).click();
    }

    public String getAlertErrorText() {
        return driver.findElement(alertError).getText();
    }

    public String getAlertSuccessText() {
        return driver.findElement(alertSuccess).getText();
    }

    public void selectSubjectHeading(String value) {
        Select dropdown = new Select(driver.findElement(subjectHeadingInput));
        dropdown.selectByValue(value);
    }

    public void enterOrderReference(String message) {
        driver.findElement(orderReferenceInput).sendKeys(message);
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void enterEmailAddress(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getBreadcrumbsText() {
        return driver.findElement(breadcrumbs).getText();
    }
}

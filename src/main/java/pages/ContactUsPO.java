package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPO {

    WebDriver driver;

    By emailInput = By.id("email");
    By orderReferenceInput = By.id("id_order");
    By subjectHeadingInput = By.id("uniform-id_contact");
    By sendButton = By.id("submitMessage");
    By messageInput = By.id("message");
    By heading = By.cssSelector(".page-heading.bottom-indent");
    By breadcrumbs = By.className("navigation_page");
    By alertError = By.cssSelector(".alert.alert-danger");
    By alertSuccess = By.cssSelector(".alert.alert-success");
    By form = By.className("contact-form-box");

    public ContactUsPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterMessage(String message) {
        driver.findElement(messageInput).sendKeys(message);
    }

    public void enterEmailAddress(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
}

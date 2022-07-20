package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ContactUsPO {

    WebDriver driver;

    By emailInput = By.id("email");
    By orderReferenceInput = By.id("id_order");
    By subjectHeadingInput = By.id("uniform-id_contact");
    By sendButton = By.id("submitMessage");
    By messageInput = By.id("message");
    By heading = By.className("page-heading bottom-indent");
    By breadcrumbs = By.className("navigation_page");
    By alertError = By.className("alert alert-danger");
    By alertSuccess = By.className("alert alert-success");
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

    public void assertAlertSuccess() {
        String message = driver.findElement(alertSuccess).getText();
        assertEquals(message, "TODO");
    }

    public void assertAlertError() {
        String message = driver.findElement(alertError).getText();
        assertEquals(message, "TODO");
    }

    public void assertCorrectPage() {
        String title = driver.findElement(heading).getText();
        String breadcrumbsText = driver.findElement(breadcrumbs).getText();
        assertEquals(title, "TODO");
        assertEquals(breadcrumbsText, "TODO");
    }
}

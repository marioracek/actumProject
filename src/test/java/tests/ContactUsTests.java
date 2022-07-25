package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ContactUsPO;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class ContactUsTests {

    WebDriver driver;
    ContactUsPO contactUsPO;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void testEmptyFormAndCheckPage() {
        contactUsPO = new ContactUsPO(driver);
        contactUsPO.clickOnContactUs();
        assertTrue(contactUsPO.getHeadingText().contains("CUSTOMER SERVICE - CONTACT US"), "Heading has correct text");
        assertTrue(contactUsPO.getBreadcrumbsText().contains("Contact"), "Breadcrumbs have correct text");
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("submitMessage")));
        contactUsPO.clickOnSubmitButton();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-danger")));
        assertEquals(contactUsPO.getAlertErrorText(), "There is 1 error\n" + "Invalid email address.", "Error message equals");
    }

    @Test
    public void testCorrectlyFilledForm() {
        contactUsPO = new ContactUsPO(driver);
        contactUsPO.clickOnContactUs();
        assertTrue(contactUsPO.getHeadingText().contains("CUSTOMER SERVICE - CONTACT US"), "Heading has correct text");
        assertTrue(contactUsPO.getBreadcrumbsText().contains("Contact"), "Breadcrumbs have correct text");
        contactUsPO.enterOrderReference("12345");
        contactUsPO.enterEmailAddress("mario.racek@gmail.com");
        contactUsPO.enterMessage("Testing message");
        contactUsPO.selectSubjectHeading("2");
        contactUsPO.clickOnSubmitButton();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));
        assertEquals(contactUsPO.getAlertSuccessText(), "Your message has been successfully sent to our team.", "Success message is correct");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}

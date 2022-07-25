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
import pages.RegistrationPO;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class RegistrationTests {

    WebDriver driver;
    RegistrationPO registrationPO;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test(priority = 2)
    public void testCorrectInputs() {
        registrationPO = new RegistrationPO(driver);
        registrationPO.clickOnSignIn();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("create-account_form")));
        checkCorrectPage("AUTHENTICATION", "Authentication");
        assertEquals(registrationPO.getSubHeadingText(), "CREATE AN ACCOUNT", "Create an account text is correct");
        registrationPO.enterEmailCreateAccount("mario.racek@seznam.fi");
        registrationPO.clickCreateAnAccount();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));
        checkCorrectPage("CREATE AN ACCOUNT", "Authentication");
        assertEquals(registrationPO.getSubHeadingText(), "YOUR PERSONAL INFORMATION", "Create an account text is correct");
        registrationPO.enterGender("Mr.");
        registrationPO.enterFirstName("Mario");
        registrationPO.enterLastName("Racek");
        registrationPO.enterPassword("password");
        registrationPO.enterDateOfBirth("1991", "11", "11");
        registrationPO.checkNewsletter();
        registrationPO.checkSpecialOffer();
        registrationPO.enterFirstNameAddress("Mario");
        registrationPO.enterLastNameAddress("Racek");
        registrationPO.enterAddressLine1("Sturova 11");
        registrationPO.enterCity("Singapur");
        registrationPO.selectCountry("21");
        registrationPO.selectState("8");
        registrationPO.enterPostalCode("14900");
        registrationPO.enterAdditionalInfo("Info");
        registrationPO.enterMobilePhone("123456789");
        registrationPO.enterAliasReference("moja");
        registrationPO.clickRegisterButton();
        checkCorrectPage("MY ACCOUNT", "My account");
    }

    @Test
    public void testIncorrectEmailAddress() {
        registrationPO = new RegistrationPO(driver);
        registrationPO.clickOnSignIn();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("create-account_form")));
        checkCorrectPage("AUTHENTICATION", "Authentication");
        assertEquals(registrationPO.getSubHeadingText(), "CREATE AN ACCOUNT", "Create an account text is correct");
        registrationPO.enterEmailCreateAccount("incorrectEmailAddress@com");
        registrationPO.clickCreateAnAccount();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println(driver.findElement(By.id("email_create")).getAttribute("class"));
        assertEquals(driver.findElement(By.id("email_create")).getAttribute("class"), "is_required validate account_input form-control");
    }

    @Test(priority = 1)
    public void testMandatoryInputs() {
        registrationPO = new RegistrationPO(driver);
        registrationPO.clickOnSignIn();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("create-account_form")));
        checkCorrectPage("AUTHENTICATION", "Authentication");
        assertEquals(registrationPO.getSubHeadingText(), "CREATE AN ACCOUNT", "Create an account text is correct");
        registrationPO.enterEmailCreateAccount("mario.racek@gmail.co");
        registrationPO.clickCreateAnAccount();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));
        checkCorrectPage("CREATE AN ACCOUNT", "Authentication");
        assertEquals(registrationPO.getSubHeadingText(), "YOUR PERSONAL INFORMATION", "Create an account text is correct");
        registrationPO.enterGender("Mr.");
        registrationPO.enterPassword("password");
        registrationPO.enterDateOfBirth("1991", "11", "11");
        registrationPO.checkNewsletter();
        registrationPO.checkSpecialOffer();
        registrationPO.enterFirstNameAddress("Mario");
        registrationPO.enterLastNameAddress("Racek");
        registrationPO.enterAddressLine1("Sturova 11");
        registrationPO.enterCity("Singapur");
        registrationPO.selectCountry("21");
        registrationPO.selectState("8");
        registrationPO.enterPostalCode("14900");
        registrationPO.enterAdditionalInfo("Info");
        registrationPO.enterMobilePhone("123456789");
        registrationPO.enterAliasReference("moja");
        registrationPO.clickRegisterButton();
        assertEquals(registrationPO.checkAlertError(), "There are 2 errors" + "\n" + "lastname is required.\n" + "firstname is required.", "Alert is visible and have correct text");
    }

    public void checkCorrectPage(String heading, String breadcrumb) {
        registrationPO = new RegistrationPO(driver);
        assertEquals(registrationPO.getBreadcrumbsText(), breadcrumb, "Breadcrumbs text is correct");
        assertEquals(registrationPO.getHeadingText(), heading, "Title text is correct");
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}

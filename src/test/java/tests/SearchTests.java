package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchPO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class SearchTests {

    WebDriver driver;
    SearchPO searchPage;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/marioracek/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void searchEmpty() {
        searchPage = new SearchPO(driver);
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.name("submit_search")));
        searchPage.clickOnSearchButton();
        assertEquals(searchPage.getAlertMessage(), "Please enter a search keyword");
    }

    @Test(priority = 1)
    public void checkPageHeading() {
        searchPage = new SearchPO(driver);
        assertTrue(searchPage.getHeadingText().contains("SEARCH"));
    }

    @Test(priority = 1)
    public void checkBreadcrumbs() {
        searchPage = new SearchPO(driver);
        assertTrue(searchPage.getBreadcrumbsText().contains("Search"));
    }
}

package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class ContactUsTests {

    @BeforeTest
    public void setup() {
        System.setProperty("webriver.chrome.driver", "/Users/marioracek/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("http://automationpractice.com/index.php");
    }

}

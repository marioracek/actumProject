package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectDemo {

    public static void main(String[] args) {
        System.setProperty("webriver.chrome.driver", "/Users/marioracek/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();
    }
}

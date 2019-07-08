package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Slide 137
 * 1. Navigate to the interested webpage for e.g. https://en.wikipedia.org/wiki/Main_Page
 * 2. Create a list of type WebElement to store all the Link elements in to it.
 * 3. Collect all the links from the webpage. All the links are associated with the Tag ‘a‘.
 * 4. Now iterate through every link and print the Link Text on the console screen.
 */

public class Task1WebElementsList {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://en.wikipedia.org/wiki/Main_Page";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void WebElementsListTest() {
        java.util.List<WebElement> links = driver.findElements(By.xpath("*//a"));
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            System.out.println(i + " " + links.get(i).getText());
        }
    }
}

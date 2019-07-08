package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Slide 141
 * 1. Open https://demoqa.com/resizable/
 * 2. Get the current size of the rectangle  and print it to console
 * 3. Resize the rectangle  (make it  bigger)
 * 4. Get the current size of the rectangle  and print it to console
 * 5. Resize the rectangle  (make it  smaller)
 * 6. Get the current size of the rectangle  and print it to console
 */

public class Task5ResizeRectangle {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/resizable/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void resizeRectangleTest() {
        WebElement rectangle = driver.findElement(By.xpath("//*[@id='resizable']"));
        Dimension dimensions = rectangle.getSize();
        System.out.println("Height: " + dimensions.height + " Width: " + dimensions.width);

        WebElement element = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));

        Actions makeRectangleBigger = new Actions(driver);
        makeRectangleBigger.clickAndHold(element).moveByOffset(50, 50).release().build().perform();
        Dimension dimensions1 = rectangle.getSize();
        System.out.println("Height: " + dimensions1.height + " Width: " + dimensions1.width);

        Actions makeRectangleSmaller = new Actions(driver);
        makeRectangleSmaller.clickAndHold(element).moveByOffset(-100, -100).release().build().perform();
        Dimension dimensions2 = rectangle.getSize();
        System.out.println("Height: " + dimensions2.height + " Width: " + dimensions2.width);
    }
}

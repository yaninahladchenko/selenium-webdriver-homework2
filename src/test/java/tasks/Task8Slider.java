package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Slide 144
 * 1. Open  https://demoqa.com/slider/
 * 2. Get sliders’ current position and print to console
 * 3. Move the slider to 50 %
 * 4. Get sliders’ current position and print to console
 * 5. Move slider randomly
 * 6. Get sliders’ current position and print to console
 */

public class Task8Slider {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/slider/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void sliderTest() {
        WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
        System.out.println(slider.getLocation());
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider).moveByOffset(178, 0).release().build().perform();
        System.out.println(slider.getLocation());
        actions.clickAndHold(slider).moveByOffset(134, 0).release().build().perform();
        System.out.println(slider.getLocation());


    }
}

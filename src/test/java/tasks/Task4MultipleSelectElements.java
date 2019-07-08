package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Slide 140
 * 1. Open https://demoqa.com/selectable/
 * 2. Select randomly any 3  elements
 * 3. Create  the screenshot  with the name (3 elements selected + current  timestamp)
 */

public class Task4MultipleSelectElements {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/selectable/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void multipleSelectElementsTest() throws IOException {
        WebElement item1 = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
        WebElement item2 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
        WebElement item3 = driver.findElement(By.xpath("//*[@id='selectable']/li[6]"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).click(item1).click(item2).click(item3).keyUp(Keys.LEFT_CONTROL).build().perform();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("3 elements selected " + System.currentTimeMillis()+".png"));
    }
}

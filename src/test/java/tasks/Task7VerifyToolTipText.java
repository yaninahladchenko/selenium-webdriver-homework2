package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Slide 143
 * 1. Open https://demoqa.com/tooltip/
 * 2. Check that tooltip contains the text statistical purposes
 */

public class Task7VerifyToolTipText {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/tooltip/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void tooltipTest() {
        WebElement inputField = driver.findElement(By.xpath("//div/p[2]/input"));

        Actions action = new Actions(driver);
        action.moveToElement(inputField).build().perform();

        WebElement inputToolTip = driver.findElement(By.xpath("//div[@role='tooltip']"));
        System.out.println("Tooltip text: " + inputToolTip.getText());

        Assert.assertTrue(inputToolTip.getText().contains("statistical purposes"), "Tooltip does not contain expected text.");
    }
}

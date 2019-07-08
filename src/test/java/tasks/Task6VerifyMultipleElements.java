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
 * Slide 142
 * 1. Open https://demoqa.com/tooltip-and-double-click/
 * 2. Check that these  3 elements work as defined
 */

public class Task6VerifyMultipleElements {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/tooltip-and-double-click/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void multipleElementsTest() {
        WebElement doubleClickBtn = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
        WebElement editMenuItem = driver.findElement(By.xpath("//*[@id='rightclickItem']/div[1]"));
        WebElement tooltipDemo = driver.findElement(By.xpath("//*[@id='tooltipDemo']"));
        WebElement tooltipDemoText = driver.findElement(By.xpath("//*[@id='tooltipDemo']/span"));

        Actions element1 = new Actions(driver);
        element1.doubleClick(doubleClickBtn).perform();
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "Double Click Alert\n" +
                        "\n" +
                        "Hi,You are seeing this message as you have double cliked on the button",
                "Alert message is wrong.");
        alert.accept();

        Actions element2 = new Actions(driver);
        element2.contextClick(rightClickBtn).perform();
        editMenuItem.click();
        String alertMessage2 = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage2, "You have selected Edit", "Alert message is wrong.");
        alert.accept();

        Actions element3 = new Actions(driver);
        element3.moveToElement(tooltipDemo).moveToElement(tooltipDemoText).perform();
        Assert.assertEquals(tooltipDemoText.getText(), "We ask for your age only for statistical purposes.",
                "Alert message is wrong.");
    }
}


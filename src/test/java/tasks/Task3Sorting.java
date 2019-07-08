package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Slide 139
 * 1. Open https://demoqa.com/sortable/
 * 2. Check that all the items now are sorted correctly
 * 3. Move the 2nd element after the 5th one
 */

public class Task3Sorting {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/sortable/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void sortingTest() {
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='sortable']/li"));
        List<String> values = new ArrayList();
        for (WebElement element : elements) {
            System.out.println(element.getText());
            values.add(element.getText());
        }

        List expectedList = new ArrayList(values);
        Collections.sort(expectedList);
        boolean isSorted = expectedList.equals(values);
        Assert.assertTrue(isSorted, "List is not sorted.");

        WebElement secondElement = driver.findElement(By.xpath("//*[@id='sortable']/li[2]"));
        WebElement fifthElement = driver.findElement(By.xpath("//*[@id='sortable']/li[5]"));

        Action dragAndDrop = new Actions(driver)
                .clickAndHold(secondElement)
                .moveToElement(fifthElement)
                .moveByOffset(0, 2)
                .release()
                .build();
        dragAndDrop.perform();
    }
}

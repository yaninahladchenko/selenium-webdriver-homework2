package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Slide 138
 * 1. For  Chrome  and Edge – open the browser
 * 2. Goto google.com
 * 3. Search for something that:
 * 3.1 is located on the first page of search results
 * 3.2  is located  further then 10th page
 * 3.3   is not in the search results
 * 4. Save  screenshot if result is found
 * 5. Provide user with the corresponding error message if result is not found
 * 6. Print to Console  Page number if result is found
 * Example:
 * 1. We  enter “selenium automation testing”  and find that “seleniumhq.org”  is on the 1st page
 * 2. We  enter “осциллограф”  and find that “vit.ua”  is on  some  page
 * 3. We enter “абракадабра”  and find that “kpi.ua” is not in the search results
 */

public class Task2GoogleSearch {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://www.google.com/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void googleSearchTest() throws IOException {
        WebElement googleSearchField = driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchField.sendKeys("selenium automation testing");
        googleSearchField.sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("seleniumhq.org"), "seleniumhq.org is not found on first page.");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("Selenium search.png"));
        WebElement currentPage1 = driver.findElement(By.xpath("//td[@class='cur']"));
        System.out.println("Current page is: " + currentPage1.getText());

        WebElement googleSearchField1 = driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchField1.clear();

        googleSearchField1.sendKeys("абырвалг");
        googleSearchField1.sendKeys(Keys.ENTER);
        WebElement page10 = driver.findElement(By.xpath("//*[@id='nav']//td[11]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page10);
        page10.click();
        WebElement page11 = driver.findElement(By.xpath("//*[@id='nav']//td[8]/a"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", page11);
        page11.click();
        Assert.assertTrue(driver.getPageSource().contains("абырвалг"), "Page 11 does not contain 'абырвалг'");
        File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("абырвалг search.png"));
        WebElement currentPage2 = driver.findElement(By.xpath("//td[@class='cur']"));
        System.out.println("Current page is: " + currentPage2.getText());

        WebElement googleSearchField2 = driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchField2.clear();

        googleSearchField2.sendKeys("абракадабра");
        googleSearchField2.sendKeys(Keys.ENTER);
        if (!driver.getPageSource().contains("kpi.ua")) {
            System.out.println("SearchTerm \"kpi.ua\" not found.");
        }
        Assert.assertFalse(driver.getPageSource().contains("kpi.ua"), "Page results contain 'kpi.ua'");
    }
}


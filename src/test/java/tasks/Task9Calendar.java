package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Slide 145
 * 1. Open https://demoqa.com/datepicker/
 * 2. Select the random day  in August 2019
 * 3 check that this date was selected
 */

public class Task9Calendar {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/datepicker/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void calendarTest() {
        WebElement dateInputField = driver.findElement(By.xpath("//*[@id='datepicker']"));

        dateInputField.sendKeys("08/26/2019");

        WebElement selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
        Assert.assertEquals(selectedMonth.getText(), "August", "Month is incorrect.");

        WebElement selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
        Assert.assertEquals(selectedYear.getText(), "2019", "Year is incorrect.");

        WebElement selectedDay = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']//tr[5]/td[2]/a"));
        Assert.assertEquals(selectedDay.getText(), "26", "Day is incorrect.");
        System.out.println(selectedMonth.getText() + " " + selectedYear.getText() + ", " + selectedDay.getText());
    }
}

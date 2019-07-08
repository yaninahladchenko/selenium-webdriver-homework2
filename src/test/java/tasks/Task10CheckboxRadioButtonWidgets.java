package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Slide 146
 * 1. Open https://demoqa.com/checkboxradio/
 * 2. Check that it’s possible to select only one location
 * 3. Check that it’s possible to select several Hotel ratings
 */

public class Task10CheckboxRadioButtonWidgets {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://demoqa.com/checkboxradio/";
        driver.get(url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void checkboxRadioButtonCheckboxTest() {
        WebElement radioButtonLabel1 = driver.findElement(By.xpath("//label[@for='radio-1']"));
        WebElement radioButtonInput1 = driver.findElement(By.xpath("//input[@id='radio-1']"));
        radioButtonLabel1.click();
        Assert.assertTrue(radioButtonInput1.isSelected(), "Radiobutton 1 is not selected");

        WebElement radioButtonLabel2 = driver.findElement(By.xpath("//label[@for='radio-2']"));
        WebElement radioButtonInput2 = driver.findElement(By.xpath("//input[@id='radio-2']"));
        radioButtonLabel2.click();
        Assert.assertTrue(radioButtonInput2.isSelected(), "Radiobutton 2 is not selected");
        Assert.assertFalse(radioButtonInput1.isSelected(), "Radiobutton 1 is selected");

        WebElement radioButtonLabel3 = driver.findElement(By.xpath("//label[@for='radio-3']"));
        WebElement radioButtonInput3 = driver.findElement(By.xpath("//input[@id='radio-3']"));
        radioButtonLabel3.click();
        Assert.assertTrue(radioButtonInput3.isSelected(), "Radiobutton 3 is not selected");
        Assert.assertFalse(radioButtonInput1.isSelected(), "Radiobutton 1 is selected");
        Assert.assertFalse(radioButtonInput2.isSelected(), "Radiobutton 2 is selected");

        WebElement hotelRatingCheckboxLabel1 = driver.findElement(By.xpath("//label[@for='checkbox-1']"));
        WebElement hotelRatingCheckboxInput1 = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
        hotelRatingCheckboxLabel1.click();
        Assert.assertTrue(hotelRatingCheckboxInput1.isSelected(), "Checkbox 1 is not selected");

        WebElement hotelRatingCheckboxLabel2 = driver.findElement(By.xpath("//label[@for='checkbox-2']"));
        WebElement hotelRatingCheckboxInput2 = driver.findElement(By.xpath("//input[@id='checkbox-2']"));
        hotelRatingCheckboxLabel2.click();
        Assert.assertTrue(hotelRatingCheckboxInput2.isSelected(), "Checkbox 2 is not selected");

        WebElement hotelRatingCheckboxLabel3 = driver.findElement(By.xpath("//label[@for='checkbox-3']"));
        WebElement hotelRatingCheckboxInput3 = driver.findElement(By.xpath("//input[@id='checkbox-3']"));
        hotelRatingCheckboxLabel3.click();
        Assert.assertTrue(hotelRatingCheckboxInput3.isSelected(), "Checkbox 3 is not selected");

        WebElement hotelRatingCheckboxLabel4 = driver.findElement(By.xpath("//label[@for='checkbox-4']"));
        WebElement hotelRatingCheckboxInput4 = driver.findElement(By.xpath("//input[@id='checkbox-4']"));
        hotelRatingCheckboxLabel4.click();
        Assert.assertTrue(hotelRatingCheckboxInput4.isSelected(), "Checkbox 4 is not selected");
    }
}



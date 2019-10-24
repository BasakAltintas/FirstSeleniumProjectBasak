package Tests.day4;

/* ###Test 2, Verify that email changed
1. Go to "http://practice.cybertekschool.com/forgot_password"
2. Enter any valid email
3. Click on retrieve password button
4. Verify that URL is equals to "http://practice.cybertekschool.com/email_sent"*/




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("random@email.com");
        WebElement button = driver.findElement(By.id("form_submit"));
        button.click();
        BrowserUtils.wait(2);
        driver.close();
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.close();





    }

}

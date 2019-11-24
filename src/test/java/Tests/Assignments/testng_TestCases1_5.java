package Tests.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class testng_TestCases1_5 {
    /*Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid” */

    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }
    @Test(description = "Verifying the message is displayed")
    public void test1(){

        driver.findElement(By.xpath("//a[text() ='Registration Form']")).click();

        WebElement date = driver.findElement(By.xpath("//input[@name='birthday']"));
        date.sendKeys("45/45/3777");

        WebElement message = date.findElement(By.xpath("//small[contains(text(),'The date of birth is not valid')]"));

        Assert.assertTrue(message.isDisplayed());
    }
    @Test (description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    private void test2(){
        driver.findElement(By.xpath("//a[text() ='Registration Form']")).click();

        WebElement cplusplus = driver.findElement(By.xpath("//label[@class='form-check-label']"));

        WebElement java = driver.findElement(By.xpath("//label[text()='Java']"));
        WebElement javaScript = driver.findElement(By.xpath("//label[text()='JavaScript']"));

        Assert.assertTrue(cplusplus.isDisplayed());
        Assert.assertTrue(java.isDisplayed());
        Assert.assertTrue(javaScript.isDisplayed());
    }
    @Test(description = "Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long")
    private void test3(){
        driver.findElement(By.xpath("//a[text() ='Registration Form']")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("B");
        BrowserUtils.wait(2);
        WebElement message = driver.findElement(By.xpath("//small[contains(text(),'first name must be more than 2 and less than 64 characters long')]"));

        Assert.assertTrue(message.isDisplayed());
    }
    @Test(description = "Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long")
    private void test4(){
        driver.findElement(By.xpath("//a[text() ='Registration Form']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("A");

        WebElement message = driver.findElement(By.xpath("//small[contains(text(),'The username must be more than 6 and less than 30 characters long')]"));

        Assert.assertEquals(message.getText(), "The username must be more than 6 and less than 30 characters long");
    }
    @Test (description = " Verify that following success message is displayed: “You've successfully completed registration!”")
    private void test5(){
        driver.findElement(By.xpath("//a[text() ='Registration Form']")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("iskender");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Kirecburnu");
        BrowserUtils.wait(2);

        driver.findElement(By.name("username")).sendKeys("erdaaaal2");
        driver.findElement(By.name("email")).sendKeys("leyla.mecnun@icloud.com");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Iskender123");
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("346-985-3656");
        BrowserUtils.wait(2);

        driver.findElement(By.xpath("//input[@name='gender']")).click();
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("02/04/1986");

        WebElement department = driver.findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(department);
        select.selectByVisibleText("MCR");
        BrowserUtils.wait(2);

        WebElement job = driver.findElement(By.xpath("//select[@name='job_title' and @class='form-control selectpicker']"));
        Select select1 = new Select(job);
        select1.selectByVisibleText("SDET");
        BrowserUtils.wait(2);


        driver.findElement(By.xpath("//label[text()='Java']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();

        WebElement message = driver.findElement(By.xpath("//p"));
        Assert.assertEquals(message.getText(), "You've successfully completed registration!");








    }
}

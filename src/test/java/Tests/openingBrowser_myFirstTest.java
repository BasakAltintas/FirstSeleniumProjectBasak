package Tests;
// this test is for opening the browser.
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

class openingBrowser_myFirstTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // driver.get is used for opening the browser
        driver.get("https://google.com");

        String actualResult =  driver.getTitle();
        String expectedResult = "Google";
        if( actualResult.equals(expectedResult)){
            System.out.println("test passed");
        }

        // driver.close is for closing the browser.
        //driver.close();
    }
}

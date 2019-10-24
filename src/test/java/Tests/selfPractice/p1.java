package Tests.selfPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;

public class p1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("http:/google.com");
        driver.navigate().to("http:/amazon.com");

    }
}

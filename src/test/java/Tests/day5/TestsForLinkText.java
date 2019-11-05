package Tests.day5;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestsForLinkText {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver(("chrome"));

        driver.get("http://practice.cybertekschool.com/");
    }
}

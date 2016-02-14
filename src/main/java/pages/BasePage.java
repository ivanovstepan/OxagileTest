package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class BasePage {

    protected WebDriver driver;
    protected Logger log = Logger.getLogger(this.getClass().getName());
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(String by) {

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> list = driver.findElements(By.xpath(by));
            if (list.size() == 0) {
                return false;
            } else {
                return true;
            }
    }
}

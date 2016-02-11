import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.onliner.by/");
        WebElement element = driver.findElement(By.xpath(".//*[@id='userbar']/div[2]/div[1]"));
        element.click();


        driver.findElement(By.xpath(".//*[@class='auth-box__part is-active'][1]/div[1]/input")).sendKeys("stepanivanov11@gmail.com");
        driver.findElement(By.xpath(".//*[@class='auth-box__part is-active'][1]/div[2]/input")).sendKeys("newpas11");


        WebElement enter = driver.findElement(By.xpath(".//*[@class='auth-box__auth-submit auth__btn auth__btn--green']"));
        enter.click();



        WebElement success = driver.findElement(By.xpath(".//*[@id='userbar']/div[1]/div"));

    }
}

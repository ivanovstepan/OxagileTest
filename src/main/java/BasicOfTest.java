import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BasicOfTest {
    protected Logger log = Logger.getLogger(this.getClass().getName());

    protected WebDriver driver;
    protected final static String URL = "http://www.onliner.by/";

    public PageLogin pageLogin;
    public PageHome pageHome;
    public PageOnliner pageOnliner;
    public PageTechnology pageTechnology;
    public PageNoteBook pageNoteBook;
    public Product product;

    public abstract void initPages();

    @Parameters("browser")
    @BeforeMethod

    public void startBrowser(String browser){
        PropertyConfigurator.configure("./src/main/resources/log4j");
        if(browser.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        else throw new IllegalArgumentException("Incorrect browser type");
        initPages();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }



    @AfterMethod
    public void stopBrowser(){
        driver.quit();
    }


}

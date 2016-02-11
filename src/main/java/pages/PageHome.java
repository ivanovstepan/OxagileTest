package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends BasePage {


    public final String IMAGE_USER = ".//*[@id='userbar']/div[1]/div";
    @FindBy(xpath = IMAGE_USER)
    WebElement image;

    public PageHome (WebDriver driver){
        super(driver);

    }



}

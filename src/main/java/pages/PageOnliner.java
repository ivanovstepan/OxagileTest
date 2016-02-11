package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageOnliner extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = ".//*[@class='auth-bar__item auth-bar__item--text']")
    WebElement enter;

    public PageOnliner( WebDriver driver){
        super(driver);
    }

    public void goToLoginPage (){
        this.enter.click();
    }


}

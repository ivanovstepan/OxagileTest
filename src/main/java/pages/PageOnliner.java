package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageOnliner extends BasePage {

    private final static String LOGIN_PAGE =".//*[@class='auth-bar__item auth-bar__item--text']";
    @FindBy(xpath = LOGIN_PAGE)
    WebElement goToLoginPage;


    public PageOnliner( WebDriver driver){
        super(driver);
    }

    public void goToLoginPage (){
        log.info("Go to loginPage");
        this.goToLoginPage.click();
    }




}

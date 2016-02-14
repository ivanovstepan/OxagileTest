package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageLogin extends BasePage {

    private final static String LOGIN ="(.//*[@class='auth-box__input'])[1]";
    @FindBy(xpath = LOGIN)
    WebElement login;
    private final static String PASS = "(.//*[@class='auth-box__input'])[2]";
    @FindBy(xpath = PASS)
    WebElement password;

    private final static String ENTER =".//*[@class='auth-box__line auth-box__line--final']/button";
    @FindBy(xpath = ENTER)
    WebElement enter;


    public PageLogin( WebDriver driver){
        super(driver);
    }

    private void setPass(String password){
        log.info("Enter password");
        this.password.sendKeys(password);
    }

    private void setLogin(String login){
        log.info("Enter login");
        this.login.sendKeys(login);
    }

    private void clickLogin(){
        log.info("Enter information");
        this.enter.click();
    }

    public void loginToPageHome(String login, String password){
        this.setLogin(login);
        this.setPass(password);
        this.clickLogin();
    }

}

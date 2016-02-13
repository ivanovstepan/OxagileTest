package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageLogin extends BasePage {
    @FindBy(xpath = "(.//*[@class='auth-box__input'])[1]")
    WebElement login;

    @FindBy(xpath = "(.//*[@class='auth-box__input'])[2]")
    WebElement password;

    @FindBy(xpath = ".//*[@class='auth-box__line auth-box__line--final']/button")
    WebElement enter;


    public PageLogin( WebDriver driver){
        super(driver);
    }

    private void setPass(String password){
        this.password.sendKeys(password);
    }

    private void setLogin(String login){
        this.login.sendKeys(login);
    }

    private void clickLogin(){
        this.enter.click();
    }

    public void loginToPageHome(String login, String password){
        this.setLogin(login);
        this.setPass(password);

        this.clickLogin();
    }

}

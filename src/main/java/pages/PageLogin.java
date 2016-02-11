package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageLogin extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = ".//*[@class='auth-box__part is-active'][1]/div[1]/input")
    WebElement login;

    @FindBy(xpath = ".//*[@class='auth-box__part is-active'][1]/div[2]/input")
    WebElement password;

    @FindBy(xpath = ".//*[@class='auth-box__auth-submit auth__btn auth__btn--green']")
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

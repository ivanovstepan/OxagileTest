package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends BasePage {


    public final String LOGIN_USER = ".//*[@id='userbar']/div[1]/p/a";
    @FindBy(xpath = LOGIN_USER)
    WebElement loginUser;

    @FindBy(xpath = ".//*[@class='b-main-navigation']/li[4]/a")
    WebElement technologyPage;

    @FindBy(xpath = ".//*[@class='catalog-bar__list']/li[3]/a")
    WebElement notebook;

    public PageHome (WebDriver driver){
        super(driver);

    }
    public void goToTechnologyPage(){
        this.technologyPage.click();
    }
    public void goToSearchNoteBook(){
        this.notebook.click();
    }
    public String getUserLogin(){
        if (loginUser.getText().equals("")){
            System.out.println("DAAAAAAAAAAAAAAAAAAAAAAAAAA");
            return "kjadfn";
        }

        else return loginUser.getText();
    }


}

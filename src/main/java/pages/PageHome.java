package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends BasePage {


    public final String LOGIN_USER = ".//*[@class='user-name']/a";
    @FindBy(xpath = LOGIN_USER)
    WebElement loginUser;

    @FindBy(xpath = ".//*[@href='http://tech.onliner.by/']")
    WebElement technologyPage;

    @FindBy(xpath = "(.//*[@href='http://catalog.onliner.by/notebook'])[1]")
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
        System.out.print(loginUser.getText());
       return loginUser.getText();
    }


}

package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends BasePage {




    private final static String LOGIN_USER = ".//*[@class='user-name']/a";
    @FindBy(xpath = LOGIN_USER)
    WebElement loginUser;
    private final static String TECHNOLOGY_PAGE =".//*[@href='http://tech.onliner.by/']";
    @FindBy(xpath = TECHNOLOGY_PAGE)
    WebElement technologyPage;
    private final static String NOTEBOOK ="(.//*[@href='http://catalog.onliner.by/notebook'])[1]";
    @FindBy(xpath = NOTEBOOK)
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

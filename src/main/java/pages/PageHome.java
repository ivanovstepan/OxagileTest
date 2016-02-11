package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageHome extends BasePage {


    public final String IMAGE_USER = ".//*[@id='userbar']/div[1]/div";
    @FindBy(xpath = IMAGE_USER)
    WebElement image;

    @FindBy(xpath = ".//*[@class='b-main-navigation']/li[4]/a")
    WebElement goToTechnologyPage;

    public PageHome (WebDriver driver){
        super(driver);

    }
    public void goToTechnologyPage(){
        this.goToTechnologyPage.click();
    }


}

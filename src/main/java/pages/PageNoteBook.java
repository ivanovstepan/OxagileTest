package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageNoteBook {

    private WebDriver driver;

    public PageNoteBook(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = ".//*[@id='schema-filter']/div[2]/div[1]/a")
    WebElement additionalParameters;


    public void openAddition(){
        this.additionalParameters.click();
    }



}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageNoteBook extends BasePage {



    public PageNoteBook(WebDriver driver) {
        super(driver);
    }

    private final static String PARAMETERS =".//*[@class='schema-filter-additional__trigger']/a";
    @FindBy(xpath = PARAMETERS)
    WebElement additionalParameters;


    public void openAddition(){
        log.info("Open additional parameters");
        this.additionalParameters.click();
    }



}

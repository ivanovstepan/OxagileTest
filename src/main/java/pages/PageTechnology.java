package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageTechnology {
    private WebDriver driver;
    private List<WebElement> list;

    public PageTechnology(WebDriver driver) {
        this.driver = driver;
    }

    final String news =".//*[@class='b-posts-1 b-content-posts-1']/article";
    final String nameOfNews = ".//*[@class='b-posts-1-item__title'][1]/a/span[1]";
    final String dateOfNews = ".//*[@class='b-inner-pages-footer-1']/span[2]/time";
    final String previousPage = ".//*[@class='previous-page']";

    public void getAllNews(){
        int k=0;
        for (int i =0; i < 3; i++) {
            list = driver.findElements(By.xpath(news));
            for (WebElement webElement : list) {
                k++;
                System.out.println("da "+k);
                System.out.println(webElement.findElement(By.xpath(nameOfNews)).getText());
                System.out.println(webElement.findElement(By.xpath(dateOfNews)).getAttribute("datetime"));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            driver.findElement(By.xpath(previousPage)).click();
        }
    }



}

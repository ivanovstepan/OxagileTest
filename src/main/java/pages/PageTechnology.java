package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PageTechnology  extends BasePage{

    private final static String NEWS =".//*[@class='b-posts-1 b-content-posts-1']/article";
    @FindBy(xpath = NEWS)
    List<WebElement> news;

    final String nameOfNews = ".//*[@class='b-posts-1-item__title'][1]/a/span[1]";
    final String dateOfNews = ".//*[@class='b-inner-pages-footer-1']/span[2]/time";
    private final static String PREVIOUS_PAGE = ".//*[@class='previous-page']";
    @FindBy(xpath = PREVIOUS_PAGE)
    WebElement page;

    final String nameAttribute = "datetime";
    private int countPages = 3;

    public String getUnparsedDate() {
        return sb.toString();
    }

    private StringBuilder sb;

    private Writer writer;


    public PageTechnology(WebDriver driver) throws IOException {
        super(driver);
        sb = new StringBuilder();
        writer = new OutputStreamWriter(new FileOutputStream(new File("out1.txt")),"UTF-8");
    }

    public boolean getAllNews(){
        boolean flag = true;
        for (int i =0; i < countPages; i++) {
            log.info("Write information  from one page in file");
            for (WebElement webElement : news) {
                String name = webElement.findElement(By.xpath(nameOfNews)).getText();
                String date = webElement.findElement(By.xpath(dateOfNews)).getAttribute(nameAttribute);
                try {
                    writeDateInFile(name, date);
                } catch (Exception e) {
                    sb.append(date).append(" unparsed date");
                    log.info("catch exception");
                    flag= false;
                }
            }
                page.click();
        }
        try {

            writer.flush();
            writer.close();
        } catch (Exception e) {
            log.info("catch exception");
            flag = false;
        }
        return flag;
    }

    private void writeDateInFile(String name,String data) throws IOException, ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+03:00'");
        Date date;
            date=simpleDateFormat.parse(data);
            writer.append("Name: ").append(name).append("\n");
            writer.append("Date: ").append(date.toString()).append("\n\n");

    }
}

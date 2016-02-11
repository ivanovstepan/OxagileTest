package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PageTechnology {

    final String news =".//*[@class='b-posts-1 b-content-posts-1']/article";
    final String nameOfNews = ".//*[@class='b-posts-1-item__title'][1]/a/span[1]";
    final String dateOfNews = ".//*[@class='b-inner-pages-footer-1']/span[2]/time";
    final String previousPage = ".//*[@class='previous-page']";
    final String nameAttribute = "datetime";
    private int countPages = 1;

    private WebDriver driver;
    private Writer writer;


    public PageTechnology(WebDriver driver) throws IOException {
        this.driver = driver;
        writer = new OutputStreamWriter(new FileOutputStream(new File("out1.txt")),"UTF-8");
    }

    public void getAllNews(){
        for (int i =0; i <= countPages; i++) {
           List<WebElement> list = driver.findElements(By.xpath(news));
            for (WebElement webElement : list) {
                String name = webElement.findElement(By.xpath(nameOfNews)).getText();
                String date = webElement.findElement(By.xpath(dateOfNews)).getAttribute(nameAttribute);
                writeDateInFile(name,date);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            driver.findElement(By.xpath(previousPage)).click();
        }
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDateInFile(String name,String data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+03:00'");
        Date date;
        try {

            date=simpleDateFormat.parse(data);
            writer.append("Name: "+name+"\n");
            writer.append("Date: "+date.toString()+"\n\n");

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

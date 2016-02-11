package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PageTechnology {
    private WebDriver driver;
    private List<WebElement> list;
    private FileWriter fileWriter;

    public PageTechnology(WebDriver driver) throws IOException {
        this.driver = driver;
        fileWriter = new FileWriter("out.txt");
    }

    final String news =".//*[@class='b-posts-1 b-content-posts-1']/article";
    final String nameOfNews = ".//*[@class='b-posts-1-item__title'][1]/a/span[1]";
    final String dateOfNews = ".//*[@class='b-inner-pages-footer-1']/span[2]/time";
    final String previousPage = ".//*[@class='previous-page']";

    public void getAllNews(){
        int k=0;
        for (int i =0; i < 1; i++) {
            list = driver.findElements(By.xpath(news));
            for (WebElement webElement : list) {
                k++;
                System.out.println("da "+k);
                String name = webElement.findElement(By.xpath(nameOfNews)).getText();
                String date = webElement.findElement(By.xpath(dateOfNews)).getAttribute("datetime");
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
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDateInFile(String name,String data){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+03:00'");
        Date date=null;
        try {

            date=simpleDateFormat.parse(data);
            fileWriter.write("Name: "+name+"\n");
            fileWriter.write("Date: "+date.toString()+"\n\n");

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

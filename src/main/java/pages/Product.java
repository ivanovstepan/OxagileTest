package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Product {
    private WebDriver driver;
    private final String param1="Количество ядер";
    private final String param2="Тип оперативной памяти";
    private final String value1="2";
    private final String value2="DDR3";


    public Product(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = ".//*[@id='schema-filter']/div[2]/div[2]/div/div[3]/div[3]/ul/li[1]/label/span[1]/span")
    WebElement countOfCores;

    @FindBy(xpath = ".//*[@id='schema-filter']/div[2]/div[2]/div/div[5]/div[3]/ul/li[1]/label/span[1]/span")
    WebElement RAM;

    @FindBy(xpath = ".//*[@id='schema-products']/div[1]/div/div[1]/div[2]/a")
    WebElement noteBook;





    public void setParameters() {
        this.countOfCores.click();
        this.RAM.click();
    }

    public void getNoteBook(){
        noteBook.click();
    }


    public boolean checkParameterOne(){
        List<WebElement> list = driver.findElements(By.xpath(".//*[@class='product-specs__table']/tbody[2]/tr[5]/td"));
        System.out.println(list.get(0).getText());
        System.out.println(list.get(1).getText());
        return list.get(0).getText().equals(param1) && list.get(1).getText().equals(value1);
    }

    public boolean checkParameterTwo(){
        List<WebElement> list = driver.findElements(By.xpath(".//*[@class='product-specs__table']/tbody[6]/tr[2]/td"));
        System.out.println(list.get(0).getText());
        System.out.println(list.get(1).getText());
        return list.get(0).getText().equals(param2) && list.get(1).getText().equals(value2);
    }






}

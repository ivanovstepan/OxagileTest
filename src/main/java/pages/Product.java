package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Product extends BasePage {
    private final String param1="Количество ядер";
    private final String param2="Тип оперативной памяти";
    private final String value1="2";
    private final String value2="DDR3";


    public Product(WebDriver driver) {
        super(driver);
    }


    private final static String firstParam = ".//*[@class='product-specs__table']/tbody[2]/tr[5]/td";
    private final static String secondParam = ".//*[@class='product-specs__table']/tbody[6]/tr[2]/td";

    private final static String COUNT_CORES =".//*[@id='schema-filter']/div[2]/div[2]/div/div[3]/div[3]/ul/li[1]/label/span[1]/span";
    @FindBy(xpath = COUNT_CORES)
    WebElement countOfCores;

    private final static String PATH_RAM = ".//*[@id='schema-filter']/div[2]/div[2]/div/div[5]/div[3]/ul/li[1]/label/span[1]/span";
    @FindBy(xpath = PATH_RAM)
    WebElement RAM;

    private final static String NOTEBOOK = ".//*[@id='schema-products']/div[1]/div/div[1]/div[2]/a";
    @FindBy(xpath = NOTEBOOK)
    WebElement noteBook;



    public void setParameters() {
        log.info("Set parameters");
        this.countOfCores.click();
        this.RAM.click();
    }

    public void getNoteBook(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        noteBook.click();
    }


    public boolean checkParameterOne(){

        List<WebElement> list = driver.findElements(By.xpath(firstParam));
        System.out.println(list.get(0).getText());
        System.out.println(list.get(1).getText());
        return list.get(0).getText().equals(param1) && list.get(1).getText().equals(value1);
    }

    public boolean checkParameterTwo(){
        List<WebElement> list = driver.findElements(By.xpath(secondParam));
        System.out.println(list.get(0).getText());
        System.out.println(list.get(1).getText());
        return list.get(0).getText().equals(param2) && list.get(1).getText().equals(value2);
    }






}

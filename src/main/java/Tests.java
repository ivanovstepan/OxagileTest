import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class Tests extends BasicOfTest {

    private final String mainLogin = "1856102";
    private final String pass = "newpas11";

    @DataProvider( name = "loginValidation")
    public Object [][] loginValidation(){
        return new Object[][]{
                {mainLogin,pass,true},
                {"","",false}
        };
    }

    @Override
    public void initPages() {
        PropertyConfigurator.configure("./src/main/resources/log4j");
        pageLogin = PageFactory.initElements(driver,PageLogin.class);
        pageHome = PageFactory.initElements(driver, PageHome.class);
        pageOnliner = PageFactory.initElements(driver, PageOnliner.class);
        pageTechnology = PageFactory.initElements(driver, PageTechnology.class);
        pageNoteBook = PageFactory.initElements(driver, PageNoteBook.class);
        product = PageFactory.initElements(driver,Product.class);
    }

   @Test(dataProvider = "loginValidation")
    public void test_login(String login,String password,boolean flag){
        log.info("Login test start");

        pageOnliner.goToLoginPage();
        log.info("Set login and password");
        pageLogin.loginToPageHome(login,password);
        log.info("Check the result");
        Assert.assertEquals(pageHome.getUserLogin().equals(mainLogin), flag,"Login");
        log.info("End of Login test");
    }


    @Test
    public void searchNotebook() throws InterruptedException {
        log.info("Search NoteBook Test start");
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome(mainLogin, pass);
        pageHome.goToSearchNoteBook();
        pageNoteBook.openAddition();
        product.setParameters();
        product.getNoteBook();
        Assert.assertEquals(product.checkParameterOne(), product.checkParameterTwo(),"NoteBook result");
        log.info("End of Search NoteBook test");
    }

    @Test
    public void test_technology(){
        log.info("Search all news Test start");
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome(mainLogin, pass);
        pageHome.goToTechnologyPage();
        Assert.assertTrue(pageTechnology.getAllNews(),"Technology News");
        log.info("End of Searching news test");
    }

}

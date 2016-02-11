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

                {"sadfsad","asdf"},
        };
    }

    @Override
    public void initPages() {
        pageLogin = PageFactory.initElements(driver,PageLogin.class);
        pageHome = PageFactory.initElements(driver, PageHome.class);
        pageOnliner = PageFactory.initElements(driver, PageOnliner.class);
        pageTechnology = PageFactory.initElements(driver, PageTechnology.class);
        pageNoteBook = PageFactory.initElements(driver, PageNoteBook.class);
        product = PageFactory.initElements(driver,Product.class);

    }

  /* @Test(dataProvider = "loginValidation")
    public void test_login(String login,String password){
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome(login,password);
        Assert.assertEquals(pageHome.getUserLogin(), mainLogin);
    }*/





    @Test
    public void serch_notebook(){
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome(mainLogin, pass);
        pageHome.goToSearchNoteBook();
        pageNoteBook.openAddition();
        product.setParameters();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product.getNoteBook();
        Assert.assertEquals(product.checkParameterOne(),true);

    }



   /* @Test
    public void test_technology(){
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome(login, pass);
        pageHome.goToTechnologyPage();
        pageTechnology.getAllNews();
    }*/

}

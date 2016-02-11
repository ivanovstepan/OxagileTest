import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PageHome;
import pages.PageLogin;
import pages.PageOnliner;
import pages.PageTechnology;


public class TestLogin extends BasicOfTest {

    @DataProvider( name = "loginValidation")
    public Object [][] loginValidation(){
        return new Object[][]{
                {"stepanivanov11@gmail.com","newpas11"},
                {"sadfsad","asdf"},
        };
    }

    @Override
    public void initPages() {
        pageLogin = PageFactory.initElements(driver,PageLogin.class);
        pageHome = PageFactory.initElements(driver, PageHome.class);
        pageOnliner = PageFactory.initElements(driver, PageOnliner.class);
        pageTechnology = PageFactory.initElements(driver, PageTechnology.class);
    }

    /*@Test(dataProvider = "loginValidation")
    public void test_login(String login,String password){
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome(login,password);
        assertTrue(pageHome.isElementPresent(pageHome.IMAGE_USER));
    }
*/
    @Test
    public void test_technology(){
        pageOnliner.goToLoginPage();
        pageLogin.loginToPageHome("stepanivanov11@gmail.com","newpas11");
        pageHome.goToTechnologyPage();
        pageTechnology.getAllNews();
    }
}

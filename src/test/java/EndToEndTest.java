import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CoursesCards;
import pages.HomePage;
import pages.LoginPage;

public class EndToEndTest
{
    WebDriver driver;
    LoginPage Lg;
    HomePage Hp;
    CoursesCards Cc;
    CartPage Cp;
    @BeforeTest
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/en");
        Hp=new HomePage(driver);
        Lg=new LoginPage(driver);
        Cc=new CoursesCards(driver);
        Cp=new CartPage(driver);
    }
    @Test
    void VerifyEndToEnd()
    {
        Hp.ClickLoginPage();
        Lg.LoginWithValidCredentials();
        Hp.ClickCoursesButton();
        Cc.ClickSubscribeButton();
        Cc.ClickCartLink();
        Cp.VerifyIsCourseAdded();
    }
    @AfterTest
    void Clean()
    {
        driver.close();
    }
}

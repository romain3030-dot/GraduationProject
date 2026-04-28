import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage Lg;
    HomePage Hp;
    @BeforeTest
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/en");
        Lg=new LoginPage(driver);
        Hp=new HomePage(driver);
    }

    @Test
    void AssertLogin()
    {
        Hp.ClickLoginPage();
        Lg.LoginWithInvalidCredentials();
        Assert.assertTrue(Lg.CheckErrorMessage(),"the error Message is not Displayed");
    }
    @AfterTest
    void Clean()
    {
        driver.close();
    }
}

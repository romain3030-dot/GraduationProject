import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.HomePage;

public class CreateAccountTest {
    WebDriver driver;
    HomePage Hp;
    CreateAccountPage Ca;
    @BeforeTest
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/en");
        Hp=new HomePage(driver);
        Ca=new CreateAccountPage(driver);
    }
    @Test
    void ValidateCreateAccount()
    {
        Hp.ClickNewAccount();

        Ca.CreateAccount();

        Assert.assertTrue(Ca.VerifyMissingName());



    }
    @AfterTest()
            void Clear()
            {
                driver.close();
            }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class FacebookTest {
    WebDriver driver;
    HomePage Hp;

    @BeforeTest
    void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/en");
        Hp=new HomePage(driver);
    }
    @Test
    void TestFacebookIcon()
    {
        Hp.VerifyFacebookIcon();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"),
                "Page title does not contain expected facebook");

    }
    @AfterTest
    void Clean()
    {
        driver.close();

    }
}

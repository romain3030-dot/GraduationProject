import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class JoinUsPage {
    WebDriver driver;
    HomePage Hp;
    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/en");
        Hp=new HomePage(driver);
    }
    @Test
    public void AssertSignUp()
    {
        Hp.ClickNewAccount();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Page URL does not contain /signup");
    }
    @AfterTest
    public void Clean()
    {
        driver.close();
    }

}

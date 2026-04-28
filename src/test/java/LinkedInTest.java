import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class LinkedInTest {
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
    void TestLinkedInIcon()
    {
        Hp.LinkedInIcon();
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"),
                "Page title does not contain expected linkedin");

    }
    @AfterTest
    void Clean()
    {
        driver.close();

    }
}


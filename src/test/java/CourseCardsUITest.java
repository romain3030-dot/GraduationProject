import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CoursesCards;
import pages.HomePage;

public class CourseCardsUITest
{
    WebDriver driver;
    HomePage Hp;
    CoursesCards Cc;
    @BeforeTest
            void setup()
             {
                 driver=new ChromeDriver();
                 driver.manage().window().maximize();
                 driver.get("https://eyouthlearning.com/en");
                 Hp=new HomePage(driver);
                 Cc=new CoursesCards(driver);
             }
    @Test
    void VerifyCourseCardUI()
    {

        Hp.ClickCoursesButton();
        Assert.assertTrue(Cc.VerifyCourseImage(),"course image is not displayed");
        Assert.assertTrue(Cc.VerifyCourseTitle(),"course title is not displayed");
        Assert.assertTrue(Cc.VerifyInstructorName(),"course title is not displayed");
        Assert.assertTrue(Cc.VerifySubscribeButton() ,"subscribe button is not displayed");

    }
    @AfterTest
    void Clean()
    {
        driver.close();
    }

}

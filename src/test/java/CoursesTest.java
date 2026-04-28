import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CourseDetailPage;
import pages.CoursesCards;
import pages.HomePage;

public class CoursesTest {
    WebDriver driver;
    HomePage Hp;
    CoursesCards Cc;
    CourseDetailPage Cd;
    @BeforeTest
    public void setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eyouthlearning.com/en");
        Hp=new HomePage(driver);
        Cc =new CoursesCards(driver);
        Cd=new CourseDetailPage(driver);
    }
    @Test
    void EnterCoursesPage()
    {

        Hp.ClickHoverCourses();
        Assert.assertTrue(driver.getCurrentUrl().contains("courses"),
                "Page title does not contain expected courses");

       Cc.ClickCourseCard();
        Assert.assertTrue(driver.getCurrentUrl().contains("power-bi-for-data-analysis"),"Page is not on Course card");


        Assert.assertTrue(Cd.ChickOverviewFound(),"the overview is not displayed");
    }
    @AfterTest
            void clean()
    {
            driver.close();
    }
}

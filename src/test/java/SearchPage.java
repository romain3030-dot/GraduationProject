import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchPage {
    WebDriver driver;
HomePage Hp;



   @BeforeMethod
    public void setup()
   {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://eyouthlearning.com/en");
Hp=new HomePage(driver);
   }

   @Test
   public void searchWithValidKeyword() {

       String keyword = "كيف تنضم إلى البنك";
       // String Title="how";
       Hp.setFormSearch(keyword);
       Hp.ClickSearchButton();

      // String actualTitle = Hp.getPageTitle();

       Assert.assertTrue(driver.getCurrentUrl().contains("join"),
               "Page title does not contain expected keyword");
   }


   @AfterMethod
   public void Clean() {
       driver.quit();
   }

}

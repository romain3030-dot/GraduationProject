package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CourseDetailPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By CourseOverview=By.id("overview");
    public CourseDetailPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public  boolean ChickOverviewFound()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CourseOverview)).isDisplayed();
    }



}

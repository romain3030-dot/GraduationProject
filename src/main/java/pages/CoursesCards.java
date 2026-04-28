package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoursesCards {
    private WebDriver driver;
    private WebDriverWait wait;
    private  By SelectedCourse=By.xpath("//a[contains(@href,'power-bi-for-data-analysis')]");
    private By CourseImage= By.cssSelector("img[alt=\"Power BI for Data Analysis\"]");
    private By CourseTitle= By.xpath("//a[contains(@href,'power-bi-for-data-analysis')]//h3");
    private  By InstructorName= By.xpath("//h6[normalize-space()='With Mahmoud Serag']");
    private  By SubscribeButton= By.xpath("//button[normalize-space()='Enroll Now']");
    private  By cartLink = By.xpath("//a[@href='/en/cart']");

    public CoursesCards(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void ClickCourseCard()
    {


        WebElement course = wait.until(ExpectedConditions.presenceOfElementLocated(SelectedCourse));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", course);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(course)).click();
        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", course);
        }

        wait.until(ExpectedConditions.urlContains("power-bi-for-data-analysis"));
    }

   public boolean VerifyCourseImage ()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CourseImage)).isDisplayed();
    }

    public boolean VerifyCourseTitle ()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CourseTitle)).isDisplayed();
    }

    public boolean VerifyInstructorName ()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(InstructorName)).isDisplayed();
    }
    public boolean VerifySubscribeButton ()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SubscribeButton)).isDisplayed();
    }

    public void ClickSubscribeButton()
    {
        wait.until(ExpectedConditions.elementToBeClickable(SubscribeButton)).click();

    }

    public void ClickCartLink()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

}

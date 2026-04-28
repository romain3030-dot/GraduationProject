package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HomePage {
    private  WebDriver driver;
    private WebDriverWait wait;

   // private  By FormCourses= By.linkText("Courses");
   // <a class="font-light" href="/en/courses">Courses</a>
   // By.cssSelector("a[href='/en/courses']");
    private  By FormCourses= By.cssSelector("a[href='/en/courses']");
    private  By SearchInput=  By.cssSelector("input[placeholder='Search Courses']");
    private  By SearchButton =By.cssSelector("a[href=\"/en/courses/how-to-join-a-bank\"]");
   // private  By NewAccountButton=By.cssSelector("a[href=\"/en/auth/register\"]");
    private  By NewAccountButton=By.linkText("Create Account");
    private By LoginButton=By.linkText("Login");
    private By FacebookIcon=By.xpath("//a[contains(@href,'facebook')]");
    private By LinkedInIcon=By.xpath("//a[contains(@href,'linkedin')]");
    private By YoutubeIcon=By.xpath("//a[contains(@href,'youtube')]");



public HomePage(WebDriver driver)
{
    this.driver=driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}

    public  void setFormSearch(String Input) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(SearchInput));
        input.clear();
        driver.findElement(SearchInput).sendKeys(Input);
    }

    public void ClickHoverCourses() {

        Actions actions = new Actions(driver);

        // Hover on "Courses"
        WebElement coursesMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Courses"))
        );

        actions.moveToElement(coursesMenu).perform();
        actions.release();
        // Wait for submenu item to appear
        WebElement subCourse = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("a[href='/en/courses']")
                )
        );

        // Click submenu item
        subCourse.click();

        // Wait for navigation
        wait.until(ExpectedConditions.urlContains("courses"));
    }

    public void ClickCoursesButton ()
    {

        WebElement courses = wait.until(ExpectedConditions.elementToBeClickable(FormCourses));
        courses.click();
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.urlContains("courses"));

    }

    public void ClickSearchButton ()
    {

        wait.until(ExpectedConditions.elementToBeClickable(SearchButton)).click();
        wait.until(ExpectedConditions.urlContains("how-to-join-a-bank"));

    }

    public void ClickNewAccount()
    {
        wait.until(ExpectedConditions.elementToBeClickable(NewAccountButton)).click();
        wait.until(ExpectedConditions.urlContains("register"));
        System.out.println(driver.getCurrentUrl());
    }

    public  void ClickLoginPage()

    {
        wait.until(ExpectedConditions.elementToBeClickable(LoginButton)).click();
        wait.until(ExpectedConditions.urlContains("login"));

    }

    public void VerifyFacebookIcon()
    {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(FacebookIcon));
       String originalWindow = driver.getWindowHandle();

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

    }

    public void LinkedInIcon()
    {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(LinkedInIcon));
        String originalWindow = driver.getWindowHandle();


        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);


        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

    }

    public void YoutubeIcon()
    {
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(YoutubeIcon));
        String originalWindow = driver.getWindowHandle();


        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);


        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (Exception e) {

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }


}

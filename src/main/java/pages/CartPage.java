package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    private By CourseName= By.xpath("//a[@href='/en/courses/power-bi-for-data-analysis']");

    public CartPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean VerifyIsCourseAdded()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CourseName)).isDisplayed();
    }

}

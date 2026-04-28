package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CoursesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By CourseName=new By.ByCssSelector("a[href=\"/en/courses/power-bi-for-data-analysis\"]");

    public CoursesPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void ClickCourseName ()

    {

        wait.until(ExpectedConditions.elementToBeClickable(CourseName)).click();
        System.out.println(driver.getCurrentUrl());
        driver.findElement(CourseName).click();
        System.out.println(driver.getCurrentUrl());
    }

}

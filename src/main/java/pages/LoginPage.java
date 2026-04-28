package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By EMail=By.id("email");
    private  By Password=By.id("password");
    private By LoginButton=By.xpath("//button[@type='submit' and text()='Login']");
    private By ErrorMessage=By.xpath("//p[normalize-space()='Invalid email address']");
    private By ErrorMessageEmptyMail=By.xpath("//p[normalize-space()='Email is required']");
    private By ErrorMessageEmptyPass=By.xpath("//p[normalize-space()='Password is required']");

   public void LoginWithInvalidCredentials()
    {
        wait.until(ExpectedConditions.urlContains("login"));
        driver.findElement(EMail).sendKeys("rf@gmail.com");
        driver.findElement(Password).sendKeys("P@ssw0rd");
        driver.findElement(LoginButton).click();
    }

    public void LoginWithValidCredentials()
    {
        wait.until(ExpectedConditions.urlContains("login"));
        driver.findElement(EMail).sendKeys("nourandarwiish@gmail.com");
        driver.findElement(Password).sendKeys("Eyouth@2025");
        driver.findElement(LoginButton).click();
    }

    public boolean CheckErrorMessage()
    {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage)).isDisplayed();
    }
    public boolean CheckEmptyMailErrorMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageEmptyMail)).isDisplayed();
    }
    public boolean CheckEmptyPassErrorMessage()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageEmptyPass)).isDisplayed();
    }

   public void LoginWithEmptyFields()
   {
       wait.until(ExpectedConditions.urlContains("login"));
       driver.findElement(EMail).sendKeys("");
       driver.findElement(Password).sendKeys("");
       driver.findElement(LoginButton).click();

   }
}

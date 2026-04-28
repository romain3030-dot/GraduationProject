package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CreateAccountPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By UserName= By.name("fullname_en");
    private By Email=By.name("email");
    private By CountryDropDown=By.xpath("//button[@role='combobox']");
    private By cityDropdown = By.xpath("//button[@role='combobox' and .//span[normalize-space()='City']]");
    private By GenderDropdown = By.xpath("//button[@role='combobox' and .//span[normalize-space()='Gender']]");
    private By PhoneNumber = By.id("phone");
    private By Password= By.id("password");
    private By ConfirmPassword=By.id("confirm_password");
    private By CheckBox=By.id("terms");
    private By ErrorMessage = By.xpath("//p[contains(.,'Name')]");


    By createAccountBtn = By.xpath("//button[contains(.,'Create')]");;

    public  void CreateAccount()
    {
        wait.until(ExpectedConditions.urlContains("register"));
        driver.findElement(UserName).sendKeys("");
        driver.findElement(Email).sendKeys("rr@gmail.com");

        ClickDropDown(CountryDropDown,"Egypt","مصر");
        ClickDropDown(cityDropdown,"Cairo","القاهرة");
        ClickDropDown(GenderDropdown,"Female","انثى");
        driver.findElement(PhoneNumber).sendKeys("01032658749");
        driver.findElement(Password).sendKeys("P@ssw0rd");
        driver.findElement(ConfirmPassword).sendKeys("P@ssw0rd");


        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(CheckBox));

        if (!"true".equals(checkbox.getAttribute("aria-checked"))) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        }
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(createAccountBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

    }
    public void ClickDropDown(By DropDown,String EngValue, String ArbValue)
    {
        wait.until(ExpectedConditions.elementToBeClickable(DropDown)).click();


        By egyptOption = By.xpath("//div[@role='option' and (contains(.,'"+EngValue+"') or contains(.,'"+ArbValue+"'))]");
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(egyptOption));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

    }
   public boolean VerifyMissingName()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessage)).isDisplayed();
    }
}

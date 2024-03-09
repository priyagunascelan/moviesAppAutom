package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//ul/li")
    List<WebElement> AccountUlEl;
    @FindBy(className = "logout-button")
    WebElement logoutEl;
    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public int getAccountUl(){
        return AccountUlEl.size();
    }
    public WebElement getLogOut(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout-button")));
        return logoutEl;
    }

}

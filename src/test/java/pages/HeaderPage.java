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

public class HeaderPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(className = "website-logo")
    WebElement checkLogo;
    @FindBy(xpath = "(//ul[@class ='nav-menu-list']/child::*)[1]")
    WebElement homeNavEl;
    @FindBy(xpath = "(//ul[@class ='nav-menu-list']/child::*)[2]")
    WebElement popularNavEl;
    @FindBy(xpath = "(//div[@class = 'search-account-container'])/*[1]")
    WebElement searchNavEl;
    @FindBy(className = "avatar-button")
    WebElement accountNavEl;

    public HeaderPage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement getCheckLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        return  checkLogo;
    }
    public WebElement getHomeNavEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class ='nav-menu-list']/child::*)[1]")));
        return homeNavEl;
    }
    public WebElement getPopularNavEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//ul[@class ='nav-menu-list']/child::*)[2]")));
        return popularNavEl;
    }
    public WebElement getSearchNavEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class = 'search-account-container'])/*[1]")));
        return searchNavEl;
    }
    public WebElement getAccountNavEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-button")));
        return accountNavEl;
    }
}

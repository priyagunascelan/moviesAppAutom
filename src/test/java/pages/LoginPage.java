package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    @FindBy(className = "login-website-logo")
    @CacheLookup
    WebElement moviesLogoEl;

    @FindBy(className = "sign-in-heading")
    @CacheLookup
    WebElement moviesLoginEl;

    @FindBy(xpath = "//label[@for ='usernameInput']")
    @CacheLookup
    WebElement moviesUsernameEl;

    @FindBy(xpath = "//label[@for ='passwordInput']")
    @CacheLookup
    WebElement moviesPasswordEl;

    @FindBy(className = "login-button")
    @CacheLookup
    WebElement moviesLoginButtonEl;
    @FindBy(id = "usernameInput")
    @CacheLookup
    WebElement moviesUsernameEnter;
    @FindBy(id = "passwordInput")
    @CacheLookup
    WebElement moviesPasswordEnter;

    @FindBy(css = "p[class = 'error-message']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public WebElement getMoviePageLogo(){
        return moviesLogoEl;
    }
    public String getLoginText(){
        return  moviesLoginEl.getText();
    }
    public String getUserNameText(){
        return  moviesUsernameEl.getText();
    }
    public String getPasswordText(){
        return moviesPasswordEl.getText();
    }
    public WebElement getLoginButton(){
        return moviesLoginButtonEl;
    }
    public void enterUserName(String name){
        moviesUsernameEnter.sendKeys(name);
    }
    public void enterPassword(String password){
        moviesPasswordEnter.sendKeys(password);
    }
    public void clickLoginPage(){
        getLoginButton().click();
    }
    public void logintheApplication(String name, String password){
        moviesUsernameEnter.sendKeys(name);
        moviesPasswordEnter.sendKeys(password);
        getLoginButton().click();
    }
     public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMessage.getText();
    }



}

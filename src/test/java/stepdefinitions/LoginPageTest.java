package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    @Given("I am on the login page")
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test()
    @When("I Test the Login Page UI")
    public void loginPageUi(){
        Assert.assertTrue(loginPage.getMoviePageLogo().isDisplayed(),"Logo Not Displayed");
        Assert.assertEquals(loginPage.getLoginText(),"Login","Login Doesn't Match");
        Assert.assertEquals(loginPage.getUserNameText(),"USERNAME","Username doesn't match");
        Assert.assertEquals(loginPage.getPasswordText(),"PASSWORD","Password doesn't match");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed(),"Login Button doesn't match");
        System.out.println("login 1");
    }
    @Test(priority = 1)
    @When("I Login with empty input fields")
    public void loginPageEmptyField(){
        loginPage.clickLoginPage();
        String error = loginPage.getErrorMsg();
        Assert.assertEquals(error,"*Username or password is invalid");
        System.out.println("login 2");
    }
    @Test(priority = 2)
    @And("I Login with empty User name field")
    public void loginPageEmptyUsername(){
        loginPage.logintheApplication("","rahul@2021");
        String error = loginPage.getErrorMsg();
        Assert.assertEquals(error,"*Username or password is invalid");
        System.out.println("login 3");
    }
    @Test(priority = 3)
    @And("I Login with empty password field")
    public void loginPageEmptyPassword(){
        loginPage.logintheApplication("rahul","");
        String error = loginPage.getErrorMsg();
        Assert.assertEquals(error,"*Username or password is invalid");
        System.out.println("login 4");
    }
    @Test(priority = 4)
    @But("I Login with invalid password")
    public void loginPageInvalidCredentials(){
        loginPage.logintheApplication("rahul","rahul14");
        String error = loginPage.getErrorMsg();
        Assert.assertEquals(error,"*username and password didn't match");
        System.out.println("login 5");
    }
    @Test(priority = 5)
    @Then("I Login with valid UserID and password")
    public void loginPageValidCredentials(){
        loginPage.logintheApplication("rahul","rahul@2021");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login");
        System.out.println("login 6");
    }
}
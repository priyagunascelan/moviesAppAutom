package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {
    WebDriver driver;
    AccountPage accountPage;
    LoginPage loginPage;
    HomePage homePage;
    HeaderPage headerPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        headerPage = new HeaderPage(driver);

        loginPage.logintheApplication("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    @When("I test all the UI elements present on the web page")
    public void ulElAccount(){
        headerPage.getAccountNavEl().click();
        int ulAccount = accountPage.getAccountUl();
        Assert.assertEquals(ulAccount,2,"Account ul doesn't match");
        System.out.println("Account 1");
    }
    @Test(priority = 1)
    @Then("I Test the Logout functionality")
    public  void logoutFun(){
        headerPage.getAccountNavEl().click();
        accountPage.getLogOut().click();
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl,"After logout URL doesn't match");
    }

}


package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;

import java.time.Duration;

public class HeaderPageTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HeaderPage headerPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
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
    @When("I test the logo is display")
    public void checkLogo(){
        boolean logo = headerPage.getCheckLogo().isDisplayed();
        Assert.assertTrue(logo,"Logo doesn't display");
    }
    @Test(priority = 1)
    @And("I test Navbar elements present")
    public void checkNavHome(){
        boolean home = headerPage.getHomeNavEl().isDisplayed();
        Assert.assertTrue(home,"Home doesn't display");
        boolean popular = headerPage.getPopularNavEl().isDisplayed();
        Assert.assertTrue(popular,"Home doesn't display");
        boolean search = headerPage.getSearchNavEl().isDisplayed();
        Assert.assertTrue(search,"Home doesn't display");
        boolean account = headerPage.getAccountNavEl().isDisplayed();
        Assert.assertTrue(account,"Home doesn't display");
    }
    @Test(priority = 2)
    @Then("I have validate the url page")
    public void headerSectionFun(){
        headerPage.getHomeNavEl().click();
        String currentUrl = driver.getCurrentUrl();
        String expectUrl = "https://qamoviesapp.ccbp.tech/";
        Assert.assertEquals(currentUrl,expectUrl,"Home Url doesn't match");
        headerPage.getPopularNavEl().click();
        currentUrl = driver.getCurrentUrl();
        expectUrl ="https://qamoviesapp.ccbp.tech/popular";
        Assert.assertEquals(currentUrl,expectUrl,"Popular Url doesn't match");
        headerPage.getSearchNavEl().click();
        currentUrl = driver.getCurrentUrl();
        expectUrl ="https://qamoviesapp.ccbp.tech/search";
        Assert.assertEquals(currentUrl,expectUrl,"Search Url doesn't match");
        headerPage.getAccountNavEl().click();
        currentUrl = driver.getCurrentUrl();
        expectUrl ="https://qamoviesapp.ccbp.tech/account";
        Assert.assertEquals(currentUrl,expectUrl,"Account Url doesn't match");
    }


}

package stepdefinitions;

import io.cucumber.java.en.When;
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
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HeaderPage headerPage;
    PopularPage popularPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        popularPage = new PopularPage(driver);

        loginPage.logintheApplication("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        headerPage.getPopularNavEl().click();
        expectedUrl="https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    @When("I Test whether the popular movies are displayed")
    public void checkPopularMovies(){
        int numMovies = popularPage.getAllPopularMovies();
        Assert.assertEquals(numMovies,30,"Number of movies present is mismatch");
        boolean moviePresent = popularPage.getaMoviePresent().isDisplayed();
        Assert.assertTrue(moviePresent,"A particular movie doesn't present in popular page");
    }
}

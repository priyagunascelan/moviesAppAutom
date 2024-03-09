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
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {
    WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;
    HeaderPage headerPage;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.logintheApplication("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        headerPage.getSearchNavEl().click();
        expectedUrl="https://qamoviesapp.ccbp.tech/search";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    @When("I searching with a movie name and the count of movies displayed")
    public void enterMovieName(){
        searchPage.getEnterName("ca");
        searchPage.clickMovieEnter().click();
        int numMovies = searchPage.getMoviesDis();
        Assert.assertEquals(numMovies,3,"number of Movies diplay count is Mismatch");
    }
}

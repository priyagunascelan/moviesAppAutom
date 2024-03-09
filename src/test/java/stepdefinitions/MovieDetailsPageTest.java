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
import pages.HeaderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MovieDetailsPage;

import java.time.Duration;

public class MovieDetailsPageTest {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;
    HeaderPage headerPage;
    MovieDetailsPage movieDetailsPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        homePage = new HomePage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
        loginPage = new LoginPage(driver);
        headerPage = new HeaderPage(driver);

        loginPage.logintheApplication("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    @When("I am in the Home Page click on any Movie and test all the UI elements present in it")
    public void homemovies(){
        movieDetailsPage.getHomePageMovie().click();
        int ulSize = movieDetailsPage.getUlElement();
        Assert.assertEquals(ulSize,3,"Ul elemnent missing");
    }
    @Test(priority = 1)
    @Then("I am in the Popular Page click on any Movie and test all the UI elements present in it")
    public void popularMovies(){
        headerPage.getPopularNavEl().click();
        movieDetailsPage.getUlElementPopular().click();
        int popularUl = movieDetailsPage.getUlpopular();
        Assert.assertEquals(popularUl,3,"Popular pageul doesn't match");
    }

}

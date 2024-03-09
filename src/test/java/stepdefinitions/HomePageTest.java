package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
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

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    @When("I should be redirected to the homepage")
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.logintheApplication("rahul", "rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    @And("I test the heading texts of each section")
    public void checkHeading() {
        String trendText = homePage.getTrending();
        Assert.assertEquals(trendText, "Trending Now", "Trending doesn't match");
        String originalText = homePage.getOriginal();
        Assert.assertEquals(originalText, "Originals", "Original doesn't match");
    }

    @Test(priority = 1)
    @And("I test whether the play button is displayed or not")
    public void checkPlayButton() {
        Assert.assertTrue(homePage.getPlayButton().isDisplayed(), "Play button doesn't display");
    }

    @Test(priority = 2)
    @But("I test whether the Movies are displayed, in the corresponding movies sections")
    public void checkWhetherMoviesDisplay() {
        int size = homePage.getMoviesTrending();
        Assert.assertEquals(size, 10, "Some movies not display");
        int sizeOriginalMovie = homePage.getMoviesOriginal();
        Assert.assertEquals(sizeOriginalMovie, 10, "Some movies not display");
        boolean trendingCheckPresent = homePage.getTredingMovie().isDisplayed();
        Assert.assertTrue(trendingCheckPresent, "Trending Movie doesn't not display");
        boolean originalCheckPresent = homePage.getOriginalMovie().isDisplayed();
        Assert.assertTrue(originalCheckPresent, "Original Movie doesn't not display");
    }

    @Test(priority = 3)
    @Then("I test the Contact Us Section")
    public void contactSection() {
        int contactSize = homePage.getContactEl();
        Assert.assertEquals(contactSize, 4, "Some contact not display");
        boolean getGoogle = homePage.getGoogleContactEl().isDisplayed();
        Assert.assertTrue(getGoogle, "Google Doesn't present");
        boolean getTwitter = homePage.getTwitterContactEl().isDisplayed();
        Assert.assertTrue(getTwitter, "Twitter Doesn't present");
        boolean getInsta = homePage.getInstaContactEl().isDisplayed();
        Assert.assertTrue(getInsta, "Insta Doesn't present");
        boolean getYoutube = homePage.getYoutubeContactEl().isDisplayed();
        Assert.assertTrue(getYoutube, "Youtube Doesn't present");
    }

}
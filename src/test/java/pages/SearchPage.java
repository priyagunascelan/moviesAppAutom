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

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "search")
    WebElement entername;
    @FindBy(className = "search-button")
    WebElement clickMovieEnter;
    @FindBy(xpath = "//ul[@class ='search-movies-container']/*")
    List<WebElement> countMovies;
    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void getEnterName(String movieName){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/search"));
        entername.sendKeys(movieName);
    }
    public WebElement clickMovieEnter(){
        return clickMovieEnter;
    }
    public int getMoviesDis(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class ='search-movies-container']/*")));
        return countMovies.size();
    }

}

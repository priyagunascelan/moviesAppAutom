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

public class MovieDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "((//div[@class = 'slick-track'])[1]/div)[3]")
    WebElement homePageMovie;
    @FindBy(xpath = "//ul")
    List<WebElement> allUlElement;
    @FindBy(xpath = "((//div[@class = 'search-movies-container'])[1]/li)[3]")
    WebElement popularPageMovie;
    @FindBy(xpath = "//ul")
    List<WebElement> allUlPopularElement;
    public MovieDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getHomePageMovie() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class = 'slick-track'])[1]/div)[3]")));
        return homePageMovie;
    }
    public int getUlElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class ='movie-title']")));
        return allUlElement.size();
    }
    public WebElement getUlElementPopular(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class = 'search-movies-container'])[1]/li)[3]")));
        return popularPageMovie;
    }
    public int getUlpopular(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul")));
        return allUlPopularElement.size();
    }

}

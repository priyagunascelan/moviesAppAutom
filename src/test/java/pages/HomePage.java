package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Introspector;
import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//h1[text() = 'Trending Now']")
    @CacheLookup
    WebElement trendingSection;

    @FindBy(xpath = "//h1[text() = 'Originals']")
    @CacheLookup
    WebElement originalSection;
    @FindBy(xpath = "//button[text() ='Play']")
    @CacheLookup
    WebElement playButton;

    @FindBy(xpath= "(//div[@class = 'slick-track'])[1]/div")
    List<WebElement> eachtrendingMovies;

    @FindBy(xpath= "(//div[@class = 'slick-track'])[2]/div")
    List<WebElement> eachOriginalMovies;
    @FindBy(xpath = "((//div[@class = 'slick-track'])[1]/div)[1]")
    WebElement trendingMovie;
    @FindBy(xpath = "((//div[@class = 'slick-track'])[2]/div)[2]")
    WebElement originalMovie;
    @FindBy(xpath = "//div[@class = 'footer-icons-container']/child::*")
    List<WebElement> contactEl;
    @FindBy(xpath = "(//div[@class = 'footer-icons-container']/child::*)[1]")
    WebElement googleContactEl;
    @FindBy(xpath = "(//div[@class = 'footer-icons-container']/child::*)[2]")
    WebElement twitterContactEl;
    @FindBy(xpath = "(//div[@class = 'footer-icons-container']/child::*)[3]")
    WebElement instaContactEl;
    @FindBy(xpath = "(//div[@class = 'footer-icons-container']/child::*)[4]")
    WebElement youtubeContactEl;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getTrending(){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        return  trendingSection.getText();
    }
    public String getOriginal(){
        return  originalSection.getText();
    }
    public WebElement getPlayButton(){
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        return playButton;
    }
    public int getMoviesTrending(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class = 'slick-track'])[1]/div")));
        return eachtrendingMovies.size();
    }
    public int getMoviesOriginal(){
        return eachOriginalMovies.size();
    }
    public WebElement getTredingMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class = 'slick-track'])[1]/div)[1]")));
        return trendingMovie;
    }
    public WebElement getOriginalMovie(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class = 'slick-track'])[2]/div)[2]")));
        return originalMovie;
    }
    public int getContactEl(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'footer-icons-container']/child::*")));
        return contactEl.size();
    }
    public WebElement getGoogleContactEl(){
        return  googleContactEl;
    }
    public WebElement getTwitterContactEl(){
        return  twitterContactEl;
    }
    public WebElement getInstaContactEl(){
        return  instaContactEl;
    }
    public WebElement getYoutubeContactEl(){
        return  youtubeContactEl;
    }


}

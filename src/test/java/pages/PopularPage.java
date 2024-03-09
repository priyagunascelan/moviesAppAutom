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

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[@class ='link-item']/child::*")
    List<WebElement> allPopularMovies;
    @FindBy(xpath = "//img[@alt ='Venom']")
    WebElement aMoviePresent;
    public PopularPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public int getAllPopularMovies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class ='link-item']/child::*")));
        return allPopularMovies.size();
    }
    public WebElement getaMoviePresent(){
        return aMoviePresent;
    }
}

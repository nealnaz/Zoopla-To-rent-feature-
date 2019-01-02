import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Torent {


    WebDriver driver;


    @Test
    public void openBrowser() {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zubair\\Desktop\\NewAutomation\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.zoopla.co.uk/");


        String t = driver.getTitle();
        System.out.println(t);

        if (t.contains("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents"))

            System.out.println("title validated ");
        else
            System.out.println("title different");

        driver.findElement(By.xpath("//*[@id=\"mn-rent\"]/a")).click();


        driver.findElement(By.id("search-input-location")).sendKeys("oxfordshire");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        new Select(driver.findElement(By.id("rent_price_min_per_month"))).selectByVisibleText("£100 pcm");

        new Select(driver.findElement(By.id("rent_price_max_per_month"))).selectByVisibleText("£100 pcm");


        new Select(driver.findElement(By.id("property_type"))).selectByVisibleText("Flats");


        new Select(driver.findElement(By.id("beds_min"))).selectByVisibleText("1+");


        driver.findElement(By.id("search-submit")).submit();
    }
}



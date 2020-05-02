import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
//        driver.get("https://google.com");
//        System.out.println(driver.getTitle());
//        System.out.println(driver.getCurrentUrl());
//        driver.close();

        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).
                sendKeys("погода Минск");
        driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).submit();
        driver.findElement(By.xpath("//div[contains(@class,'r')]/a[1]")).click();


        //driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().back();
//        driver.navigate().refresh();

    }
}

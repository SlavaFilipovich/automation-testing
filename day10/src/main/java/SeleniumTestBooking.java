import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTestBooking {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("https://booking.com");
        driver.findElement(By.xpath("//*[contains(@placeholder,'Куда вы хотите поехать')]")).sendKeys("Париж");
//        WebElement dateYear = driver.findElement(By.xpath("//input[@name='checkin_year']"));
//        dateYear.sendKeys("2020");
//        WebElement dateMonth = driver.findElement(By.xpath("//input[@name='checkin_month']"));
//        dateMonth.sendKeys("May");
//        WebElement dateYear = driver.findElement(By.xpath("//input[@name='checkin_year']"));
//        dateYear.sendKeys("2020");
//        driver.findElement(By.xpath("//*[contains(@placeholder,'Where are you going')]")).sendKeys("Paris");

        //WebElement dateYear = driver.findElement(By.xpath("//*[@id=\"frm\"]//select/option[@value=""]"));

        //dateYear.click();
        //dateYear.click();

        WebElement dateMonth = driver.findElement(By.xpath("///*[@id=\"frm\"]//select[@aria-label=\"Месяц заезда\"]/option[1]"));
        dateMonth.sendKeys("5-2020");
        dateMonth.click();
        dateMonth.click();

//*[@id="frm"]//select/option[@value=6]

    }
}

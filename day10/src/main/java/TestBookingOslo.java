import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestBookingOslo {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();

        driver.get("https://booking.com");
        WebElement elCity = driver.findElement(By.id("ss"));
        elCity.sendKeys("Осло");
        elCity.click();

        driver.findElement(By.xpath("//*[@data-mode='checkin']")).click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date oneNight = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date oneDay = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusOneNight = dateFormat.format(oneNight);
        String datePlusOneDay = dateFormat.format(oneDay);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusOneDay)));
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusOneNight)));

        Actions actions = new Actions(driver);
        actions.click(dateFrom).moveToElement(dateTo).click().build().perform();

        WebElement settingTrip = driver.findElement(By.xpath("//label[@class='xp__input']"));
        WebElement buttonChildren = driver.findElement(By.xpath("//*[@aria-describedby='group_children_desc'][2]"));
        WebElement checkPrice = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));

        actions.click(settingTrip).moveToElement(buttonChildren).click()
                .moveToElement(settingTrip).doubleClick()
                .moveToElement(checkPrice).click().build().perform();

        WebElement checkboxStar3 = driver.findElement(By.xpath("//a[@data-id='class-3']"));
        WebElement checkboxStar4 = driver.findElement(By.xpath("//a[@data-id='class-4']"));
        actions.click(checkboxStar3).moveToElement(checkboxStar4).click().build().perform();
        Thread.sleep(3000);

        WebElement tenthHotel = driver.findElement(By.xpath("//*[@data-hotelid][10]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);
        Thread.sleep(1000);
        WebElement nameOfHotel = driver.findElement(By.xpath("//*[@data-hotelid][10]//span[contains(@class,'sr-hotel__name')]"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthHotel);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", nameOfHotel);
        Thread.sleep(3000);

        Assert.assertEquals("Change of textColor doesn't work","color: red;", nameOfHotel.getAttribute("style"));
        Assert.assertEquals("Change of backgroundColor doesn't work","background-color: green;", tenthHotel.getAttribute("style"));

        Thread.sleep(5000);
        driver.quit();
    }
}

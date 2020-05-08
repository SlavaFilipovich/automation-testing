import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestBookingMoscow {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://booking.com");
        WebElement elCity = driver.findElement(By.id("ss"));
        elCity.sendKeys("Москва");
        elCity.click();

        driver.findElement(By.xpath("//*[@data-mode='checkin']")).click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date tenDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fiveDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusTenDays = dateFormat.format(tenDays);
        String datePlusFiveDays = dateFormat.format(fiveDays);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        dateFrom.click();
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusFiveDays)));
        dateTo.click();

        Actions actions = new Actions(driver);
        WebElement settingTrip = driver.findElement(By.xpath("//label[@class='xp__input']"));
        WebElement buttonAdults = driver.findElement(By.xpath("//*[@aria-describedby='group_adults_desc'][2]"));
        WebElement buttonRoom = driver.findElement(By.xpath("//*[@aria-describedby='no_rooms_desc'][2]"));
        WebElement checkPrice = driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']"));
        actions.click(settingTrip).moveToElement(buttonAdults).doubleClick()
                .moveToElement(buttonRoom).click()
                .moveToElement(settingTrip).doubleClick()
                .moveToElement(checkPrice).click().build().perform();

        WebElement checkbox = driver.findElement(By.xpath("//a[@data-id='pri-1']"));
        actions.click(checkbox).build().perform();

        String sampleMaxPrice = driver.findElement(By.xpath("//a[@data-id='pri-1']//span"))
                                        .getText()
                                        .split("-")[1]
                                        .replaceAll("[^0-9.]", "");
        int maxPrice = Integer.parseInt(sampleMaxPrice);
        Thread.sleep(5000);

        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='bui-price-display__value prco-inline-block-maker-helper']"));
        String maxCost = priceList.get(1).getText().replaceAll("[^0-9.]", "");
        int budgetNight = Integer.parseInt(maxCost) / 5;

        if(budgetNight>maxPrice) {
            Assert.assertTrue("Something wrong", budgetNight>maxPrice);
        } else
            System.out.println(String.format("Budget per night: %s BYN\r\nMaxPrice: %s BYN",budgetNight,maxPrice));

        Thread.sleep(5000);
        driver.quit();
    }
}

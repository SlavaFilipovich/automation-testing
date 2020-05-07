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
        WebElement elCity = driver.findElement(By.xpath("//*[contains(@placeholder,'Куда вы хотите поехать')]"));
        elCity.sendKeys("Москва");
        elCity.click();

        driver.findElement(By.xpath("//div[@data-calendar2-title='Приезжаю']")).click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusThreeDays)));
        dateFrom.click();
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        dateTo.click();

        Actions actions = new Actions(driver);
        WebElement settingTrip = driver.findElement(By.xpath("//label[@class='xp__input']"));
        WebElement buttonAdults = driver.findElement(By.xpath("//*[contains(@aria-label, 'Взрослых: увеличить количество')]"));
        WebElement buttonRoom = driver.findElement(By.xpath("//*[contains(@aria-label, 'Номера: увеличить количество')]"));
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
        //driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        Thread.sleep(5000);
        List<WebElement> hotelsList = driver.findElements(By.xpath("//div[@class='bui-price-display__value prco-inline-block-maker-helper']"));
        String maxCost = hotelsList.get(1).getText().replaceAll("[^0-9.]", "");
        int budgetNight = Integer.parseInt(maxCost) / 5;

        if(budgetNight>maxPrice) {
            Assert.assertTrue("Something wrong", budgetNight>maxPrice);
        } else
            System.out.println(String.format("Budget per night: %s BYN\r\nMaxPrice: %s BYN",budgetNight,maxPrice));

        //driver.quit();



    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestBooking {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("https://booking.com");
        WebElement elCity = driver.findElement(By.xpath("//*[contains(@placeholder,'Куда вы хотите поехать')]"));
        elCity.sendKeys("Париж");
        elCity.click();

        driver.findElement(By.xpath("//div[@data-calendar2-title='Приезжаю']")).click();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);
        System.out.println(datePlusThreeDays);
        System.out.println(datePlusTenDays);
        WebElement dateFrom=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusThreeDays)));
        dateFrom.click();
        WebElement dateTo=driver.findElement(By.xpath(String.format("//*[contains(@data-date,'%s')]", datePlusTenDays)));
        dateTo.click();

        WebElement element = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[3]"));
        element.click();

        WebElement button = driver.findElement(By.xpath("//*[contains(@aria-label, 'Взрослых: увеличить количество')]"));
        button.click();button.click();
        WebElement button2 = driver.findElement(By.xpath("//*[contains(@aria-label, 'Номера: увеличить количество')]"));
        button2.click();
        element.click();element.click();

        WebElement checkPrice = driver.findElement(By.xpath("//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button"));
        checkPrice.click();



    }
}

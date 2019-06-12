
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class SeleniumTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Paweł\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("staples solutions uk");
        element.submit();

        WebElement result = driver.findElement(By.id("resultStats"));
        System.out.println("Result ststs: " + result.getText());

        WebElement search = ((ChromeDriver) driver).findElement(By.xpath("//h3[contains(.,'Office Supplies, Office Furniture and Stationery | Staples®')]"));
        search.click();

        Boolean isItemPresent = driver.findElements(By.cssSelector(".hdr_logo")).size() > 0;
        System.out.println("Czy element istnieje: "+ isItemPresent);

        //String screenShot = System.getProperty("user.dir")+"screenShot.png";
        String screenShot = "screenShot.png";

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime time = LocalDateTime.now();
        try {
            FileUtils.copyFile(scrFile, new File(screenShot));
            System.out.println("blabla");
        } catch (IOException e) {
            e.printStackTrace();
        }


        driver.quit();

    }
}


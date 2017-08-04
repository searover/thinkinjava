import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by searover on 05/06/2017.
 */
public class SeleniumTest {

    @Test
    public void takeScreenshot() throws IOException {
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com/");
//        ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        System.out.println(driver.findElement(By.id("u1")));
//        File imgFile = we.getScreenshotAs(OutputType.FILE);
//        System.out.println(imgFile);
        WebElement we = driver.findElement(By.id("lg"));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = we.getLocation();
        int weWidth = we.getSize().getWidth();
        int weHeight = we.getSize().getHeight();
        System.out.println(point.getX() + "\t," + point.getY() + "\t," + weWidth + "\t," + weHeight);
        BufferedImage weScreenshot = fullImg.getSubimage(point.getX(), point.getY(), weWidth * 2, weHeight * 2);
        ImageIO.write(weScreenshot, "png", screenshot);
        File screenshotLocation = new File("/Users/searover/Documents/temp/java-demo/thinkinjava/kafka/src/main/resources/a.png");
        FileUtils.copyFile(screenshot, screenshotLocation);
//        FileUtils.copyFile(imgFile, new File("/Users/searover/Documents/temp/java-demo/thinkinjava/kafka/src/main/resources/a.png"));
        driver.close();
    }
}

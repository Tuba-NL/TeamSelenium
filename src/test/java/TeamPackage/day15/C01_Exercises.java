package TeamPackage.day15;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Exercises extends TestBase {
    //1.Bir Class olusturalim KeyboardActions2
    // 2.https://html.com/tags/iframe/ sayfasina gidelim
    // 3.video'yu gorecek kadar asagi inin
    //4.videoyu izlemek icin Play tusuna basin
    //5.videoyu calistirdiginizi test edin


    @Test
    public void Test01() {

        // 1.https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        wait(1);


        //2.video'yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //3.videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
        wait(1);

        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click();

        //4.videoyu calistirdiginizi test edin
        WebElement test = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(test.isDisplayed());
    }
}
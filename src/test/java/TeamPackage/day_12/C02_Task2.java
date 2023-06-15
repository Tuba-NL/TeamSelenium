package TeamPackage.day_12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Task2 extends TestBase {
    @Test
    public void Test01() {
     // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe);

     // ikinci emojiye tıklayın
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

     // İkinci emoji öğelerini yazdırınız
        String emoji = driver.findElement(By.xpath("//*[@class='mdl-tabs__panel is-active']")).getText();
        System.out.println("emoji = " + emoji);

     // Parent iframe e geri donun
        driver.switchTo().parentFrame();
     //driver.switchTo().defaultContent();

     // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Merhaba", Keys.TAB,
                "Tuba",Keys.TAB, "Nur",Keys.TAB , "Kubra",Keys.TAB , "Hamit");

     // Apply button a basiniz
        driver.findElement(By.xpath("//*[.='Apply']")).click();
    }
}

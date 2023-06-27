package Task;

import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Date;
import java.util.List;

public class Task5 extends TestBase {

    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    // ikinci emojiye tıklayın
    // İkinci emoji öğelerini yazdırınız
    // Parent iframe e geri donun
    // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
    // Apply button a basiniz


    @Test
    public void Test01() {
      // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

      // ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();

      // İkinci emoji öğelerini yazdırınız
        List<WebElement> emojiler = driver.findElements(By.xpath("//div[@id='nature']"));
        emojiler.forEach(t-> System.out.println(t.getText()));

      // Parent iframe e geri donun
        driver.switchTo().parentFrame();

      // Formu doldurun,(Formu istediğiniz metinlerle doldurun)
        WebElement veriler = driver.findElement(By.xpath("(//*[@class='mdl-textfield__input'])[1]"));
        veriler.sendKeys("Tuba"+ Keys.TAB,"Icer" +Keys.TAB,"selenium"+Keys.TAB,"lambda"+Keys.TAB,"sql"+Keys.TAB,"java"+ Keys.ENTER);

      // Apply button a basiniz
        driver.findElement(By.xpath("//*[.='Apply']")).click();
    }
}

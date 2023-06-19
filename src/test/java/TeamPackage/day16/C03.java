package TeamPackage.day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03 extends TestBase {


     // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
     // - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
     // - Çizimden sonra clear butonuna basınız
     // - Sayfayi kapatiniz

    @Test
    public void Test01() {

      // - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

      // - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement ekran = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));
        Actions action = new Actions(driver);
        action.clickAndHold(ekran).
                moveByOffset(50,20).
                moveByOffset(20,50).
                moveByOffset(-70,10).
                moveByOffset(90,-100).
                moveByOffset(20,50).
                release().
                perform();

      // - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[@class='button clear']")).click();
        wait(2);

      // - Sayfayi kapatiniz
        driver.close();

    }
}

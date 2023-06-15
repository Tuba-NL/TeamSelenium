package TeamPackage.day_12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_Task3 extends TestBase {
    @Test
    public void Test01() {
     //  ...Exercise2...

     //  1-driver olusturalim

     //  2-java class'imiza chromedriver.exe'yi tanitalim
     //  3-driver'in tum ekrani kaplamasini saglayalim
     //  4-driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     //    söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
     //  5-"hepsiburada.com" adresine gidelim
        driver.get("https://hepsiburada.com");
        String handle1 = driver.getWindowHandle();
        wait(2);

     //  6-bu web adresinin sayfa basligini(title) ve adres(url)ini alalim
        String sayfaBasligi1 = driver.getTitle();
        String sayfaUrl1 = driver.getCurrentUrl();
        wait(2);

     //  7-title ve url'nin "Oto" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertFalse(sayfaBasligi1.contains("Oto"));
        Assert.assertFalse(sayfaUrl1.contains("Oto"));
        wait(2);

     //  8-Ardindan "https://trendyol.com" yeni sekmede acalim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://trendyol.com");
        String handle2 = driver.getWindowHandle();
        wait(2);

     //  9-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini
     //    kontrol edelim
        String sayfaBasligi2 = driver.getTitle();
        Assert.assertFalse(sayfaBasligi2.contains("Sitesi"));
        wait(2);

     //  10-Bi onceki web sayfamiza geri donelim
        driver.switchTo().window(handle1);
        wait(2);

     //  11-sayfayi yenileyelim
        driver.navigate().refresh();
        wait(2);

     //  12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.switchTo().window(handle2);
        wait(2);
        driver.close();



     //  13-En son adim olarak butun sayfalarimizi kapatmis olalim
       // driver.quit();

    }
}

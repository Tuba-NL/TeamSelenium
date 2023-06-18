package TeamPackage.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {

    // 1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
    // 2) sayfadaki toplam iframe sayısını bulunuz.
    // 3) Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
    // 4) Paragrafdaki yaziyi silelim
    // 5) Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
    // 6) Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim

    @Test
    public void Test01() {
        // 1)https://the-internet.herokuapp.com/iframe sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2) sayfadaki toplam iframe sayısını bulunuz.
        int sayi = driver.findElements(By.tagName("iframe")).size();
        System.out.println(sayi);

        // 3) Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        String editor = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));

        // 4) Paragrafdaki yaziyi silelim
        WebElement iframe = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//p")).clear();
        wait(2);

        // 5) Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        driver.findElement(By.xpath("//p")).sendKeys("iframein icindeyim");
        driver.switchTo().defaultContent();


        // 6) Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        WebElement sonYazi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(sonYazi.isDisplayed());
/*
        selenium iframe'i goremez. switchto() ile iframe gecmenin 3 yolu vardir.

        1. index ile
        driver.switchto().frame(index of the iframe); index 0 dan baslar.

        2. id veya name value ile
        driver.switchto().frame(id of the iframe);

        3. Webelement ile
        driver.switchto().frame(webelement of the iframe);

        iframe'den cikmak icin iki komut vardir.

        driver.switchto().parentFrame();= bir ust seviyedeki frame
        driver.switchto().defaultContent();=en ustteki frame cikmak icin kullanilir.
*/
    }
}

package TeamPackage.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_WindowHandles extends TestBase {

    // 'https://www.n11.com' adresine gidin
    // arama motoruna 'Oppo' yazıp aratın
    // ilk ürüne tıklayın
    // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
    // ilk sayfaya donun ve Title'ını yazdırın

    @Test
    public void Test01() {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("sayfa1Handle = " + sayfa1Handle);


        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//*[@id='searchData']")).sendKeys("Oppo", Keys.ENTER);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='productName'])[1]"));
        ilkUrun.click();
        wait(2);




        Set<String> pencereler = driver.getWindowHandles();
        System.out.println("pencereler = " + pencereler);

        String sayfa2Handle = "";
        for (String each : pencereler ) {
            if(!each.equals(sayfa1Handle)){
                sayfa2Handle = each;
            }
        }

        System.out.println("sayfa2Handle = " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);
        wait(2);


        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        String ikinciSayfaTitle = driver.getTitle();
        System.out.println("ikinciSayfaTitle = " + ikinciSayfaTitle);
        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));

        // ilk sayfaya donun ve Title'ını yazdırın
        driver.switchTo().window(sayfa1Handle);
        System.out.println("ilkSayfaTitle = " + driver.getTitle());

    }
}

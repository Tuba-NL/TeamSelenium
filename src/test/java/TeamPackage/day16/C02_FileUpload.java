package TeamPackage.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FileUpload extends TestBase {

    @Test
    public void Test01() {

        // 2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 3. chooseFile butonuna basalim

        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
        // dosyaSec.sendKeys(dosyaYolu);

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "/Desktop/text.txt";
        String yol = farkliKisim + ortakKisim;
        dosyaSec.sendKeys(yol);


        // 4. Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:/Users/gebruiker/Desktop/text.txt";

        // 5. Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        // 6. “File Uploaded!” textinin goruntulendigini test edelim
        WebElement sonuc = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(sonuc.isDisplayed());
    }
}

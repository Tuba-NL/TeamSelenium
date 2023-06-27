package Task;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task6 extends TestBase {

    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
    //- Çizimden sonra clear butonuna basınız
    //- Sayfayi kapatiniz


    @Test
    public void Test01() {
        //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

        //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement yaziTahtasi = driver.findElement(By.xpath("//*[@id='signature-pad']"));
        Actions actions = new Actions(driver).clickAndHold(yaziTahtasi);
        //  actions.moveByOffset(20,50).
        //  moveByOffset()

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(-5, -5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0, 5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5, 0);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10, 10);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10, 0);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0, 10);
        }
        actions.release().build().perform();
        wait(2);


        //- Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("(//*[@type='button'])[1]")).click();

        //- Sayfayi kapatiniz
        driver.close();

    }
}


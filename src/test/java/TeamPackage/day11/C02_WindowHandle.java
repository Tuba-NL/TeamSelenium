package TeamPackage.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
        //Yeni bir class olusturun: WindowHandle
public class C02_WindowHandle extends TestBase {



    @Test
    public void WindowHandle() {


        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");


        //Sayfa'nin window handle degerini String bir degiskene atayin
        String amazonHandle = driver.getWindowHandle();
        System.out.println("amazonHandle = " + amazonHandle);

        //Sayfa title'nin "Amazon" icerdigini test edin
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));
        wait(2);

       // Assert.assertEquals("Amazon",amazonTitle);

        //Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");
        wait(2);

        //Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
        String techproTitle = driver.getTitle();
        Assert.assertFalse(techproTitle.contains("TECHPROEDUCATION" ));
        wait(2);

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        wait(2);

        //Sayfa title'nin "Walmart" icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Walmart"));
        wait(2);

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonHandle);
        wait(2);


    }
}

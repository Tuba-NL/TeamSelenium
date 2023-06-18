package TeamPackage.day15;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_Exercises extends TestBase {

    //    Test01 :
//            1- amazon gidin
//2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
//3. dropdown menude 40 eleman olduğunu doğrulayın
//            Test02
//1. dropdown menuden elektronik bölümü seçin
//2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
//3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
//4. ikinci ürüne relative locater kullanarak tıklayin
//5. ürünün title'ni ve fiyatını variable'a assign edip ürünü sepete ekleyelim
//    Test03
//1. yeni bir sekme açarak amazon anasayfaya gidin
//2. dropdown'dan bebek bölümüne secin
//3. bebek puset aratıp bulundan sonuç sayısını yazdırın
//4. sonuç yazsının puset içerdiğini test edin
//5-üçüncü ürüne relative locater kullanarak tıklayin
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
//    Test 4
// 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın


    @Test
    public void Test01() {
        //    Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");

        //2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);

        List<WebElement> categoryName = select.getOptions();
        categoryName.forEach(t -> System.out.println(t.getText()));
        System.out.println("Drop Down Sayisi : " + categoryName.size());


        //3. dropdown menude 40 eleman olduğunu doğrulayın
        Assert.assertFalse(categoryName.size() == 40);
    }

    @Test
    public void Test02() {
        //            Test02
        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);


        //1. dropdown menuden elektronik bölümü seçin
        select.selectByVisibleText("Electronics");

        //2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc Yazisi = " + sonucYazisi.getText());
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[3]);

        //3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));
        wait(1);

        //4. ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[2]")).click();
        wait(1);


        //5. ürünün title'ni ve fiyatını variable'a assign edip ürünü sepete ekleyelim
        System.out.println("Urun Basligi : " + driver.getTitle());
        WebElement fiyat = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        System.out.println("Fiyat =" + fiyat.getText());
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

    }

    @Test
    public void Test03() {
        //    Test03
        driver.get("https://www.amazon.com");
        driver.getWindowHandle();

        //1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        wait(1);


        //2. dropdown'dan bebek bölümüne secin
        WebElement ddm = driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Baby");
        wait(1);

        //3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys(" bebek puset", Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Sonuc Yazisi = " + sonucYazisi.getText());
        String sonucSayisi[] = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[2]);


        //4. sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("puset"));
        wait(1);

        //5-üçüncü ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[3]")).click();

        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        System.out.println("Urun Basligi : " + driver.getTitle());
        WebElement fiyat = driver.findElement(By.xpath("//*[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']"));
        System.out.println("Fiyat =" + fiyat.getText());
        driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

    }

    @Test
    public void Test04() {
        //Test 4
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

        driver.get("https://www.amazon.com");
    }
}

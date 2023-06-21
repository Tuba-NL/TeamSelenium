package TeamPackage.day16;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C06_ActionMoveToElement extends TestBase {

    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void Test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");

        String ilkSayfaHandle = driver.getWindowHandle();

        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);

        System.out.println("Ilk Sayfa Title = " + driver.getTitle());


        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions = new Actions(driver);

        WebElement dilMenu = driver.findElement(By.xpath("(//*[text()='EN'])[1]"));

        actions.moveToElement(dilMenu).perform();

        //moveToElement() -->bir WebElemente yaklasmak icin kullanilir.

        // Change country/region butonuna basiniz
        driver.findElement(By.xpath("(//*[@class='icp-mkt-change-lnk'])[1]")).click();
        wait(2);


        // United States dropdown'undan 'Turkey (Türkiye)' seciniz

        // dropdown 3 adimda handle edilir:
        //1-)dropdown locate edilmeli:
        WebElement ddm = driver.findElement(By.xpath("//select[@id='icp-dropdown']"));

        //2-)select objesi olusturulmali:
        Select select = new Select(ddm);

        //3-)opsiyonlardan bir tanesi secilir.
        select.selectByVisibleText("Turkey (Türkiye)");
        wait(2);


        // Go to website butonuna tiklayiniz

        // drop down opsiyon listesi 'Go to website' butonuna basmamıza engel oldugu icin
        // herhangi bir yere click yapıp dropdown option listesinin toparlanmasını sagladık

        driver.findElement(By.xpath("//*[.='Changing country/region website']")).click();
        wait(1);

        WebElement gotoWebsite = driver.findElement(By.xpath("//*[@class='a-button-input']"));
        gotoWebsite.click();
        wait(1);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz.

        Set<String> pencereler = driver.getWindowHandles();

        System.out.println("pencereler = " + pencereler);

        String ikinciSayfaHandle = "";

        for (String each : pencereler ) {

            if(!each.equals(ikinciSayfaHandle)){

                ikinciSayfaHandle=each;
            }
        }
        System.out.println("ikinciSayfaHandle = " + ikinciSayfaHandle);

        driver.switchTo().window(ikinciSayfaHandle);

        String ikinciSayfaTitle = driver.getTitle();

        System.out.println("Ikinci Sayfa Title = " + driver.getTitle());

        Assert.assertTrue(ikinciSayfaTitle.contains("Elektronik"));

    }
}

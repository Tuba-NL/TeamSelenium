package TeamPackage.day14_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Odev extends TestBase {

/*
    1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    2- Hover over  Me First" kutusunun ustune gelin
    3- Link 1" e tiklayin
    4- Popup mesajini yazdirin
    5- Popup'i tamam diyerek kapatin
    6- “Click and hold" kutusuna basili tutun
    7-“Click and hold" kutusunda cikan yaziyi yazdirin
    8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
     */

    @Test
    public void Test01() {

       // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

       // 2- Hover over  Me First" kutusunun ustune gelin
        WebElement box = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(box).perform();


       // 3- Link 1" e tiklayin
        WebElement link1 = driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        link1.click();

       // 4- Popup mesajini yazdirin
        System.out.println("Popup Mesaj : "+driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        allertAccept();

       // 6- “Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickHold).perform();

       // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHold.getText());

        // 8- “Double click me" butonunu cift tiklayin.
        WebElement doubleButton = driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleButton).perform();

        //Tiklandigini test edin.
        String actualClass=doubleButton.getAttribute("class");
        System.out.println("actualClass = " + actualClass);
        String expectedClass="div-double-click double";
        Assert.assertEquals(expectedClass,actualClass);

      //  WebElement yesilEkran = driver.findElement(By.xpath("//*[@class='div-double-click double']"));

      // Assert.assertTrue(yesilEkran.isDisplayed());


       // driver.close();
    }

}

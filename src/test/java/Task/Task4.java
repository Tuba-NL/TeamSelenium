package Task;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task4 extends TestBase {


    //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
    //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
    //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
    //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
    //-Çıkan alert'te iptal butonuna basınız
    //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
    //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
    //-Çıkan mesajı konsola yazdırınız
    //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız


    @Test
    public void Test01() {

        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement alert = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        alert.click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        wait(2);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        wait(2);

        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();
        wait(2);
        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        wait(2);

        //-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Tuba");
        wait(2);

        //-Çıkan mesajı konsola yazdırınız
        driver.switchTo().alert().accept();
        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());


        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello Tuba How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());


    }
}

package Task;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Task10 extends TestBase {

    //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
    //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
    //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
    //Bütün Height bilgilerini yazdırınız
    //Otel uzunluklarının hepsini toplayınız
    //Bir method ile satır ve sutun bilgilerini çağıralım


    @Test
    public void Test02() {

        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//*[@id='ez-accept-all']")).click();
        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız
        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        //Bütün Height bilgilerini yazdırınız
        //Otel uzunluklarının hepsini toplayınız
        //Bir method ile satır ve sutun bilgilerini çağıralım

    }
}

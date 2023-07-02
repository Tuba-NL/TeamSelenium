package Task;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task8 extends TestBase {

    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım

    @Test
    public void Test01() {

        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        WebElement rakam1 = driver.findElement(By.xpath("//*[.='1']"));

        //Sonucu konsola yazdırıp

        //Sonucun doğrulamasını yapalım
    }

}

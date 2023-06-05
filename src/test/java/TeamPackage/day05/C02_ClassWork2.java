package TeamPackage.day05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork2 {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //ÖDEV
        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        // Add Element butonuna 100 defa basınız
        // 100 defa basıldığını test ediniz
        // 90 defa delete butonuna basınız
        // 90 defa basıldığını doğrulayınız
        // Sayfayı kapatınız

/*
        a.Verilen web sayfasına gidin.
        https://the-internet.herokuapp.com/checkboxes
        b.Checkbox1 ve checkbox2 elementlerini locate edin.
        c.Checkbox1 seçili değilse onay kutusunu tıklayın
        d.Checkbox2 seçili değilse onay kutusunu tıklayın





        10:28
         -https://www.facebook.com adresine gidin
        -Cookies’i kabul edin
         -“Create an Account” button’una basin
        -“radio buttons” elementlerini locate edin
         -Secili degilse cinsiyet butonundan size uygun olani secin
                */

    }











}

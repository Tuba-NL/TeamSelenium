package TeamPackage.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1. https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        Thread.sleep(1000);

        //2. cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();

        //3. Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        if (actualTitle.contains("Google")) {
            System.out.println("Evet Google iceriyor");
        } else System.out.println("Hayir Google icermiyor");


        //4. Arama cubuguna "Nutella" yazip aratin
        driver.findElement(By.xpath("//*[@title='Ara']")).sendKeys("Nutella");
        driver.findElement(By.xpath("(//*[@class='gNO89b'])[2]")).click();


        //5. Bulunan sonuc sayisini yazdirin
        WebElement sonuc = driver.findElement(By.xpath("//*[@id='result-stats']"));
        System.out.println("sonuc = " + sonuc.getText());
        String sonucSayisi = sonuc.getText().split(" ")[1];
        System.out.println("sonucSayisi = " + sonucSayisi);


       // String snc = sonucSayisi.replace(".", "");
        String snc = sonucSayisi.replaceAll("\\D","");
       int sonucInt = Integer.parseInt(snc); //Stringi integer degere cevirmek icin
        System.out.println("sonucInt = " + sonucInt);


//    7. sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
        int expectedSayi = 10000000;

        if (sonucInt > 10000000) {
            System.out.println("Test Passed");
        } else System.out.println("Test Failed");


        //7. Sayfayi kapatin
        driver.close();
    }
}

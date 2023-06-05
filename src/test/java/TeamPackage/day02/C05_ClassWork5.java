package TeamPackage.day02;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork5 {
    /*
   1.Yeni bir class olusturalim (Homework)
   2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
    oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
   3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
   4.https://www.walmart.com/ sayfasina gidin.
   5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
   6. Tekrar “facebook” sayfasina donun
   7.Sayfayi yenileyin
   8.Sayfayi tam sayfa (maximize) yapin
   9.Browser’i kapatin
    */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1)ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        System.out.println("*******************************");



        String  actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        if(driver.getTitle().equals("facebook")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> ActualTitle : " + actualTitle);
        Thread.sleep(3000);
        System.out.println("******************************");


        //2)Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "facebook";
        if(actualUrl.contains("facebook")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> ActualUrl : " + actualUrl);
        Thread.sleep(2000);
        System.out.println("*************************************");

        //3)https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to(" https://www.walmart.com/");
        Thread.sleep(2000);
        System.out.println("***********************");

        //4) Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        System.out.println(driver.getTitle());
        String actualTitle1 = "driver.getTitle()";
        String expectedTitle1 = "Walmart.com";
        if(actualTitle1.contains(expectedTitle1)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> ActualTitle : " + actualTitle1);
        Thread.sleep(2000);

        //5) Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(2000);

        //6)Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);

        //7)Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //8)Browser’i kapatin
        driver.close();

    }




}

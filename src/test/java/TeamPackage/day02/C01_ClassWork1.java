package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork1 {
    /*
        Class Work
    1.Yeni bir package olusturalim : day01
    2. Yeni bir class olusturalim : C03_GetMethods
    3. Amazon sayfasina gidelim. https://www.amazon.com/
    4. Sayfa basligini(title) yazdirin
    5. Sayfa basliginin “Amazon” icerdigini test edin
    6. Sayfa adresini(url) yazdirin
    7.Sayfa url’inin “amazon” icerdigini test edin.
    8. Sayfa handle degerini yazdirin
    9. Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
    10.Sayfayi kapatin.
    */
    public static void main(String[] args) {

        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1)Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get(" https://www.amazon.com/    ");

        //2)Sayfa basligini(title) yazdirin
        System.out.println("Sayfa Basligi : " + driver.getTitle());

        //3) Sayfa basliginin “Amazon” icerdigini test edin
        String actualTitle = driver.getTitle();
        String aranankelime = "Amazon";
        if(actualTitle.contains(aranankelime)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //4) Sayfa adresini(url) yazdirin
        System.out.println("Sayfanin Url`si :  "  +  driver.getCurrentUrl());

        //5)Sayfa url’inin “amazon” icerdigini test edin.
        String actualUrl = driver.getCurrentUrl();
        String aranankelime1 = "amazon";
        if(actualUrl.contains(aranankelime1)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //6) Sayfa handle degerini yazdirin
        System.out.println( "Sayfanin Handle Degeri : " + driver.getWindowHandle());

        //7) Sayfa HTML kodlarinda “Gateway” kelimesi gectigini test edin
        String HtmlactualSayfa = driver.getPageSource();
        String arananKelime3 = "Gateway";
        if(driver.getPageSource().contains("Gateway")){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //8)Sayfayi kapatin.
        driver.close();

    }





















































    /*
    Yeni bir Class olusturalim.C07_ManageWindowSet
    Amazon soyfasina gidelim. https://www.amazon.com/
    Sayfanin konumunu ve boyutlarini yazdirin
    Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
    Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
    Sayfayi kapatin


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        Thread.sleep(4000);

        // Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(50, 50));
        driver.manage().window().setSize(new Dimension(500, 500));

        //Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        String position = "driver.manage().window().getPosition()";
        String expectedpos = "driver.manage().window().setPosition(new Point(50,50))";
        if (!position.equals(expectedpos)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED -> position ");

        String actualSize = "driver.manage().window().getSize()";
        String expectedSize= "driver.manage().window().setSize(new Dimemsion(500,500))";
        if (!actualSize.equals(expectedSize)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED ->  actualSize");

        // Sayfayi kapatin
        driver.close();
        */

}

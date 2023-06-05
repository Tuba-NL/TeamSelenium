package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_ClassWork6 {
    /*
    1. Yeni bir class olusturun (TekrarTesti)
    2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
     (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
    3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru
     URL'yi yazdırın.
    4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
    5. Youtube sayfasina geri donun
    6. Sayfayi yenileyin
    7. Amazon sayfasina donun
    8. Sayfayi tamsayfa yapin
    9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru
    başlığı(Actual Title) yazdırın.
    10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru
    URL'yi yazdırın
    11.Sayfayi kapatin
*/

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // driver.manage().window().maximize(); 70. satirda yaptik.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1)Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın
        // (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://youtube.com");
        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle = "youtube";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> ActualTitle : " + actualTitle);


        //2) Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğr URL'yi yazdırın.
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "youtube";
        if(actualUrl.contains("youtube")){
            System.out.println("youtube iceriyor");
        }else System.out.println("youtube icermiyor --> Dogru Url: " + actualUrl);


        
        //3)Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);


        //4) Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(2000);


        //5)Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2000);


        //6) Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);

        //7)Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);


        //8)Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Amazon";
        if(actualTitle1.contains(expectedTitle1)){
            System.out.println("Evet Amazon iceriyor");
        }else System.out.println("Hayir Amazon icermiyor-->Actual Title : " + actualTitle1);



        //9)Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String actualUrl1 = driver.getCurrentUrl();
        String expectedUrl1 = "https://www.amazon.com/";
        if(actualUrl1.equals(expectedUrl1)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED --> ActualUrl : " + actualUrl);


        //10)Sayfayi kapatin
        driver.close();




















    }


}

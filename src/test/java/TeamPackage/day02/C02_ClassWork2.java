package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork2 {
    /*
        1.Yeni bir Class olusturalim.C05_NavigationMethods
        2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        3. Amazon soyfasina gidelim. https://www.amazon.com/
        4. Tekrar YouTube’sayfasina donelim
        5. Yeniden Amazon sayfasina gidelim
        6. Sayfayi Refresh(yenile) yapalim
        7.Sayfayi kapatalim / Tum sayfalari kapatalim
*/
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1) Youtube ana sayfasina gidelim . https:// www.youtube.com/
        driver.get(" https://www.youtube.com/");
        Thread.sleep(2000);

        //2) Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get(" https://www.amazon.com/ ");
        Thread.sleep(2000);

        //3) Tekrar YouTube’sayfasina donelim
        driver.navigate().back();
        Thread.sleep(2000);

        //4) Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        //5) Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        //6)Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();
        driver.quit();

    }
}

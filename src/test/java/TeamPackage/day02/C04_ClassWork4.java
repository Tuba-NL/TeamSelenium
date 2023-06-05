package TeamPackage.day02;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_ClassWork4 {
    /*
   1.Yeni bir Class olusturalim.C07_ManageWindowSet
   2. Amazon soyfasina gidelim. https://www.amazon.com/
   3. Sayfanin konumunu ve boyutlarini yazdirin
   4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin.
   5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
   8. Sayfayi kapatin
*/


    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       //1) Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       //2) Sayfanin konumunu ve boyutlarini yazdirin.
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

       //3) Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin.
        driver.manage().window().setPosition(new Point(60,60));
        driver.manage().window().setSize(new Dimension(200,600));

       //4) Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        String actualPosition = "driver.manage().window().setPosition(new Point(60,60)";
        String expectedPosition = " driver.manage().window().getPosition()";
        if(actualPosition.equals(expectedPosition)){
            System.out.println("Test FAILED");
        }else System.out.println("Test PASSED");

        String actualSize = "driver.manage().window().setSize(new Dimension(200,600)";
        String expectedSize = " driver.manage().window().getSize";
        if(actualSize.equals(expectedSize)){
            System.out.println("Test FAILED");
        }else System.out.println("Test PASSED");


        //5)Sayfayi kapatin
        driver.close();








    }
}

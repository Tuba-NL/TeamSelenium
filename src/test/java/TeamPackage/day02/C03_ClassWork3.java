package TeamPackage.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ClassWork3 {
/*
1.Yeni bir Class olusturalim.C06_ManageWindow
2.Amazon soyfasina gidelim. https://www.amazon.com/
3.Sayfanin konumunu ve boyutlarini yazdirin
4.Sayfayi simge durumuna getirin
5.simge durumunda 3 saniye bekleyip sayfayi maximize yapin
6.Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
7.Sayfayi fullscreen yapin
8.Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
9.Sayfayi kapatin
*/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize(); 5.durumda yapacagimiz icin burada kapattik
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       //1)Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

       //2)Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin Konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanin Boyutu : " + driver.manage().window().getSize());

        //3)Sayfayi simge durumuna getirin
        driver.manage().window().minimize();


       //4)simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

       //5)Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Sayfanin Max Konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanin Max Boyutu : " + driver.manage().window().getSize());


       //6)Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

       //7)Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Sayfanin FullScreen Konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanin FullScreen Boyutu : " + driver.manage().window().getSize());


        //8)Sayfayi kapatin
        driver.close();


    }
}

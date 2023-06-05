package TeamPackage.day07_Junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Odev {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    //https://id.heroku.com/login sayfasina gidin
    //Bir mail adersi giriniz
    //Login butonuna tiklayini
    // "There was a problem with your login." texti gorunur ise
    //"kayit yapilamadi" yazdiriniz
    //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    //sayfayı kapatiniz











    }





}

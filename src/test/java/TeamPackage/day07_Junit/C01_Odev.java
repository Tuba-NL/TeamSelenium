package TeamPackage.day07_Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Odev {
    public static void main(String[] args) {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");

        //Bir mail adresi giriniz
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("atin@gmail.com", Keys.TAB, "1234asd", Keys.ENTER);

        //Bir password giriniz.
        //Login butonuna tiklayini
        // "There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz

        WebElement actualtext = driver.findElement(By.xpath("//*[.='There was a problem with your login.']"));
        String expectedtext = "There was a problem with your login.";
        if (actualtext.isDisplayed()) {
            System.out.println("Kayit yapilmadi");
        } else System.out.println("Kayit yapildi");

        //sayfayı kapatiniz
        driver.close();


    }


}

package TeamPackage.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //  https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");


        //  Browseri tam sayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(2000);


        //  Sayfayi "refresh" yapin
        driver.navigate().refresh();

        // Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String actualTitel = driver.getTitle();
        String expectedTitel = "Spend less";
        if (actualTitel.contains(expectedTitel)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED " + actualTitel);
        Thread.sleep(2000);


        // Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[.='Gift Cards']")).click();
        Thread.sleep(2000);

        // Birthday butonuna basin
        driver.findElement(By.xpath("//*[@aria-label='Birthday']")).click();
        Thread.sleep(2000);

        //  Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@aria-label='Best Sellers']")).click();
        driver.findElement(By.xpath("//*[@alt='Amazon Reload']")).click();
        Thread.sleep(2000);


        // Gift card details'den 50 $'i secin

        WebElement actualDeger = driver.findElement(By.xpath("(//*[@type='button'])[2]"));
        actualDeger.click();
        System.out.println(actualDeger.getText());


        //  Urun ucretinin 50$ oldugunu test edin

        if (actualDeger.getText().equals("$50")) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");


        // Sayfayi kapatin
        driver.close();


    }
}

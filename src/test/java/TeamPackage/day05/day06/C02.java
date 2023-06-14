package TeamPackage.day05.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //  2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");
        Thread.sleep(1500);

        //  3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(1500);

        //  4. Login tusuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Thread.sleep(1500);

        //  5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//*[.='Sauce Labs Backpack']"));
        System.out.println(ilkUrun.getText());
        ilkUrun.click();
        Thread.sleep(1000);

        // 6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[.='Add to cart']")).click();
        Thread.sleep(1000);

        //  7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@class='shopping_cart_badge']")).click();
        Thread.sleep(1000);

        //  8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sectigimUrun = driver.findElement(By.xpath("//*[@class='inventory_item_desc']"));
        if(sectigimUrun.isDisplayed()){
            System.out.println("Evet gorunuyor");
        }else System.out.println("Hayir gorunmuyor");
        Thread.sleep(1000);

        //  9. Sayfayi kapatin
        driver.close();


    }
}

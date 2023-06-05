package TeamPackage.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //-ÖDEV-
        //Amazon sayfasına gidiniz
        driver.get("https://www.amazon.com");

        //iphone aratınız
        WebElement aramaMotoru = driver.findElement(By.id("twotabsearchtextbox"));
        aramaMotoru.sendKeys("iphone");
        aramaMotoru.submit();

        //çıkan sonuç yazısını konsola yazdırınız
        List<WebElement> sonucYazisi= driver.findElements(By.className("sg-col-inner"));
        System.out.println(sonucYazisi.get(0).getText());//1-16 of 24 results for "iphone"


        //çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız

        for (int i = 0; i < 5; i++) {
            List<WebElement> urunler = driver.findElements(By.className("s-image"));
            // WebElement urun = driver.get(0);
            urunler.get(i).click();
            System.out.println((i + 1) + ".urun basligi" + driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        }
        driver.close();
    }
}

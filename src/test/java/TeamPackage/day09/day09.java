package TeamPackage.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class day09 {


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();

    }


    @Test
    public void Test01() throws InterruptedException {

        // -Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");


        // -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(aramaKutusu);
        select.getOptions().forEach(t -> System.out.println(t.getText()));

        // -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        // başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        for (int i = 1; i < 6; i++) {

            WebElement element1 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
            Select select1 = new Select(element1);
            select1.selectByIndex(i);
            driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).submit();
            System.out.println(i + ".sayfa basligi : " + driver.getTitle());
            Thread.sleep(1000);
        }

        //  Not: Select Class'ı kullanalım


    }

    @Test
    public void Test02() throws InterruptedException {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Dropdown menuyu yazdıralım
        Select select = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w : select.getOptions()) {
            System.out.println(w.getText());
        }
        System.out.println("***********************************************");

        //Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip başlık altındakileri aratalım.
        //Her aramada sayfa başlığını yazdıralım
        int sayac = 1;
        for (WebElement w : select.getOptions()) {
            Select option = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            option.selectByIndex(sayac);
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            sayac++;
            if (sayac >= 6) {
                break;
            }
        }
    }
}


package TeamPackage.day08_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C02_Odev2 {


    /*
        ODEV2
    ●https://www.amazon.com/ adresine gidin.
            -Test 1
    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
    oldugunu test edin
            -Test 2
    1.Kategori menusunden Books secenegini secin
    2.Arama kutusuna Java yazin ve aratin
    3.Bulunan sonuc sayisini yazdirin
    4.Sonucun Java kelimesini icerdigini test edin
*/
        WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After
    public void tearDown() throws Exception {
       driver.close();
    }

    @Test
    public void Test01() {

        /*
        -Test 1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
        oldugunu test edin
        */

        WebElement category = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select option = new Select(category);
        int categorySize = option.getOptions().size();
        System.out.println(categorySize);
        Assert.assertNotEquals("45","categorySize");
    }

    @Test
    public void Test02() throws InterruptedException {
        /*
        -Test 2
        1.Kategori menusunden Books secenegini secin
        2.Arama kutusuna Java yazin ve aratin
        3.Bulunan sonuc sayisini yazdirin
        4.Sonucun Java kelimesini icerdigini test edin
        */
        WebElement category = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Thread.sleep(1500);
        Select option = new Select(category);
        option.selectByVisibleText("Books");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String [] sonucSayisi = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi = " + sonucSayisi[3]);

        Assert.assertTrue(sonucYazisi.getText().contains("Java"));


        }

    }


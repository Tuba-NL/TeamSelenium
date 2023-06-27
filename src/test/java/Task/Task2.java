package Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {

    //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
    //Before methodunda http://www.google.com adresine gidin
    //AfterClass ile browser'ı kapatınız
    //After method'u ile başlıkları yazdırınız
    //Üç farklı test methodu ile;
    //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin

    static WebDriver driver;
    @BeforeClass
    public static void beforeClass()  {
        //BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp(){

        //Before methodunda http://www.google.com adresine gidin
        driver.get("http://www.google.com");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        //AfterClass ile browser'ı kapatınız
        driver.close();

    }

    @After
    public void tearDown() throws Exception {
        //After method'u ile başlıkları yazdırınız
        System.out.println("Baslik = " + driver.getTitle());


    }

    @Test
    public void Test01() {
        //Üç farklı test methodu ile;
        //arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
        driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[2]")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("The God Father");
        aramaKutusu.submit();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi1 = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi1 = " + sonucSayisi1[1]);



    }

    @Test
    public void Test02() {
        //arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
        // driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[2]")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("Lord of the Rings");
        aramaKutusu.submit();
        driver.navigate().refresh();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi2 = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi2 = " + sonucSayisi2[1]);


    }

    @Test
    public void Test03() {
        //arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
        // driver.findElement(By.xpath("(//*[.='Tümünü kabul et'])[2]")).click();
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("Kill Bill");
        aramaKutusu.submit();
        driver.navigate().refresh();
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String[] sonucSayisi3 = sonucYazisi.getText().split(" ");
        System.out.println("Sonuc Sayisi3 = " + sonucSayisi3[1]);

    }

}

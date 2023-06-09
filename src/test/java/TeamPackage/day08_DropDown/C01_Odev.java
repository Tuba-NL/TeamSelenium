package TeamPackage.day08_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Odev {

    /*
    ODEV3
    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    4.Tüm dropdown değerleri(value) yazdırın
    5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.

     */
    static WebDriver driver;

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

       // ●https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

       // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Thread.sleep(1500);
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option = new Select(ddm);
        option.selectByIndex(1);
        System.out.println("Option 1: " + option.getFirstSelectedOption().getText());

        System.out.println("**********************************************");
       // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        Thread.sleep(1500);
        WebElement ddm1 = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option1 = new Select(ddm);
        option1.selectByValue("2");
        System.out.println("Option 2: " + option1.getFirstSelectedOption().getText());

        System.out.println("**********************************************");

        Thread.sleep(1500);
        WebElement ddm2 = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option2 = new Select(ddm2);
        option2.selectByVisibleText("Option 1");
        System.out.println("Option 1: " + option2.getFirstSelectedOption().getText());

        System.out.println("**********************************************");

        //1.yol
        List<WebElement> tagName = driver.findElements(By.tagName("option"));
        tagName.forEach(t-> System.out.println(t.getText()));

        //2.yol:
        List<WebElement> tagName2 =option.getOptions();
        tagName2.stream().forEach(t-> System.out.println(t.getText()));

        System.out.println("****************************************");
        int tagName3 = option.getOptions().size();
        System.out.println(tagName3);

        if (tagName3 == 4){
            System.out.println("True");
        }else{
            System.out.println("false");
        }

    }
}
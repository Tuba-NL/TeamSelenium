package TeamPackage.day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Odev {
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
    public void test01() throws InterruptedException {

        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //  b.Checkbox1 ve checkbox2 elementlerini locate edin.

        //  c.Checkbox1 seçili değilse onay kutusunu tıklayın
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
            if (!checkbox1.isSelected()){
                Thread.sleep(2000);
                checkbox1.click();
            }


        //  d.Checkbox2 seçili ise onay kutusunu tıklayın
            WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
            if(checkbox2.isSelected()){
                checkbox2.click();

            }
        Thread.sleep(2000);

    }




    }




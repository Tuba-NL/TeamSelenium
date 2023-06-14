package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {

     protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
      // driver.quit();

    }

    public void wait (int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void allertAccept(){
        driver.switchTo().alert().accept();
    }

    public void allertDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void allertgetText(){
        driver.switchTo().alert().getText();
    }


    public void allertSendKeys(String text){
        driver.switchTo().alert().sendKeys(text);
    }



}

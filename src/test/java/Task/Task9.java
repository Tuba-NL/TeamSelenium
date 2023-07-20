package Task;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.utils.FileUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;




public class Task9 extends TestBase {

    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    ExtentReports extentReports; //raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter; // raporu HTML formatinda duzenler.
    ExtentTest extentTest; // test adimlarina eklemk istedigimiz bilgileri bu class ile olusruruz.

    @Test
    public void Test01() throws IOException {

        extentReports = new ExtentReports();
        String date = new SimpleDateFormat("_hh_mm_ss").format(new Date());
        String raporDosyaYolu = "testOutput/extentReports/extentReport"+date+".html";
        extentHtmlReporter = new ExtentHtmlReporter(raporDosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);// HTML formatinda raporlamayi baslatacak

        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Tuba");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test");
        extentTest= extentReports.createTest("ExtentTest","Test Raporu");//test ismi ve aciklamasi

        //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
        wait(2);
        extentTest.info("Sayfaya gidildi");


        //Sayfanın resmini alalım

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/EkranGoruntusu" + date + ".png"));

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        wait(1);

        extentTest.info("Browser bolumu gorunene kadar sayfa kaydirildi");

        //  WebElement browsers = driver.findElement(By.xpath("(//*[@class='card-body'])[17]"));
        //  JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("arguments[0].scrollIntoView(true);",browsers);

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        WebElement browser = driver.findElement(By.xpath("(//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]"));
        wait(1);
        browser.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        extentTest.info("documentation linkine tiklandi");


        //Documentation webelementinin resmini alalım
        WebElement documentWe = driver.findElement(By.xpath("(//*[@class='aJHbb dk90Ob jgXgSe HlqNPb'])[7]"));
        String dosyaYolu ="src/test/java/TeamPackage/ScreenShot"+date+".png";
        FileUtils.copyFile(documentWe.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        extentTest.info("Web elementin resmi alindi");


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        driver.findElement(By.linkText("Downloads")).click();
        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("sayfa1Handle = " + sayfa1Handle);
        driver.findElement(By.linkText("ChromeDriver 114.0.5735.90")).click();
        extentTest.info("Chrome Driver versiyonu secildi");
        wait(1);

        Set<String> windows = driver.getWindowHandles();
        for (String each: windows) {
            // System.out.println(each);
            if (!each.equals(sayfa1Handle)){
                driver.switchTo().window(each);
            }
        }
        String sayfa2Handle = driver.getWindowHandle();
        System.out.println("sayfa2Handle = " + sayfa2Handle);
        driver.switchTo().window(sayfa2Handle);
        System.out.println("sayfa2Handle = " + driver.getWindowHandle());

      // driver.findElement(By.xpath("//table//tbody//tr[7]//td[2]")).click();
        WebElement download = driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']"));
        download.submit();

        extentTest.info("Chrome Driver indirme linkine tiklandi");



        //Driver'in indiğini doğrulayalım
        String indirilenDosyaYolu= "C:\\Users\\gebruiker\\Downloads\\chromedriver_win32 (3).zip";
        wait(15);
        Assert.assertTrue(Files.exists(Paths.get(indirilenDosyaYolu)));
        extentTest.info("Driver'in indirildigi dogrulandi");



        //İndirmiş olduğumuz dosyayı silelim

        try {
            Files.delete(Paths.get(indirilenDosyaYolu));
        }catch (IOException e){
            System.out.println("dosya bulunamadi");
        }
        extentTest.info("Indirilen dosya silindi");


        //Silindiğini doğrulayalım
        wait(5);
        Assert.assertFalse(Files.exists(Paths.get(indirilenDosyaYolu)));
        extentTest.info("Indirilen dosyanin silindigi dogrulandi");

        driver.close();
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();// bu kodu yazmazsak rapor olusmaz.


        //Not: Bu task'in her adımı için Html rapor oluşturalım(ExtentReport)



    }
}



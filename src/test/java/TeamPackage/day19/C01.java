package TeamPackage.day19;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01 extends TestBase {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Add products to cart
    //5. Click 'Cart' button
    //6. Verify that cart page is displayed
    //7. Click 'X' button corresponding to particular product
    //8. Verify that product is removed from the cart

    ExtentReports extentReports; // --> Raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter;// -->Raporu HTML formatinda duzenler
    ExtentTest extentTest;// --> Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz.

    @Test
    public void Test01() throws IOException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'

        String dosyaYolu = "testOutput/extentReport.html";
        extentReports = new ExtentReports();
        extentHtmlReporter =new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Tuba");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentTest = extentReports.createTest("ExtentTest","Test Raporu");

        driver.get("http://automationexercise.com");
        wait(1);
        extentTest.info("sayfaya gidildi");

        //  3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        wait(2);
        extentTest.info("sayfaya gidildi ve dogrulama yapildi");

        //  4. Add products to cart

        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        wait(1);
        extentTest.info("sayfaya gidildi ve urun eklendi");

        //5. Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        driver.findElement(By.xpath("(//*[@class='fa fa-shopping-cart'])[1]")).click();
        extentTest.info("sayfaya gidildi urun ekleme butonuna tiklandi");



        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Proceed To Checkout']")).isDisplayed());
        wait(1);
        String date = new SimpleDateFormat("_hh_mm_ss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("Screenshot/TakesScreenshot" + date + ".png"));
        extentTest.info("sayfaya gidildi ve dogrulama yapildi");

        //7. Click 'X' button corresponding to particular product
        driver.findElement(By.xpath("//*[@class='fa fa-times']")).click();
        wait(1);

        extentTest.info("sayfaya gidildi urun eklnedi ve silme islemi yapildi");

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File("src/test/java/TeamPackage/ScreenShot/Ekrangoruntusu" + date + ".png"));


        //8. Verify that product is removed from the cart
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='text-center'])[3]")).isDisplayed());
        wait(2);

        extentTest.info("sayfaya gidildi ve silme islemi yapildiktan sonra kontorl edildi.");
        extentReports.flush();
    }
}

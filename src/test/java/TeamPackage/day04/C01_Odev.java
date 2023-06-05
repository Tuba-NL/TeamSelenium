package TeamPackage.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Odev {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("chromDriver", " src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //Odev1
        //Techproeducation sayfasına gidelim
        driver.get("https://Techproeducation.com");
        Thread.sleep(2000);


        //Çıkan reklamı locate edip kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        Thread.sleep(2000);



        //Arama bölümünde qa aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"))
                                   .sendKeys("qa" + Keys.ENTER);



        //Sayfa başlığının qa içerdiğini doğrulayalım
        String actualTitle = driver.getTitle();
        String expectedTitle = "qa";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Test1 PASSED");
        }else System.out.println("Test1 FAILED");


        //Carrer Opportunities In QA linkinin görünür ve erişilebilir olduğunu doğrulayalım
        WebElement carrerOpLink = driver.findElement(By.xpath("(//h3[@class='elementor-post__title'])[1]"));
        System.out.println(carrerOpLink.isDisplayed() && carrerOpLink.isEnabled());


        //Carrer Opportunities In QA linkine tıklayalım
         driver.findElement(By.xpath("(//h3[@class='elementor-post__title'])[1]")).click();


        //Başlığın Opportunities içerdiğini test edelim
        String actualTitle1 = driver.getTitle();
        String expectedWord = "Opportunities";
        if(actualTitle1.contains(expectedWord)){
            System.out.println("Test2 PASSED");
        }else System.out.println("Test2 FAILED");



        //Tekrar anasayfaya dönelim ve url'in https://techproeducation.com/ olduğunu doğrulayalım
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://techproeducation.com/";
        if(actualUrl.equals(expectedUrl)) {
            System.out.println("Test3 PASSED");
        }else System.out.println("Test3 FAILED-->ActualUrl : " + actualUrl);


        driver.close();








            //Odev2
        //https://id.heroku.com/login sayfasina gidin
        driver.get("https://id.heroku.com/login");


        //Bir mail adersi giriniz


        //Bir password giriniz
        //Login butonuna tiklayiniz
        //"There was a problem with your login." texti gorunur ise
        //"kayit yapilamadi" yazdiriniz
        //eger yazi gorunur degilse "kayit yapildi" yazdiriniz
    }


}
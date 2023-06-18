package TeamPackage.day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Exercises extends TestBase {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that categories are visible on left side bar
    4. Click on 'Women' category
    5. Click on any category link under 'Women' category, for example: Dress
    6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    7. On left side bar, click on any sub-category link of 'Men' category
    8. Verify that user is navigated to that category page

*/

    @Test
    public void test01() {


            //2. 'http://automationexercise.com' URL'sine gidin
            driver.get("http://automationexercise.com");


            //3. Kategorilerin sol kenar çubuğunda göründüğünü doğrulayın
            WebElement kategories =  driver.findElement(By.xpath("//div[@class='panel-group category-products']"));
            Assert.assertTrue(kategories.isDisplayed());


            //4. 'Kadınlar' kategorisine tıklayın
            driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[1]")).click();

            //5. 'Kadınlar' kategorisi altındaki herhangi bir kategori bağlantısına tıklayın, örneğin: Elbise
            driver.findElement(By.xpath("(//*[text()='Dress '])[1]")).click();
            wait(2);


            //6. Kategori sayfasının görüntülendiğini doğrulayın ve 'WOMEN - DRESS PRODUCTS' metnini onaylayın

            WebElement baslik = driver.findElement(By.xpath("//*[text()='Women - Dress Products']"));
            Assert.assertTrue(baslik.isDisplayed());
            wait(2);



            //7. Sol kenar çubuğunda, 'Erkekler' kategorisinin herhangi bir alt kategori bağlantısına tıklayın
            driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[2]")).click();
            wait(2);
            driver.findElement(By.xpath("//*[text()='Tshirts ']")).click();


            //8. Kullanıcının bu kategori sayfasına yönlendirildiğini doğrulayın
            WebElement baslikMen = driver.findElement(By.xpath("//*[text()='Men - Tshirts Products']"));
            Assert.assertTrue(baslikMen.isDisplayed());



        }
    }

package Task;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task7 extends TestBase {

    //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
    //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
    //-Sarı olduğunu test edelim


    @Test
    public void Test01() {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        wait(2);

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);


        WebElement ikinciButon = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        Actions actions = new Actions(driver);
        //Kirmizi Kutu Kodu:
        actions.clickAndHold(ikinciButon).moveByOffset(-160, 0).release().perform();

        //Sari Kutu Kodu:
        actions.clickAndHold(ikinciButon).moveByOffset(320, 0).release().perform();


        //-Sarı olduğunu test edelim
        WebElement sariKutu = driver.findElement(By.xpath("//*[@style='background-color: rgb(255, 255, 60);']"));

    }
}

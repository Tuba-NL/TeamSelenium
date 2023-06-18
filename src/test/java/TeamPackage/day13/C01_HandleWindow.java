package TeamPackage.day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_HandleWindow extends TestBase {
    /*
    ● https://testcenter.techproeducation.com/index.php?page=multiple-windows
    ● Title in ‘Windows’ oldugunu test edin
    ● Click here a tiklayin
    ● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
*/

    @Test
    public void Test01() {

    //● https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");
        String ilkHandle = driver.getWindowHandle();
        System.out.println("ilkHandle = " + ilkHandle);
        wait(2);

    //● Title in ‘Windows’ oldugunu test edin

        String actual1 = driver.getTitle();
        String expected1 = "Windows";
        System.out.println("ilkSayfaBasligi: " +  actual1);
        Assert.assertEquals("Windows",actual1);


    // ● Click here a tiklayin
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        String ikinciHandle = driver.getWindowHandle();

    // ● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin

        Set<String> handles = driver.getWindowHandles();
        System.out.println("handles = " + handles);

        String second = "";
        for (String w : handles) {

            if (!w.equals(ilkHandle)) {

                second = w;
            }
        }
        driver.switchTo().window(second);
        System.out.println(second);
       // driver.switchTo().window(ikinciHandle);
        String actual2 = driver.getTitle();
        String expected2 = "New Window";
        System.out.println("ikinciSayfaBasligi: " +  actual2);
        Assert.assertEquals("New Window",actual2);


    }
}

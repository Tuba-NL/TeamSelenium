package TeamPackage.day14_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    @Test
    public void Test01() {

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");
        wait(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //Sayfanin altına doğru gidelim

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        /*
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
*/

        //Sonra sayfanın üstüne doğru gidelim

        actions.sendKeys(Keys.HOME).perform();
        /*
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).
                sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
*/


    }
}

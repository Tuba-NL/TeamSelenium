package TeamPackage.day08_DropDown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C03_Odev3 extends TestBase {
    @Test
    public void Test01() {

        //  ODEV1
        // 1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


        //2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        //3.Login kutusuna “username” yazin
        //4.Password kutusuna “password.” yazin

        WebElement kutu = driver.findElement(By.xpath("//*[@id='user_login']"));
        kutu.sendKeys("username"+ Keys.TAB+"password" + Keys.TAB);

        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        driver.navigate().back();

        //6. Online Banking bölümüne tıklayın
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();

        //7.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //8.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("(//*[@class='ui-state-default ui-corner-top'])[2]")).click();

        //9.“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(ddm);
        select.selectByIndex(6);

        //10.“amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("100");

        //11.“US Dollars” in secilmedigini test edin
        WebElement buton1 = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        Assert.assertTrue(!buton1.isSelected());

        //12.“Selected currency” butonunu secin
        driver.findElement(By.xpath("(//*[@type='radio'])[2]")).click();

        //13.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();

        //“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
        WebElement yazi = driver.findElement(By.xpath("//*[.='Foreign currency cash was successfully purchased.']"));
        Assert.assertTrue(yazi.isDisplayed());

    }
}
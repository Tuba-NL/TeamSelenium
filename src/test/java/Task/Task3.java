package Task;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task3 extends TestBase {

    //-Amazon sayfasına gidelim
    //-Arama Kutusundaki Dropdown menuyu yazdıralım
    //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    //Not: Select Class'ı kullanalım

    @Test
    public void Test01() {
        //-Amazon sayfasına gidelim
        driver.get("https://www.amazon.com");

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        Select select = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
        for (WebElement w: select.getOptions()){
            System.out.println(w.getText());
        }
        System.out.println("********************************************************");

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        int sayac = 1;
        for (WebElement w: select.getOptions()){
            Select options = new Select(driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
            driver.findElement(By.xpath("//*[@type='submit']")).click();
            System.out.println(driver.getTitle());
            wait(2);
            driver.navigate().back();
            wait(2);
            sayac++;
            if (sayac>=6){
                break;
            }
        }


    }
}



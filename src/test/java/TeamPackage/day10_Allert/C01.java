package TeamPackage.day10_Allert;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01 extends TestBase {

    @Test
    public void Test01() {
        driver.get("https://demoqa.com/alerts");
        wait(2);

        driver.findElement(By.xpath("(//button)[2]")).click();
        wait(2);

        allertAccept();

    }

    @Test
    public void Test02() {
        driver.get("https://demoqa.com/alerts");
        wait(2);

        driver.findElement(By.xpath("(//button)[4]")).click();
        wait(2);

        allertDismiss();
        wait(2);

        System.out.println(driver.findElement(By.xpath("//*[@id='confirmResult']")).getText());
    }

    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");
        wait(2);

        driver.findElement(By.xpath("(//button)[5]")).click();
        wait(2);

        allertSendKeys("Tuba");
        wait(2);
        allertAccept();
    }
}

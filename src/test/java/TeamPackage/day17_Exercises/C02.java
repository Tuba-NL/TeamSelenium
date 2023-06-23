package TeamPackage.day17_Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02 extends TestBase {
    @Test
    public void Test01() {

        // http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna 100 defa basınız

        for (int i = 0; i < 100; i++) {
            WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            button.click();
           wait(2);
        }


        // 100 defa basıldığını test ediniz
        int addedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if (addedElementsCount == 100) {
            System.out.println("Add Element butonuna 100 defa basıldı.");
        } else {
            System.out.println("Add Element butonuna 100 defa basılmadi.");
        }


        // 90 defa delete butonuna basınız
        for (int i = 0; i < 90; i++) {
            WebElement deleteButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
            deleteButton.click();
        }


        // 90 defa basıldığını doğrulayınız
        int deletedElementsCount = driver.findElements(By.xpath("//button[contains(text(), 'Delete')]")).size();
        if (deletedElementsCount == 10) {
            System.out.println("Delete butonuna 90 defa basildi.");
        } else {
            System.out.println("Delete butonuna 90 defa basilmadi.");
        }


    }
}

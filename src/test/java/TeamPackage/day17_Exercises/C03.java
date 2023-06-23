package TeamPackage.day17_Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03 extends TestBase {

    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    // 3. Verify that home page is visible successfully
    // 4. Click on 'Contact Us' button
    // 5. Verify 'GET IN TOUCH' is visible
    // 6. Enter name, email, subject and message
    // 7. Upload file
    // 8. Click 'Submit' button
    // 9. Click OK button
    // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    // 11. Click 'Home' button and verify that landed to home page successfull


    @Test
    public void Exercises6() {
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        wait(2);

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();

        // 5. Verify 'GET IN TOUCH' is visible
        WebElement yazi = driver.findElement(By.xpath("(//*[@class='title text-center'])[2]"));
        Assert.assertTrue(yazi.isDisplayed());

        // 6. Enter name, email, subject and message
        // 6. Enter name, email, subject and message
        WebElement form = driver.findElement(By.xpath("//input[@name='name']"));
        form.sendKeys("Ali", Keys.TAB, "veli@gmail.com",Keys.TAB, "djknskdnfkldf",Keys.TAB,";kasflskdns;dlmsldkfep");

        // 7. Upload file
       // "C:\Users\gebruiker\Desktop\text.txt"
        WebElement file = driver.findElement(By.xpath("(//*[@class='form-control'])[5]"));
        String farkliYol = System.getProperty("user.home");
        String ortakYol = "\\Desktop\\text.txt";
        String yol = farkliYol + ortakYol;
        file.sendKeys(yol);

        // 8. Click 'Submit' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();


        // 9. Click OK button
        driver.switchTo().alert().accept();
        //allertAccept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement succesYazi = driver.findElement(By.xpath("(//*[.='Success! Your details have been submitted successfully.'])[1]"));
        Assert.assertTrue(succesYazi.isDisplayed());
        

    }
}
